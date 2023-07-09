package item.armadura;

import item.Item;

public abstract class Armadura extends Item{
    /**
     * Defensa base de la armadura.
     */
    protected int defensa;

    /**
     * Constructor de la clase abstracta Armadura.
     * @param nombre Nombre de la Armadura.
     */
    public Armadura(String nombre, int defensa) {
        super(nombre);
        this.defensa = defensa;
    }

    /**
     * Un String con el nombre de la pieza de armadura y su estadistica de defensa.
     */
    public String toString() {
        return super.toString() + defensa + ']';
    }
}
