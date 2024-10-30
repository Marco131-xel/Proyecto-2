package main.instrucciones;

import java.util.LinkedList;
import main.abstracto.Instruccion;
import main.excepciones.Errores;
import main.simbolo.*;

public class DeclaYAsigVar extends Instruccion  {
    private String id;
    private Instruccion exp;
    private Tipo tipo;

    public DeclaYAsigVar(Tipo tipo, String id, Instruccion exp, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
        this.exp = this.exp;
    }

    @Override
    public String generarCodigo() {
        return "let" + id + " = " + exp.generarCodigo() + ";";
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
