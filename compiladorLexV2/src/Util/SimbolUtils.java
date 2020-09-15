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
public class SimbolUtils {
    
    public static String fronteras ="inicio-fin";
    public static String tipoDato = "text-num-bool";
    public static String tipoBool = "true-false";
    public static String palReserv = "leer-imp-set";
    public static String opMatematic ="sum-res-mul-div-pot";
    public static String opRelacion = "<-<=->=->-<>";
    public static String opLogico ="AND-OR-!";
    public static String sentCondicional="si-sino-fsi";
    public static String terminacionLine=";";
    public static String cadenaSimbol =fronteras+"-"+tipoDato+
            "-"+tipoBool+"-"+palReserv+
            "-"+opMatematic+"-"+opRelacion+
            "-"+opLogico+"-"+sentCondicional+
            "-"+terminacionLine;
    
    // codigo Errores
    public static String codErrcaracterInvalido = "(C1000)";
    public static String codErrLexemaEmpty = "(C1001)";
    public static String codErrLexema = "(C1002)";
    public static String codErrLexemaUbica = "(C1003)";
    
    
    // mensaje Error
    public static String msjErrcaracterInvalido = "Se encontro un error en el escaneo del programa";
    public static String msjErrLexemaEmpty = "No se encuentra ningun lexema a analizar";
    public static String msjErrLexema = "No se encuentra la palabra reservada";
    public static String msjErrLexemaUbica = "Palabra recervada mal ubicada";
    
}
