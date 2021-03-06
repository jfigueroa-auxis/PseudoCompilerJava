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
import Interpreter.Variable;

/**
 *
 * @author Usuario
 */
public class VariableText extends Simbolo{
    
    Variable variable;
    
    @Override
    public Resultado validar(List<Token> tokens) {
        Resultado res = new Resultado();
        Variable var = contexto.ObtenerVariable(tokens.get(0).valor());
        if(var == null) {
            contexto.Error(tokens.get(0),"la variable " + tokens.get(0).valor() + " no esta definida");
        }
        else if(var.getTipo() == Interpreter.Tipo.TEXT)
        {
            res.Valido(1);
            variable = var;
            _desplazamiento = 1;
        }
        else
            contexto.Error(tokens.get(0),"la variable " + tokens.get(0).valor() + " no es de tipo texto");
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        return new Solucion(variable.getValor(),Interpreter.Tipo.TEXT ,_desplazamiento);
    }
}
