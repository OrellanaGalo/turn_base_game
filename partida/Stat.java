package partida;

import item.Item;

/**
 * Es la clase que se encarga de manejar las estadisticas de los jugadores.
 */
public class Stat {
    /**
     * Atributos principales de un personaje dentro del juego.
     */
    public final int vida;
    public final int stamina;
    public final int ataque;
    public final int defensa;
    public final int inteligencia;

    /**
     * Constructor de la clase Stat.
     * @param vida Vida base de los personajes.
     * @param stamina Stamina base de los personajes.
     * @param ataque Ataque base de los items o personajes.
     * @param defensa Defensa base de los personajes.
     * @param inteligencia Inteligencia base de los personajes y/o items.
     */
    public Stat(int vida, int stamina, int ataque, int defensa, int inteligencia) {
        this.vida = vida;
        this.stamina = stamina;
        this.ataque = ataque;
        this.defensa = defensa;
        this.inteligencia = inteligencia;
    }

    /**
     * Aplica el dano obtenido del entero pasado como argumento y lo aplica a los stats del personaje.
     * @param original Son los stats del personaje al cual le vamos a aplicar el dano.
     * @param danio El dano entero que se le aplica.
     * @return Retorna un nuevo stat que reemplaza al anterior.
     */
    public Stat aplicarDanio(Stat original, int danio) {
        return new Stat(
                original.vida - danio,
                original.stamina,
                original.ataque,
                original.defensa,
                original.inteligencia
        );
    }

    /**
     * Aplica los stats obtenidos del item a los diferentes stats del personaje.
     * @param item Item del cual van a ser obtenidos los stats.
     * @return Retorna un nuevo Stat que va a reemplazar el viejo.
     */
    public Stat aplicarStats(Stat original, Item item) {
        Stat nuevo_stat = item.obtenerStat();

        return new Stat(
                original.vida + nuevo_stat.vida,
                original.stamina + nuevo_stat.stamina,
                original.ataque + nuevo_stat.ataque,
                original.defensa + nuevo_stat.defensa,
                original.inteligencia + nuevo_stat.inteligencia
        );
    }
}
