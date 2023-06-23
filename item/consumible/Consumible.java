package item.consumible;

import item.Item;

public abstract class Consumible extends Item {
    public String nombre;
    public int cantidad;

    public Consumible(String nombre, int cantidad) {
        super(nombre);
        this.cantidad = cantidad;
    }

    public String toString(){
        return nombre;
    }
}
