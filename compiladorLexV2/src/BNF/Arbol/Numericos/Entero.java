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
import Interpreter.Tipo;
import Util.tools;

/**
 *
 * @author georg
 */
public class Entero extends Simbolo{

    int numero;
    
    @Override
    public Resultado validar(List<Token> tokens) {
        Resultado res = new Resultado();
        if(tools.esNumerico(tokens.get(0).valor()))
        {
            res.Valido(1);
            numero = Integer.parseInt(tokens.get(0).valor());
            _desplazamiento = 1;
            _simboloValido = true;
        }
        else
            contexto.Error(tokens.get(0),tokens.get(0).valor() + " no es un valor entero");
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return new Solucion(numero, Tipo.ENTERO,_desplazamiento);
    }
}
