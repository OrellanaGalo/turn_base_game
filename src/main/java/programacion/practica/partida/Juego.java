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
    public Juego() {
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

        System.out.println("\n< Ingrese el nombre del nuevo personaje: >");
        nombre = scanner.next();

        return new Personaje(nombre, base, inventario);
    }
}
