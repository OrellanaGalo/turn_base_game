package main;

import item.armadura.Pantalon;
import item.armadura.Pies;
import item.armadura.Torso;
import partida.Administrador;
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
        Administrador administrador = new Administrador();
        List<Item> items = new ArrayList<>();
        List<Item> equipado = new ArrayList<>();
        Stat base = new Stat(100, 100, 10, 10, 10);

        Personaje personaje = new Personaje("Galo el conquistador", base, equipado, items);
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Bienvenido al menu: \n");
            System.out.println("Opcion 1 -> AGREGAR ITEM\n");
            System.out.println("Opcion 2 -> ELIMINAR ITEM\n");
            System.out.println("Opcion 3 -> INFORMACION DEL PERSONAJE\n");
            System.out.println("Opcion 4 -> EQUIPAR ITEM\n");
            System.out.println("Opcion 5 -> EQUIPAR ITEM REPETIDO\n");
            System.out.println("Opcion 6 -> DESEQUIPAR ITEM\n");
            System.out.println("Opcion 7 -> LISTA DE TODOS LOS ITEMS.\n");
            System.out.print(":");

            int numero;
            numero = scanner.nextInt();

            switch (numero){
                case 1:
                    System.out.println("Caso 1");
                    break;

                case 2:
                    System.out.println("Caso 2");
                    break;

                case 3:
                    System.out.println(personaje.toString());
                    System.out.println("\t> Si desea salir del inventario presiones '1'.");

                    if(scanner.nextInt() == 1){
                        break;
                    }

                case 4:
                    System.out.println("Caso 4");
                    break;

                case 5:
                    System.out.println("Caso 5");

                case 6:
                    System.out.println("Caso 6");
                    break;

                case 7:
                    System.out.println(administrador.toString());
                    break;
            }

            System.out.println("-------------------------------------------------------------------------------------");
        }
    }
}
