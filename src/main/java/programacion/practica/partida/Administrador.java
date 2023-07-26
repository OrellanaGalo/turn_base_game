package programacion.practica.partida;

import programacion.practica.item.Item;
import programacion.practica.item.accesorio.Amuleto;
import programacion.practica.item.accesorio.Anillo;
import programacion.practica.item.arma.Lanza;
import programacion.practica.item.armadura.*;
import programacion.practica.item.consumible.Pocion;
import programacion.practica.personaje.Personaje;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase `Administrador` se encarga de manejar todos los objetos o items presentes en el juego. Estos items pueden
 * ser armas, armaduras, accesorios o consumibles, y son elementos fundamentales para la jugabilidad y la mecánica del
 * juego. Además, esta clase también maneja las listas de personajes jugables y sus respectivos inventarios y
 * equipamientos.
 * En esta clase, se inicializan y almacenan todos los objetos predefinidos que estarán disponibles para los personajes
 * durante la partida. Cada objeto, ya sea un arma, una armadura, un accesorio o un consumible, se crea con sus
 * características específicas, como nombre, estadísticas y estado actual (condición para armas o defensa para
 * armaduras).
 * La clase `Administrador` es responsable de agregar los objetos a las listas correspondientes, como la lista de items,
 * la lista de personajes jugables y la lista de inventarios individuales.
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
    Pecho pecho_001 = new Pecho("Armadura de Alva.", 89);
    Pecho pecho_002 = new Pecho("Armadura de Raime.", 203);
    Pecho pecho_003 = new Pecho("Armadura de Catarina.", 149);
    Pecho pecho_004 = new Pecho("Armadura de la ruina.", 139);
    Pecho pecho_005 = new Pecho("Armadura de guerrero loco.", 171);
    Pecho pecho_006 = new Pecho("Armadura de jinete de dragon.", 242);

    /**
     * Piezas de parte inferior.
     */
    Piernas piernas_001 = new Piernas("Pantalones de Alva.", 53);
    Piernas piernas_002 = new Piernas("Polainas de caballero de Heide.", 63);
    Piernas piernas_003 = new Piernas("Pantalones de Velstadt.", 108);
    Piernas piernas_004 = new Piernas("Pantalones de soldado real.", 45);
    Piernas piernas_005 = new Piernas("Pantalones de Raime.", 97);
    Piernas piernas_006 = new Piernas("Pantalones de la ruina.", 82);

    /**
     * Zapatos - Botas - Pies.
     */
    Botas botas_001 = new Botas("Botas de Faraam.", 78);
    Botas botas_002 = new Botas("Botas de Vengarl.", 115);
    Botas botas_003 = new Botas("Botas de felino volador.", 40);
    Botas botas_004 = new Botas("Botas de maniqui.", 32);
    Botas botas_005 = new Botas("Botas insolentes.", 50);
    Botas botas_006 = new Botas("Timbos de Messi.", 81);

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

    /**
     * Pociones.
     */
    Pocion pocion_001 = new Pocion("Pocion#001", 50, 0);
    Pocion pocion_002 = new Pocion("Pocion#002", 50, 0);
    Pocion pocion_003 = new Pocion("Pocion#003", 50, 0);
    Pocion pocion_004 = new Pocion("Pocion#004", 50, 0);
    Pocion pocion_005 = new Pocion("Pocion#005", 50, 0);
    Pocion pocion_006 = new Pocion("Pocion#006", 50, 0);

    private void agregarObjetos() {
        agregarLanzas();
        agregarCascos();
        agregarPechos();
        agregarPiernas();
        agregarBotas();
        agregarAmuletos();
        agregarAnillos();
        agregarPociones();
    }

    /**
     * Agrega los objetos 'Lanza' a la lista de Items.
     */
    private void agregarLanzas() {
        itemList.add(lanza_001);
        itemList.add(lanza_002);
        itemList.add(lanza_003);
        itemList.add(lanza_004);
        itemList.add(lanza_005);
        itemList.add(lanza_006);
    }

    /**
     * Agrega los objetos 'Casco' a la lista de Items.
     */
    private void agregarCascos() {
        itemList.add(casco_001);
        itemList.add(casco_002);
        itemList.add(casco_003);
        itemList.add(casco_004);
        itemList.add(casco_005);
        itemList.add(casco_006);
    }

    /**
     * Agrega los objetos 'Pecho' a la lista de Items.
     */
    private void agregarPechos() {
        itemList.add(pecho_001);
        itemList.add(pecho_002);
        itemList.add(pecho_003);
        itemList.add(pecho_004);
        itemList.add(pecho_005);
        itemList.add(pecho_006);
    }

    /**
     * Agrega los objetos 'Piernas' a la lista de Items.
     */
    private void agregarPiernas() {
        itemList.add(piernas_001);
        itemList.add(piernas_002);
        itemList.add(piernas_003);
        itemList.add(piernas_004);
        itemList.add(piernas_005);
        itemList.add(piernas_006);
    }

    /**
     * Agrega los objetos 'Botas' a la lista de Items.
     */
    private void agregarBotas() {
        itemList.add(botas_001);
        itemList.add(botas_002);
        itemList.add(botas_003);
        itemList.add(botas_004);
        itemList.add(botas_005);
        itemList.add(botas_006);
    }

    /**
     * Agrega los objetos 'Amuleto' a la lista de Items.
     */
    private void agregarAmuletos() {
        itemList.add(amuleto_001);
        itemList.add(amuleto_002);
        itemList.add(amuleto_003);
        itemList.add(amuleto_004);
        itemList.add(amuleto_005);
        itemList.add(amuleto_006);
    }

    /**
     * Agrega los objetos 'Anillo' a la lista de Items.
     */
    private void agregarAnillos() {
        itemList.add(anillo_001);
        itemList.add(anillo_002);
        itemList.add(anillo_003);
        itemList.add(anillo_004);
        itemList.add(anillo_005);
        itemList.add(anillo_006);
    }

    /**
     * Agrega los objetos 'Pocion' a la lista de items.
     */
    private void agregarPociones() {
        itemList.add(pocion_001);
        itemList.add(pocion_002);
        itemList.add(pocion_003);
        itemList.add(pocion_004);
        itemList.add(pocion_005);
        itemList.add(pocion_006);
    }

    /**
     * Este metodo tiene como proposito devolver la lista de items para ser usada en otra clase.
     * @return Retorna la lista de items.
     */
    public List<Item> getItemList() {
        return itemList;
    }

    /**
     * Este metodo tiene como proposito devolver la lista de personajes para ser usada en otra clase.
     * @return Retorna la lista de personajes.
     */
    public List<Personaje> getPlayerList() {
        return playerList;
    }

    /**
     * Este metodo tiene como proposito devolver la lista de inventarios para ser usada en otra clase.
     * @return Retorna la lista de inventarios.
     */
    public List<Inventario> getInventoryList() {
        return inventoryList;
    }

    /**
     * Un metodo que se encarga de ordenar y devolver todos los objetos presentes en las listas de esta clase.
     * @return Un String que contiene toda las listas presentes en esta clase.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        int indice = 0;

        sb.append(String.format("%-4s %-40s %-20s", "Pos:", "Nombre de Item:", "   Stats:")).append("\t\t")
                .append(String.format("%-4s %-40s %-20s", "Pos:", "Nombre de Item:", "   Stats:")).append("\t\t")
                    .append(String.format("%-4s %-40s %-20s", "Pos:", "Nombre de Item:", "   Stats:")).append("\n");

        for (Item item : itemList) {
            String string_items = item.toString();
            String[] partes = string_items.split("->");
            String nombre_de_item = partes[0].trim();
            String valor_item = partes[1].trim();

            String numeros_formateados = String.format("%-20s", valor_item);
            String linea = String.format("%-4d %-40s -> %s", contador, nombre_de_item, numeros_formateados);

            sb.append(linea);
            contador++;
            indice++;

            if (indice % 3 == 0) {
                sb.append("\n");
            } else {
                sb.append("\t");
            }
        }

        return sb.toString();
    }
}