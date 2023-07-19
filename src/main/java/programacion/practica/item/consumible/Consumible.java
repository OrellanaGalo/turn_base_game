package programacion.practica.item.consumible;

import programacion.practica.item.Item;
import programacion.practica.partida.Stat;

/**
 * completar.
 */
public abstract class Consumible extends Item {
    /**
     * Estadisticas del consumible. Puede ser tanto positivo como negativo, ya que si usamos una pocion, podemos
     * restaurar stamina. Pero si utilizamos un arrojable, perdemos stamina. Tambien es aplicable a pociones que
     * aumenten vida durante la pelea.
     */
    private Stat stat;

    /**
     * Constructor de la clase Consumible.
     * @param nombre Nombre del consumible.
     * @param stamina Stamina que va a ser agregada o restada del personaje.
     */
    public Consumible(String nombre, int vida, int stamina) {
        super(nombre);
        this.stat = new Stat(vida, stamina, 0, 0, 0);
    }

    /**
     * Pasa como un String el atributo nombre y el atributo stat en la clase abstracta de Consumible.
     */
    public String toString(){
        return super.toString() + stat.toString(true) + ']';
    }
}
