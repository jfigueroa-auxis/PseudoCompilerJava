/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales;

import BNF.Arbol.Textuales.Literal;
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
public class Condicional extends Simbolo{
    
    List<Simbolo> simbolos;
    
    public Condicional()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new Literal("SI"));
        simbolos.add(new CondicionalCuerpo());
    }

    @Override
    public Resultado validar(List<Token> tokens) {
        return validarHorizontalmente(tokens, simbolos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        simbolos.get(1).ejecutar(desplazar(tokens, 1));
        return new Solucion(_desplazamiento);
    }
}
