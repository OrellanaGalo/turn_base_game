package main;

import item.arma.Lanza;
import item.armadura.Torso;
import partida.Administrador;
import partida.Inventario;
import partida.Stat;
import personaje.Personaje;
import item.Item;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Administrador administrador = new Administrador();

        List<Item> itemList = administrador.getItemList();

        Stat base = new Stat(100, 100, 10, 10, 10);

        Inventario inventario_000 = new Inventario();
        Inventario inventario_001 = new Inventario();

        Personaje personaje = new Personaje("Personaje 1", base, inventario_000);
        Personaje personaje2 = new Personaje("Personaje 2", base, inventario_001);

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Bienvenido al menu: \n");
            System.out.println("Opcion 1 -> AGREGAR ITEMS DE LA LISTA GLOBAL DE ITEMS.\n");
            System.out.println("Opcion 2 -> IMPRIME PERSONAJES.\n");
            System.out.println("Opcion 3 -> IMPRIME INVENTARIOS Y EQUIPAMIENTOS DE AMBOS PERSONAJES.\n");
            System.out.println("Opcion 4 -> SELECCIONA UN ITEM Y TE LO EQUIPA.\n");
            System.out.println("Opcion 5 -> CASO 5.\n");
            System.out.println("Opcion 6 -> ATACAR (PERSONAJE 1 A PERSONAJE 2).\n");
            System.out.println("Opcion 7 -> CASO 7.\n");
            System.out.print(":");

            int numero;
            numero = scanner.nextInt();

            switch (numero){
                case 1:
                    System.out.println("AGREGAR ITEMS DE LA LISTA GLOBAL DE ITEMS.");
                    System.out.println(administrador);

                    int entrada_001 = scanner.nextInt();
                    Item obj = itemList.get(entrada_001);

                    inventario_000.agregarItem(obj);
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 2:
                    System.out.println("IMPRIME PERSONAJES.");
                    System.out.println(personaje);
                    System.out.println(personaje2);
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 3:
                    System.out.println("IMPRIME INVENTARIOS Y EQUIPAMIENTOS DE AMBOS PERSONAJES.");
                    System.out.println(inventario_000);
                    System.out.println("\n--------------------------------------------------------\n");
                    System.out.println(inventario_001);
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 4:
                    System.out.println("SELECCIONA UN ITEM Y TE LO EQUIPA.");

                    int entrada = scanner.nextInt();
                    Item objetoSeleccionado = inventario_000.seleccionarItem(entrada);

                    inventario_000.equiparItem(objetoSeleccionado);
                    //personaje.equipar(objetoSeleccionado);

                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 5:
                    System.out.println("CASO 5.");
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 6:
                    System.out.println("Atacaste");
                    personaje.atacar(personaje2);
                    System.out.println(personaje);
                    System.out.println(personaje2);

                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 7:
                    System.out.println("CASO 7.");
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                default:
                    break;
            }
        }
    }
}
