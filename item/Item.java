package item;

import main.Modificar;

public abstract class Item extends Modificar{
    protected String nombre;

    public Item(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
