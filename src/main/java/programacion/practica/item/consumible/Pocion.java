package programacion.practica.item.consumible;

/**
 * Clase pocion, estas se encargan de brindar vida o stamina a nuestro personaje.
 */
public class Pocion extends Consumible{

    /**
     * Constructor de la clase Pocion.
     * @param nombre Nombre de la pocion.
     * @param vida asd.
     * @param stamina asd.
     */
    public Pocion(String nombre, int vida, int stamina) {
        super(nombre, vida, stamina);
    }
}
