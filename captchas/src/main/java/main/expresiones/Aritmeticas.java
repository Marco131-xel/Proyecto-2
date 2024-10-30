package main.expresiones;

import java.util.LinkedList;
import main.abstracto.Instruccion;
import main.excepciones.Errores;
import main.simbolo.*;

public class Aritmeticas extends Instruccion {

    private Instruccion ope1;
    private Instruccion ope2;
    private OperadoresAritmeticos operacion;
    private Instruccion ope0;

    private LinkedList<Errores> listaErrores = new LinkedList<>();

    public Aritmeticas(Instruccion ope0, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(TipoDato.INTEGER), linea, col);
        this.operacion = operacion;
        this.ope0 = ope0;
    }

    public Aritmeticas(Instruccion ope1, Instruccion ope2, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(TipoDato.INTEGER), linea, col);
        this.ope1 = ope1;
        this.ope2 = ope2;
        this.operacion = operacion;
    }

    @Override
    public String generarCodigo() {
        String codigo = "";
        switch (operacion) {
            case SUMA:
                codigo = ope1.generarCodigo() + " + " + ope2.generarCodigo();
                break;
            case RESTA:
                codigo = ope1.generarCodigo() + " - " + ope2.generarCodigo();
                break;
            case MULTIPLICACION:
                codigo = ope1.generarCodigo() + " * " + ope2.generarCodigo();
                break;
            case DIVISION:
                if (ope2.generarCodigo().equals("0")) {
                    listaErrores.add(new Errores("SEMANTICO", "División por cero", linea, col, "Revisa el divisor"));
                }
                codigo = ope1.generarCodigo() + " / " + ope2.generarCodigo();
                break;
            case NEGACION:
                codigo = "-" + ope0.generarCodigo();
                break;
            default:
                listaErrores.add(new Errores("SEMANTICO", "Operación aritmética desconocida", linea, col, "Verifica el operador"));
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
