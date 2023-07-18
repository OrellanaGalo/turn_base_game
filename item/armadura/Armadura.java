package item.armadura;

import item.Item;
import partida.Stat;

/**
 * completar.
 */
public abstract class Armadura extends Item{
    /**
     * Defensa base de la armadura.
     */
    private int defensa;

    /**
     * Constructor de la clase abstracta Armadura.
     * @param nombre Nombre de la Armadura.
     */
    public Armadura(String nombre, int defensa) {
        super(nombre);
        this.defensa = defensa;
    }

    /**
     * completar.
     * @return completar.
     */
    public Stat obtenerStat() {
        return new Stat(0, 0, 0, defensa, 0);
    }

    /**
     * Un String con el nombre de la pieza de armadura y su estadistica de defensa.
     */
    public String toString() {
        return super.toString() + defensa + ']';
    }
}
