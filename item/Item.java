package item;

import partida.Stat;

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

    public abstract Stat obtenerStat();

    /**
     * Compara este objeto con otro objeto para determinar si son iguales.
     * @param o el objeto a comparar con este objeto.
     * @return True si los objetos son iguales, False en caso contrario.
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
        return "[" + nombre + "\t->";
    }
}
