package programacion.practica.item.arma;

/**
 * Esta clase representa una lanza en el juego. Las lanzas son armas que se utilizan principalmente para aumentar o
 * disminuir el stat de ataque. Estas también cuentan con el atributo 'condicion' que representa el estado actual del
 * arma y cómo el ataque de esta varía en función de la condición.
 */
public class Lanza extends Arma{
    /**
     * Constructor de la clase Lanza.
     * @param nombre Nombre de la lanza.
     * @param ataque Ataque base de la lanza
     * @param condicion Condicion total de la lanza.
     */
    public Lanza(String nombre, int ataque, int condicion) {
        super(nombre, ataque, condicion);
    }
}
