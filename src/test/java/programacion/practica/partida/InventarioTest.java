package programacion.practica.partida;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programacion.practica.excepciones.EquipamientoFullException;
import programacion.practica.excepciones.ItemNotFoundException;
import programacion.practica.item.Item;
import programacion.practica.item.arma.Lanza;
import programacion.practica.item.armadura.Casco;
import programacion.practica.item.armadura.Pecho;

public class InventarioTest {

    private Inventario inventario;

    @BeforeEach
    public void setUp() {
        inventario = new Inventario();
    }

    @Test
    public void testAgregarItem() {
        Lanza lanza = new Lanza("Lanza", 50, 100);
        inventario.agregarItem(lanza);

        // Verificamos que el inventario contenga el arma agregada.
        Assertions.assertEquals(1, inventario.getItems().size());
        Assertions.assertTrue(inventario.getItems().contains(lanza));
    }

    @Test
    public void testEliminarItem() {
        Lanza lanza = new Lanza("Lanza", 50, 100);
        inventario.agregarItem(lanza);

        // Eliminamos el arma del inventario.
        try {
            inventario.eliminarItem(lanza);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Verificamos que el inventario esté vacío.
        Assertions.assertEquals(0, inventario.getItems().size());
        Assertions.assertFalse(inventario.getItems().contains(lanza));
    }

    @Test
    public void testEquiparItemArma() {
        // Creamos un arma y lo agregamos al inventario.
        Lanza lanza = new Lanza("Lanza", 50, 100);
        inventario.agregarItem(lanza);

        // Equipamos el arma y verificamos que esté en el equipamiento.
        try {
            inventario.equiparItem(lanza);
        } catch (EquipamientoFullException e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertEquals(lanza, inventario.seleccionarItemEnEquipamiento(0));
    }

    @Test
    public void testEquiparItemArmadura() {
        Casco casco =  new Casco("Casco", 50);
        inventario.agregarItem(casco);

        // Equipamos el casco y verificamos que esté en el equipamiento.
        try {
            inventario.equiparItem(casco);
        } catch (EquipamientoFullException e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertEquals(casco, inventario.seleccionarItemEnEquipamiento(1));
    }

    @Test
    public void testRemoverItemDeEquipamiento() {
        Item item = inventario.seleccionarItemEnEquipamiento(0);

        // Removemos el arma del equipamiento y verificamos que no esté presente.
        try {
            inventario.removerItemDeEquipamiento(item);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertNull(inventario.seleccionarItemEnEquipamiento(0));
    }

    @Test
    public void testObtenerStatsArmaduras() {
        // Verificamos que sean dos tipos de armadura distinto porque sino se sobreescribe la informacion de uno sobre
        // El otro.
        Casco casco =  new Casco("Casco", 50);
        Pecho pecho = new Pecho("Torso", 50);

        try {
            inventario.equiparItem(casco);
            inventario.equiparItem(pecho);
        } catch (EquipamientoFullException e) {
            System.out.println(e.getMessage());
        }

        // Obtenemos los stats combinados de las armaduras.
        Stat statsArmaduras = inventario.obtenerStatsArmaduras();

        // Verificamos que los stats sean la suma de las armaduras.
        Assertions.assertEquals(0, statsArmaduras.vida);
        Assertions.assertEquals(0, statsArmaduras.stamina);
        Assertions.assertEquals(0, statsArmaduras.ataque);
        Assertions.assertEquals(100, statsArmaduras.defensa);
        Assertions.assertEquals(0, statsArmaduras.stamina);
    }

    // Faltan mas tests.
}

