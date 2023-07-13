package personaje;

import item.Item;
import partida.Inventario;
import partida.Stat;

/**
 * La clase que se encarga de manejar todo lo relacionado al personaje y sus diferentes atributos.
 */
public class Personaje{
    /**
     * Nombre que va a tener nuestro personaje.
     */
    private String nombre;

    /**
     * Estadisticas base que va a tener nuestro personaje.
     */
    private Stat base;

    /**
     * Estadisticas del personaje que van a ser modificadas.
     */
    private Stat stat;

    /**
     * Inventario del personaje.
     */
    private Inventario inventario;

    /**
     * Constructor de Personaje.
     * @param nombre Nombre que va a llevar el personaje.
     * @param base Son los stats base del personaje, la clase Stat contiene los atributos principales del personaje.
     * Estos pueden ser vida, stamina, ataque, etc.
     * @param inventario Es el inventario del personaje, aca se guardan los items y tambien se controla el equipamiento
     * del personaje.
     */
    public Personaje(String nombre, Stat base, Inventario inventario){
        this.nombre = nombre;
        this.base = base;
        this.inventario = inventario;

        stat = base;
    }

    /**
     * Metodo que calcula el ataque del personaje segun sus stats.
     * @return un entero que representa el ataque total de este personaje.
     */
    private int ataque(int stamina){
        int ataque_total = stat.ataque;

        if (stamina < 15) {
            System.out.println(stamina);

            return 0;
        }

        stamina = stamina - 15;
        double danio_realizado = Math.pow(ataque_total, (stamina * 0.004));

        System.out.println(danio_realizado);

        return (int) danio_realizado;
    }

    /**
     * Metodo por el cual atacamos al personaje que elijamos.
     * @param personaje Personaje al cual deseamos atacar.
     */
    public void atacar(Personaje personaje) {
        personaje.stat = stat.aplicarDanio(personaje.stat, ataque(stat.stamina));
    }

    public void equipar(Item item) {
        stat = stat.aplicarStats(stat, item);
    }

    /**
     * Convierte todos los atributos e informacion en un String para ser mostrado en consola.
     * @return Un StringBuilder convertido a un String para mostrarlo en consola.
     */
    public String toString() {

        String string = "----------------------------------------------------------------------------------------------" +
                "-------------------------------------------------------------------" +
                "\n" +
                String.format(
                        "%-30s %-10s %-10s %-10s %-10s %-10s", "Nombre:", "Vida", "Stamina", "Ataque", "Defensa",
                        "Inteligencia") +
                "\n" +
                String.format(
                        "%-30s %-10s %-10s %-10s %-10s %-10s", nombre, base.vida, base.stamina, base.ataque, base.defensa,
                        base.inteligencia) +
                "\n" +
                String.format(
                        "%-30s %-10s %-10s %-10s %-10s %-10s", nombre, stat.vida, stat.stamina,
                        stat.ataque, stat.defensa, stat.inteligencia) +
                "\n" +
                "\n";

        return string;
    }
}
