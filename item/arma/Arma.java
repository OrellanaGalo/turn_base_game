package item.arma;

import item.Item;
import partida.Stat;

public abstract class Arma extends Item{
    /**
     * Ataque base que posee el arma.
     */
    private int ataque;

    /**
     * Condicion actual en la cual se encuentra el arma.
     */
    private int condicion;

    /**
     * Constructor de la clase abstracta Arma.
     * @param nombre Nombre del arma.
     * @param ataque Ataque base del arma.
     * @param condicion Condicion total del arma.
     */
    public Arma(String nombre, int ataque, int condicion) {
        super(nombre);
        this.ataque = ataque;
        this.condicion = condicion;
    }

    /**
     * Crea un nuevo Stat en base al atributo principal de cada clase.
     */
    public Stat obtenerStat() {
        return new Stat(0, 0, ataque, 0, 0);
    }

    /**
     * completar...
     */
    public String toString() {
        return super.toString() + ataque + "//" + condicion + ']';
    }
}
