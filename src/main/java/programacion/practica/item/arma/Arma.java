package programacion.practica.item.arma;

import programacion.practica.item.Item;
import programacion.practica.partida.Stat;

/**
 * Esta clase representa un arma en el juego. Las armas son objetos que se utilizan principalmente para aumentar o
 * disminuir el stat de ataque. Estas tambien cuentan con el atributo 'condicion' que representa el estado actual del
 * arma y como el ataque de esta varia en funcion de la condicion.
 */
public abstract class Arma extends Item{
    /**
     * Condicion actual en la cual se encuentra el arma.
     */
    private int condicion;

    /**
     * Constructor de la clase abstracta Arma.
     * @param nombre Nombre del arma.
     * @param ataque Es el danio que efectua el arma.
     * @param condicion Condicion total del arma.
     */
    public Arma(String nombre, int ataque, int condicion) {
        super(nombre, new Stat(0, 0, ataque, 0, 0));
        this.condicion = condicion;
    }

    /**
     * Retorna una representacion a texto de los atributos de este arma.
     */
    public String toString() {
        return super.toString() + obtenerStat().toString(true) + ']';
    }

    /**
     * Metodo que se encarga de modificar la condicion del arma.
     * @param variable Es la cantidad por la cual se desea que se reduzca la condicion.
     * @return Retorna un entero que indica la nueva condicion del arma.
     */
    public int gastarCondicion(int variable) {
        return this.condicion - variable;
    }
}
