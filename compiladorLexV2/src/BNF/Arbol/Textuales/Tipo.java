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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author georg
 */
public class Tipo extends Simbolo {
    
    @Override
    public Resultado validar(List<Token> tokens) {
        List<Simbolo> candidatos = new ArrayList<>();
        candidatos.add(new Literal("TEXT"));
        candidatos.add(new Literal("BOOL"));
        candidatos.add(new Literal("ENTERO"));
        Resultado res = validarVerticalmente(tokens, candidatos);
        
        if(!res.esValido)
        {
            Token token = tokens.get(0);
            contexto.Error(token, token.valor() + " no es un tipo de dato valido");
        }
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return simbolo.ejecutar(tokens);
    }
}
