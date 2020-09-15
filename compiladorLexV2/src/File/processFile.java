/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ivonnemayerli
 */
public class processFile {

    public boolean cargarArchivo(String text, String rutaArchivoFuente) {
        FileWriter flwriter = null;
        try {
                //crea el flujo para escribir en el archivo
                flwriter = new FileWriter(rutaArchivoFuente);
                //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
                BufferedWriter bfwriter = new BufferedWriter(flwriter);
                bfwriter.write(text);
                //cierra el buffer intermedio
                bfwriter.close();
                System.out.println("Archivo creado satisfactoriamente..");
                return true;
        } catch (IOException e) {
                e.printStackTrace();
                return false;
        } finally {
                if (flwriter != null) {
                        try {//cierra el flujo principal
                                flwriter.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }
    }

    public List<String> leerArchivo(String rutaArchivoFuente) {
        File file = new File(rutaArchivoFuente);
        Scanner scanner;
        List<String> listLineas = new ArrayList<String>(); 
        try {
                //se pasa el flujo al objeto scanner
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                        // el objeto scanner lee linea a linea desde el archivo
                        String linea = scanner.nextLine();
                        Scanner delimitar = new Scanner(linea);
                        //se usa una expresión regular
                        //que valida que antes o despues de una coma (,) exista cualquier cosa
                        //parte la cadena recibida cada vez que encuentre una coma				
                        delimitar.useDelimiter("\\s*;\\s*");
                        listLineas.add(linea);
                }
                //se cierra el ojeto scanner
                scanner.close();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }
        return listLineas;
    }
    
}
