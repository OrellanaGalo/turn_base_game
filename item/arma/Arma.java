package item.arma;

import item.Item;

public abstract class Arma extends Item{
    /**
     * Ataque base que posee el arma.
     */
    public int ataque;

    /**
     * Condicion actual en la cual se encuentra el arma.
     */
    public int condicion;

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
     * completar...
     */
    public String toString() {
        return super.toString() + ataque + condicion + ']';
    }
}
