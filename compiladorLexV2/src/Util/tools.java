/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Interpreter.Contexto;

/**
 *
 * @author Usuario
 */
public class tools {

    public static boolean esNumerico(String str)  
    {  
      try  
      {  
        double d = Double.parseDouble(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }
    
    public static boolean esComparable(String str)
    {
        return false;
    }
    
    public static boolean  esSimboloComparador(String str)
    {
        return true;
    }
    
    public static boolean  esCadena(String str)
    {
        return str.startsWith("'") && str.endsWith("'");
    }

    public static boolean contieneSimbolos(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean esBooleano(String token) {
        return token.equals("TRUE") || token.equals("FALSE");
    }

    public static boolean esAlfanumerico(String palabra) {
        return true;
    }
}
