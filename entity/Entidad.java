package entity;

import main.Modificar;

public abstract class Entidad extends Modificar{
    protected String nombre;
    public int vida;
    public int stamina;
    public float ataque;
    public float defensa;
    public float inteligencia;

    /**
     * Constructor de la clase abstracta Entidad.
     * @param nombre Nombre que va a llevar la entidad.
     * @param vida Vida total que va a tener la entidad.
     * @param stamina Stamina total que va a tener la entidad.
     * @param ataque Ataque base que posee la entidad.
     * @param defensa Defensa base que posee la entidad.
     * @param inteligencia Inteligencia base que posee la entidad.
     */
    public Entidad(String nombre, int vida, int stamina, float ataque, float defensa, float inteligencia){
        this.nombre = nombre;
        this.vida = vida;
        this.stamina = stamina;
        this.ataque = ataque;
        this.defensa = defensa;
        this.inteligencia = inteligencia;
    }
}
