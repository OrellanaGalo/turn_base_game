package item.acessorio;

import item.Item;

public abstract class Accesorio extends Item{
    /**
     * Constructor de la clase abstracta Accesorio.
     * @param nombre Nombre del accesorio.
     */
    protected Accesorio(String nombre) {
        super(nombre);
    }

    /**
     * completar...
     */
    public String toString(){
        return super.toString() + ']';
    }
}
