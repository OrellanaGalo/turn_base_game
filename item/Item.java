package item;

import main.Modificar;

public abstract class Item extends Modificar{
    public String nombre;

    public Item(String nombre){
        this.nombre = nombre;
    }

    public abstract boolean equals(Object o);

    @Override
    public String toString(){
        return nombre;
    }
}
