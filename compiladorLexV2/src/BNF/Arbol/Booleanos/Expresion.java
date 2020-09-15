/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Booleanos;

import BNF.base.Resultado;
import BNF.base.Solucion;
import Interpreter.Token;
import java.util.ArrayList;
import java.util.List;
import BNF.base.Simbolo;

/**
 *
 * @author georg
 */
public class Expresion extends Simbolo{

    
    @Override
    public Resultado validar(List<Token> tokens) {
        List<Simbolo> candidatos = new ArrayList<>();
        candidatos.add(new ExpresionLogicoNumerica());
        candidatos.add(new ExpresionLogicoTextual());
        candidatos.add(new ExpresionLogicoBooleana());
        candidatos.add(new NegacionBooleana());
        candidatos.add(new Booleano());
        Resultado res = validarVerticalmente(tokens, candidatos);
        if(!res.esValido)
            contexto.Error(tokens.get(0), "No es una expresion valida");
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return simbolo.ejecutar(tokens);
    }
}
