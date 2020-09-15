/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales.Fabricas;

import BNF.Arbol.Sentenciales.Asignacion;
import BNF.base.Fabrica.SimboloFactory;
import BNF.base.Simbolo;

/**
 *
 * @author georg
 */
public class FabricaAsignacion extends SimboloFactory{

    @Override
    public Simbolo crear() {
        return new Asignacion();
    }
}
