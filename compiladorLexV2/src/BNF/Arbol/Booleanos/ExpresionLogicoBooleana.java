/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Booleanos;

import BNF.Arbol.Textuales.OperadorLogico;
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
public class ExpresionLogicoBooleana extends Simbolo{

    List<Simbolo> simbolos;
    
    public ExpresionLogicoBooleana()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new Booleano());
        simbolos.add(new OperadorLogico());
        simbolos.add(new Booleano());
    }
    
    @Override
    public Resultado validar(List<Token> tokens) {
        return validarHorizontalmente(tokens, simbolos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        boolean op1 = (boolean)simbolos.get(0).ejecutar(tokens).resultado;
        String operando = (String)simbolos.get(1).ejecutar(tokens).resultado;
        boolean op2 = (boolean)simbolos.get(2).ejecutar(tokens).resultado;
        boolean resultado = operando.equals("!=") ? op1 != op2 : op1 == op2;
        return new Solucion(resultado,Tipo.BOOL, 3);
    }
}
