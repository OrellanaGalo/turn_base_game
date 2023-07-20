package programacion.practica.item.armadura;

/**
 * La clase `Casco` representa un tipo de armadura que se puede equipar en el inventario de un personaje para
 * proporcionar protección adicional. Los cascos son objetos que forman parte del equipo de un personaje y pueden
 * aumentar la defensa del personaje contra ciertos tipos de daño, como ataques físicos o ataques mágicos.
 */
public class Casco extends Armadura{
    /**
     * Constructor de la clase 'Casco'.
     * @param nombre Nombre que va a llevar el casco.
     * @param defensa Cantidad de defensa que otorga el casco actual.
     */
    public Casco(String nombre, int defensa) {
        super(nombre, defensa);
    }
}
