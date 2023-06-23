package entity;

import item.Item;

import java.util.ArrayList;
import java.util.List;

public class Personaje extends Entidad{
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
    public Personaje(String nombre, List<Item> equipado, List<Item> items){
        super(nombre, 100, 100, 10, 10, 10);
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
    public float atacar(Personaje personaje){
        if(stamina - 20 >= 0){
            personaje.vida -= ataque;
        } else {
            return personaje.vida;
        }

        return ataque;
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
            item.modificarStat(); // Esto no deberia estar aca.
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
     * Modifica las stats de manera general.
     * @return Un flotante.
     */
    @Override
    public float modificarStat() {
        return 0;
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

        sb.append("\n").append("Equipo de: " ).append(nombre).append("\n").append("[");
        for(Item item : equipado){
            sb.append(item).append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
