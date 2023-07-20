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
                        agregarItemsAInventario(scanner, administrador, itemList);
                case 2 ->
                        // Imprime los personajes en la lista.
                        imprimirPersonajes(playerList);
                case 3 ->
                        // Imprimir inventario del personaje seleccionado.
                        imprimirInventarioDePersonaje(scanner, playerList);
                case 4 ->
                        // Seleccionar y equipar un item.
                        seleccionarYEquiparItem(scanner, playerList);
                case 5 ->
                        // Crea y agrega un personaje.
                        crearYAgregarPersonaje(juego, playerList, inventarioList);
                case 6 ->
                        // Pelear.
                        pelear(scanner, playerList);
                case 7 ->
                        // Desequipar Item.
                        desequiparItem(scanner, playerList);
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
        System.out.println("Opcion 7 -> DESEQUIPA EL ITEM SELECCIONADO.");
    }

    private static void agregarItemsAInventario(Scanner scanner, Administrador administrador, List<Item> itemList) {
        System.out.println(administrador);
        System.out.println("< Nro de item: >");
        int ingreso = scanner.nextInt();
        Item objeto = itemList.get(ingreso);

        System.out.println(administrador.getInventoryList());
        System.out.println("< Inventario al que deseas agregarlo: >");
        int ingresoDos = scanner.nextInt();

        administrador.getInventoryList().get(ingresoDos).agregarItem(objeto);
    }

    private static void imprimirPersonajes(List<Personaje> playerList) {
        System.out.println(playerList);
    }

    private static void imprimirInventarioDePersonaje(Scanner scanner, List<Personaje> playerList) {
        System.out.println("< Personaje >");
        int ingreso = scanner.nextInt();

        Personaje personaje = playerList.get(ingreso);
        Inventario inventario = personaje.getInventario();

        System.out.println(inventario);
    }

    private static void seleccionarYEquiparItem(Scanner scanner, List<Personaje> playerList) {
        System.out.println("< Personaje >");
        int ingreso = scanner.nextInt();

        Personaje personaje = playerList.get(ingreso);
        Inventario inventario = personaje.getInventario();

        System.out.println(inventario);

        System.out.println("< Item >");
        int ingresoDos = scanner.nextInt();

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

    private static void pelear(Scanner scanner, List<Personaje> playerList) {
        System.out.println(playerList);

        System.out.println("< Ingresa el personaje que comienza la pelea: >");
        int ingreso = scanner.nextInt();

        System.out.println("< Ingresa el segundo peleador: >");
        int ingresoDos = scanner.nextInt();

        Personaje peleadorUno = playerList.get(ingreso);
        Personaje peleadorDos = playerList.get(ingresoDos);

        peleadorUno.pelear(peleadorUno, peleadorDos);
    }

    private static void desequiparItem(Scanner scanner, List<Personaje> playerList) {
        System.out.println("< Personaje >");
        int ingreso = scanner.nextInt();

        Personaje personaje = playerList.get(ingreso);
        Inventario inventario = personaje.getInventario();

        System.out.println(inventario);

        System.out.println("< Item >");
        int ingresoDos = scanner.nextInt();

        Item item = inventario.seleccionarItemEnEquipamiento(ingresoDos);

        personaje.desequiparItem(item);
    }
}
