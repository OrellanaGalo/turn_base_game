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
     * Atributo que indica si el personaje se encuentra actualmente defendiendo o no.
     */
    private boolean defensa = false;

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
     * @param variable El argumento variable sirve para cambiar el ataque del personaje.
     * @return un entero que representa el ataque total de este personaje.
     */
    private Stat calcularAtaque(int variable){
        int ataque_total = stat.ataque;

        double danio_realizado = Math.pow(ataque_total, (variable * 0.007));

        System.out.println((int) danio_realizado);

        return new Stat((int) -danio_realizado, 0, 0, 0, 0);
    }

    /**
     * Metodo que calcula la defensa momentanea del personaje segun la variable introducida.
     * @param variable El argumento variable sirve para modificar la cantidad de defensa que recibe el personaje.
     * @return Retorna un nuevo stat el cual va a sobreescribir momentaneamente el stat viejo del personaje.
     */
    private Stat calcularDefensa(int variable) {
        return new Stat(0, 0, 0, variable, 0);
    }

    /**
     * Metodo para defenderse por un turno. Aumenta su defensa un 50% por un turno.
     */
    public void defender() {
        if(!defensa) {
            stat = stat.aplicarStats(stat, calcularDefensa(80));
            defensa = true;
        } else {
            stat = stat.aplicarStats(stat, calcularDefensa(-80));
            defensa = false;
        }
    }

    /**
     * Metodo por el cual atacamos al personaje que elijamos.
     * @param personaje Personaje al cual deseamos atacar.
     */
    public void atacar(Personaje personaje) {
        personaje.stat = stat.aplicarStats(personaje.stat, calcularAtaque(stat.stamina));
    }

    /**
     * Aplica los stats del item seleccionado.
     * @param item Es el item que se desea equipar.
     */
    public void equipar(Item item) {
        stat = stat.aplicarStatsItem(stat, item);
    }

//    /**
//     * Metodo que aplica los efectos de estado de gastar o sumar stamina.
//     * @param stamina La estamina que se desea agregar o sacar. Tiene que ser un entero.
//     */
//    public void gastarStamina(int stamina) {
//        stat = stat.aplicarStamina(stat, stamina);
//    }

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
