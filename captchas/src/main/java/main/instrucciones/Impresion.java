package main.instrucciones;

import java.util.LinkedList;
import main.excepciones.Errores;

public class Impresion {

    private String funcion;
    private String expresion;

    private LinkedList<Errores> listaErrores = new LinkedList<>();

    public Impresion(String funcion, String expresion) {
        this.funcion = funcion;
        this.expresion = expresion;
    }

    public String interprete() {
        switch (funcion) {
            case "ASC":
                return "console.log(" + expresion + ".sort());\n";
            case "DESC":
                return "console.log(" + expresion + ".sort().reverse());\n";
            case "LETPAR":
                return "console.log(" + expresion + ".filter(n => n % 2 === 0));\n";
            case "LETIMPAR":
                return "console.log(" + expresion + ".filter(n => n % 2 !== 0));\n";
            case "REVERSE":
                return "console.log(" + expresion + ".reverse())\n;";
            case "CARALE":
                return "console.log(" + expresion + ".charAt(Math.floor(Math.random() * " + expresion + ".length)));\n";
            case "NUMALE":
                return "console.log(Math.floor(Math.random() * " + expresion + "));\n";
            case "ALEINF":
                return "console.log(Math.random());\n";
            default:
                listaErrores.add(new Errores("SEMANTICO", "Operación desconocida en Aritmeticas", 0, 0, "Verifica el operador"));
                return "";
        }
    }
}
