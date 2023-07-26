package programacion.practica.partida;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatTest {

    @Test
    public void testCalcularVidaValorPositivo() {
        Stat stat = new Stat(100, 50, 20, 10, 5);
        Stat resultado = stat.calcularVida(30);

        stat = Stat.aplicarStats(stat, resultado);

        // Verificar que la nueva vida sea 100 (límite superior).
        Assertions.assertEquals(100, stat.vida);

        // Verificar que la nueva stamina sea 50 (sin cambios).
        Assertions.assertEquals(50, stat.stamina);

        // Verificar que los otros atributos no cambian.
        Assertions.assertEquals(20, stat.ataque);
        Assertions.assertEquals(10, stat.defensa);
        Assertions.assertEquals(5, stat.inteligencia);
    }

    @Test
    public void testCalcularVidaValorNegativo() {
        Stat stat = new Stat(80, 50, 20, 10, 5);
        Stat resultado = stat.calcularVida(-90);

        stat = Stat.aplicarStats(stat, resultado);

        // Verificar que la nueva vida sea 0 (límite inferior).
        Assertions.assertEquals(0, stat.vida);

        // Verificar que la nueva stamina sea 50 (sin cambios).
        Assertions.assertEquals(50, stat.stamina);

        // Verificar que los otros atributos no cambian.
        Assertions.assertEquals(20, stat.ataque);
        Assertions.assertEquals(10, stat.defensa);
        Assertions.assertEquals(5, stat.inteligencia);
    }

    @Test
    public void testCalcularStaminaValorPositivo() {
        Stat stat = new Stat(100, 50, 20, 10, 5);
        Stat resultado = stat.calcularStamina(40);

        stat = Stat.aplicarStats(stat, resultado);

        // Verificar que la nueva stamina sea 90 (cambios positivos).
        Assertions.assertEquals(90, stat.stamina);

        // Verificar que la nueva vida sea 100 (sin cambios).
        Assertions.assertEquals(100, stat.vida);

        // Verificar que los otros atributos no cambian.
        Assertions.assertEquals(20, stat.ataque);
        Assertions.assertEquals(10, stat.defensa);
        Assertions.assertEquals(5, stat.inteligencia);
    }

    @Test
    public void testCalcularStaminaValorNegativo() {
        Stat stat = new Stat(80, 50, 20, 10, 5);
        Stat resultado = stat.calcularStamina(-70);

        stat = Stat.aplicarStats(stat, resultado);

        // Verificar que la nueva stamina sea 0 (límite inferior).
        Assertions.assertEquals(0, stat.stamina);

        // Verificar que la nueva vida sea 80 (sin cambios).
        Assertions.assertEquals(80, stat.vida);

        // Verificar que los otros atributos no cambian.
        Assertions.assertEquals(20, stat.ataque);
        Assertions.assertEquals(10, stat.defensa);
        Assertions.assertEquals(5, stat.inteligencia);
    }

    @Test
    public void testCalcularAtaque() {
        Stat atacante = new Stat(100, 100, 50, 0, 0);
        Stat defensor = new Stat(100, 100, 0, 50, 0);

        int resultado = atacante.calcularAtaque(defensor);

        // Verificamos que el resultado sea mayor o igual a 0.
        Assertions.assertTrue(resultado >= 0);
    }

    @Test
    public void testEstaVivo() {
        Stat statUno = new Stat(100, 50, 20, 10, 5);
        Stat statDos = new Stat(0, 50, 20, 10, 5);

        // Verificar que la vida en el primer stat sea mayor que 0 (vida > 0).
        Assertions.assertTrue(statUno.estaVivo());

        // Verificar que en el segundo stat la vida sea menor o igual a 0 (vida <= 0).
        Assertions.assertFalse(statDos.estaVivo());
    }

    @Test
    public void testVerificarStamina() {
        Stat stat = new Stat(100, 80, 20, 10, 5);

        // Verificar que la stamina actual es mayor a 50.
        Assertions.assertTrue(stat.verificarStamina(50));

        // Verificar que la stamina actual es menor a 90.
        Assertions.assertFalse(stat.verificarStamina(90));
    }

    // Faltan mas pruebas.
}

