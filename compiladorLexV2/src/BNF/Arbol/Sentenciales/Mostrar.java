/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales;

import BNF.Arbol.Textuales.Literal;
import BNF.Arbol.Textuales.Text;
import BNF.Arbol.Textuales.Valor;
import BNF.Arbol.Textuales.Variable;
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
public class Mostrar extends Simbolo{

    List<Simbolo> simbolos;
    
    public Mostrar()
    {
        simbolos = new ArrayList<>();
        simbolos.add(new Literal("MTR"));
        simbolos.add(new Valor());
    }
    
    @Override
    public Resultado validar(List<Token> tokens) {
        return validarHorizontalmente(tokens, simbolos);
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        String valor = (String)simbolos.get(1).ejecutar(desplazar(tokens, 1)).resultado;
        JOptionPane.showMessageDialog(null,valor);
        return new Solucion(_desplazamiento);
    }
}
