/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Textuales;

import BNF.base.Solucion;
import BNF.base.Resultado;
import Interpreter.Token;
import java.util.ArrayList;
import java.util.List;
import BNF.base.Simbolo;

/**
 *
 * @author Usuario
 */
public class Text extends Simbolo{

    @Override
    public Resultado validar(List<Token> tokens) {
        List<Simbolo> candidatos = new ArrayList<>();
        candidatos.add(new Cadena());
        candidatos.add(new VariableText());
        return validarVerticalmente(tokens, candidatos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return simbolo.ejecutar(tokens);
    }
}
