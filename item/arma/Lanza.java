package item.arma;

import entity.Personaje;

public class Lanza extends Arma{
    private Personaje personaje;

    public Lanza(String nombre, float ataque, float condicion) {
        super(nombre, ataque, condicion);
    }

    @Override
    public float modificarStat() {
        if(personaje != null && ataque >= 0){
            personaje.ataque += ataque;
        }

        return personaje != null ? personaje.ataque : 0;
    }

    @Override
    public String aCadena() {
        return "[" + nombre + "//" + ataque + "]";
    }
}
