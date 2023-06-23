package item.arma;

import item.Item;

public abstract class Arma extends Item{
    /**
     * Ataque base que posee el arma.
     */
    public float ataque;

    /**
     * Condicion actual en la cual se encuentra el arma.
     */
    public float condicion;

    /**
     * Constructor de la clase abstracta Arma.
     * @param nombre Nombre del arma.
     * @param ataque Ataque base del arma.
     * @param condicion Condicion total del arma.
     */
    public Arma(String nombre, float ataque, float condicion) {
        super(nombre);
        this.ataque = ataque;
        this.condicion = condicion;
    }
}
