package compiladorlex;


import java.io.File;

public class Configuracion {

	File file = new File("tabla_simbolos.txt");
	public String ruta= "D:/"; 
	private String tablaSimbolos ="tabla_simbolos.txt";
	private String archivoAnalisisLexico ="analisisLexico.txt";
	private String archivoAnalisisLexicoCompleto ="analisisLexicoCompleto.txt";
	private String archivoAnalisisPrograma1 ="analisisPrograma1.txt";
	private String tablaSimbolosAct="Tabla_Simbolos_Actualizada";
		
	public String getTablaSimbolos() {
        return tablaSimbolos;
    }
	
	public String getTablaSimbolosAct() {
        return tablaSimbolosAct;
    }
	
	public String getArchivoAnalisisLexico() {
        return archivoAnalisisLexico;
    }

	public String getArchivoAnalisisLexicoCompleto() {
        return archivoAnalisisLexicoCompleto;
    }

	public String getArchivoAnalisisPrograma1() {
        return archivoAnalisisPrograma1;
    }
	
	public String setRuta(String val) {
        return ruta=val;
    }
}