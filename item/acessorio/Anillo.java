package item.acessorio;

public class Anillo extends Accesorio{
    /**
     * Atributo flotante que indica la inteligencia que aporta la calse Anillo.
     */
    private int inteligencia;

    /**
     * completar...
     * @param nombre Nombre del Anillo.
     * @param inteligencia Inteligencia por la cual se modifican los stats de personaje al equipar el Anillo.
     */
    public Anillo(String nombre, int inteligencia) {
        super(nombre);
        this.inteligencia = inteligencia;
    }
}
