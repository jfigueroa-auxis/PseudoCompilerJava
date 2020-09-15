/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Booleanos;

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
public class Booleano extends Simbolo{
    
    @Override
    public Resultado validar(List<Token> tokens) {
       List<Simbolo> candidatos = new ArrayList<>();
       candidatos.add(new Bool());
       candidatos.add(new VariableBool());
       return validarVerticalmente(tokens, candidatos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return simbolo.ejecutar(tokens);
    }
}
