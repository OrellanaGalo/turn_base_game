package programacion.practica.item.acessorio;

import programacion.practica.item.Item;
import programacion.practica.partida.Stat;

/**
 * Clase accesorio. Los accesorios son un item equipable que aportar x beneficio al personaje.
 */
public abstract class Accesorio extends Item{
    /**
     * Atributo inteligencia.
     */
    private int inteligencia;

    /**
     * Constructor de la clase abstracta Accesorio.
     * @param nombre Nombre del accesorio.
     * @param inteligencia Inteligencia que aporta el item al personaje.
     */
    protected Accesorio(String nombre, int inteligencia) {
        super(nombre);
        this.inteligencia = inteligencia;
    }

    /**
     * Metodo para generar un nuevo Stat que contiene la informacion de inteligencia del accesorio.
     * @return Un nuevo Stat con el atributo inteligencia agregado.
     */
    public Stat obtenerStat() {
        return new Stat(0, 0, 0, 0, inteligencia);
    }

    /**
     * completar...
     */
    public String toString(){
        return super.toString() + inteligencia + ']';
    }
}
