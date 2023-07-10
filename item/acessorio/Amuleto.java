package item.acessorio;

public class Amuleto extends Accesorio{
    /**
     * Atributo que indica el porcentaje por el cual se modifican los stats del personaje.
     */
    private int porcentaje;

    /**
     * Constructor de la clase Amuleto.
     * @param nombre Nombre del Amuleto.
     * @param inteligencia ....
     * @param porcentaje Porcentaje por el cual se modifican los stats de personaje si utiliza el Amuleto.
     */
    public Amuleto(String nombre, int inteligencia, int porcentaje) {
        super(nombre, inteligencia);
        this.porcentaje = porcentaje;
    }
}
