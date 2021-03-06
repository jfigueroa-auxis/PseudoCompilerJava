/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Textuales;

import BNF.Arbol.Booleanos.VariableBool;
import BNF.Arbol.Numericos.VariableNum;
import BNF.base.Resultado;
import BNF.base.Simbolo;
import BNF.base.Solucion;
import Interpreter.Token;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author georg
 */
public class Variable extends Simbolo {

    
    @Override
    public Resultado validar(List<Token> tokens) {
        List<Simbolo> candidatos = new ArrayList<>();
        candidatos.add(new VariableBool());
        candidatos.add(new VariableNum());
        candidatos.add(new VariableText());
        return validarVerticalmente(tokens, candidatos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return simbolo.ejecutar(tokens);
    }
}
