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
    }

    @Override
    public String generarCodigo() {
        StringBuilder codigo = new StringBuilder();

        // Caso para operaciones unarias como la negación
        if (operacion == OperadoresAritmeticos.NEGACION && ope0 != null) {
            codigo.append("-").append(ope0.generarCodigo());
        } // Caso para operaciones binarias como suma, resta, etc.
        else if (ope1 != null && ope2 != null) {
            // Agrega el código del primer operando
            codigo.append(ope1.generarCodigo());

            switch (operacion) {
                case SUMA:
                    codigo.append(" + ");
                    break;
                case RESTA:
                    codigo.append(" - ");
                    break;
                case MULTIPLICACION:
                    codigo.append(" * ");
                    break;
                case DIVISION:
                    codigo.append(" / ");
                    break;
                default:
                    listaErrores.add(new Errores("SEMANTICO", "Operación desconocida en Aritmeticas", this.linea, this.col, "Verifica el operador"));
                    return "";
            }

            // Agrega el código del segundo operando
            codigo.append(ope2.generarCodigo());
        } else {
            listaErrores.add(new Errores("SEMANTICO", "Faltan operandos en la expresión aritmética", this.linea, this.col, "Verifica los operandos"));
            return "";
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
