/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.base;

/**
 *
 * @author Usuario
 */
public class Resultado {
    
    public int PosicionLector;
    public boolean esValido;
    
    public Resultado()
    {
        PosicionLector = 0;
        esValido = false;
    }
    
    public void Valido(int pos)
    {
        PosicionLector = pos;
        esValido = true;
    }
}
