/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales;

import BNF.Arbol.Textuales.Cadena;
import BNF.Arbol.Textuales.Literal;
import BNF.Arbol.Textuales.Variable;
import BNF.Arbol.Textuales.VariableText;
import BNF.base.Resultado;
import BNF.base.Simbolo;
import BNF.base.Solucion;
import Interpreter.Token;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author georg
 */
public class Leer extends Simbolo{

    List<Simbolo> simbolos;
    
    public Leer()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new Literal("LEER"));
        simbolos.add(new Cadena());
        simbolos.add(new VariableText());
    }
    @Override
    public Resultado validar(List<Token> tokens) {
        return validarHorizontalmente(tokens, simbolos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        String nombreVariable = tokens.get(2).valor();
        Interpreter.Variable var = contexto.ObtenerVariable(nombreVariable);
        String valor = JOptionPane.showInputDialog((String)simbolos.get(1).ejecutar(desplazar(tokens,1)).resultado);
        var.setValor(valor);
        return new Solucion(_desplazamiento);
    }
}
