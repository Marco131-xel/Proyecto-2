package main.instrucciones;

public class Par<K,V> {
    private K primero;
    private V segundo;

    public Par(K primero, V segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public K getPrimero() {
        return primero;
    }

    public V getSegundo() {
        return segundo;
    }

    public void setPrimero(K primero) {
        this.primero = primero;
    }

    public void setSegundo(V segundo) {
        this.segundo = segundo;
    }
}
