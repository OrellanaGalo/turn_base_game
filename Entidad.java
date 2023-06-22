public abstract class Entidad extends Modificar{
    protected String nombre;
    protected int vida;
    protected int stamina;
    protected float ataque;
    protected float defensa;
    protected float inteligencia;

    public Entidad(String nombre, int vida, int stamina, float ataque, float defensa, float inteligencia){
        this.nombre = nombre;
        this.vida = vida;
        this.stamina = stamina;
        this.ataque = ataque;
        this.defensa = defensa;
        this.inteligencia = inteligencia;
    }
}
