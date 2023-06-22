public abstract class Arma extends Item{
    protected float ataque;
    protected float condicion;

    protected Arma(String nombre, float ataque, float condicion) {
        super(nombre);
        this.ataque = ataque;
        this.condicion = condicion;
    }
}
