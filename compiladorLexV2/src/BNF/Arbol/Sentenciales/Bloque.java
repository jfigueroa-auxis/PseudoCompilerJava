/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BNF.Arbol.Sentenciales;

import BNF.Arbol.Sentenciales.Fabricas.*;
import BNF.base.Fabrica.SimboloFactory;
import BNF.base.Resultado;
import BNF.base.Solucion;
import Interpreter.Token;
import java.util.ArrayList;
import java.util.List;
import BNF.base.Simbolo;

/**
 *
 * @author georg
 */
public class Bloque extends Simbolo{

    List<Simbolo> Sentencias;
    
    public Bloque()
    {
        Sentencias = new ArrayList<>();
    }
    
    @Override
    public Resultado validar(List<Token> tokens) {
        Resultado res = new Resultado();
        
        List<SimboloFactory> candidatos = new ArrayList<>();
        candidatos.add(new FabricaAsignacion());
        candidatos.add(new FabricaSuma());
        candidatos.add(new FabricaDefinicion());
        candidatos.add(new FabricaResta());
        candidatos.add(new FabricaCondicional());
        candidatos.add(new FabricaMostrar());
        candidatos.add(new FabricaMultiplicacion());
        candidatos.add(new FabricaMientras());
        candidatos.add(new FabricaLeer());
        
        int posicionLector = 0;
        boolean agotado = false;
        boolean NoRomperWhile = false;
        while(!agotado)
        {
            NoRomperWhile = false;
            for (SimboloFactory fabrica : candidatos) {
                Simbolo sim = fabrica.crear();
                List<Token> tokensRestantes = desplazar(tokens, posicionLector);
                //if(tokensRestantes.isEmpty()) return new Resultado();
                Resultado tmp = sim.validar(tokensRestantes);
                if (tmp.esValido)
                {
                    posicionLector += tmp.PosicionLector;
                    Sentencias.add(sim);
                    NoRomperWhile = true;
                    break;
                }
            }
            if (!NoRomperWhile) agotado = true;
        }
        if(agotado)
        {
            contexto.sobreEscribirError(tokens.get(posicionLector), "No se reconoce la sentencia " + tokens.get(posicionLector).valor());
        }
        _desplazamiento = posicionLector;
        res.Valido(posicionLector);
        return res;
    }

    @Override
    public Solucion ejecutar(List<Token> tokens) {
        int desplazamiento = 0;
        for(Simbolo sim : Sentencias)
        {
            sim.ejecutar(desplazar(tokens, desplazamiento));
            desplazamiento += sim.getDesplazamiento();
        }
        return new Solucion(_desplazamiento);
    }
}
