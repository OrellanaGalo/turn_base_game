package item.acessorio;

import entity.Personaje;

public class Amuleto extends Accesorio{
    /**
     * Personaje al cual se le efectuan los cambios de stats.
     */
    private Personaje personaje;

    /**
     * Atributo que indica el porcentaje por el cual se modifican los stats del personaje.
     */
    private int porcentaje;

    /**
     * Constructor de la clase Amuleto.
     * @param nombre Nombre del Amuleto.
     * @param durabilidad_max Durabilidad maxima del objeto Amuleto.
     * @param durabilidad_act Durabilidad actual del objeto Amuleto.
     * @param porcentaje Porcentaje por el cual se modifican los stats de personaje si utiliza el Amuleto.
     * @param personaje Personaje el cual va a ser modificado.
     */
    public Amuleto(String nombre, float durabilidad_max, float durabilidad_act, int porcentaje, Personaje personaje) {
        super(nombre, durabilidad_max, durabilidad_act);
        this.porcentaje = porcentaje;
        this.personaje = personaje;
    }

    /**
     * Verifica que el objeto introducido en el argumento sea de la misma clase que Amuleto.
     * @param o Objeto que se desea comparar con Amuleto.
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

        Amuleto amuleto = (Amuleto) o;
        return nombre.equals(amuleto.nombre);
    }

    /**
     * Modifica los stats del personaje.
     * @return Un flotante que es numero por el cual se modifican los stats de inteligencia, defensa y ataque del
     *         personaje.
     */
    @Override
    public float modificarStat() {
        if(personaje != null && personaje.defensa >= 0 && personaje.ataque >= 0 && personaje.inteligencia >= 0){
            personaje.defensa += (personaje.defensa * porcentaje);
            personaje.ataque += (personaje.ataque * porcentaje);
            personaje.inteligencia += (personaje.inteligencia * porcentaje);
        }

        return personaje != null ? personaje.inteligencia : 0;
    }

    @Override
    public String aCadena() {
        return "[" + nombre + porcentaje + "]";
    }
}
