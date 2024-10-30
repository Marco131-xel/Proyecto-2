package main.expresiones;

import java.util.LinkedList;
import main.abstracto.Instruccion;
import main.excepciones.Errores;
import main.simbolo.*;

public class Logicos extends Instruccion {

    private Instruccion log1;
    private Instruccion log2;
    private OperadoresLogicos logico;
    private Instruccion log;
    
    private LinkedList<Errores> listaErrores = new LinkedList<>();

    // Solo una operacion
    public Logicos(Instruccion log, OperadoresLogicos logico, int linea, int col) {
        super(new Tipo(TipoDato.BOOLEAN), linea, col);
        this.logico = logico;
        this.log = log;
    }

    // operacion de dos 
    public Logicos(Instruccion log1, Instruccion log2, OperadoresLogicos logico, int linea, int col) {
        super(new Tipo(TipoDato.BOOLEAN), linea, col);
        this.log1 = log1;
        this.log2 = log2;
        this.logico = logico;
    }
    
     @Override
    public String generarCodigo() {
        String codigo = "";
        switch (logico) {
            case OR:
                codigo = log1.generarCodigo() + " || " + log2.generarCodigo();
                break;
            case AND:
                codigo = log1.generarCodigo() + " && " + log2.generarCodigo();
                break;
            case NOT:
                codigo = "!" + log.generarCodigo();
                break;
            default:
                listaErrores.add(new Errores("SEMANTICO", "Operación lógica desconocida", this.linea, this.col, "Verifica el operador lógico"));
        }
        return codigo;
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
