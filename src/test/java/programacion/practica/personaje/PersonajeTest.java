package programacion.practica.personaje;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import programacion.practica.excepciones.IllegalNombreException;

import programacion.practica.item.arma.Lanza;
import programacion.practica.partida.Inventario;
import programacion.practica.partida.Stat;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    private Personaje personaje;

    @BeforeEach
    public void setUp() {
        try {
            Inventario inventario = new Inventario();
            Stat base = new Stat(100, 100, 10, 10, 10);
            personaje = new Personaje("Jugador", base, inventario);
        } catch (IllegalNombreException e) {
            fail("Error en la creacion del personaje." + e.getMessage());
        }
    }

    @Test
    public void testEquiparItem() {
        Lanza lanza = new Lanza("Lanza", 80, 100);

        assertTrue(personaje.equiparItem(lanza));
    }

    @Test
    public void testDesequiparItem() {
        Lanza lanza = new Lanza("Lanza", 80, 100);

        personaje.equiparItem(lanza);

        assertTrue(personaje.desequiparItem(lanza));
    }

    @Test
    public void testAtacar() throws IllegalNombreException {
        Personaje enemigo = new Personaje(
                "Enemigo",
                new Stat(100, 100, 10, 10, 10),
                new Inventario()
                );

        assertTrue(enemigo.getStat().estaVivo());

        personaje.atacar(enemigo);

        assertTrue(enemigo.getStat().estaVivo());
    }

    @Test
    public void testDefender() {
        Stat nuevaArmadura = new Stat(0, 0, 0, 50, 0);

        assertFalse(personaje.isDefensa());

        personaje.defender(nuevaArmadura);

        assertTrue(personaje.isDefensa());

        personaje.defender(nuevaArmadura);

        assertFalse(personaje.isDefensa());
    }

    // Faltan agregar mas pruebas.
}
