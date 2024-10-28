package main.instrucciones;
import java.util.Arrays;
import main.abstracto.Instruccion;
import main.simbolo.*;
import main.excepciones.Errores;

public class AlertInfo extends Instruccion{
    
    private Instruccion mensaje;
    
    public AlertInfo(Instruccion mensaje, int linea, int col) {
        super(new Tipo(TipoDato.VOID), linea, col);
        this.mensaje = mensaje;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        String msg = (String) mensaje.interpretar(arbol, tabla);
        if(msg != null){
            arbol.Print("Alert: " + msg);
        }
        return null;
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
