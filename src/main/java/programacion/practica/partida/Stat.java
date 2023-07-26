package programacion.practica.partida;

/**
 * La clase `Stat` representa las estadísticas de un personaje o un objeto en el juego. Estas estadísticas incluyen
 * valores como vida, stamina, ataque, defensa e inteligencia, que determinan las capacidades y características del
 * personaje o del objeto en el juego. La clase `Stat` es inmutable, lo que significa que una vez que se crea una
 * instancia, sus valores no pueden modificarse directamente. En cambio, para aplicar cambios en las estadísticas, se
 * utilizan métodos específicos para calcular y retornar nuevas instancias de `Stat` con los valores actualizados.
 */
public class Stat {
    /**
     * Hit points del personaje.
     */
    protected final int vida;
    /**
     * Stamina o, energia del personaje.
     */
    protected final int stamina;
    /**
     * Ataque total del personaje, con este atributo se calcula la perdida de HP del personaje enemigo.
     */
    protected final int ataque;
    /**
     * Defensa total del personaje, este atributo se usa para calcular la reduccion de ataque que recibis del enemigo.
     */
    protected final int defensa;
    /**
     * Inteligencia del personaje, en base a este atributo se calculan las probabilidades de ataque critico.
     */
    protected final int inteligencia;

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
     * Metodo que recibe un Stat nuevo y le aplica la reduccion de stat al Stat viejo.
     * @param original Stat que va a recibir los cambios.
     * @param nuevo Stat nuevo que trae los cambios negativos para el Stat viejo.
     * @return Retorna un Stat nuevo, que es una combinacion de los que entraron como argumentos.
     */
    public static Stat desAplicarStats(Stat original, Stat nuevo) {
        return new Stat(
                original.vida - nuevo.vida,
                original.stamina - nuevo.stamina,
                original.ataque - nuevo.ataque,
                original.defensa - nuevo.defensa,
                original.inteligencia - nuevo.inteligencia
        );
    }

    /**
     * Calcula la vida y la modifica en funcion de la vida agregada en el argumento.
     * @param vida Es un entero que representa la vida que deseamos agregar.
     * @return Retorna un Stat con los nuevos valores de vida.
     */
    public Stat calcularVida(int vida) {
        int nueva_vida = this.vida + vida;
        nueva_vida = Math.max(0, Math.min(100, nueva_vida));

        int diferencia_vida = nueva_vida - this.vida;

        return new Stat(diferencia_vida, 0, 0, 0, 0);
    }

    /**
     * Calcula la stamina y la modifica en funcion de la stamina agregada en el argumento.
     * @param stamina Es un entero que representa la stamina que deseamos agregar.
     * @return Retorna un Stat con los nuevos valores de stamina.
     */
    public Stat calcularStamina(int stamina) {
        int nueva_stamina = this.stamina + stamina;
        nueva_stamina = Math.max(0, Math.min(100, nueva_stamina));

        int diferencia_stamina = nueva_stamina - this.stamina;

        return new Stat(0, diferencia_stamina, 0, 0, 0);
    }

    /**
     * Calcula el daño de ataque resultante después de considerar el stamina del atacante y la defensa del
     * personaje atacado.
     * @param defensaAjena La Stat de defensa del personaje enemigo.
     * @return Un entero que representa el dano final efectuado por el atacante.
     */
    public int calcularAtaque(Stat defensaAjena) {
        int diferenciaStamina = 100 - this.stamina;

        double factorStamina = 0.5 + (diferenciaStamina / (double) 100) * 0.5;

        int danioInicial = this.ataque;
        double danioReduccionDefensa = Math.max(defensaAjena.defensa * 0.8 - danioInicial, 0);
        int danioReducido = danioInicial - (int) danioReduccionDefensa;

        int danioFinal = (int) (danioReducido * factorStamina);
        if (danioFinal < 0) {
            danioFinal = 5;
        }

        return danioFinal;
    }

    /**
     * Metodo que revisa si la vida del personaje es mayor a 0, lo que en mecanicas del juego significa que sigue con
     * vida.
     * @return Retorna true si la vida es mayor a 0 y false en caso contrario.
     */
    public boolean estaVivo() {
        return this.vida > 0;
    }

    /**
     * Metodo que verifica si la stamina es suficiente comparada con la stamina introducida como argumento.
     * @param stamina Es la stamina con la que deseamos comparar.
     * @return True si la stamina actual es mayor a la introducida, false en caso contrario.
     */
    public boolean verificarStamina(int stamina) {
        return this.stamina >= stamina;
    }

    /**
     * Metodo que muestra la informacion de los argumentos presente en esta clase.
     * @param ignorarCero Un booleano que se utiliza para saber si se tiene que mostrar los valores en 0 del stat o no.
     * @return Retorna un String con todos los elementos.
     */
    public String toString(boolean ignorarCero) {
        StringBuilder sb = new StringBuilder();

        if (!ignorarCero || vida != 0) {
            sb.append(String.format("%-10s ", vida));
        }
        if (!ignorarCero || stamina != 0) {
            sb.append(String.format("%-10s ", stamina));
        }

        if (!ignorarCero || ataque != 0) {
            sb.append(String.format("%-10s ", ataque));
        }

        if (!ignorarCero || defensa != 0) {
            sb.append(String.format("%-10s ", defensa));
        }

        if (!ignorarCero || inteligencia != 0) {
            sb.append(String.format("%-10s ", inteligencia));
        }

        return sb.toString();
    }

    /**
     * Compara el objeto Stat con otro objeto introducido como argumento para determinar si son iguales o no.
     * @param o El objeto con el cual se compara Stat.
     * @return True si ambos objetos son iguales o False si son distintos.
     */
    @Override
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
