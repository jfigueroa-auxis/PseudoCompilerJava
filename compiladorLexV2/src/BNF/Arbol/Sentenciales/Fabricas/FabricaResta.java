/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales.Fabricas;

import BNF.Arbol.Sentenciales.Resta;
import BNF.base.Fabrica.SimboloFactory;
import BNF.base.Simbolo;

/**
 *
 * @author georg
 */
public class FabricaResta extends SimboloFactory{

    @Override
    public Simbolo crear() {
        return new Resta();
    }
}
