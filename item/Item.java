package item;

import main.Modificar;

public abstract class Item extends Modificar{
    protected String nombre;

    protected Item(String nombre){
        this.nombre = nombre;
    }
}
