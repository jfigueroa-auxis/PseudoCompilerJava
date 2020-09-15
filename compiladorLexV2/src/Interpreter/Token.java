/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpreter;

/**
 *
 * @author Usuario
 */
public class Token {
    private String _valor;
    private int _linea;
    private int _posicion;
    
    public Token()
    {}
    
    public Token(String valor, int linea, int posicion)
    {
        _valor = valor;
        _linea = linea;
        _posicion = posicion;
    }
    
    public String valor()
    {
        return _valor;
    }
    
    public int linea()
    {
        return _linea;
    }
    
    public int posicion()
    {
        return _posicion;
    }
}
