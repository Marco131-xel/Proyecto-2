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
        StringBuilder codigo = new StringBuilder();

        // Caso para operaciones unarias como NOT
        if (logico == OperadoresLogicos.NOT && log != null) {
            codigo.append("!").append(log.generarCodigo());
        } // Caso para operaciones binarias como AND, OR
        else if (log1 != null && log2 != null) {
            // Agrega el código del primer operando
            codigo.append(log1.generarCodigo());

            // Determina el operador en JavaScript según el tipo de operación
            switch (logico) {
                case AND:
                    codigo.append(" && ");
                    break;
                case OR:
                    codigo.append(" || ");
                    break;
                default:
                    // Agregar un error si el operador es desconocido
                    listaErrores.add(new Errores("SEMANTICO", "Operación lógica desconocida", this.linea, this.col, "Verifica el operador lógico"));
                    return ""; // Retorna cadena vacía en caso de error
            }

            // Agrega el código del segundo operando
            codigo.append(log2.generarCodigo());
        } else {
            // Si alguno de los operandos es nulo, agrega un error
            listaErrores.add(new Errores("SEMANTICO", "Faltan operandos en la expresión lógica", this.linea, this.col, "Verifica los operandos"));
            return ""; // Retorna cadena vacía en caso de error
        }

        return codigo.toString();
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
