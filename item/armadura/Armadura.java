package item.armadura;

import item.Item;

public abstract class Armadura extends Item{
    protected float defensa;
    protected int durabilidad_max;
    protected int durabilidad_actual;

    protected Armadura(String nombre, float defensa, int durabilidad_max, int durabilidad_actual) {
        super(nombre);
        this.defensa = defensa;
        this.durabilidad_max = durabilidad_max;
        this.durabilidad_actual = durabilidad_actual;
    }
}
