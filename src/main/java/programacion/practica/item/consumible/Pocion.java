package programacion.practica.item.consumible;

import programacion.practica.excepciones.IllegalNombreException;

/**
 * La clase `Pocion` es una subclase de la clase `Consumible` y representa un tipo específico de consumible en el juego.
 * Las pociones son objetos que pueden ser utilizados por un personaje para recuperar puntos de vida o stamina durante
 * la partida. Cuando un personaje utiliza una poción, obtiene un efecto curativo que le permite recuperar su salud o
 * resistencia
 */
public class Pocion extends Consumible{
    /**
     * Constructor de la clase Pocion.
     * @param nombre Nombre de la pocion.
     * @param vida Cantidad de vida que restaura o quita consumir o arrojar la pocion.
     * @param stamina Cantidad de Stamina que recupera o quita al consumir o arrojar la pocion.
     */
    public Pocion(String nombre, int vida, int stamina) throws IllegalNombreException {
        super(nombre, vida, stamina);
    }
}
