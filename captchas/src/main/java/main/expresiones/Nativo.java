package main.expresiones;

import main.abstracto.Instruccion;
import main.simbolo.*;

public class Nativo extends Instruccion {

    public Object valor;

    public Nativo(Object valor, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.valor = valor;
    }

    @Override
    public String generarCodigo() {
        if (valor instanceof String) {
            return "\"" + valor + "\"";
        } else {
            return valor.toString();
        }
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return this.valor;
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        String nodoNativo = "n" + arbol.getContador();//n1
        String nodoValor = "n" + arbol.getContador();//n2

        String resultado = anterior + " -> " + nodoNativo + ";\n";

        resultado += nodoNativo + "[label=\"NATIVO\"];\n";
        resultado += nodoValor + "[label=\""
                + this.valor.toString() + "\"];\n";

        resultado += nodoNativo + " -> " + nodoValor + ";\n";
        return resultado;
    }

}
