package item.acessorio;

import entity.Personaje;

public class Anillo extends Accesorio{
    /**
     * Personaje al cual se le efectuan los cambios de stats.
     */
    private Personaje personaje;

    /**
     * Atributo flotante que indica la inteligencia que aporta la calse Anillo.
     */
    private float inteligencia;

    /**
     *
     * @param nombre Nombre del Anillo.
     * @param inteligencia Inteligencia por la cual se modifican los stats de personaje al equipar el Anillo.
     * @param durabilidad_max Durabilidad maxima del objeto Anillo.
     * @param durabilidad_act Durabilidad actual del objeto Anillo.
     * @param personaje Personaje el cual va a ser modificado.
     */
    public Anillo(String nombre, float inteligencia, float durabilidad_max, float durabilidad_act, Personaje personaje) {
        super(nombre, durabilidad_max, durabilidad_act);
        this.inteligencia = inteligencia;
        this.personaje = personaje;
    }

    /**
     * Verifica que el objeto introducido en el argumento sea de la misma clase que Anillo.
     * @param o Objeto que se desea comparar con Anillo.
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

        Anillo anillo = (Anillo) o;
        return nombre.equals(anillo.nombre);
    }

    /**
     * Modifica los stats del personaje.
     * @return Un flotante que es numero por el cual se modifican los stats de inteligencia del personaje.
     */
    @Override
    public float modificarStat() {
        if(personaje != null && inteligencia >= 0){
            personaje.inteligencia += inteligencia;
        }

        return personaje != null ? personaje.inteligencia : 0;
    }

    /**
     * Pasa como un String todos los atributos presentes en la clase de Anillo.
     * @return Retorna un String con los atributos pasados a texto.
     */
    @Override
    public String aCadena() {
        return "[" + nombre + inteligencia + "]";
    }
}
