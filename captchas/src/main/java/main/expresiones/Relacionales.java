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
        String codigo = "";
        switch (relacional) {
            case EQUALS:
                codigo = cond1.generarCodigo() + " == " + cond2.generarCodigo();
                break;
            case NOTEQUALS:
                codigo = cond1.generarCodigo() + " != " + cond2.generarCodigo();
                break;
            case MENORIGUAL:
                codigo = cond1.generarCodigo() + " <= " + cond2.generarCodigo();
                break;
            case MAYORIGUAL:
                codigo = cond1.generarCodigo() + " >= " + cond2.generarCodigo();
                break;
            case MENORQUE:
                codigo = cond1.generarCodigo() + " < " + cond2.generarCodigo();
                break;
            case MAYORQUE:
                codigo = cond1.generarCodigo() + " > " + cond2.generarCodigo();
                break;
            default:
                listaErrores.add(new Errores("SEMANTICO", "Operación relacional desconocida", this.linea, this.col, "Verifica el operador relacional"));
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
