package compiladorlex;


import Util.ErrorCompilacion;
import Util.SimbolUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MetodosAuxiliares {
//private ErrorCompilacion mErr = new ErrorCompilacion();
// Metodo para verificar lexemas en la tabla de simbolos    
     public String consultarEnTablaDeSimbolos(String lexema){
        if(lexema != null && !lexema.isEmpty()){
            String[] datosLexema =SimbolUtils.cadenaSimbol.split("-");
            for (int i = 0 ; i < datosLexema.length;i++){
                if (lexema.toLowerCase().trim().equals(datosLexema[i])){
                    return lexema;
                }
            }
            return null;
        }else{
            //mErr.setLinea(SimbolUtils.codErrLexemaEmpty);
            //mErr.setMensaje(SimbolUtils.msjErrLexemaEmpty);
            return null;// mErr.getLinea() +" - "+mErr.getMensaje() + " !!";
        }
        
    }
    
   
 
    // Al encontrar lexema en la tabla de simbolos, se actualiza archivo de 
    // Analisis lexico.
    public void actualizarLexemasIdentificaos(String lexema, String token)
    {
    	Configuracion configuracion = new Configuracion();
        FileWriter fileWriter2 = null;
        BufferedWriter bufferedWriter2 = null;
        try
        {
            fileWriter2 = new FileWriter(configuracion.getArchivoAnalisisLexico(), true);
            bufferedWriter2 = new BufferedWriter(fileWriter2);
            bufferedWriter2.write("  Referencia: "+ "lexema: " + lexema + " :"+ " token: " + token + "\n" );
        }
        catch (IOException ex)
        {
            System.out.println(":( Error al actualizar la tabla de simbolos");
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                bufferedWriter2.close();
                fileWriter2.close();
            }
            catch (IOException ex)
            {
                System.out.println(":( Error .close() actualizar la tabla de simbolos");
                ex.printStackTrace();
            }

        }
    }

    public void actualizarLinea(String linea, int numeroDeLinea)
    {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        Configuracion configuracion = new Configuracion();
        try
        {
            fileWriter = new FileWriter(configuracion.getArchivoAnalisisLexico(), true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Linea " + numeroDeLinea + ": " + linea + "\n");
        }
        catch (IOException ex)
        {
            System.out.println("error al actualizar la tabla de simbolos");
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                bufferedWriter.close();
                fileWriter.close();

            }
            catch (IOException ex)
            {
                System.out.println("error .close() actualizar la tabla de simbolos");
                ex.printStackTrace();
            }

        }
    }

    // Impresion en patalla los resultados realizados
    public ArrayList  mostrarInformacionEnPantalla(String file)
    {
        ArrayList <String> informacionArchivo = new ArrayList();
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
        try
        {
            fileReader = new FileReader(file);
            bufferReader = new BufferedReader(fileReader);
            try
            {
                while (bufferReader.ready())
                {
                    String linea = bufferReader.readLine();
                    System.out.println(linea);
                    informacionArchivo.add(linea);
                }
            }
            catch (IOException ex)
            {
                System.out.println(":( Error al leer el archivo");
                ex.printStackTrace();
            }


        }
        catch (FileNotFoundException ex)
        {
            System.out.println(":( Error al abrir el archivo");
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                bufferReader.close();
                fileReader.close();
            }
            catch (IOException ex)
            {
                System.out.println(":( Error al cerrar el archivo");
                ex.printStackTrace();
            }
        }
        return informacionArchivo;
    }

    
    public ArrayList  mostrarInformacionEnPantallaTabla(String file)
    {
        ArrayList <String> informacionArchivo = new ArrayList();
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
        try
        {
            fileReader = new FileReader(file);
            bufferReader = new BufferedReader(fileReader);
            
            		informacionArchivo.add("programa:programa");
                    informacionArchivo.add("int:int");
                    informacionArchivo.add("char:char");
                    informacionArchivo.add("float:float");
                    informacionArchivo.add("leer:leer");
                    informacionArchivo.add("imprimir:imprimir");
                    informacionArchivo.add("+:+");
                    informacionArchivo.add("-:-");
                    informacionArchivo.add("*:*");
                    informacionArchivo.add("/:/");
                    informacionArchivo.add("=:=");
                    informacionArchivo.add("terminar:terminar");
                    informacionArchivo.add("mientras:mientras");
                    informacionArchivo.add("si:si");
                    informacionArchivo.add("sino:sino");
                    informacionArchivo.add(",:,");
                    informacionArchivo.add("\"\"");
                    informacionArchivo.add("(:(");
                    informacionArchivo.add("):)");
                    informacionArchivo.add("{:{");
                    informacionArchivo.add("}:}");
                    informacionArchivo.add("&:&");
                    informacionArchivo.add("&&:&&");
                    informacionArchivo.add("|:|");
                    informacionArchivo.add("||:||");
                    informacionArchivo.add(";:;");
            

        }
        catch (FileNotFoundException ex)
        {
            System.out.println(":( Error al abrir el archivo");
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                bufferReader.close();
                fileReader.close();
            }
            catch (IOException ex)
            {
                System.out.println(":( Error al cerrar el archivo");
                ex.printStackTrace();
            }
        }
        return informacionArchivo;
    }
    
    public void actualizarLexemasIdentificaosCompleto(String linea)
    {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        Configuracion configuracion = new Configuracion();
        try
        {
            fileWriter = new FileWriter(configuracion.getArchivoAnalisisLexicoCompleto(), true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(linea + "\n");
        }
        catch (IOException ex)
        {
            System.out.println("error al actualizar la tabla de simbolos");
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                bufferedWriter.close();
                fileWriter.close();

            }
            catch (IOException ex)
            {
                System.out.println("error .close() actualizar la tabla de simbolos");
                ex.printStackTrace();
            }

        }
    }

    public void actualizarTablaSimbolos(String linea)
    {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        Configuracion configuracion = new Configuracion();
        try
        {
            fileWriter = new FileWriter(configuracion.getTablaSimbolosAct(), true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(linea + "\n");
        }
        catch (IOException ex)
        {
            System.out.println("error al actualizar la tabla de simbolos");
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                bufferedWriter.close();
                fileWriter.close();

            }
            catch (IOException ex)
            {
                System.out.println("error .close() actualizar la tabla de simbolos");
                ex.printStackTrace();
            }

        }
    }

    public void actualizarLineaP1(String linea)
    {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        Configuracion configuracion = new Configuracion();
        try
        {
            fileWriter = new FileWriter(configuracion.getArchivoAnalisisPrograma1(), true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(linea + "\n");
        }
        catch (IOException ex)
        {
            System.out.println("error al actualizar la tabla de simbolos");
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                bufferedWriter.close();
                fileWriter.close();

            }
            catch (IOException ex)
            {
                System.out.println("error .close() actualizar la tabla de simbolos");
                ex.printStackTrace();
            }

        }
    }
	
}
