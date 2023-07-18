package programacion.practica.partida;

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
    public static Stat aplicarStats(Stat original, Stat nuevo) {
        return new Stat(
                original.vida + nuevo.vida,
                original.stamina + nuevo.stamina,
                original.ataque + nuevo.ataque,
                original.defensa + nuevo.defensa,
                original.inteligencia + nuevo.inteligencia
        );
    }

    /**
     * Metodo que muestra la informacion de los argumentos presente en esta clase.
     * @return Retorna un String con todos los elementos.
     */
    public String toString() {
        return "\n" + vida + stamina + ataque + defensa + inteligencia + "\n";
    }

    /**
     * Compara el objeto Stat con otro objeto introducido como argumento para determinar si son iguales o no.
     * @param o El objeto con el cual se compara Stat.
     * @return True si ambos objetos son iguales o False si son distintos.
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Stat otro_stat = (Stat) o;

        return vida == otro_stat.vida &&
                stamina == otro_stat.stamina &&
                ataque == otro_stat.ataque &&
                defensa == otro_stat.defensa &&
                inteligencia == otro_stat.inteligencia;
    }

    /**
     * Calcula el valor de Hash para el objeto Stat.
     * @return Un entero que representa el valor de hash para este objeto.
     */
    @Override
    public int hashCode() {
        final int primo = 31;
        int resultado = 1;

        resultado = primo * resultado + vida;
        resultado = primo * resultado + stamina;
        resultado = primo * resultado + ataque;
        resultado = primo * resultado + defensa;
        resultado = primo * resultado + inteligencia;

        return resultado;
    }
}
