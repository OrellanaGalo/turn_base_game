package item.consumible;

import item.Item;

public abstract class Consumible extends Item {
    public String nombre;
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
     * Pasa como un String el atributo nombre presente en la clase abstracta de Consumible.
     * @return Un String con el nombre del Consumible.
     */
    public String toString(){
        return nombre;
    }
}
