package programacion.practica.item;

import programacion.practica.partida.Stat;

import java.util.Objects;

/**
 * Esta clase se encarga de manejar los items presentes en el juego. Estos pueden ser armas, armaduras o incluso items
 * consumibles.
 */
public abstract class Item{
    /**
     * Nombre del Item.
     */
    protected String nombre;

    /**
     * Constructor de la clase abstracta Item.
     * @param nombre Nombre que va a llevar el item.
     */
    public Item(String nombre){
        this.nombre = nombre;
    }

    /**
     * Retorna el Stat del item seleccionado.
     * @return Retorna un Stat que representa los atributos del item buscado.
     */
    public Stat obtenerStat() {
        return new Stat(0, 0, 0, 0, 0);
    }

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
        return Objects.equals(nombre, item.nombre);
    }

    /**
     * Metodo hashCode para item, esto sirve para mejorar la diferenciacion de items.
     */
    public int hashCode() {
        return nombre.hashCode();
    }

    /**
     * Operacion que muestra el nombre del item, y deja un espacio para que las siguiente clases completen.
     */
    public String toString() {
        return "[" + nombre + " -> ";
    }
}
