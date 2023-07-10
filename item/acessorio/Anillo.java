package item.acessorio;

public class Anillo extends Accesorio{
    /**
     * Atributo flotante que indica la inteligencia que aporta la calse Anillo.
     */
    private int variable;

    /**
     * completar...
     * @param nombre Nombre del Anillo.
     * @param inteligencia Inteligencia por la cual se modifican los stats de personaje al equipar el Anillo.
     * @param variable ... Todavia tengo que elegir que hacen los anillos.
     */
    public Anillo(String nombre, int inteligencia, int variable) {
        super(nombre, inteligencia);
        this.variable = variable;
    }
}
