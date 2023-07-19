package programacion.practica.personaje;

import programacion.practica.item.Item;
import programacion.practica.partida.Inventario;
import programacion.practica.partida.Stat;

import java.util.Scanner;

/**
 * La clase que se encarga de manejar todo lo relacionado al personaje y sus diferentes atributos.
 */
public class Personaje {
    /**
     * Nombre que va a tener nuestro personaje.
     */
    private String nombre;

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
    private boolean isDefensa = false;

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
        this.stat = base;
        this.inventario = inventario;
    }

    /**
     * Metodo por el cual atacamos al personaje que elijamos.
     * @param personaje Personaje al cual deseamos atacar.
     * @param stat Stat del cual se obtiene el danio que se le aplica al personaje que atacamos.
     */
    public void atacar(Personaje personaje, Stat stat) {
        Stat nuevo_ataque = stat;

        if (stat.verificarStamina(30)) {
            modificarStamina(-30);
            personaje.stat = Stat.desAplicarStats(personaje.stat, nuevo_ataque);
        } else {
            // Mandar excepcion.
            System.out.println("< No tenes stamina para atacar. >");
        }
    }

    /**
     * Metodo para defenderse por un turno.
     * @param stat Stat que aporta armadura por el turno.
     */
    public void defender(Stat stat) {
        Stat nueva_armadura = stat;

        if (stat.verificarStamina(30)) {
            modificarStamina(-30);
            isDefensa = !isDefensa;

            if (!isDefensa) {
                this.stat = Stat.aplicarStats(stat, nueva_armadura);
            } else {
                this.stat = Stat.desAplicarStats(stat, nueva_armadura);
            }
        } else {
            // Mandar excepcion.
            System.out.println("< No tenes stamina suficiente para defenderte. >");
        }
    }

    /**
     * Metodo que implementa la pelea entre dos personajes.
     * @param personaje_001 Primer personaje que participa en la pelea.
     * @param personaje_002 Segundo personaje que participa en la pelea.
     */
    public void pelear(Personaje personaje_001, Personaje personaje_002) {
        boolean turno = true;
        Scanner scanner = new Scanner(System.in);

        while (personaje_001.stat.estaVivo() && personaje_002.stat.estaVivo()) {
            System.out.println(personaje_001);
            System.out.println(personaje_002);

            if (turno) {
                System.out.println("< Que deberia hacer: " + personaje_001.nombre + " >");
                System.out.println("< 1: Atacar, 2: Defender, 3: Descansar >");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 -> {
                        System.out.println(personaje_001.nombre + " ataca a " + personaje_002.nombre);
                        personaje_001.atacar(personaje_002, personaje_001.stat);
                    }
                    case 2 -> {
                        System.out.println(personaje_001.nombre + " se defiende de " + personaje_002.nombre);
                        personaje_001.defender(personaje_001.stat);
                    }
                    case 3 -> {
                        System.out.println(personaje_001.nombre + " descansa.");
                        personaje_001.modificarStamina(50);
                    }
                }
            } else {
                System.out.println("< Que deberia hacer: " + personaje_002.nombre + " >");
                System.out.println("< 1: Atacar, 2: Defender, 3: Descansar >");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 -> {
                        System.out.println(personaje_002.nombre + " ataca a " + personaje_001.nombre);
                        personaje_002.atacar(personaje_001, personaje_002.stat);
                    }
                    case 2 -> {
                        System.out.println(personaje_002.nombre + " se defiende de " + personaje_001.nombre);
                        personaje_002.defender(personaje_001.stat);
                    }
                    case 3 -> {
                        System.out.println(personaje_002.nombre + " descansa.");
                        personaje_002.modificarStamina(50);
                    }
                }
            }

            turno = !turno;
        }

        if (personaje_001.stat.estaVivo()) {
            System.out.println("< Ganador: " + personaje_001.nombre + " >");
        } else {
            System.out.println("< Ganador: " + personaje_002.nombre + " >");
        }

        personaje_001.modificarVida(1000);
        personaje_001.modificarStamina(1000);
        personaje_002.modificarVida(1000);
        personaje_002.modificarStamina(1000);
    }

    /**
     * Aplica los stats del item seleccionado.
     * @param item Es el item que se desea equipar.
     */
    public void equiparItem(Item item) {
        this.stat = Stat.aplicarStats(stat, item.obtenerStat());
    }

    /**
     * Desaplica los stats del item seleccionado.
     * @param item Es el item que deseamos que se desequipe.
     */
    public void desequiparItem(Item item) {
        this.stat = Stat.desAplicarStats(stat, item.obtenerStat());
    }

    /**
     * Metodo que aplica los efectos de estado de gastar o sumar stamina.
     * @param stamina La estamina que se desea agregar o sacar. Tiene que ser un entero.
     */
    public void modificarStamina(int stamina) {
        Stat nueva_stamina = stat.calcularStamina(stamina);
        this.stat = Stat.aplicarStats(stat, nueva_stamina);
    }

    /**
     * Este metodo se encarga de modificar la cantidad de vida que posee el personaje.
     * @param vida La cantidad de vida que deseemos que se le agregue o saque al personaje.
     */
    public void modificarVida(int vida) {
        Stat nueva_vida = stat.calcularVida(vida);
        this.stat = Stat.aplicarStats(stat, nueva_vida);
    }

    public Inventario getInventario() {
        return inventario;
    }

    /**
     * Convierte todos los atributos e informacion en un String para ser mostrado en consola.
     * @return Un StringBuilder convertido a un String para mostrarlo en consola.
     */
    public String toString() {
        String string = "--------------------------------------------------------------------------------------------" +
                "\n" +
                String.format(
                        "%-30s %-10s %-10s %-10s %-10s %-10s", "Nombre:", "Vida", "Stamina", "Ataque", "Defensa",
                        "Inteligencia") + "\n" +
                String.format(
                        "%-30s %-50s", nombre, stat.toString(true)) + "\n";

        return string;
    }
}
