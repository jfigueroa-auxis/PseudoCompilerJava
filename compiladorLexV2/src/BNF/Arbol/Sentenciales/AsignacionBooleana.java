/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales;

import BNF.Arbol.Booleanos.Booleano;
import BNF.Arbol.Booleanos.VariableBool;
import BNF.Arbol.Textuales.VariableText;
import BNF.base.Resultado;
import BNF.base.Simbolo;
import BNF.base.Solucion;
import Interpreter.Token;
import Interpreter.Variable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author georg
 */
public class AsignacionBooleana extends Simbolo{

    List<Simbolo> simbolos;
    
    public AsignacionBooleana()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new VariableBool());
        simbolos.add(new Booleano());
    }
    
    @Override
    public Resultado validar(List<Token> tokens) {
        Resultado res = validarHorizontalmente(tokens, simbolos);
        if(!res.esValido)
            contexto.Error(tokens.get(0), "No es una asignacion de variable booleana válida");
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        String nombreVariable = tokens.get(0).valor();
        Variable var = contexto.ObtenerVariable(nombreVariable);
        boolean valor = (boolean)simbolos.get(1).ejecutar(desplazar(tokens, 1)).resultado;
        var.setValor(String.valueOf(valor));
        return new Solucion(2);
    }
    
}
