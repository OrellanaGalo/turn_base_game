package programacion.practica.item.armadura;

/**
 * La clase `Pies` representa un tipo de armadura que se puede equipar en el inventario de un personaje para
 * proporcionar protección adicional. Los pies son objetos que forman parte del equipo de un personaje y pueden
 * aumentar la defensa del personaje contra ciertos tipos de daño, como ataques físicos o ataques mágicos.
 */
public class Pies extends Armadura{
    /**
     * Constructor de la clase 'Pies'.
     * @param nombre Nombre que va a llevar los pies.
     * @param defensa Cantidad de defensa que otorgan los pies actuales.
     */
    public Pies(String nombre, int defensa) {
        super(nombre, defensa);
    }
}
