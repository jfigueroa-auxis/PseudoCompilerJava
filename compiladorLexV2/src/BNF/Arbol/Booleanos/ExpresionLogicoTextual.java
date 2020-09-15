/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Booleanos;

import BNF.Arbol.Textuales.OperadorLogico;
import BNF.Arbol.Textuales.Text;
import BNF.base.Solucion;
import BNF.base.Resultado;
import Interpreter.Token;
import java.util.ArrayList;
import java.util.List;
import BNF.base.Simbolo;
import Interpreter.Tipo;

/**
 *
 * @author Usuario
 */
public class ExpresionLogicoTextual extends Simbolo{

    List<Simbolo> simbolos;
    
    public ExpresionLogicoTextual()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new Text());
        simbolos.add(new OperadorLogico());
        simbolos.add(new Text());
    }
    
    @Override
    public Resultado validar(List<Token> tokens) {
        return validarHorizontalmente(tokens, simbolos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        String op1 = (String)simbolos.get(0).ejecutar(tokens).resultado;
        String operador = (String)simbolos.get(1).ejecutar(tokens).resultado;
        String op2 = (String)simbolos.get(2).ejecutar(tokens).resultado;
        boolean resultado = operador.equals("==") ? op1.equals(op2) : !op1.equals(op2); 
        return new Solucion(resultado, Tipo.BOOL,3);
    }
}
