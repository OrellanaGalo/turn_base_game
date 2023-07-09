package main;

import item.armadura.Pantalon;
import item.armadura.Pies;
import item.armadura.Torso;
import partida.Stat;
import personaje.Personaje;
import item.Item;
import item.acessorio.Amuleto;
import item.arma.Lanza;
import item.armadura.Casco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        List<Item> equipado = new ArrayList<>();
        Stat base = new Stat(100, 100, 10, 10, 10);

        Personaje personaje = new Personaje("Galo el conquistador", base, equipado, items);
        Scanner scanner = new Scanner(System.in);

        Lanza lanza = new Lanza("Bidente de gargola", 50, 100);
        Casco casco = new Casco("Sombrero de playa", 15);
        Torso torso = new Torso("Camisa Hawaaiana", 20);
        Pantalon pantalon = new Pantalon("Short veraniego", 17);
        Pies pies = new Pies("Sandalias", 10);
        Amuleto amuleto = new Amuleto("Collar de oro", 5);

        while (true){
            System.out.println("Bienvenido al menu: \n");
            System.out.println("Opcion 1 -> AGREGAR ITEM\n");
            System.out.println("Opcion 2 -> ELIMINAR ITEM\n");
            System.out.println("Opcion 3 -> INFORMACION DEL PERSONAJE\n");
            System.out.println("Opcion 4 -> EQUIPAR ITEM\n");
            System.out.println("Opcion 5 -> EQUIPAR ITEM REPETIDO\n");
            System.out.println("Opcion 6 -> DESEQUIPAR ITEM\n");
            System.out.print(":");

            int numero;
            numero = scanner.nextInt();

            switch (numero){
                case 1:
                    personaje.agregarItem(casco);
                    personaje.agregarItem(torso);
                    personaje.agregarItem(pantalon);
                    personaje.agregarItem(pies);
                    personaje.agregarItem(amuleto);
                    personaje.agregarItem(lanza);
                    break;

                case 2:
                    personaje.removerItem(lanza);
                    break;

                case 3:
                    System.out.println(personaje.aCadena());
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 4:
                    personaje.equiparItem(casco);
                    personaje.equiparItem(torso);
                    personaje.equiparItem(pantalon);
                    personaje.equiparItem(pies);
                    personaje.equiparItem(lanza);
                    personaje.equiparItem(amuleto);
                    break;

                case 5:
                    personaje.equiparItem(casco);

                case 6:
                    personaje.desequiparItem(amuleto);
                    break;
            }

            System.out.println("-------------------------------------------------------------------------------------");
        }
    }
}
