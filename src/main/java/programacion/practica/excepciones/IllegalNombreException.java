package programacion.practica.excepciones;

/**
 * Excepcion lanzada por intentar poner un nombre vacio o nulo en el personaje.
 */
public class IllegalNombreException extends Exception{
    public IllegalNombreException(String mensaje) {
        super(mensaje);
    }
}
