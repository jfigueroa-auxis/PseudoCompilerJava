/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Textuales;

import BNF.base.Solucion;
import BNF.base.Resultado;
import Interpreter.Token;
import Util.tools;
import java.util.List;
import BNF.base.Simbolo;

/**
 *
 * @author Usuario
 */
public class Cadena extends Simbolo{

    String cadena;
    
    @Override
    public Resultado validar(List<Token> tokens) {
        Resultado res = new Resultado();
        if(tools.esCadena(tokens.get(0).valor()))
        {
            res.Valido(1);
            cadena = tokens.get(0).valor().replace("'", "");
            _desplazamiento = 1;
        }
        else
            contexto.Error(tokens.get(0), tokens.get(0).valor() + " no es una cadena válida");
        return  res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return new Solucion(cadena, Interpreter.Tipo.TEXT ,_desplazamiento);
    }
}
