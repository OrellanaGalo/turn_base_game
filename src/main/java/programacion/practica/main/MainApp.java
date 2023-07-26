package programacion.practica.main;

import programacion.practica.partida.Administrador;
import programacion.practica.partida.Inventario;
import programacion.practica.partida.Juego;
import programacion.practica.personaje.Personaje;
import programacion.practica.item.Item;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final int OPCION_SALIR = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Administrador administrador = new Administrador();
        Juego juego = new Juego();

        List<Item> itemList = administrador.getItemList();
        List<Personaje> playerList = administrador.getPlayerList();
        List<Inventario> inventarioList = administrador.getInventoryList();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 ->
                        // Agrega items a un inventario seleccionado.
                        agregarItemsAInventario(juego, administrador, itemList);
                case 2 ->
                        // Imprime los personajes en la lista.
                        imprimirPersonajes(playerList);
                case 3 ->
                        // Imprimir inventario del personaje seleccionado.
                        imprimirInventarioDePersonaje(juego, playerList);
                case 4 ->
                        // Seleccionar y equipar un item.
                        seleccionarYEquiparItem(juego, playerList);
                case 5 ->
                        // Crea y agrega un personaje.
                        crearYAgregarPersonaje(juego, playerList, inventarioList);
                case 6 ->
                        // Pelear.
                        pelear(juego, playerList);
                case 7 ->
                        // Desequipar Item.
                        desequiparItem(juego, playerList);
                default -> System.out.println("< Opcion invalida, intente nuevamente. >");
            }
        } while (opcion != OPCION_SALIR);
    }

    private static void mostrarMenu() {
        System.out.println("\nBienvenido al menu: ");
        System.out.println("Opcion 1 -> AGREGAR ITEMS A UN INVENTARIO SELECCIONADO.");
        System.out.println("Opcion 2 -> IMPRIME PERSONAJES EN LA LISTA.");
        System.out.println("Opcion 3 -> IMPRIME INVENTARIO DEL PERSONAJE SELECCIONADO.");
        System.out.println("Opcion 4 -> SELECCIONA UN ITEM Y TE LO EQUIPA.");
        System.out.println("Opcion 5 -> CREA Y AGREGA UN PERSONAJE.");
        System.out.println("Opcion 6 -> PELEAR.");
        System.out.println("Opcion 7 -> DESEQUIPA EL ITEM SELECCIONADO <-- No funciona.");
    }

    private static void agregarItemsAInventario(Juego juego, Administrador administrador, List<Item> itemList) {
        System.out.println(administrador);
        int ingreso = juego.obtenerNumeroEntero("< Nro de item: >", 0, itemList);
        Item objeto = itemList.get(ingreso);

        List<Inventario> lista = administrador.getInventoryList();

        System.out.println(lista);
        int ingresoDos = juego.obtenerNumeroEntero("< Inventario al que deseas agregarlo: >", 0, lista);

        administrador.getInventoryList().get(ingresoDos).agregarItem(objeto);
    }

    private static void imprimirPersonajes(List<Personaje> playerList) {
        System.out.println(playerList);
    }

    private static void imprimirInventarioDePersonaje(Juego juego, List<Personaje> playerList) {
        int ingreso = juego.obtenerNumeroEntero("< Personaje >", 0, playerList);

        Personaje personaje = playerList.get(ingreso);
        Inventario inventario = personaje.getInventario();

        System.out.println(inventario.toString());
    }

    private static void seleccionarYEquiparItem(Juego juego, List<Personaje> playerList) {
        System.out.println(playerList);
        int ingreso = juego.obtenerNumeroEntero("< Personaje >", 0, playerList);

        Personaje personaje = playerList.get(ingreso);
        Inventario inventario = personaje.getInventario();

        System.out.println(inventario);

        int ingresoDos = juego.obtenerNumeroEntero("< Item >", 0, inventario.getItems());

        Item item = inventario.seleccionarItemEnInventario(ingresoDos);

        personaje.equiparItem(item);
    }

    private static void crearYAgregarPersonaje(
            Juego juego, List<Personaje> playerList, List<Inventario> inventarioList) {
        Personaje personaje = juego.crearPersonaje();
        Inventario inventario = personaje.getInventario();
        playerList.add(personaje);
        inventarioList.add(inventario);
    }

    private static void pelear(Juego juego, List<Personaje> playerList) {
        System.out.println(playerList);

        int ingreso = juego.obtenerNumeroEntero(
                "< Ingresa el personaje que comienza la pelea: >",
                0,
                playerList
        );

        int ingresoDos = juego.obtenerNumeroEntero(
                "< Ingresa el segundo peleador: >",
                0,
                playerList
        );

        Personaje peleadorUno = playerList.get(ingreso);
        Personaje peleadorDos = playerList.get(ingresoDos);

        peleadorUno.pelear(peleadorUno, peleadorDos);
    }

    private static void desequiparItem(Juego juego, List<Personaje> playerList) {
        int ingreso = juego.obtenerNumeroEntero("< Personaje >", 0, playerList);

        Personaje personaje = playerList.get(ingreso);
        Inventario inventario = personaje.getInventario();

        System.out.println(inventario);

        int ingresoDos = juego.obtenerNumeroEntero("< Item >", 0, inventario.getItems());

        Item item = inventario.seleccionarItemEnEquipamiento(ingresoDos);

        personaje.desequiparItem(item);
    }
}
