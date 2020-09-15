/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Textuales;

import BNF.base.Solucion;
import BNF.base.Resultado;
import Interpreter.Token;
import java.util.List;
import BNF.base.Simbolo;

/**
 *
 * @author Usuario
 */
public class Literal extends Simbolo{
    
    String _cadena;
    
    public Literal(String cadena)
    {
        _cadena = cadena;
        contexto.añadirPalabraReservada(cadena);
    }

    @Override
    public Resultado validar(List<Token> tokens) {
        Resultado res = new Resultado();
        if(tokens.get(0).valor().equals(_cadena))
        {
            res.Valido(1);
            _desplazamiento = 1;
            _simboloValido = true;
        }
        else
            contexto.Error(tokens.get(0), "Se esperaba la palabra reservada: "+ _cadena);
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return new Solucion(_cadena, Interpreter.Tipo.TEXT,_desplazamiento);
    }
}
