package entity;

import main.Modificar;

public abstract class Entidad extends Modificar{
    protected String nombre;
    public int vida;
    public int stamina;
    public float ataque;
    public float defensa;
    public float inteligencia;

    public Entidad(String nombre, int vida, int stamina, float ataque, float defensa, float inteligencia){
        this.nombre = nombre;
        this.vida = vida;
        this.stamina = stamina;
        this.ataque = ataque;
        this.defensa = defensa;
        this.inteligencia = inteligencia;
    }
}
