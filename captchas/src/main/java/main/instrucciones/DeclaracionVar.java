package main.instrucciones;

import java.util.LinkedList;
import main.abstracto.Instruccion;
import main.excepciones.Errores;
import main.simbolo.*;

public class DeclaracionVar extends Instruccion {
    private String id;
    private Tipo tipo;

    public DeclaracionVar(Tipo tipo, String id, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public String generarCodigo() {
        return "let " + id + ";\n";
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
