/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpreter;

import BNF.Arbol.Sentenciales.Programa;
import BNF.Arbol.Textuales.Cadena;
import BNF.base.Resultado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Compilador {

    
    public List<Token> tokenizar(String codigo)
    {
        List<Token> tokens = new ArrayList<>();
        Token token;
        int linea = 1;
        int posicion = 1;
        String palabra = "";
        boolean esUnaCadena = false;
        
        for(int i = 0; i < codigo.length(); i++)
        {
            char caracter = codigo.charAt(i);
            int ascii = (int)caracter;
            if(ascii == 32) //ESPACIO
            {
                if(esUnaCadena)
                    palabra += caracter;
                else
                {
                    if(palabra.length() == 0) continue;
                    token = new Token(palabra, linea, posicion);
                    tokens.add(token);
                    palabra = "";
                    posicion++;
                }
            }
            else if(ascii == 10) //SALTO DE LINEA
            {
                if(esUnaCadena)
                    palabra += caracter;
                else
                {
                    if(palabra.length() != 0) 
                    {
                        token = new Token(palabra, linea, posicion);
                        tokens.add(token);
                        palabra = "";
                        posicion++;
                    }
                    linea++;
                }
            }
            else if(ascii == 39) //COMILLA
            {
                esUnaCadena = !esUnaCadena;
                palabra += caracter;
            }
            else //OTRO CARACTER
                palabra += caracter;
        }
        if(palabra.length() != 0)
        {
            token = new Token(palabra, linea, posicion);
            tokens.add(token);
        }
        
        return tokens;
    }
    
    public void validar(List<Token> tokens)
    {
        Programa prog = new Programa();
        Resultado res = prog.validar(tokens);
    }
    
    public String ejecutar(List<Token> tokens)
    {
        Contexto.getContexto().purgarMemoria();
        Programa prog = new Programa();
        Resultado res = prog.validar(tokens);
        if(res.esValido)
        {
            prog.ejecutar(tokens);
            return "Ejecucion finalizada";
        }
        return Contexto.getContexto().ObtenerError();
    }
}
