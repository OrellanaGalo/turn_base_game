package partida;

/**
 * Es la clase que se encarga de manejar las estadisticas de las distintas clases.
 */
public class Stat {
    public final int vida;
    public final int stamina;
    public final int ataque;
    public final int defensa;
    public final int inteligencia;

    /**
     * Constructor de la clase Stat.
     * @param vida
     * @param stamina
     * @param ataque
     * @param defensa
     * @param inteligencia
     */
    public Stat(int vida, int stamina, int ataque, int defensa, int inteligencia) {
        this.vida = vida;
        this.stamina = stamina;
        this.ataque = ataque;
        this.defensa = defensa;
        this.inteligencia = inteligencia;
    }
}
