package item.arma;

import item.Item;

public abstract class Arma extends Item{
    public float ataque;
    public float condicion;

    protected Arma(String nombre, float ataque, float condicion) {
        super(nombre);
        this.ataque = ataque;
        this.condicion = condicion;
    }
}
