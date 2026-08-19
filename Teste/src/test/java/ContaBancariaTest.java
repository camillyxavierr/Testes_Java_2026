import org.example.ContaBancaria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    @Test
    void depositarValorValidoDeveAumentarSaldo() {

        ContaBancaria conta = new ContaBancaria("Maria", "123");

        conta.depositar(100.0);
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void sacarValorMaiorQueSaldoDeveLancarExcecao() {
        ContaBancaria conta = new ContaBancaria("Maria", "123");

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> conta.sacar(50.0));

        System.out.println("Mensagem capturada: " + excecao.getMessage());
        assertEquals("Saldo insuficiente", excecao.getMessage());
    }

    @Test
    void sacarComSaldoDisponivelDeveReduzirSaldo() {

        ContaBancaria conta = new ContaBancaria("Maria", "123");
        conta.depositar(100.0);

        assertDoesNotThrow(() -> conta.sacar(40.0));
        assertEquals(60.0, conta.getSaldo(), 0.001);
    }

    @Test
    void depositarZeroDeveLancarExcecao() {

        ContaBancaria conta = new ContaBancaria("Maria", "123");

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> conta.depositar(0.0));
        assertEquals("O valor do depósito deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void sacarValorNegativoDeveLancarExcecao() {

        ContaBancaria conta = new ContaBancaria("Maria", "123", 100.0);
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(-20.0));
    }

    @Test
    void construtorDeveInicializarTodosOsAtributos() {
        ContaBancaria conta = new ContaBancaria("João", "99999-9");

        assertAll(
                "Dados iniciais da conta",
                () -> assertEquals("João", conta.getTitular()),
                () -> assertEquals("99999-9", conta.getNumeroConta()),
                () -> assertEquals(0.0, conta.getSaldo(), 0.001));

    }

}