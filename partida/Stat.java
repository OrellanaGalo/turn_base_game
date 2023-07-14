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
     * Metodo que recibe un stat nuevo y le aplica los cambios al stat viejo.
     * @param original Stat que va a recibir los cambios.
     * @param nuevo Stat nuevo que trae los cambios de estado para los stats viejos.
     * @return Retorna un nuevo stat que es la combinacion de los dos stats.
     */
    public Stat aplicarStats(Stat original, Stat nuevo) {
        return new Stat(
                original.vida + nuevo.vida,
                original.stamina + nuevo.stamina,
                original.ataque + nuevo.ataque,
                original.defensa + nuevo.defensa,
                original.inteligencia + nuevo.inteligencia
        );
    }

    /**
     * Aplica los stats obtenidos del item a los diferentes stats del personaje.
     * @param item Item del cual van a ser obtenidos los stats.
     * @return Retorna un nuevo Stat que va a reemplazar el viejo.
     */
    public Stat aplicarStatsItem(Stat original, Item item) {
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
