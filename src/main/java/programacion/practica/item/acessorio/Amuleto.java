package programacion.practica.item.acessorio;

/**
 * La clase `Amuleto` representa un tipo de accesorio en el juego. Los amuletos son objetos que se pueden equipar en el
 * inventario de un personaje para proporcionar bonificaciones o efectos especiales. Los amuletos pueden otorgar mejoras
 * en las estadísticas del personaje, aumentar la resistencia a ciertos tipos de daño o proporcionar habilidades
 * adicionales.
 */
public class Amuleto extends Accesorio{
    /**
     * Atributo que indica el variable por el cual se modifican los stats del personaje.
     */
    private int variable;

    /**
     * Constructor de la clase Amuleto.
     * @param nombre Nombre del Amuleto.
     * @param inteligencia ....
     * @param variable variable por el cual se modifican los stats de personaje si utiliza el Amuleto.
     */
    public Amuleto(String nombre, int inteligencia, int variable) {
        super(nombre, inteligencia);
        this.variable = variable;
    }
}
