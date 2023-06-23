package item;

import main.Modificar;

public abstract class Item extends Modificar{
    /**
     * Nombre del Item.
     */
    public String nombre;

    /**
     * Constructo de la clase abstracta Item.
     * @param nombre Nombre que va a llevar el item.
     */
    public Item(String nombre){
        this.nombre = nombre;
    }

    /**
     * Metodo para que hereden y complementen los hijos de esta clase.
     * @param o Objeto para comparar.
     * @return Retorna un boleano True o False segun la comparacion que se de.
     */
    public abstract boolean equals(Object o);

    /**
     * Pasa como un String el atributo nombre presente en la clase abstracta de Item.
     * @return Un String con el nombre del Item.
     */
    @Override
    public String toString(){
        return nombre;
    }
}
