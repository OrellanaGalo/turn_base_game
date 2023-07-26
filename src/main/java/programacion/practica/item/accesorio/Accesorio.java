package programacion.practica.item.accesorio;

import programacion.practica.item.Item;
import programacion.practica.partida.Stat;

/**
 * Representa un accesorio, que es un tipo de item equipable que aporta beneficios al personaje. Los accesorios pueden
 * aumentar la inteligencia del personaje, lo que afecta su capacidad para realizar acciones relacionadas con la magia.
 */
public abstract class Accesorio extends Item{
    /**
     * Constructor de la clase abstracta Accesorio.
     * @param nombre Nombre del accesorio.
     * @param inteligencia Inteligencia que aporta el item al personaje.
     */
    protected Accesorio(String nombre, int inteligencia) {
        super(nombre, new Stat(0, 0, 0, 0, inteligencia));
    }

    /**
     * Hereda el toString de la clase padre y luego le agrega el atributo inteligencia presente en esta.
     * @return Retorna un String con la informacion de la clase padre sumado a nuevos atributos.
     */
    public String toString(){
        return super.toString() + obtenerStat().toString(true) + ']';
    }
}
