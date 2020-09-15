/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales;

import BNF.Arbol.Textuales.Alfanumerico;
import BNF.Arbol.Textuales.Literal;
import BNF.Arbol.Textuales.Tipo;
import BNF.base.Resultado;
import BNF.base.Solucion;
import Interpreter.Token;
import java.util.List;
import BNF.base.Simbolo;
import java.util.ArrayList;

/**
 *
 * @author georg
 */
public class Definicion extends Simbolo{

    List<Simbolo> simbolos;
    
    public Definicion()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new Literal("DEF"));
        simbolos.add(new Tipo());
        simbolos.add(new Alfanumerico());
    }
    
    @Override
    public Resultado validar(List<Token> tokens) {
        Resultado res = validarHorizontalmente(tokens, simbolos);
        
        if(res.esValido)
        {
            String nombreVariable = (String)simbolos.get(2).ejecutar(tokens).resultado;
            res.esValido = !contexto.esPalabraReservada(nombreVariable);
            if(res.esValido)
            {
                String tipo = (String)simbolos.get(1).ejecutar(tokens).resultado;
                if(contexto.ObtenerVariable(nombreVariable) == null)
                {
                    Interpreter.Tipo tip = Interpreter.Tipo.valueOf(tipo);
                    contexto.definirVariable(nombreVariable, tip);
                }
                else
                {
                    res.esValido = false;
                    contexto.Error(tokens.get(2),"La variable: " + nombreVariable + " ya fue declarada");
                }
            }
            else
            {
                contexto.Error(tokens.get(2), "No se puede declarar una variable con el nombre: " + nombreVariable + ". Es una palabra reservada");
            }
        }
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return new Solucion(3);
    }
    
}
