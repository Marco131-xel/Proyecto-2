package main.analizadores;

public class Generador {
    public static void main(String[] args) {
        generar();
    }
    
    public static void generar(){
        try{
            String ruta = "src/main/java/main/analizadores/";
            
            System.out.println("\t============ ANALIZADOR LEXICO ==============");
            String Flex[] = {ruta + "lexico.jflex", "-d", ruta};
            jflex.Main.generate(Flex);
            
            System.out.println("\t============ ANALIZADOR SINTACTICO =================");
            String Cup[] = { "-destdir", ruta, "-parser", "parser", ruta + "sintactico.cup" };
            java_cup.Main.main(Cup);
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}