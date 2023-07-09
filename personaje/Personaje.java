package personaje;

import item.Item;
import partida.Stat;

import java.util.ArrayList;
import java.util.List;

public class Personaje{
    /**
     * Nombre que va a tener nuestro personaje.
     */
    private String nombre;

    /**
     * Estadisticas base que va a tener nuestro personaje.
     */
    private Stat base;

    /**
     * Elementos que tiene equipado el personaje.
     */
    private List<Item> equipado;

    /**
     * Inventario del personaje.
     */
    private List<Item> items;

    /**
     * Constructor de Personaje.
     * @param nombre Nombre que va a llevar el personaje.
     * @param equipado Lista que indica que objetos tiene equipado el personaje.
     * @param items Lista de Items que tiene en el inventario el personaje.
     */
    public Personaje(String nombre, Stat base, List<Item> equipado, List<Item> items){
        this.nombre = nombre;
        this.base = base;
        this.items = items != null ? items : new ArrayList<>();
        this.equipado = equipado != null ? equipado : new ArrayList<>();
    }

    /**
     * Agrega un item al inventario del personaje.
     * @param item Es el item que se desea agregar al inventario.
     */
    public void agregarItem(Item item){
        this.items.add(item);
    }

    /**
     * Remueve un item del inventario del personaje.
     * @param item Es el item que se desea remover del inventario.
     */
    public void removerItem(Item item){
        this.items.remove(item);
    }

    /**
     * Metodo para que el personaje A ataque al personaje B.
     * @param personaje Personaje al cual se desea atacar.
     * @return un entero que representa el ataque total de este personaje.
     */
    public int atacar(Personaje personaje){
        return 0;
    }

    /**
     * Metodo que permite equipar items pero solo los que estan presentes en el inventario.
     * @param item Item que se desea equipar.
     */
    public void equiparItem(Item item){
        if(equipado.stream().anyMatch(e -> e.equals(item))){
            System.out.println("Ya hay un item de la misma clase equipado.");
        } else if(items.contains(item)){
            equipado.add(item);
            System.out.println("Item equipado: " + item);
        } else {
            System.out.println("El item no esta presente en el inventario.");
        }
    }

    /**
     * Desequipa el item seleccionado presente en la lista equipado.
     * @param item Item que se desea desequipar.
     */
    public void desequiparItem(Item item){
        this.equipado.remove(item);
    }

    /**
     * Convierte todos los atributos e informacion en un String para ser mostrado en consola.
     * @return Un StringBuilder convertido a un String para mostrarlo en consola.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[").append(nombre).append("\t->\t").append("Vida: ").append(base.vida).append("\t").append("Stamina: ")
                .append(base.stamina).append("\t").append("Ataque: ").append(base.ataque).append("\t").append("Defensa: ")
                    .append(base.defensa).append("\t").append("Inteligencia: ").append(base.inteligencia).append("]");
        sb.append("\n").append("Inventario de: " ).append(nombre).append("\n").append("[");
        for(Item item : items){
            sb.append(item).append(", ");
        }
        sb.append("]");

        sb.append("\n").append("Equipo de: " ).append(nombre).append("\n").append("[");
        for(Item item : equipado){
            sb.append(item).append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
