package programacion.practica.item.armadura;

import programacion.practica.item.Item;
import programacion.practica.partida.Stat;

/**
 * Esta clase representa una armadura en el juego. Las armaduras son objetos que se utilizan principalmente para
 * aumentar o disminuir el stat de defensa. Cada tipo de armadura (casco, torso, pie, y pantalón) será una subclase de
 * esta clase abstracta, y cada una podrá tener características específicas adicionales.
 */
public abstract class Armadura extends Item{
    /**
     * Constructor de la clase abstracta Armadura.
     * @param nombre Nombre de la Armadura.
     */
    public Armadura(String nombre, int defensa) {
        super(nombre, new Stat(0, 0, 0, defensa, 0));
    }

    /**
     * Un String con el nombre de la pieza de armadura y su estadistica de defensa.
     */
    public String toString() {
        return super.toString() + obtenerStat().toString(true) + ']';
    }
}
