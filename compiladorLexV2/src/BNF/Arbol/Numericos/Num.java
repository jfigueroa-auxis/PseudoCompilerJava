/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Numericos;

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
public class Num extends Simbolo{
    

    @Override
    public Resultado validar(List<Token> tokens) {
        List<Simbolo> candidatos = new ArrayList<>();
        candidatos.add(new Entero());
        candidatos.add(new VariableNum());
        Resultado res = validarVerticalmente(tokens, candidatos);
        if(!res.esValido)
            contexto.Error(tokens.get(0),tokens.get(0).valor() + " no es de tipo numero");
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return simbolo.ejecutar(tokens);
    }
}
