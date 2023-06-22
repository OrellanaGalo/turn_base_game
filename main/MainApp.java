package main;

import entity.Personaje;
import item.Item;
import item.arma.Lanza;
import item.armadura.Casco;
import item.armadura.Pantalon;
import item.armadura.Pies;
import item.armadura.Torso;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Item> items = null;

        Personaje personaje = new Personaje("Galo el caballero de la noche", items);

        Lanza lanza = new Lanza("Bidente de gargola", 50, 100);
        Lanza lanza2 = new Lanza("Lanza de Santier", 50, 100);
        Lanza lanza3 = new Lanza("Lanza platinegra", 50, 100);

        Casco casco = new Casco("Mascara del hechicero de humo", 30, 50, 50, personaje);
        Torso torso = new Torso("Tunicas del hechicero de humo", 45, 100, 100, personaje);
        Pies pies = new Pies("Botas del hechicero de humo", 45, 100, 100, personaje);

        personaje.agregarItem(lanza);
        personaje.agregarItem(lanza2);
        personaje.agregarItem(lanza3);
        personaje.agregarItem(casco);
        personaje.agregarItem(torso);
        personaje.agregarItem(pies);

        personaje.equiparArma(lanza);
        personaje.equiparCasco(casco);
        personaje.equiparTorso(torso);
        personaje.equiparPies(pies);

        System.out.println(personaje.aCadena());
    }
}
