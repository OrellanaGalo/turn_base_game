package item.arma;

import entity.Personaje;

public class Lanza extends Arma{
    /**
     * Personaje al cual le afectan los cambios de stats.
     */
    private Personaje personaje;

    public Lanza(String nombre, float ataque, float condicion, Personaje personaje) {
        super(nombre, ataque, condicion);
        this.personaje = personaje;
    }

    /**
     * asd
     * @return asd
     */
    @Override
    public float modificarStat() {
        if(personaje != null && ataque >= 0){
            personaje.ataque += ataque;
        }

        return personaje != null ? personaje.ataque : 0;
    }

    /**
     * asd
     * @return asd
     */
    @Override
    public String aCadena() {
        return "[" + nombre + "//" + ataque + "]";
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

        Lanza lanza = (Lanza) o;
        return nombre.equals(lanza.nombre);
    }
}
