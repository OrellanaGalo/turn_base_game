package programacion.practica.partida;

import programacion.practica.excepciones.IllegalNombreException;
import programacion.practica.personaje.Personaje;
import java.util.Scanner;

/**
 * La clase `Juego` se encarga de manejar todas las mecánicas principales del juego. Esta clase es el corazón del juego
 * y se encarga de coordinar todas las interacciones entre los personajes, los objetos y las acciones del jugador
 * durante la partida.
 */
public class Juego {
    /**
     * Constructor de la clase.
     */
    public Juego() {}

    /**
     * Este metodo es utilizado para la creacion de personajes en el juego.
     * @return Retorna un nuevo personaje en base a la informacion introducida.
     */
    public Personaje crearPersonaje() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        Stat base = new Stat(100, 100, 10, 10, 10);
        Inventario inventario = new Inventario();

        try {
            System.out.println("\n< Ingrese el nombre del nuevo personaje: >");
            nombre = scanner.next();

            return new Personaje(nombre, base, inventario);
        } catch (IllegalNombreException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
