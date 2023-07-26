package programacion.practica.item.armadura;

/**
 * La clase `Torso` representa un tipo de armadura que se puede equipar en el inventario de un personaje para
 * proporcionar protección adicional. Los torsos son objetos que forman parte del equipo de un personaje y pueden
 * aumentar la defensa del personaje contra ciertos tipos de daño, como ataques físicos o ataques mágicos.
 */
public class Pecho extends Armadura{
    /**
     * Constructor de la clase 'Torso'.
     * @param nombre Nombre que va a llevar el torso.
     * @param defensa Cantidad de defensa que otorga el torso actual.
     */
    public Pecho(String nombre, int defensa) {
        super(nombre, defensa);
    }
}
