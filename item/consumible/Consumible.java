package item.consumible;

import item.Item;

public abstract class Consumible extends Item {
    /**
     * completar...
     */
    public String nombre;

    /**
     * completar...
     */
    public int cantidad;

    /**
     * Constructor de la clase Consumible.
     * @param nombre Nombre del consumible.
     * @param cantidad Cantidad del consumible presente en el inventario.
     */
    public Consumible(String nombre, int cantidad) {
        super(nombre);
        this.cantidad = cantidad;
    }

    /**
     * Pasa como un String el atributo nombre y la cantidad presente en la clase abstracta de Consumible.
     */
    public String toString(){
        return super.toString() + cantidad + ']';
    }
}
