package programacion.practica.partida;

import programacion.practica.personaje.Personaje;

import java.util.Scanner;

/**
 * Esta clase se encarga de manejar todas las mecanicas principales del juego.
 */
public class Juego {

    /**
     * Constructor de la clase.
     */
    public Juego () {

    }

    /**
     * Este metodo es utilizado para la creacion de personajes en el juego.
     * @return Retorna un nuevo personaje en base a la informacion introducida.
     */
    public Personaje crearPersonaje() {
        Scanner scanner = new Scanner(System.in);
        Stat base = new Stat(100, 100, 10, 10, 10);
        Inventario inventario = new Inventario();
        String nombre;

        System.out.println("\nIngrese el nombre del nuevo personaje:");
        nombre = scanner.next();

        return new Personaje(nombre, base, inventario);
    }

    /**
     * Este metodo simula la mecanica de pelear dentro del juego.
     * @param personaje_uno Es el primer personaje.
     * @param personaje_dos Es el segundo personaje. Este personaje siempre tiene su turno al final.
     */
    public void pelear(Personaje personaje_uno, Personaje personaje_dos) {
        boolean turno = true;
        int ingreso;

        Scanner scanner = new Scanner(System.in);

        while (personaje_uno.getVida() > 0 && personaje_dos.getVida() > 0) {
            System.out.println("Estado de: " + personaje_uno.getNombre() + personaje_uno);
            System.out.println("Estado de: " + personaje_dos.getNombre() + personaje_dos);

            if (turno) {
                System.out.println("Que deberia hacer: " + personaje_uno.getNombre());
            } else {
                System.out.println("Que deberia hacer: " + personaje_dos.getNombre());
            }

            System.out.println("1: ATACAR, 2: DEFENDER, 3: DESCANSAR\n");

            ingreso = scanner.nextInt();

            if (turno) {
                // Turno del primer personaje.
                switch (ingreso) {
                    case 1 -> {
                        personaje_uno.atacar(personaje_dos);
                        personaje_uno.modificarStamina(-30);
                    }
                    case 2 -> personaje_uno.defender();
                    case 3 -> personaje_uno.modificarStamina(30);
                    default -> System.out.println("Entrada invalida.");
                }
            } else {
                // Turno del segundo personaje.
                switch (ingreso) {
                    case 1 -> {
                        personaje_dos.atacar(personaje_uno);
                        personaje_dos.modificarStamina(-30);
                    }
                    case 2 -> personaje_dos.defender();
                    case 3 -> personaje_dos.modificarStamina(30);
                    default -> System.out.println("Entrada invalida.");
                }
            }

            turno = !turno;
        }

        // Nos fijamos quien gano.
        if (personaje_uno.getVida() <= 0) {
            System.out.println(personaje_dos.getNombre() + " gano la pelea.");
        } else {
            System.out.println(personaje_uno.getNombre() + " gano la pelea.");
        }
    }
}
