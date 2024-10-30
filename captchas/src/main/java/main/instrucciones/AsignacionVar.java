package main.instrucciones;

import java.util.LinkedList;
import main.abstracto.Instruccion;
import main.excepciones.Errores;
import main.simbolo.*;

public class AsignacionVar extends Instruccion{
    private String id;
    private Instruccion exp;

    public AsignacionVar(String id, Instruccion exp, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.id = id;
        this.exp = exp;
    }

    @Override
    public String generarCodigo() {
        return  id + " = " + exp.generarCodigo() + ";\n";
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
