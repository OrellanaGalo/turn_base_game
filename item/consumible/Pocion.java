package item.consumible;

public class Pocion extends Consumible{

    /**
     * Constructor de la clase Pocion.
     * @param nombre Nombre de la pocion.
     * @param cantidad Cantidad de la pocion presente en el inventario.
     */
    public Pocion(String nombre, int cantidad) {
        super(nombre, cantidad);
    }

    /**
     * falta completar.
     * @param o falta completar.
     * @return falta completar.
     */
    @Override
    public boolean equals(Object o) {
        return false;
    }

    /**
     * Falta completar.
     * @return falta completar.
     */
    @Override
    public float modificarStat() {
        return 0;
    }

    /**
     * Falta completar.
     * @return falta completar.
     */
    @Override
    public String aCadena() {
        return null;
    }
}
