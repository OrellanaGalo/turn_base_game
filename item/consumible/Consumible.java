package item.consumible;

import item.Item;
import partida.Stat;

public abstract class Consumible extends Item {
    /**
     * Cantidad de ese consumible presente en el inventario. Puede ser tanto positivo como negativo, ya que si usamos
     * una pocion, podemos restaurar stamina. Pero si utilizamos un arrojable, perdemos stamina.
     */
    private int stamina;

    /**
     * Idem stamina pero con vida del personaje. En este caso no puede ser negativa.
     */
    private int vida;

    /**
     * Constructor de la clase Consumible.
     * @param nombre Nombre del consumible.
     * @param stamina Stamina que va a ser agregada o restada del personaje.
     */
    public Consumible(String nombre, int vida, int stamina) {
        super(nombre);
        this.vida = vida;
        this.stamina = stamina;
    }

    public Stat obtenerStat() {
        return new Stat(vida, stamina, 0, 0, 0);
    }

    /**
     * Pasa como un String el atributo nombre y la cantidad presente en la clase abstracta de Consumible.
     */
    public String toString(){
        return super.toString() + vida + stamina + ']';
    }
}
