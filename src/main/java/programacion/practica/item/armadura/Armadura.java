package programacion.practica.item.armadura;

import programacion.practica.item.Item;
import programacion.practica.partida.Stat;

/**
 * completar.
 */
public abstract class Armadura extends Item{
    /**
     * Defensa base de la armadura.
     */
    private Stat stat;

    /**
     * Constructor de la clase abstracta Armadura.
     * @param nombre Nombre de la Armadura.
     */
    public Armadura(String nombre, int defensa) {
        super(nombre);
        this.stat = new Stat(0, 0, 0, defensa, 0);
    }

    /**
     * Un String con el nombre de la pieza de armadura y su estadistica de defensa.
     */
    public String toString() {
        return super.toString() + stat.toString(true) + ']';
    }
}
