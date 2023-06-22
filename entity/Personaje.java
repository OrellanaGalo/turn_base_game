package entity;

import item.Item;
import item.armadura.*;
import item.arma.*;

import java.util.ArrayList;
import java.util.List;

public class Personaje extends Entidad{
    private Arma arma;
    private Casco casco;
    private Torso torso;
    private Pantalon pantalon;
    private Pies pies;

    /**
     * Inventario del personaje.
     */
    private List<Item> items;

    public Personaje(String nombre, List<Item> items){
        super(nombre, 100, 100, 10, 10, 10);
        this.items = items != null ? items : new ArrayList<>();
    }

    /**
     * Agrega un item al inventario del personaje.
     * @param item Es el item que se desea agregar al inventario.
     */
    public void agregarItem(Item item){
        this.items.add(item);
    }

    /**
     * Metodo para que el personaje A ataque al personaje B.
     * @param personaje Personaje al cual se desea atacar.
     * @return un entero que representa el ataque total de este personaje.
     */
    public float atacar(Personaje personaje){
        if(stamina - 20 >= 0){
            personaje.vida -= ataque;
        } else {
            return personaje.vida;
        }

        return ataque;
    }

    /**
     * Metodo para que un personaje A se defienda de personaje B.
     * @param personaje Personaje del cual deseas defenderte.
     * @return Un entero que representa la defensa total de este personaje.
     */
    public float defender(Personaje personaje){
        if(personaje.arma.condicion >= 80 && defensa >= 0){
            defensa -= personaje.ataque;
        } else if(personaje.arma.condicion <= 80 && personaje.arma.condicion >= 50 && defensa >= 0){
            defensa -= personaje.ataque * 0.70;
        } else if (defensa >= 0){
            defensa -= personaje.ataque * 0.40;
        } else {
            vida -= personaje.ataque;
        }

        return defensa;
    }

    public void equiparArma(Arma arma){
        this.arma = arma;
        arma.modificarStat();
    }

    public void equiparCasco(Casco casco){
        this.casco = casco;
        casco.modificarStat();
    }

    public void equiparTorso(Torso torso){
        this.torso = torso;
        torso.modificarStat();
    }

    public void equiparPantalon(Pantalon pantalon){
        this.pantalon = pantalon;
        pantalon.modificarStat();
    }

    public void equiparPies(Pies pies){
        this.pies = pies;
        pies.modificarStat();
    }

    @Override
    public float modificarStat() {
        float nueva_defensa = 0;

        if(casco != null){
            nueva_defensa += casco.modificarStat();
        }
        if(torso != null){
            nueva_defensa += torso.modificarStat();
        }
        if(pantalon != null){
            nueva_defensa += pantalon.modificarStat();
        }
        if(pies != null){
            nueva_defensa += pies.modificarStat();
        }

        defensa = defensa + nueva_defensa;
        return defensa;
    }

    /**
     * Convierte todos los atributos e informacion en un String para ser mostrado en consola.
     * @return Un StringBuilder convertido a un String para mostrarlo en consola.
     */
    @Override
    public String aCadena() {
        StringBuilder sb = new StringBuilder();

        sb.append("[").append(nombre).append("\t->\t").append("Vida: ").append(vida).append("\t").append("Stamina: ")
                .append(stamina).append("\t").append("Ataque: ").append(ataque).append("\t").append("Defensa: ")
                    .append(defensa).append("\t").append("Inteligencia: ").append(inteligencia).append("]");
        sb.append("\n").append("Inventario de: " ).append(nombre).append("\n").append("[");
        for(Item item : items){
            sb.append(item).append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
