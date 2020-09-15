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
 * @author hpclab
 */
public class NegacionBooleana extends Simbolo{

    List<Simbolo> simbolos;
    
    public NegacionBooleana()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new Literal("!"));
        simbolos.add(new Expresion());
    }
    
    @Override
    public Resultado validar(List<Token> tokens) {
        return validarHorizontalmente(tokens, simbolos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        Solucion tmp = simbolos.get(1).ejecutar(tokens.subList(1, tokens.size()));
        return new Solucion(!((boolean)tmp.resultado), Tipo.BOOL,tmp.posicionLector + 1);
    }
}
