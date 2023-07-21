package programacion.practica.personaje;

import programacion.practica.excepciones.EquipamientoFullException;
import programacion.practica.excepciones.IllegalNombreException;
import programacion.practica.excepciones.ItemNotFoundException;
import programacion.practica.item.Item;
import programacion.practica.partida.Inventario;
import programacion.practica.partida.Stat;

import java.util.Scanner;

/**
 * La clase `Personaje` se encarga de manejar todo lo relacionado al personaje jugable en el juego y sus diferentes
 * atributos. Un personaje representa al protagonista o al avatar controlado por el jugador durante la partida y puede
 * tener habilidades, estadísticas y equipamiento que afectan su rendimiento y capacidad para enfrentar desafíos.
 * *
 * En esta clase, se definen y gestionan los atributos principales del personaje, como la vida, la stamina, el ataque,
 * la defensa y la inteligencia. Además, esta clase también permite al personaje equipar y desequipar objetos, así como
 * realizar acciones como atacar, defenderse y utilizar consumibles durante el juego.
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
     * @throws IllegalNombreException si el nombre del personaje es nulo o vacio.
     */
    public Personaje(String nombre, Stat base, Inventario inventario) throws IllegalNombreException {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalNombreException("El nombre del personaje no puede ser nulo o vacio.");
        }

        this.nombre = nombre;
        this.stat = base;
        this.inventario = inventario;
    }

    /**
     * Metodo por el cual atacamos al personaje que elijamos.
     * @param personaje Personaje al cual deseamos atacar.
     */
    public void atacar(Personaje personaje) {
        if (this.stat.verificarStamina(30)) {
            modificarStamina(-30);
            // El entero que tiene que recibir es el calculo del stat ataque procesado por diferentes variables.
            personaje.modificarVida(-(int)(stat.calcularAtaque(personaje.stat) * 0.5));
            System.out.println(-(int)(stat.calcularAtaque(personaje.stat) * 0.5));
        } else {
            // Mandar excepcion.
            System.out.println("< No tenes stamina para atacar. >");
        }
    }

    /**
     * Metodo para defenderse por un turno.
     * @param statArmadura Stat que aporta armadura por el turno.
     */
    public void defender(Stat statArmadura) {
        if (stat.verificarStamina(30)) {
            modificarStamina(-30);
            isDefensa = !isDefensa;

            if (!isDefensa) {
                stat = Stat.aplicarStats(stat, statArmadura);
            } else {
                stat = Stat.desAplicarStats(stat, statArmadura);
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
                        personaje_001.atacar(
                                personaje_002
                        );
                    }
                    case 2 -> {
                        System.out.println(personaje_001.nombre + " se defiende de " + personaje_002.nombre);
                        personaje_001.defender(personaje_001.inventario.obtenerStatsArmaduras());
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
                        personaje_002.atacar(personaje_001);
                    }
                    case 2 -> {
                        System.out.println(personaje_002.nombre + " se defiende de " + personaje_001.nombre);
                        personaje_002.defender(personaje_001.inventario.obtenerStatsArmaduras());
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
        try {
            if (inventario.equiparItem(item)) {
                Stat nuevosStats = item.obtenerStat();
                this.stat = Stat.aplicarStats(this.stat, nuevosStats);
            }
        } catch (EquipamientoFullException e) {
            System.out.println("Error al equipar el item: " + e.getMessage());
        }
    }

    /**
     * Desaplica los stats del item seleccionado.
     * @param item Es el item que deseamos que se desequipe.
     */
    public void desequiparItem(Item item) {
        try {
            inventario.removerItemDeEquipamiento(item);
            stat = Stat.desAplicarStats(stat, item.obtenerStat());
        } catch (ItemNotFoundException e) {
            // Aca podemos manejar la excepcion.
            System.out.println("Error al desequipar el item: " + e.getMessage());
        }
    }

    /**
     * Este metodo se encarga de modificar la cantidad de vida que posee el personaje.
     * @param vida La cantidad de vida que deseemos que se le agregue o saque al personaje.
     */
    public void modificarVida(int vida) {
        Stat nuevaVida = stat.calcularVida(vida);
        stat = Stat.aplicarStats(stat, nuevaVida);
    }

    /**
     * Metodo que aplica los efectos de estado de gastar o sumar stamina.
     * @param stamina La estamina que se desea agregar o sacar. Tiene que ser un entero.
     */
    public void modificarStamina(int stamina) {
        Stat nuevaStamina = stat.calcularStamina(stamina);
        stat = Stat.aplicarStats(stat, nuevaStamina);
    }

    /**
     * Metodo que devuelve el inventario del personaje.
     * @return Retorna un objeto de instancia inventario.
     */
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
