package programacion.practica.partida;

import programacion.practica.excepciones.IllegalNombreException;
import programacion.practica.personaje.Personaje;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * La clase `Juego` se encarga de manejar todas las mecánicas principales del juego. Esta clase es el corazón del juego
 * y se encarga de coordinar todas las interacciones entre los personajes, los objetos y las acciones del jugador
 * durante la partida.
 */
public class Juego {

    /**
     * Este metodo se utiliza para obtener un numero entero valido del usuario.
     * Si el usuario se equivoca de ingreso, se le va a pedir que lo ingrese nuevamente.
     * @param mensaje El mensaje que se mostrara al usuario para obtener el input.
     * @param min Valor minimo permitido (el inclusive).
     * @param lista La lista de objetos a la cual el usuario intenta acceder.
     * @return El numero entero ingresado por el usuario.
     */
    public int obtenerNumeroEntero(String mensaje, int min, List<?> lista) {
        int tamanioActual = lista.size();
        int rangoMaximo = tamanioActual > 0 ? tamanioActual - 1 : 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(mensaje);
                int input = scanner.nextInt();

                if (input >= min && input <= rangoMaximo) {
                    return input;
                } else {
                    System.out.println("< Ingresa un numero dentro del rango permitido. >");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("< Error: Ingresa un entero valido. >");
            }
        }
    }

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
