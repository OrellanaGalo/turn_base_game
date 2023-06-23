package item.acessorio;

import entity.Personaje;

public class Anillo extends Accesorio{
    private Personaje personaje;
    private float inteligencia;

    public Anillo(String nombre, float inteligencia, float durabilidad_max, float durabilidad_act, Personaje personaje) {
        super(nombre, durabilidad_max, durabilidad_act);
        this.inteligencia = inteligencia;
        this.personaje = personaje;
    }

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

    @Override
    public float modificarStat() {
        if(personaje != null && inteligencia >= 0){
            personaje.inteligencia += inteligencia;
        }

        return personaje != null ? personaje.inteligencia : 0;
    }

    @Override
    public String aCadena() {
        return "[" + nombre + inteligencia + "]";
    }
}
