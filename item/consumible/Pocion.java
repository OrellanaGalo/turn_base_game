package item.consumible;

public class Pocion extends Consumible{
    public Pocion(String nombre, int cantidad) {
        super(nombre, cantidad);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public float modificarStat() {
        return 0;
    }

    @Override
    public String aCadena() {
        return null;
    }
}
