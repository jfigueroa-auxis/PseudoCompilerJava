package BNF.base;

import Interpreter.Contexto;
import Interpreter.Token;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public abstract class Simbolo {
    
    protected Contexto contexto = Contexto.getContexto();
    protected int _desplazamiento = 0;
    protected Simbolo simbolo;
    protected boolean _simboloValido = false;
    
    public abstract Resultado validar(List<Token> tokens);
    public abstract Solucion ejecutar(List<Token> tokens);
    
    protected Resultado validarVerticalmente(List<Token> tokens, List<Simbolo> candidatos)
    {        
        Resultado res = new Resultado();
        for (Simbolo sim : candidatos) {
            res = sim.validar(tokens);
            if (res.esValido)
            {
                simbolo = sim;
                _desplazamiento = simbolo.getDesplazamiento();
                _simboloValido = simbolo.getEsValido();
                return res;
            }  
        }
        return res;
    }
    
    protected Resultado validarHorizontalmente(List<Token> tokens, List<Simbolo> tuplas)
    {
        Resultado res = new Resultado();
        boolean tuplaValida = true;
        int posicionLector = 0;
        
        for (Simbolo sim : tuplas) {
            List<Token> tokensRestantes = desplazar(tokens, posicionLector);
            //if(tokensRestantes.isEmpty()) return new Resultado();
            Resultado tmp = sim.validar(tokensRestantes);
            if (tmp.esValido)
                posicionLector += tmp.PosicionLector;
            else
            {
                tuplaValida = false;
                break;
            }
        }
        if(tuplaValida) 
        {
            res.Valido(posicionLector);
            _desplazamiento = posicionLector;
            _simboloValido = true;
        }
        return res;
    }
    
    protected List<Token> desplazar(List<Token> tokens, int desplazamiento)
    {
        List<Token> result = new ArrayList<>();
        try
        {
            result = tokens.subList(desplazamiento, tokens.size());
        }
        catch(Exception ex)
        {
        }
        return result;
    }
    
    public int getDesplazamiento()
    {
        return _desplazamiento;
    }
    
    public boolean getEsValido()
    {
        return _simboloValido;
    }
}
