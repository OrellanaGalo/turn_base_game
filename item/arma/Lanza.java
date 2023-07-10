package item.arma;

import partida.Stat;

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
