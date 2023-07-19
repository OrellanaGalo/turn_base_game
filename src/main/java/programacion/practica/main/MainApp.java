package programacion.practica.main;

import programacion.practica.partida.Administrador;
import programacion.practica.partida.Inventario;
import programacion.practica.partida.Juego;
import programacion.practica.personaje.Personaje;
import programacion.practica.item.Item;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Administrador administrador = new Administrador();
        Juego juego = new Juego();

        List<Item> itemList = administrador.getItemList();
        List<Personaje> playerList = administrador.getPlayerList();
        List<Inventario> inventoryList = administrador.getInventoryList();

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Bienvenido al menu: ");
            System.out.println("Opcion 1 -> AGREGAR ITEMS A UN INVENTARIO SELECCIONADO.");
            System.out.println("Opcion 2 -> IMPRIME PERSONAJES EN LA LISTA.");
            System.out.println("Opcion 3 -> IMPRIME INVENTARIO DEL PERSONAJE SELECCIONADO.");
            System.out.println("Opcion 4 -> SELECCIONA UN ITEM Y TE LO EQUIPA.");
            System.out.println("Opcion 5 -> CREA Y AGREGA UN PERSONAJE.");
            System.out.println("Opcion 6 -> PELEAR.");
            System.out.println("Opcion 7 -> DESEQUIPA EL ITEM SELECCIONADO.");
            System.out.print(":");

            int numero;
            numero = scanner.nextInt();

            switch (numero){
                case 1:
                    System.out.println(administrador);

                    System.out.println("< NRO DE ITEM: >");
                    int ingreso = scanner.nextInt();
                    Item obj = itemList.get(ingreso);

                    System.out.println(inventoryList);
                    System.out.println("< INVENTARIO AL QUE DESEAS AGREGARLO: >");
                    int ingreso_dos = scanner.nextInt();

                    inventoryList.get(ingreso_dos).agregarItem(obj);

                    System.out.println("\t< Si desea salir del inventario presione '1'.>");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 2:
                    System.out.println(playerList);

                    System.out.println("\t< Si desea salir del inventario presione '1'.>");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 3:
                    System.out.println("< PERSONAJE >");
                    int jugador = scanner.nextInt();

                    System.out.println(playerList.get(jugador).getInventario());

                    System.out.println("\t< Si desea salir del inventario presione '1'.>");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 4:
                    System.out.println("< PERSONAJE: >");
                    int personaje_in = scanner.nextInt();

                    Personaje personaje = playerList.get(personaje_in);
                    Inventario inventario = personaje.getInventario();

                    System.out.println(inventario);

                    System.out.println("< ITEM: >");
                    int objeto = scanner.nextInt();

                    Item objetoSeleccionado = inventario.seleccionarItemEnInventario(objeto);

                    inventario.equiparItem(objetoSeleccionado);
                    personaje.equiparItem(objetoSeleccionado);

                    System.out.println("\t< Si desea salir del inventario presione '1'.>");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 5:
                    personaje = juego.crearPersonaje();
                    playerList.add(personaje);
                    inventoryList.add(personaje.getInventario());

                    System.out.println("\t< Si desea salir del inventario presione '1'.>");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 6:
                    System.out.println(playerList);

                    System.out.println("< INGRESA EL PERSONAJE QUE COMIENZA LA PELEA. >");
                    int player_001 = scanner.nextInt();

                    System.out.println("\n< INGRESA EL SEGUNDO PELEADOR. >");
                    int player_002 = scanner.nextInt();

                    Personaje personaje_001 = playerList.get(player_001);
                    Personaje personaje_002 = playerList.get(player_002);

                    personaje_001.pelear(personaje_001, personaje_002);

                    System.out.println("\t< Si desea salir del inventario presione '1'.>");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 7:
                    System.out.println("< PERSONAJE: >");
                    int pj_in = scanner.nextInt();

                    personaje = playerList.get(pj_in);
                    inventario = personaje.getInventario();

                    System.out.println(inventario);

                    System.out.println("< ITEM: >");
                    int ob = scanner.nextInt();

                    Item objetoSeleccionado_01 = inventario.seleccionarItemEnEquipamiento(ob);

                    inventario.desequiparItem(objetoSeleccionado_01);
                    playerList.get(pj_in).desequiparItem(objetoSeleccionado_01);

                    System.out.println("\t< Si desea salir del inventario presione '1'.>");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                default:
                    break;
            }
        }
    }
}
