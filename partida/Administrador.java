package partida;

import item.Item;
import item.acessorio.Amuleto;
import item.acessorio.Anillo;
import item.arma.Lanza;
import item.armadura.*;
import personaje.Personaje;

import java.util.ArrayList;
import java.util.List;

/**
 * En esta clase van a ir todos los objetos que van a haber en el juego.
 */
public class Administrador {
    /**
     * Lista de todos los items en el juego.
     */
    private List<Item> itemList;

    /**
     * Lista de personajes jugables.
     */
    private List<Personaje> playerList;

    /**
     * Lista de inventarios e equipamientos individuales de cada personaje en el juego.
     */
    private List<Inventario> inventoryList;

    /**
     * Constructor de la clase Administrador.
     * Inicializa la lista de items y agrega los objetos predefinidos.
     */
    public Administrador() {
        itemList = new ArrayList<>();
        playerList = new ArrayList<>();
        inventoryList = new ArrayList<>();

        agregarObjetos();
    }

    /**
     * Armas.
     */
    Lanza lanza_001 = new Lanza("Lanza del Matadragones.", 72, 100);
    Lanza lanza_002 = new Lanza("Lanza de Yorgh.", 214, 100);
    Lanza lanza_003 = new Lanza("Lanza escupefuego.", 64, 100);
    Lanza lanza_004 = new Lanza("Bidente de gargola.", 104, 100);
    Lanza lanza_005 = new Lanza("Lanza platinegra.", 75, 100);
    Lanza lanza_006 = new Lanza("Lanza de soldado de piedra.", 95, 100);

    /**
     * Cascos - Sombreros.
     */
    Casco casco_001 = new Casco("Corona del rey.", 45);
    Casco casco_002 = new Casco("Corona del viejo rey de hierro.", 57);
    Casco casco_003 = new Casco("Corona del rey hundido.", 35);
    Casco casco_004 = new Casco("Corona del rey de marfil.", 55);
    Casco casco_005 = new Casco("Yelmo de Cale.", 39);
    Casco casco_006 = new Casco("Mascara de Pharros.", 39);

    /**
     * Piezas de parte superior.
     */
    Torso torso_001 = new Torso("Armadura de Alva.", 89);
    Torso torso_002 = new Torso("Armadura de Raime.", 203);
    Torso torso_003 = new Torso("Armadura de Catarina.", 149);
    Torso torso_004 = new Torso("Armadura de la ruina.", 139);
    Torso torso_005 = new Torso("Armadura de guerrero loco.", 171);
    Torso torso_006 = new Torso("Armadura de jinete de dragon.", 242);

    /**
     * Piezas de parte inferior.
     */
    Pantalon pantalon_001 = new Pantalon("Pantalones de Alva.", 53);
    Pantalon pantalon_002 = new Pantalon("Polainas de caballero de Heide.", 63);
    Pantalon pantalon_003 = new Pantalon("Pantalones de Velstadt.", 108);
    Pantalon pantalon_004 = new Pantalon("Pantalones de soldado real.", 45);
    Pantalon pantalon_005 = new Pantalon("Pantalones de Raime.", 97);
    Pantalon pantalon_006 = new Pantalon("Pantalones de la ruina.", 82);

    /**
     * Zapatos - Botas - Pies.
     */
    Pies pies_001 = new Pies("Botas de Faraam.", 78);
    Pies pies_002 = new Pies("Botas de Vengarl.", 115);
    Pies pies_003 = new Pies("Sandalias#003", 10);
    Pies pies_004 = new Pies("Sandalias#004", 10);
    Pies pies_005 = new Pies("Sandalias#005", 10);
    Pies pies_006 = new Pies("Sandalias#006", 10);

    /**
     * Amuletos - Collares.
     */
    Amuleto amuleto_001 = new Amuleto("Collar#001", 5, 10);
    Amuleto amuleto_002 = new Amuleto("Collar#002", 5, 10);
    Amuleto amuleto_003 = new Amuleto("Collar#003", 5, 10);
    Amuleto amuleto_004 = new Amuleto("Collar#004", 5, 10);
    Amuleto amuleto_005 = new Amuleto("Collar#005", 5, 10);
    Amuleto amuleto_006 = new Amuleto("Collar#006", 5, 10);

    /**
     * Anillos.
     */
    Anillo anillo_001 = new Anillo("Anillo#001", 10, 10);
    Anillo anillo_002 = new Anillo("Anillo#002", 10, 10);
    Anillo anillo_003 = new Anillo("Anillo#003", 10, 10);
    Anillo anillo_004 = new Anillo("Anillo#004", 10, 10);
    Anillo anillo_005 = new Anillo("Anillo#005", 10, 10);
    Anillo anillo_006 = new Anillo("Anillo#006", 10, 10);

    private void agregarObjetos() {
        agregarLanzas();
        agregarCascos();
        agregarTorsos();
        agregarPantalones();
        agregarPies();
        agregarAmuletos();
        agregarAnillos();
    }

    private void agregarLanzas() {
        itemList.add(lanza_001);
        itemList.add(lanza_002);
        itemList.add(lanza_003);
        itemList.add(lanza_004);
        itemList.add(lanza_005);
        itemList.add(lanza_006);
    }

    private void agregarCascos() {
        itemList.add(casco_001);
        itemList.add(casco_002);
        itemList.add(casco_003);
        itemList.add(casco_004);
        itemList.add(casco_005);
        itemList.add(casco_006);
    }

    private void agregarTorsos() {
        itemList.add(torso_001);
        itemList.add(torso_002);
        itemList.add(torso_003);
        itemList.add(torso_004);
        itemList.add(torso_005);
        itemList.add(torso_006);
    }

    private void agregarPantalones() {
        itemList.add(pantalon_001);
        itemList.add(pantalon_002);
        itemList.add(pantalon_003);
        itemList.add(pantalon_004);
        itemList.add(pantalon_005);
        itemList.add(pantalon_006);
    }

    private void agregarPies() {
        itemList.add(pies_001);
        itemList.add(pies_002);
        itemList.add(pies_003);
        itemList.add(pies_004);
        itemList.add(pies_005);
        itemList.add(pies_006);
    }

    private void agregarAmuletos() {
        itemList.add(amuleto_001);
        itemList.add(amuleto_002);
        itemList.add(amuleto_003);
        itemList.add(amuleto_004);
        itemList.add(amuleto_005);
        itemList.add(amuleto_006);
    }

    private void agregarAnillos() {
        itemList.add(anillo_001);
        itemList.add(anillo_002);
        itemList.add(anillo_003);
        itemList.add(anillo_004);
        itemList.add(anillo_005);
        itemList.add(anillo_006);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int contador = 0;

        sb.append(String.format("%-40s %-10s", "Nombre de Item:", "   Stats:")).append("\t\t")
                .append(String.format("%-40s %-10s", "Nombre de Item:", "   Stats:")).append("\t\t")
                    .append(String.format("%-40s %-10s", "Nombre de Item:", "   Stats:")).append("\n");

        for (Item item : itemList) {
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

        for (Personaje personaje : playerList) {
            sb.append(personaje);
            contador++;

            if (contador % 3 == 0) {
                sb.append("\n");
            } else {
                sb.append("\t");
            }
        }

        for (Inventario inventario : inventoryList) {
            sb.append(inventario);
            contador++;

            if (contador % 3 == 0) {
                sb.append("\n");
            } else {
                sb.append('\t');
            }
        }

        return sb.toString();
    }
}