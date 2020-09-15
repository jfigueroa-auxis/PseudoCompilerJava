/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Textuales;

import BNF.base.Resultado;
import BNF.base.Simbolo;
import BNF.base.Solucion;
import Interpreter.Token;
import Util.tools;
import java.util.List;

/**
 *
 * @author georg
 */
public class Alfanumerico extends Simbolo{

    String valor;
    
    @Override
    public Resultado validar(List<Token> tokens) {
        Resultado res = new Resultado();
        String palabra = tokens.get(0).valor();
        if(tools.esAlfanumerico(palabra))
        {
            valor = palabra;
            res.Valido(1);
        }
        else
            contexto.Error(tokens.get(0), palabra + " no es un valor alfanumérico válido");
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return new Solucion(valor,Interpreter.Tipo.TEXT, 1);
    }
}
