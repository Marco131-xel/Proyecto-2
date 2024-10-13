package main.excepciones;

public class Errores {

    private String tipo;
    private String desc;
    private int linea;
    private int columna;
    private String solucion;

    public Errores(String tipo, String desc, int linea, int columna, String solucion) {
        this.tipo = tipo;
        this.desc = desc;
        this.linea = linea;
        this.columna = columna;
        this.solucion = solucion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    @Override
    public String toString() {
        return "Errores{" + "tipo=" + tipo + ", desc=" + desc + ", linea=" + linea + ", columna=" + columna + ", solucion=" + solucion + '}';
    }
}
