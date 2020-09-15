/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpreter;

/**
 *
 * @author georg
 */
public class Variable {

    private String _Valor;
    private Tipo _Tipo;

    public Variable(Tipo _Tipo) {
        this._Tipo = _Tipo;
    }

    public String getValor() {
        return _Valor;
    }

    public Tipo getTipo() {
        return _Tipo;
    }
    
    public void setValor(String valor)
    {
        this._Valor = valor;
    }
}
