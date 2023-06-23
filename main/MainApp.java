package main;

import entity.Personaje;
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

        Personaje personaje = new Personaje("Galo el caballero de la noche", equipado, items);
        Scanner scanner = new Scanner(System.in);

        Lanza lanza = new Lanza("Bidente de gargola", 50, 100, personaje);
        Casco casco = new Casco("Sombrero de playa", 15, 100, 100, personaje);
        Amuleto amuleto = new Amuleto("Collar de oro", 100, 100, 5, personaje);

        while (true){
            System.out.println("Bienvenido al menu: \n");
            System.out.println("Opcion 1 -> AGREGAR ITEM\n");
            System.out.println("Opcion 2 -> ELIMINAR ITEM\n");
            System.out.println("Opcion 3 -> INFORMACION DEL PERSONAJE\n");
            System.out.println("Opcion 4 -> EQUIPAR ITEM\n");
            System.out.println("Opcion 5 -> DESEQUIPAR ITEM\n");
            System.out.print(":");

            int numero;
            numero = scanner.nextInt();

            switch (numero){
                case 1:
                    personaje.agregarItem(casco);
                    personaje.agregarItem(amuleto);
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
                    personaje.equiparItem(amuleto);
                    break;

                case 5:
                    personaje.desequiparItem(amuleto);
                    break;
            }

            System.out.println("-------------------------------------------------------------------------------------");
        }
    }
}
