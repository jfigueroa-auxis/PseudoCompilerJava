/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpreter;

import Util.ErrorCompilacion;
import Util.MensajeCorrecto;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Contexto {
    
    private HashMap<String, Variable> Variables;
    private HashMap<String, String> PalabrasReservadas;
    private static Contexto _instancia;
    private ErrorCompilacion _Error;
    
    private Contexto()
    {
        Variables = new HashMap<>();
        PalabrasReservadas = new HashMap<>();
        _Error = new ErrorCompilacion();
    }
    
    public static  Contexto getContexto()
    {
        if(_instancia == null)
            _instancia = new Contexto();
        return _instancia;
    }
    
    public void Error(Token token, String mensaje) 
    {
        if(token.posicion() > _Error.getPosicion())
            _Error = new ErrorCompilacion(mensaje, token.linea(), token.posicion());
        else if(token.posicion() == _Error.getPosicion())
            _Error.adjuntar(mensaje);
    }
    
    public void sobreEscribirError(Token token, String mensaje)
    {
        if(token.posicion() == _Error.getPosicion())
            _Error.sobreEscribir(mensaje);
    }
    
    public boolean esPalabraReservada(String nombre)
    {
        return PalabrasReservadas.containsKey(nombre);
    }
    
    public Variable ObtenerVariable(String nombre)
    {
        return Variables.containsKey(nombre) ? Variables.get(nombre) : null;
    }
    
    public void definirVariable(String nombre, Tipo tip)
    {
        if(ObtenerVariable(nombre) == null)
            Variables.put(nombre, new Variable(tip));
    }
    
    public void añadirPalabraReservada(String palabra)
    {
        if(palabra == null)
            return;

        if(!PalabrasReservadas.containsKey(palabra))
            PalabrasReservadas.put(palabra, palabra);
    }
    
    public void purgarMemoria()
    {
        Variables = new HashMap<>();
        PalabrasReservadas = new HashMap<>();
        _Error = new ErrorCompilacion();
    }
    
    public String ObtenerError()
    {
        return _Error.getMensaje();
    }
}   
