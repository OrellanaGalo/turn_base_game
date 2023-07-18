package programacion.practica.item.acessorio;

/**
 * completar.
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
