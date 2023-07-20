package programacion.practica.item.consumible;

import programacion.practica.item.Item;
import programacion.practica.partida.Stat;

/**
 * La clase abstracta `Consumible` es una subclase de la clase `Item` y representa un tipo de objeto que puede ser
 * consumido o utilizado por un personaje en el juego. Los consumibles son objetos que proporcionan efectos o beneficios
 * temporales al personaje que los usa, como curar puntos de vida, aumentar la resistencia, otorgar bonificaciones
 * temporales a las estadísticas o proporcionar habilidades especiales durante un período limitado.
 */
public abstract class Consumible extends Item {
    /**
     * Constructor de la clase 'Consumible'.
     * @param nombre Nombre del consumible.
     * @param stamina Stamina que va a ser agregada o restada del personaje.
     */
    public Consumible(String nombre, int vida, int stamina) {
        super(nombre, new Stat(vida, stamina, 0, 0, 0));
    }

    /**
     * Pasa como un String el atributo nombre y el atributo stat en la clase abstracta de Consumible.
     */
    public String toString(){
        return super.toString() + obtenerStat().toString(true) + ']';
    }
}
