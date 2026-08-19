import org.example.Circulo;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CirculoTest {
    @Test
    void deveCriarCirculoComRaioValido() {

        double raio = 5;
        Circulo circulo = new Circulo(raio);
        assertNotNull(circulo);
    }

    @Test
    void deveCalcularAreaDoCirculo() {

        Circulo circulo = new Circulo(5);

        double area = circulo.calcularArea();
        assertEquals(Math.PI * 25, area, 0.001);
    }

    @Test
    void deveIdentificarCirculoGrande() {

        Circulo circulo = new Circulo(10);

        boolean resultado = circulo.verificarSeCirculoEGrande();
        assertTrue(resultado);
    }

    @Test
    void deveIdentificarCirculopequeno(){

        Circulo circulo= new Circulo(9);

        boolean resultado = circulo.verificarSeCirculoPequeno();
        assertTrue(resultado);
    }

    @Test
    void deveIdentificarCirculoPequeno() {

        Circulo circulo = new Circulo(5);
        boolean resultado = circulo.verificarSeCirculoEGrande();

        assertFalse(resultado);
    }
    @Test
    void deveLancarExcecaoQuandoRaioForZero() {

        assertThrows(IllegalArgumentException.class, () -> new Circulo(0));
    }

    @Test
    void deveLancarExcecaoQuandoRaioForNegativo() {

        assertThrows(IllegalArgumentException.class, () -> new Circulo(-5));
    }

    @Test
    void deveCalcularCircunferenciaDoCirculo() {

        Circulo circulo = new Circulo(5);

        double circunferencia = circulo.calcularCircunferencia();
        assertEquals(2 * Math.PI * 5, circunferencia, 0.001);
    }

    @Test
    void deveAgruparVerificacoesComAssertAll() {
        Circulo circulo = new Circulo(10);

        double area = circulo.calcularArea();
        double circunferencia = circulo.calcularCircunferencia();

        assertAll(
                () -> assertNotNull(circulo),
                () -> assertTrue(circulo.verificarSeCirculoEGrande()),
                () -> assertEquals(Math.PI * 100, area, 0.001),
                () -> assertEquals(2 * Math.PI * 10, circunferencia, 0.001));

    }
}
