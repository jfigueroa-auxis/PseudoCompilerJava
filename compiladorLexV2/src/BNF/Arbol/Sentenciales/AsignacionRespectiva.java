/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales;

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
public class AsignacionRespectiva extends Simbolo{

    
    
    @Override
    public Resultado validar(List<Token> tokens) {
        List<Simbolo> candidatos = new ArrayList<>();
        candidatos.add(new AsignacionNumerica());
        candidatos.add(new AsignacionTextual());
        candidatos.add(new AsignacionBooleana());
        Resultado res = validarVerticalmente(tokens, candidatos);
        if(!res.esValido)
            contexto.Error(tokens.get(0), "No es una asignacion de variables válida");
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return simbolo.ejecutar(tokens);
    }
}
