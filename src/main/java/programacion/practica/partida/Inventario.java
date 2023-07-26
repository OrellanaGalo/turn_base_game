package programacion.practica.partida;

import programacion.practica.excepciones.EquipamientoFullException;
import programacion.practica.excepciones.ItemNotFoundException;
import programacion.practica.item.Item;
import programacion.practica.item.arma.Arma;
import programacion.practica.item.armadura.Armadura;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase `Inventario` se encarga de manejar todo lo correspondiente al inventario del personaje y su equipamiento en
 * el juego. El inventario es el espacio donde el personaje puede almacenar y gestionar los items que ha adquirido
 * durante la partida, como armas, armaduras, accesorios y consumibles. Además, esta clase también permite al personaje
 * equipar y desequipar objetos para mejorar sus estadísticas y habilidades durante el juego.
 */
public class Inventario {
    /**
     * Inventario principal del personaje donde se guardan todos los items.
     */
    private List<Item> items;

    /**
     * Equipamiento del personaje, lo que este presente en este atributo modifica directamente los stats del personaje.
     */
    private Item[] equipamiento;

    /**
     * Constructor de la clase.
     */
    public Inventario() {
        this.items = new ArrayList<>();
        this.equipamiento = new Item[7];
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
    public void eliminarItem(Item item) throws ItemNotFoundException {
        if (!items.contains(item)) {
            throw new ItemNotFoundException("El item no se encuentra en el inventario.");
        }
        this.items.remove(item);
    }

    /**
     * Selecciona un item del inventario y lo retorna.
     * @param posicion La posicion del item dentro de la lista.
     */
    public Item seleccionarItemEnInventario(int posicion){
        return items.get(posicion);
    }

    /**
     * Retorna el item del equipamiento en la posicion indicada.
     * @param posicion Es la posicion del item en el equipamiento que se desea obtener.
     * @return El item en la posicion indicada o, null si no hay item.
     */
    public Item seleccionarItemEnEquipamiento(int posicion) {
        if (posicion >= 0 && posicion < equipamiento.length) {
            return equipamiento[posicion];
        } else {
            System.out.println("< La posicion introducida no es valida. >");
            return null;
        }
    }

    /**
     * Equipa un item seleccionado del inventario. Tambien se escarga de verificar que un item de la misma clase no este
     * presente ya en el equipamiento.
     * @param item Es el item que se desea equipar.
     */
    public boolean equiparItem(Item item) throws EquipamientoFullException {
        if(item instanceof Arma) {
            if (equipamiento[0] != null) {
                System.out.println("< Espacio de arma ocupado. >");
                return false;
            }
            equipamiento[0] = item;
            return true;
        } else if (item instanceof Armadura nuevaArmadura) {
            Class<? extends Armadura> tipoArmadura = nuevaArmadura.getClass();

            for (int i = 1; i < equipamiento.length; i++) {
                Item itemEquipado = equipamiento[i];

                if (itemEquipado == null) {
                    equipamiento[i] = item;
                    return true;
                } else if (itemEquipado instanceof Armadura && itemEquipado.getClass() == tipoArmadura) {
                    System.out.println("< Te has cambiado de equipamiento. >");
                    equipamiento[i] = item;
                    return true;
                }
            }
            throw new EquipamientoFullException("No hay espacio disponible para ese item.");
        } else {
            throw new EquipamientoFullException("No es posible equipar ese tipo de objeto.");
        }
    }

    /**
     * Remueve un item de equipamiento.
     * @param item Item que se desea remover.
     * @return True si se pudo remover el item del equipamiento, false en caso de que el item no este en esa posicion.
     */
    public boolean removerItemDeEquipamiento(Item item) throws ItemNotFoundException {
        for (int i = 0; i < equipamiento.length; i++) {
            if (equipamiento[i] == item) {
                equipamiento[i] = null;
                reorganizarEquipamiento();
                return true;
            }
        }

        throw new ItemNotFoundException("El item no se encuentra en el equipamiento.");
    }

    /**
     * Metodo que recorre la lista de equipamiento y filtra todos los objetos de la clase Armadura, para finalmente
     * sumar todos sus stats en uno solo.
     * @return Un Stat con la suma de los stats de todas las Armaduras presentes en el equipamiento.
     */
    public Stat obtenerStatsArmaduras() {
        List<Stat> statsArmaduras = new ArrayList<>();

        for (Item item : equipamiento) {
            if (item instanceof Armadura) {
                statsArmaduras.add(item.obtenerStat());
            }
        }

        Stat statsTotales = new Stat(0, 0, 0, 0, 0);
        for (Stat statArmadura : statsArmaduras) {
            statsTotales = Stat.aplicarStats(statsTotales, statArmadura);
        }

        return statsTotales;
    }

    /**
     * Reorganiza el array de equipamiento para mantener el espacio [0] siempre disponible para el arma.
     */
    private void reorganizarEquipamiento() {
        Item[] nuevoEquipamiento = new Item[equipamiento.length];
        int nuevoIndice = 1;

        for (Item item : equipamiento) {
            if (item != null) {
                nuevoEquipamiento[nuevoIndice] = item;
                nuevoIndice++;
            }
        }

        equipamiento = nuevoEquipamiento;
    }

    /**
     * Metodo que retorna la lista de Items.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Se encarga de mostrar la informacion de ambas listas en consola.
     * @return Devuelve un String que luego se muestra.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        int pos = 0;
        int posEquipamiento = 0;

        sb.append("##################################################################################################" +
                    "################################################################################################" +
                        "#################");

        sb.append("\n").append("------------------< Inventario >------------------").append("\n");

        sb.append(String.format("%-4s %-40s %-20s", "Pos:", "Nombre del item:", "   Stats:")).append("\t\t")
                .append(String.format("%-4s %-40s %-20s", "Pos:", "Nombre del item:", "   Stats:")).append("\t\t")
                .append(String.format("%-4s %-40s %-20s", "Pos:", "Nombre del item:", "   Stats:")).append("\n");

        for(Item item : items){
            String string_items = item.toString();
            String[] partes = string_items.split("->");
            String nombre_de_item = partes[0].trim();
            String valor_item = partes[1].trim();

            String numeros_formateados = String.format("%-20s", valor_item);
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

        sb.append(String.format("%-4s %-40s %-20s", "Pos:", "Nombre del item:", "   Stats:")).append("\t\t")
                .append(String.format("%-4s %-40s %-20s", "Pos:", "Nombre del item:", "   Stats:")).append("\t\t")
                .append(String.format("%-4s %-40s %-20s", "Pos:", "Nombre del item:", "   Stats:")).append("\n");

        for(int i = 0; i < equipamiento.length; i++) {
            if (equipamiento[i] != null) {
                String stringItems = equipamiento[i].toString();
                String[] partes = stringItems.split("->");
                String nombreItem = partes[0].trim();
                String valorItem = partes[1].trim();

                String numerosFormateados = String.format("%-20s", valorItem);
                String linea = String.format("%-4s %-40s -> %s", posEquipamiento, nombreItem, numerosFormateados);

                sb.append(linea);
            } else {
                sb.append(String.format("%-4s %-40s -> %s", i, "Vacio", "--------------------"));
            }

            if (i % 3 == 0) {
                sb.append("\n");
            } else {
                sb.append("\t");
            }
        }

        sb.append("\n");

        return sb.toString();
    }
}
