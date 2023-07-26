package programacion.practica.item.accesorio;

/**
 * La clase `Anillo` representa un tipo de accesorio en el juego. Los anillos son objetos que se pueden equipar en el
 * inventario de un personaje para proporcionar bonificaciones o efectos especiales. Los anillos pueden otorgar mejoras
 * en las estadísticas del personaje, aumentar la resistencia a ciertos tipos de daño o proporcionar habilidades
 * adicionales.
 */
public class Anillo extends Accesorio{
    /**
     * Atributo entero que indica la inteligencia que aporta la calse Anillo.
     */
    private int variable;

    /**
     * Constructor de la clase anillo.
     * @param nombre Nombre del Anillo.
     * @param inteligencia Inteligencia por la cual se modifican los stats de personaje al equipar el Anillo.
     * @param variable variable por el cual se modifican los stats de personaje si utiliza el Amuleto.
     */
    public Anillo(String nombre, int inteligencia, int variable) {
        super(nombre, inteligencia);
        this.variable = variable;
    }
}
