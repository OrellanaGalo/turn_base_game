package item.acessorio;

import item.Item;

public abstract class Accesorio extends Item{
    protected float durabilidad_max;
    protected float durabilidad_act;

    protected Accesorio(String nombre, float durabilidad_max, float durabilidad_act) {
        super(nombre);
        this.durabilidad_max = durabilidad_max;
        this.durabilidad_act = durabilidad_act;
    }
}
