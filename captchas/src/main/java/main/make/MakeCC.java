package main.make;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import main.analizadores.*;
import main.excepciones.Errores;

public class MakeCC {
    // Metodo para crear archivos
    public LinkedList<Errores> translatehtml(InputStream inputStream, String outputFile){
       LinkedList<Errores> listaErrores = new LinkedList<>();
       
       try {
           Reader reader = new InputStreamReader(inputStream);
           scanner scanner = new scanner(reader);
           parser parser = new parser(scanner);
           
           parser.parse();
           
           listaErrores.addAll(scanner.getErrores());
           listaErrores.addAll(parser.getErrores());
           
           if (listaErrores.isEmpty()){
               parser.exportHtmlFile(outputFile);
           }
       } catch (Exception e){
           listaErrores.add(new Errores("Error Interno", e.getMessage(),0,0,"Revisar el archivo o el servidor"));
       }
       
       return listaErrores;
    }
}
