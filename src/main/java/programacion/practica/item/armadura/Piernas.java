package programacion.practica.item.armadura;

/**
 * La clase `Pantalon` representa un tipo de armadura que se puede equipar en el inventario de un personaje para
 * proporcionar protección adicional. Los pantalones son objetos que forman parte del equipo de un personaje y pueden
 * aumentar la defensa del personaje contra ciertos tipos de daño, como ataques físicos o ataques mágicos.
 */
public class Piernas extends Armadura{
    /**
     * Constructor de la clase 'Pantalon'.
     * @param nombre Nombre que va a llevar el pantalon.
     * @param defensa Cantidad de defensa que otorga el pantalon actual.
     */
    public Piernas(String nombre, int defensa) {
        super(nombre, defensa);
    }
}
