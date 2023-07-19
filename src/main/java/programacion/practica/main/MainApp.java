package programacion.practica.main;

import programacion.practica.partida.Administrador;
import programacion.practica.partida.Inventario;
import programacion.practica.partida.Juego;
import programacion.practica.partida.Stat;
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
            System.out.println("Bienvenido al menu: \n");
            System.out.println("Opcion 1 -> AGREGAR ITEMS A UN INVENTARIO SELECCIONADO.\n");
            System.out.println("Opcion 2 -> IMPRIME PERSONAJES EN LA LISTA.\n");
            System.out.println("Opcion 3 -> IMPRIME INVENTARIO DEL PERSONAJE SELECCIONADO.\n");
            System.out.println("Opcion 4 -> SELECCIONA UN ITEM Y TE LO EQUIPA.\n");
            System.out.println("Opcion 5 -> CREA Y AGREGA UN PERSONAJE.\n");
            System.out.println("Opcion 6 -> PELEAR.\n");
            System.out.println("Opcion 7 -> DESEQUIPA EL ITEM SELECCIONADO.\n");
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

                    Item objetoSeleccionado = inventario.seleccionarItem(objeto);

                    inventario.equiparItem(objetoSeleccionado);
                    playerList.get(personaje_in).equipar(objetoSeleccionado);

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

                    System.out.println("\n< INGRESA EL PERSONAJE QUE COMIENZA LA PELEA. >");
                    int player_001 = scanner.nextInt();

                    System.out.println("\n< INGRESA EL SEGUNDO PELEADOR. >");
                    int player_002 = scanner.nextInt();

                    juego.pelear(playerList.get(player_001), playerList.get(player_002));

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

                    inventario.desEquiparItem(objetoSeleccionado_01);
                    playerList.get(pj_in).desEquipar(objetoSeleccionado_01);

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
