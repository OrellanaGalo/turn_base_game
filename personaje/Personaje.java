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
     * Aca se guardan los stats pasados por los modificadores.
     */
    private Stat stats_modificados;

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
    public Personaje(String nombre, Stat base, Stat stats_modificados, List<Item> equipado, List<Item> items){
        this.nombre = nombre;
        this.base = base;
        this.stats_modificados = stats_modificados;
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
        return personaje.stats_modificados.vida - stats_modificados.ataque;
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
            // agregar excepciones.
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

    public Stat aplicarStats(Item item) {
        Stat nuevo_stat = item.obtenerStat();

        Stat stat_final = new Stat(
                stats_modificados.vida + nuevo_stat.vida,
                stats_modificados.stamina + nuevo_stat.stamina,
                stats_modificados.ataque + nuevo_stat.ataque,
                stats_modificados.defensa + nuevo_stat.defensa,
                stats_modificados.inteligencia + nuevo_stat.inteligencia
        );

        return stats_modificados = stat_final;
    }

    /**
     * Convierte todos los atributos e informacion en un String para ser mostrado en consola.
     * @return Un StringBuilder convertido a un String para mostrarlo en consola.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int contador = 0;

        sb.append(String.format(
                "%-30s %-10s %-10s %-10s %-10s %-10s", "Nombre:", "Vida", "Stamina", "Ataque", "Defensa",
                "Inteligencia")).append("\n");
        sb.append(String.format(
                "%-30s %-10s %-10s %-10s %-10s %-10s", nombre, base.vida, base.stamina, base.ataque, base.defensa,
                    base.inteligencia)).append("\n");
        sb.append(String.format(
                "%-30s %-10s %-10s %-10s %-10s %-10s", nombre, stats_modificados.vida, stats_modificados.stamina,
                    stats_modificados.ataque, stats_modificados.defensa, stats_modificados.inteligencia)).append("\n")
                        .append("\n");

        sb.append("Inventario de: ").append(nombre).append("\n").append("\n");

        sb.append(String.format("%-40s %-10s", "Nombre", "   Stats")).append("\t\t")
                .append(String.format("%-40s %-10s", "Nombre", "   Stats")).append("\t\t")
                .append(String.format("%-40s %-10s", "Nombre", "   Stats")).append("\n");

        for(Item item : items){
            String string_items = item.toString();
            String[] partes = string_items.split("->");
            String nombre_de_item = partes[0].trim();
            String valor_item = partes[1].trim();

            String numeros_formateados = String.format("%-10s", valor_item);
            String linea = String.format("%-40s -> %s", nombre_de_item, numeros_formateados);

            sb.append(linea);
            contador++;

            if (contador % 3 == 0) {
                sb.append("\n");
            } else {
                sb.append("\t");
            }
        }

        sb.append("\n").append("Elementos equipados de: ").append(nombre).append("\n").append("\n");

        sb.append(String.format("%-40s %-10s", "Nombre", "   Stats")).append("\t\t")
                .append(String.format("%-40s %-10s", "Nombre", "   Stats")).append("\t\t")
                .append(String.format("%-40s %-10s", "Nombre", "   Stats")).append("\n");

        for(Item item : equipado){
            String string_items = item.toString();
            String[] partes = string_items.split("->");
            String nombre_de_item = partes[0].trim();
            String valor_item = partes[1].trim();

            String numeros_formateados = String.format("%-10s", valor_item);
            String linea = String.format("%-40s -> %s", nombre_de_item, numeros_formateados);

            sb.append(linea);
            contador++;

            if (contador % 3 == 0) {
                sb.append("\n");
            } else {
                sb.append("\t");
            }
        }

        return sb.toString();
    }
}
