package item.acessorio;

import item.Item;
import partida.Stat;

public abstract class Accesorio extends Item{
    /**
     * completar...
     */
    private int inteligencia;

    /**
     * Constructor de la clase abstracta Accesorio.
     * @param nombre Nombre del accesorio.
     */
    protected Accesorio(String nombre, int inteligencia) {
        super(nombre);
        this.inteligencia = inteligencia;
    }

    /**
     * Completar...
     */
    public Stat obtenerStat() {
        return new Stat(0, 0, 0, 0, inteligencia);
    }

    /**
     * completar...
     */
    public String toString(){
        return super.toString() + inteligencia + ']';
    }
}
