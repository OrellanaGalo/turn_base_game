package programacion.practica.partida;

import programacion.practica.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase se encarga de manejar todo lo correspondiente al inventario del personaje y su equipamiento.
 */
public class Inventario {
    /**
     * Inventario principal del personaje donde se guardan todos los items.
     */
    private List<Item> items;

    /**
     * Equipamiento del personaje, lo que este presente en este atributo modifica directamente los stats del personaje.
     */
    private List<Item> equipamiento;

    /**
     * Constructor de la clase.
     */
    public Inventario() {
        this.items = new ArrayList<>();
        this.equipamiento = new ArrayList<>();
    }

    /**
     * Agrega un item al inventario.
     * @param item Item que se desea agregar.
     */
    public void agregarItem(Item item) {
        this.items.add(item);
    }

    /**
     * Remueve el item seleccionado del inventario.
     * @param item Item que se desea remover.
     */
    public void eliminarItem(Item item) {
        this.items.remove(item);
    }

    /**
     * Equipa un item seleccionado del inventario. Tambien se escarga de verificar que un item de la misma clase no este
     * presente ya en el equipamiento.
     * @param item Es el item que se desea equipar.
     */
    public boolean equiparItem(Item item) {
        if(equipamiento.stream().anyMatch(e -> e.equals(item))){
            // Agregar excepciones.
            System.out.println("Ya hay un item de la misma clase equipado.");
        } else if(items.contains(item)){
            equipamiento.add(item);
            return true;
        } else {
            // agregar excepciones.
            System.out.println("El item no esta presente en el inventario.");
        }

        return false;
    }

    /**
     * Remueve un item de la lista de equipamiento.
     * @param item El item que se desea remover.
     */
    public void desequiparItem(Item item) {
        if(equipamiento.contains(item)) {
            equipamiento.remove(item);
        } else {
            // Esto deberia ser una excepcion.
            System.out.println("El item no esta equipado");
        }
    }

    /**
     * Selecciona un item del inventario y lo retorna. Este metodo esta pensado para funcionar en conjunto con equipar
     * Item.
     * @param posicion La posicion del item dentro de la lista.
     */
    public Item seleccionarItemEnInventario(int posicion){
        // Aca deberia haber una excepcion en caso de que se seleccione una posicion que excede la longitud de la lista.
        return items.get(posicion);
    }

    /**
     * Selecciona un item del equipamiento y lo retorna. Este metodo esta pensado para funcionar con desequiparItem.
     * @param posicion La posicion del item dentro de la lista del equipamiento.
     */
    public Item seleccionarItemEnEquipamiento(int posicion) {
        return equipamiento.get(posicion);
    }

    /**
     * Se encarga de mostrar la informacion de ambas listas en consola.
     * @return Devuelve un String que luego se muestra.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        int pos = 0;
        int pos_equipamiento = 0;

        sb.append("\n").append("------------------< Inventario de >------------------").append("\n");

        sb.append(String.format("%-4s %-40s %-6s", "Pos:", "Nombre del item:", "   Stats:")).append("\t\t")
                .append(String.format("%-4s %-40s %-6s", "Pos:", "Nombre del item:", "   Stats:")).append("\t\t")
                .append(String.format("%-4s %-40s %-6s", "Pos:", "Nombre del item:", "   Stats:")).append("\n");

        for(Item item : items){
            String string_items = item.toString();
            String[] partes = string_items.split("->");
            String nombre_de_item = partes[0].trim();
            String valor_item = partes[1].trim();

            String numeros_formateados = String.format("%-5s", valor_item);
            String linea = String.format("%-4s %-40s -> %s", pos, nombre_de_item, numeros_formateados);

            sb.append(linea);
            contador++;
            pos++;

            if (contador % 3 == 0) {
                sb.append("\n");
            } else {
                sb.append("\t");
            }
        }

        sb.append("\n").append("------------------< Elementos equipados >------------------").append("\n");

        sb.append(String.format("%-4s %-40s %-6s", "Pos:", "Nombre del item:", "   Stats:")).append("\t\t")
                .append(String.format("%-4s %-40s %-6s", "Pos:", "Nombre del item:", "   Stats:")).append("\t\t")
                .append(String.format("%-4s %-40s %-6s", "Pos:", "Nombre del item:", "   Stats:")).append("\n");

        for(Item item : equipamiento){
            String string_items = item.toString();
            String[] partes = string_items.split("->");
            String nombre_de_item = partes[0].trim();
            String valor_item = partes[1].trim();

            String numeros_formateados = String.format("%-10s", valor_item);
            String linea = String.format("%-4s %-40s -> %s", pos_equipamiento, nombre_de_item, numeros_formateados);

            sb.append(linea);
            contador++;
            pos_equipamiento++;

            if (contador % 3 == 0) {
                sb.append("\n");
            } else {
                sb.append("\t");
            }
        }

        return sb.toString();
    }
}
