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
public class CondicionalDoble extends Simbolo{

    List<Simbolo> simbolos;
    
    public CondicionalDoble()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new Expresion());
        simbolos.add(new Literal("ENTONCES"));
        simbolos.add(new Bloque());
        simbolos.add(new Literal("ELSE"));
        simbolos.add(new Bloque());
        simbolos.add(new Literal("FSI"));
    }
    
    @Override
    public Resultado validar(List<Token> tokens) {
        return validarHorizontalmente(tokens, simbolos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        Solucion tmp = simbolos.get(0).ejecutar(tokens);
        boolean resultadoExpresion = (boolean)tmp.resultado;
        if(resultadoExpresion)
            simbolos.get(2).ejecutar(desplazar(tokens, tmp.posicionLector + 1));
        else
        {
            int despExpresion = simbolos.get(0).getDesplazamiento();
            int despBloqueUno = simbolos.get(2).getDesplazamiento();
            simbolos.get(4).ejecutar(desplazar(tokens, despExpresion + despBloqueUno + 2));
        }
        return new Solucion(_desplazamiento);
    }
}
