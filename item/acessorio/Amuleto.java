package item.acessorio;

import entity.Personaje;

public class Amuleto extends Accesorio{
    private Personaje personaje;
    private int porcentaje;

    public Amuleto(String nombre, float durabilidad_max, float durabilidad_act, int porcentaje, Personaje personaje) {
        super(nombre, durabilidad_max, durabilidad_act);
        this.porcentaje = porcentaje;
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

        Amuleto amuleto = (Amuleto) o;
        return nombre.equals(amuleto.nombre);
    }

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
