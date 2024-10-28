package main.instrucciones;
import main.abstracto.Instruccion;
import main.simbolo.*;
import main.excepciones.Errores;

public class Num_Aleatorio extends Instruccion {

    public Num_Aleatorio(int linea, int col) {
        super(new Tipo(TipoDato.INTEGER), linea, col);
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return (int)(Math.random()*10);
    }

    @Override
    public String generarast(Arbol arbol, String anterior) {
        return null;
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
