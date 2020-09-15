/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales;

import BNF.Arbol.Booleanos.Expresion;
import BNF.Arbol.Textuales.Literal;
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
public class Mientras extends Simbolo{
    
    List<Simbolo> simbolos;
    
    public Mientras()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new Literal("MIENTRAS"));
        simbolos.add(new Expresion());
        simbolos.add(new Literal("HACER"));
        simbolos.add(new Bloque());
        simbolos.add(new Literal("FMIENTRAS"));
    }

    @Override
    public Resultado validar(List<Token> tokens) {
        return validarHorizontalmente(tokens, simbolos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        while((boolean)simbolos.get(1).ejecutar(desplazar(tokens, 1)).resultado)
        {
            simbolos.get(3).ejecutar(desplazar(tokens, simbolos.get(1).getDesplazamiento() + 2));
        }
        return new Solucion(_desplazamiento);
    }
}
