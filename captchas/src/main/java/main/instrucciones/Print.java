package main.instrucciones;

import main.abstracto.Instruccion;
import main.excepciones.Errores;
import main.simbolo.*;

public class Print extends Instruccion {

    private Instruccion expresion;

    public Print(Instruccion expresion, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.expresion = expresion;
    }

    @Override
    public String generarCodigo() {
        String codigoExpresion = expresion.generarCodigo();
        return "console.log(" + codigoExpresion + ");";
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        var resultado = this.expresion.interpretar(arbol, tabla);
        if (resultado instanceof Errores) {
            return resultado;
        }
        arbol.Print(resultado.toString());
        return null;
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        // PRINT
        return null;
    }

}
