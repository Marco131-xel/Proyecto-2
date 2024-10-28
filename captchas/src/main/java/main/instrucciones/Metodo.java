package main.instrucciones;

import main.abstracto.Instruccion;
import main.simbolo.*;
import java.util.HashMap;
import java.util.LinkedList;

public class Metodo extends Instruccion {
    
    public String id;
    public LinkedList<HashMap> parametros;
    public LinkedList<Instruccion> instrucciones;

    public Metodo(String id, LinkedList<HashMap> parametros, LinkedList<Instruccion> instrucciones, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
    }
    
    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        for (var i : this.instrucciones){
            var resultado = i.interpretar(arbol, tabla);
        }
        return null;
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        String resultado = "";
        for (var i : this.instrucciones){
            resultado += i.generarast(arbol, anterior);
        }
        return resultado;
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
