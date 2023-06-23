package item.acessorio;

import item.Item;

public abstract class Accesorio extends Item{
    /**
     * Atributo que denota la durabilidad maxima que puede tener un objeto de la clase Accesorio.
     */
    protected float durabilidad_max;

    /**
     * La durabilidad actual que tiene el objeto luego de que se le aplique un efecto de estado.
     */
    protected float durabilidad_act;

    /**
     * Constructor de la clase abstracta Accesorio.
     * @param nombre Nombre del accesorio.
     * @param durabilidad_max Durabilidad maxima del objeto.
     * @param durabilidad_act Durabilidad actual del objeto.
     */
    protected Accesorio(String nombre, float durabilidad_max, float durabilidad_act) {
        super(nombre);
        this.durabilidad_max = durabilidad_max;
        this.durabilidad_act = durabilidad_act;
    }
}
