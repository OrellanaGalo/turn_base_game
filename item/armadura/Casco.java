package item.armadura;

import entity.Personaje;

public class Casco extends Armadura{
    /**
     * Personaje al cual le afectan los cambios de stats.
     */
    private Personaje personaje;

    /**
     * @param nombre Nombre que va a llevar el casco.
     * @param defensa Cantidad de defensa que otorga el casco actual.
     * @param durabilidad_max Durabilidad maxima del casco.
     * @param durabilidad_actual Durabilidad actual del casco.
     * @param personaje Personaje el cual va a ser modificado.
     */
    public Casco(String nombre, float defensa, int durabilidad_max, int durabilidad_actual, Personaje personaje) {
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
     * Pasa como un String todos los atributos presentes en la clase de Casco.
     * @return Retorna un String con los atributos pasados a texto.
     */
    @Override
    public String aCadena() {
        return "[" + nombre + "//" + defensa + "//" + durabilidad_actual + "/" + durabilidad_max + "]";
    }

    /**
     * Verifica que el objeto introducido en el argumento sea de la misma clase que Casco.
     * @param o Objeto que se desea comparar con Casco.
     * @return Retorna True si es de la misma clase, y False si no lo es.
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Casco casco = (Casco) o;
        return nombre.equals(casco.nombre);
    }
}
