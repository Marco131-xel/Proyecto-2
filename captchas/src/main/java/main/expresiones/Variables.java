package main.expresiones;

import java.util.LinkedList;
import main.abstracto.Instruccion;
import main.excepciones.Errores;
import main.simbolo.*;

public class Variables extends Instruccion {

    private String id;
    private LinkedList<Errores> listaErrores = new LinkedList<>();

    public Variables(String id, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.id = id;
    }

    @Override
    public String generarCodigo() {
        if (id == null || id.isEmpty()) {
            listaErrores.add(new Errores("SEMANTICO", "El identificador de la variable está vacío", this.linea, this.col, "Verifica la declaración de la variable"));
            return ""; 
        }
        return id;
    }
    
    @Override
    public String toString(){
        return id;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return 0;
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        return null;
    }
}