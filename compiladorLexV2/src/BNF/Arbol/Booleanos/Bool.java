/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Booleanos;

import BNF.Arbol.Textuales.Literal;
import BNF.base.Resultado;
import BNF.base.Solucion;
import Interpreter.Token;
import java.util.ArrayList;
import java.util.List;
import BNF.base.Simbolo;
import Interpreter.Tipo;

/**
 *
 * @author georg
 */
public class Bool extends Simbolo
{

    @Override
    public Resultado validar(List<Token> tokens) {
        List<Simbolo> candidatos = new ArrayList<>();
        candidatos.add(new Literal("TRUE"));
        candidatos.add(new Literal("FALSE"));
        Resultado res = validarVerticalmente(tokens, candidatos);
        if(!res.esValido)
        {
            Token token = tokens.get(0);
            contexto.Error(token, token.valor() + " no es un valor booleano válido");
        }
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        Solucion tmp = simbolo.ejecutar(tokens);
        return new Solucion(((String)tmp.resultado).equals("TRUE"),Tipo.BOOL ,_desplazamiento);
    }
    
}
