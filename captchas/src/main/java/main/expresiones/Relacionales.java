package main.expresiones;

import java.util.LinkedList;
import main.abstracto.Instruccion;
import main.excepciones.Errores;
import main.simbolo.*;

public class Relacionales extends Instruccion {

    private Instruccion cond1;
    private Instruccion cond2;
    private OperadoresRelacionales relacional;

    private LinkedList<Errores> listaErrores = new LinkedList<>();

    public Relacionales(Instruccion cond1, Instruccion cond2, OperadoresRelacionales relacional, int linea, int col) {
        super(new Tipo(TipoDato.BOOLEAN), linea, col);
        this.cond1 = cond1;
        this.cond2 = cond2;
        this.relacional = relacional;
    }

    @Override
    public String generarCodigo() {
        StringBuilder codigo = new StringBuilder();

        // Verifica que ambos operandos estén presentes
        if (cond1 != null && cond2 != null) {
            // Agrega el código del primer operando
            codigo.append(cond1.generarCodigo());

            // Determina el operador en JavaScript según el tipo de operación relacional
            switch (relacional) {
                case EQUALS:
                    codigo.append(" === ");
                    break;
                case NOTEQUALS:
                    codigo.append(" !== ");
                    break;
                case MENORIGUAL:
                    codigo.append(" <= ");
                    break;
                case MAYORIGUAL:
                    codigo.append(" >= ");
                    break;
                case MENORQUE:
                    codigo.append(" < ");
                    break;
                case MAYORQUE:
                    codigo.append(" > ");
                    break;
                default:
                    // Agregar un error si el operador es desconocido
                    listaErrores.add(new Errores("SEMANTICO", "Operación relacional desconocida", this.linea, this.col, "Verifica el operador relacional"));
                    return ""; // Retorna cadena vacía en caso de error
            }

            // Agrega el código del segundo operando
            codigo.append(cond2.generarCodigo());
        } else {
            // Si alguno de los operandos es nulo, agrega un error
            listaErrores.add(new Errores("SEMANTICO", "Faltan operandos en la expresión relacional", this.linea, this.col, "Verifica los operandos"));
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
