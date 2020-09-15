/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales;

import BNF.Arbol.Numericos.Num;
import BNF.Arbol.Numericos.VariableNum;
import BNF.Arbol.Textuales.Literal;
import BNF.base.Resultado;
import BNF.base.Simbolo;
import BNF.base.Solucion;
import Interpreter.Token;
import Interpreter.Variable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author georg
 */
public class Multiplicacion extends Simbolo {

    List<Simbolo> simbolos;
    
    public Multiplicacion()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new Literal("MUL"));
        simbolos.add(new Num());
        simbolos.add(new Num());
        simbolos.add(new VariableNum());
    }
    
    @Override
    public Resultado validar(List<Token> tokens) {
        return validarHorizontalmente(tokens, simbolos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        int op1 = (int)simbolos.get(1).ejecutar(tokens).resultado;
        int op2 = (int)simbolos.get(2).ejecutar(tokens).resultado;
        String nombreVariable = tokens.get(3).valor();
        Variable var = contexto.ObtenerVariable(nombreVariable);
        
        int resultado = op1 * op2;
        
        var.setValor(String.valueOf(resultado));
        
        return new Solucion(_desplazamiento);
    }
    
}
