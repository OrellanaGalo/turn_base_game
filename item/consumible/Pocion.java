package item.consumible;

public class Pocion extends Consumible{
    /**
     * Constructor de la clase Pocion.
     * @param nombre Nombre de la pocion.
     * @param cantidad Cantidad de la pocion presente en el inventario.
     */
    public Pocion(String nombre, int cantidad) {
        super(nombre, cantidad);
    }
}
