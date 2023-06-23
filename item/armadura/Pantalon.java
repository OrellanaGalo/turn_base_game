package item.armadura;

import entity.Personaje;

public class Pantalon extends Armadura{
    /**
     * Personaje al cual le afectan los cambios de stats.
     */
    private Personaje personaje;

    /**
     * @param nombre Nombre que va a llevar el pantalon.
     * @param defensa Cantidad de defensa que otorga el pantalon actual.
     * @param durabilidad_max Durabilidad maxima del pantalon.
     * @param durabilidad_actual Durabilidad actual del pantalon.
     */
    protected Pantalon(String nombre, float defensa, int durabilidad_max, int durabilidad_actual, Personaje personaje) {
        super(nombre, defensa, durabilidad_max, durabilidad_actual);
        this.personaje = personaje;
    }

    /**
     * Modifica los stats del personaje.
     * @return Un flotante que es numero por el cual se modifican los stats de defensa del personaje.
     */
    @Override
    public float modificarStat() {
        if(personaje != null && defensa >= 0){
            personaje.defensa += defensa;
        }

        return personaje != null ? personaje.defensa : 0;
    }

    /**
     * Pasa como un String todos los atributos presentes en la clase de Pantalon.
     * @return Retorna un String con los atributos pasados a texto.
     */
    @Override
    public String aCadena() {
        return "[" + nombre + "//" + defensa + "//" + durabilidad_actual + "/" + durabilidad_max + "]";
    }

    /**
     * Verifica que el objeto introducido en el argumento sea de la misma clase que Pantalon.
     * @param o Objeto que se desea comparar con Pantalon.
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

        Pantalon pantalon = (Pantalon) o;
        return nombre.equals(pantalon.nombre);
    }
}
