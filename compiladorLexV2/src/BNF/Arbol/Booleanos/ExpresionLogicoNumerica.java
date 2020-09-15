/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Booleanos;

import BNF.Arbol.Numericos.Num;
import BNF.Arbol.Textuales.OperadorDeOrden;
import BNF.base.Resultado;
import BNF.base.Solucion;
import Interpreter.Token;
import java.util.List;
import BNF.base.Simbolo;
import Interpreter.Tipo;
import java.util.ArrayList;

/**
 *
 * @author hpclab
 */
public class ExpresionLogicoNumerica extends Simbolo{

    List<Simbolo> simbolo;
    
    public ExpresionLogicoNumerica()
    {
        simbolo = new ArrayList<>();
        simbolo.add(new Num());
        simbolo.add(new OperadorDeOrden());
        simbolo.add(new Num());
    }
    
    @Override
    public Resultado validar(List<Token> tokens) {
        return validarHorizontalmente(tokens, simbolo);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        int op1 = (int)simbolo.get(0).ejecutar(tokens).resultado;
        String operador = (String)simbolo.get(1).ejecutar(tokens).resultado;
        int op2 = (int)simbolo.get(2).ejecutar(tokens).resultado;
        
        boolean resultado = false;
        
        switch(operador)
        {
            case "<":
                resultado = op1 < op2;
                break;
            case ">":
                resultado = op1 > op2;
                break;
            case ">=":
                resultado = op1 >= op2;
                break;
            case "<=":
                resultado = op1 <= op2;
                break;
            case "!=":
                resultado = op1 != op2;
                break;
            case "==":
                resultado = op1 == op2;
                break;                         
        }
        return new Solucion(resultado, Tipo.BOOL,3);
    }
    
}
