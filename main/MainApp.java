package main;

import item.arma.Lanza;
import item.armadura.Casco;
import item.armadura.Torso;
import partida.Administrador;
import partida.Stat;
import personaje.Personaje;
import item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Administrador administrador = new Administrador();
        List<Item> items = new ArrayList<>();
        List<Item> items2 = new ArrayList<>();
        List<Item> equipado = new ArrayList<>();
        List<Item> equipado2 = new ArrayList<>();
        Stat base = new Stat(100, 100, 10, 10, 10);
        Stat base2 = new Stat(100, 100, 10, 10, 10);
        Stat base_modificable = new Stat(100, 100, 11, 10, 10);
        Stat base_modificable2 = new Stat(100, 100, 11, 10, 10);

        Casco casco = new Casco("Pieza de armadura casco.", 50);
        Torso torso = new Torso("Pieza de armadura torso.", 100);
        Lanza lanza = new Lanza("Lanza que aporta ataque.", 100, 100);

        Personaje personaje = new Personaje("Galo el conquistador", base, base_modificable, equipado, items);
        Personaje personaje2 = new Personaje("Galo el destructor", base2, base_modificable2, equipado2, items2);
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Bienvenido al menu: \n");
            System.out.println("Opcion 1 -> CASO 1\n");
            System.out.println("Opcion 2 -> CASO 2\n");
            System.out.println("Opcion 3 -> CASO 3\n");
            System.out.println("Opcion 4 -> CASO 4\n");
            System.out.println("Opcion 5 -> CASO 5\n");
            System.out.println("Opcion 6 -> ATACAR (PERSONAJE 2 A PERSONAJE 1)\n");
            System.out.println("Opcion 7 -> LISTA DE TODOS LOS ITEMS Y PERSONAJES.\n");
            System.out.print(":");

            int numero;
            numero = scanner.nextInt();

            switch (numero){
                case 1:
                    System.out.println("CASO 1.");
                    personaje2.agregarItem(lanza);
                    personaje2.equiparItem(lanza);
                    personaje2.aplicarStats(lanza);
                    System.out.println(personaje2);
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 2:
                    System.out.println("CASO 2.");
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 3:
                    System.out.println("CASO 3.");
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 4:
                    System.out.println("CASO 4");
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
                    System.out.println(personaje2);
                    personaje2.atacar(personaje);
                    System.out.println(personaje);
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 7:
                    System.out.println(administrador);
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
