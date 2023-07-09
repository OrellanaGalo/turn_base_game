package item;

import item.arma.Arma;

public abstract class Item{
    /**
     * Nombre del Item.
     */
    public String nombre;

    /**
     * Constructor de la clase abstracta Item.
     * @param nombre Nombre que va a llevar el item.
     */
    public Item(String nombre){
        this.nombre = nombre;
    }

    /**
     * Completar...
     */
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Item item = (Item) o;
        return nombre.equals(item.nombre);
    }

    /**
     * Operacion que muestra el nombre del item.
     */
    public String toString() {
        return "[" + nombre + "\t->\t";
    }
}
