package entity;

import item.Item;
import item.armadura.*;
import item.arma.*;
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
        this.items = items;
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
    }

    public void equiparCasco(Casco casco){
        this.casco = casco;
    }

    public void equiparTorso(Torso torso){
        this.torso = torso;
    }

    public void equiparPantalon(Pantalon pantalon){
        this.pantalon = pantalon;
    }

    public void equiparPies(Pies pies){
        this.pies = pies;
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

        defensa += nueva_defensa;
        return defensa;
    }

    @Override
    public String aCadena() {
        return "[" + nombre + "||" + vida + "||" + stamina + "||" + ataque + "||" + defensa + "||" + inteligencia + "]" + "[" + items + "]";
    }
}
