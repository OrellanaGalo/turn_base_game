package item.armadura;

import entity.Personaje;

public class Torso extends Armadura{
    /**
     * Personaje al cual le afectan los cambios de stats.
     */
    private Personaje personaje;

    /**
     * @param nombre Nombre que va a llevar el torso.
     * @param defensa Cantidad de defensa que otorga el torso actual.
     * @param durabilidad_max Durabilidad maxima del torso.
     * @param durabilidad_actual Durabilidad actual del torso.
     */
    public Torso(String nombre, float defensa, int durabilidad_max, int durabilidad_actual, Personaje personaje) {
        super(nombre, defensa, durabilidad_max, durabilidad_actual);
        this.personaje = personaje;
    }

    /**
     * asd
     * @return asd
     */
    @Override
    public float modificarStat() {
        if(personaje != null && defensa >= 0){
            personaje.defensa += defensa;
        }

        return personaje != null ? personaje.defensa : 0;
    }

    /**
     * asd
     * @return asd
     */
    @Override
    public String aCadena() {
        return "[" + nombre + "//" + defensa + "//" + durabilidad_actual + "/" + durabilidad_max + "]";
    }

    /**
     * asd
     * @param o asd
     * @return asd
     */
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Torso torso = (Torso) o;
        return nombre.equals(torso.nombre);
    }
}
