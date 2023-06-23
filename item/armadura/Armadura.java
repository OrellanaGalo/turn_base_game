package item.armadura;

import item.Item;

public abstract class Armadura extends Item{
    /**
     * Defensa base de la armadura.
     */
    protected float defensa;
    protected int durabilidad_max;
    protected int durabilidad_actual;

    /**
     * Constructor de la clase abstracta Armadura.
     * @param nombre Nombre de la Armadura.
     * @param durabilidad_max Durabilidad maxima del objeto.
     * @param durabilidad_actual Durabilidad actual del objeto.
     */
    public Armadura(String nombre, float defensa, int durabilidad_max, int durabilidad_actual) {
        super(nombre);
        this.defensa = defensa;
        this.durabilidad_max = durabilidad_max;
        this.durabilidad_actual = durabilidad_actual;
    }
}
