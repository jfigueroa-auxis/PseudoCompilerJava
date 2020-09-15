/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author ivonnemayerli
 */
public class ErrorCompilacion {
    private int _Linea;
    private String _mensaje;
    private int _Posicion;
    
    public ErrorCompilacion()
    {
        _Linea = 0;
        _Posicion = 0;
    }
    
    public ErrorCompilacion(String mensaje, int linea, int posicion)
    {
        _Linea = linea;
        _Posicion = posicion;
        _mensaje = "Error en la linea: " + _Linea +". " + mensaje + "\n";
    }

    public int getLinea() {
        return _Linea;
    }

    public void setLinea(int _Linea) {
        this._Linea = _Linea;
    }

    public String getMensaje() {
        return _mensaje;
    }

    public void setMensaje(String Mensaje) {
        this._mensaje = Mensaje;
    }

    public int getPosicion() {
        return _Posicion;
    }

    public void setPosicion(int _Posicion) {
        this._Posicion = _Posicion;
    }
    
    public void adjuntar(String mensaje)
    {
        this._mensaje += "Error en la linea: " + _Linea +". " + mensaje + "\n";
    }
    
    public void sobreEscribir(String mensaje)
    {
        this._mensaje = "Error en la linea: " + _Linea +". " + mensaje + "\n";
    }
}
