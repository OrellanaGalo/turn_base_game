package item.arma;

import entity.Personaje;

public class Lanza extends Arma{
    /**
     * Personaje al cual le afectan los cambios de stats.
     */
    private Personaje personaje;

    /**
     * Constructor de la clase Lanza.
     * @param nombre Nombre de la lanza.
     * @param ataque Ataque base de la lanza
     * @param condicion Condicion total de la lanza.
     * @param personaje Personaje el cual va a ser modificado.
     */
    public Lanza(String nombre, float ataque, float condicion, Personaje personaje) {
        super(nombre, ataque, condicion);
        this.personaje = personaje;
    }

    /**
     * Modifica los stats del personaje.
     * @return Un flotante que es numero por el cual se modifican los stats de ataque del personaje.
     */
    @Override
    public float modificarStat() {
        if(personaje != null && ataque >= 0){
            personaje.ataque += ataque;
        }

        return personaje != null ? personaje.ataque : 0;
    }

    /**
     * Pasa como un String todos los atributos presentes en la clase de Lanza.
     * @return Retorna un String con los atributos pasados a texto.
     */
    @Override
    public String aCadena() {
        return "[" + nombre + "//" + ataque + "]";
    }

    /**
     * Verifica que el objeto introducido en el argumento sea de la misma clase que Lanza.
     * @param o Objeto que se desea comparar con Lanza.
     * @return Retorna True si es de la misma clase, y False si no lo es.
     */
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Lanza lanza = (Lanza) o;
        return nombre.equals(lanza.nombre);
    }
}
