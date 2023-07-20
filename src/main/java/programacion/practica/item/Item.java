package programacion.practica.item;

import programacion.practica.partida.Stat;

import java.util.Objects;

/**
 * La clase abstracta `Item` es la clase base que se encarga de manejar los diferentes tipos de objetos o items
 * presentes en el juego. Estos items pueden incluir armas, armaduras, accesorios, consumibles y otros objetos que los
 * personajes pueden equipar, desequipar o utilizar durante la partida para obtener beneficios.
 */
public abstract class Item{
    /**
     * Nombre del Item.
     */
    private String nombre;

    /**
     * Atributo que representa los atributos generales del item.
     */
    private Stat stat;

    /**
     * Tipo de objeto que hereda de Item.
     */
    protected String tipo;

    /**
     * Constructor de la clase abstracta Item.
     * @param nombre Nombre que va a llevar el item.
     */
    public Item(String nombre, Stat stat){
        this.nombre = nombre;
        this.stat = stat;
    }

    /**
     * Retorna el Stat del item seleccionado.
     * @return Retorna un Stat que representa los atributos del item buscado.
     */
    public Stat obtenerStat() {
        if (stat == null) {
            return new Stat(0, 0, 0, 0, 0);
        }

        return stat;
    }

    /**
     * Compara este objeto con otro objeto para determinar si son iguales.
     * @param o el objeto a comparar con este objeto.
     * @return True si los objetos son iguales, False en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Item item = (Item) o;
        return Objects.equals(nombre, item.nombre) && Objects.equals(tipo, item.tipo);
    }

    /**
     * Metodo hashCode para item, esto sirve para mejorar la diferenciacion de items.
     */
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    /**
     * Operacion que muestra el nombre del item, y deja un espacio para que las siguiente clases completen.
     */
    @Override
    public String toString() {
        return "[" + nombre + " -> ";
    }
}
