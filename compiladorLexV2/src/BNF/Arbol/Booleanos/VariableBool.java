/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Booleanos;

import BNF.base.Resultado;
import BNF.base.Simbolo;
import BNF.base.Solucion;
import Interpreter.Tipo;
import Interpreter.Token;
import Interpreter.Variable;
import java.util.List;

/**
 *
 * @author georg
 */
public class VariableBool extends Simbolo{

    Variable variable;
    
    @Override
    public Resultado validar(List<Token> tokens) {
        Resultado res = new Resultado();
        Variable var = contexto.ObtenerVariable(tokens.get(0).valor());
        if(var == null) {
            contexto.Error(tokens.get(0),"la variable " + tokens.get(0).valor() + " no esta definida");
        }
        else if(var.getTipo() == Interpreter.Tipo.BOOL)
        {
            res.Valido(1);
            variable = var;
            _desplazamiento = 1;
        }
        else
            contexto.Error(tokens.get(0),"la variable " + tokens.get(0).valor() + " no es de tipo booleano");
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        boolean valor = Boolean.valueOf(variable.getValor()) ;
        return new Solucion(valor,Tipo.BOOL,_desplazamiento);
    }
}
