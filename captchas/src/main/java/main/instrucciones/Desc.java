package main.instrucciones;
import java.util.Arrays;
import main.abstracto.Instruccion;
import main.simbolo.*;
import main.excepciones.Errores;

public class Desc extends Instruccion {
    
    private Instruccion palabra;
    
    public Desc(Instruccion palabra, int linea, int col) {
        super(new Tipo(TipoDato.STRING), linea, col);
        this.palabra = palabra;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        String str = (String) palabra.interpretar(arbol, tabla);
        if(str == null) return null;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(new StringBuilder(new String(chars)).reverse());
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        return null;
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
