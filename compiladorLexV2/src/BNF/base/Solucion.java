/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.base;

import Interpreter.Tipo;

/**
 *
 * @author Usuario
 */
public class Solucion {
    
    public int posicionLector;
    public Object resultado;
    public Tipo tipo;
    
    public Solucion()
    {
        
    }
    public Solucion(int avanceLector)
    {
        this.posicionLector = avanceLector;
    }
    public Solucion(Object resultado, Tipo tipo,int avanceLector)
    {
        this.resultado = resultado;
        this.posicionLector = avanceLector;
        this.tipo = tipo;
    }

}
