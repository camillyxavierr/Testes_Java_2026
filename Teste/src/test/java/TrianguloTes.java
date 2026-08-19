import org.example.Triangulo;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

class TrianguloTes {

        @Test
        void calcularPerimetroDeveSomarOsTresLados() {

            Triangulo triangulo = new Triangulo(3, 4, 5);
            double perimetro = triangulo.calcularPerimetro();
            assertEquals(12.0, perimetro);
        }

        @Test
        void ladoNegativoDeveLancarExcecao() {
            assertThrows(IllegalArgumentException.class, () -> new Triangulo(-1, 4, 5));
        }

        @Test
        void triangulo3_4_5DeveTerLadosCorretos() {
            Triangulo t = new Triangulo(3, 4, 5);
            assertAll(
                    () -> assertEquals(3.0, t.getLadoA()),
                    () -> assertEquals(4.0, t.getLadoB()),
                    () -> assertEquals(5.0, t.getLadoC()));

        }

}
