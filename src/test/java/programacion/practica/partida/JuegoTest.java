package programacion.practica.partida;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programacion.practica.excepciones.IllegalNombreException;
import programacion.practica.personaje.Personaje;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class JuegoTest {

    private Juego juego;

    @BeforeEach
    public void setUp() {
        juego = new Juego();
    }

    @Test
    public void testCrearPersonajeNombreValido() {
        String nombre = "Daenerys";

        // Simulamos la entrada de texto.
        String input = nombre + "\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Personaje personaje = juego.crearPersonaje();

        System.setIn(System.in);

        // Verificar que el personaje no sea nulo.
        Assertions.assertNotNull(personaje);

        // Verificar que el personaje tenga las estadísticas base.
        Assertions.assertEquals(100, personaje.getStat().vida);
        Assertions.assertEquals(100, personaje.getStat().stamina);
        Assertions.assertEquals(10, personaje.getStat().ataque);
        Assertions.assertEquals(10, personaje.getStat().defensa);
        Assertions.assertEquals(10, personaje.getStat().inteligencia);
    }

    @Test
    public void testCrearPersonajeNombreVacio() {
        String nombre = "";

        // Simulamos la entrada de texto.
        String input = nombre + "\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Personaje personaje = juego.crearPersonaje();

        System.setIn(System.in);

        // Verificar que el personaje sea nulo debido a que se ingresó un nombre vacío.
        Assertions.assertNull(personaje);
    }

    @Test
    public void testCrearPersonajeNombreNulo() {
        // Simulamos la entrada de texto.
        String input = null + "\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        Juego juego = new Juego();

        System.setIn(inputStream);

        Assertions.assertThrows(IllegalNombreException.class, juego::crearPersonaje);

        System.setIn(System.in);
    }

    // Faltan mas pruebas.
}
