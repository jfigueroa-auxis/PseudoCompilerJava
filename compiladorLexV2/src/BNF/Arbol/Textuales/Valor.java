/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Textuales;

import BNF.Arbol.Booleanos.Booleano;
import BNF.Arbol.Numericos.Num;
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
public class Valor extends Simbolo{

    @Override
    public Resultado validar(List<Token> tokens) {
        List<Simbolo> candidatos = new ArrayList<>();
        candidatos.add(new Text());
        candidatos.add(new Num());
        candidatos.add(new Booleano());
        Resultado res = validarVerticalmente(tokens, candidatos);
        if(!res.esValido)
            contexto.Error(tokens.get(0),tokens.get(0).valor() + " no esta definido");
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        Solucion tmp = simbolo.ejecutar(tokens);
        String valor = null;
        switch(tmp.tipo)
        {
            case BOOL:
                valor = String.valueOf((boolean)tmp.resultado);
                break;
            case ENTERO:
                valor = String.valueOf((int)tmp.resultado);
                break;
            case TEXT:
                valor = (String)tmp.resultado;
                break;
                
        }
        return new Solucion(valor , Interpreter.Tipo.TEXT, _desplazamiento);
    }
}
