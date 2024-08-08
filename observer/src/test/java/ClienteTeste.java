import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTeste {

    @Test
    void deveNotificarUmCliente() {
        Loja loja = new Loja("Renato Dias", 650, "Juiz de Fora", "MG");
        Cliente cliente = new Cliente("William");
        cliente.addCliente(loja);
        loja.lancarNovoProduto();
        assertEquals("Prezado(a) William, um novo produto de seu interesse acaba de ser lançado na loja da Renato Dias, 650 - Juiz de Fora, MG", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes () {
        Loja loja = new Loja("Renato Dias", 650, "Juiz de Fora", "MG");
        Cliente cliente1 = new Cliente("Rayane");
        Cliente cliente2 = new Cliente("Gustavo");
        cliente1.addCliente(loja);
        cliente2.addCliente(loja);
        loja.lancarNovoProduto();
        assertEquals("Prezado(a) Rayane, um novo produto de seu interesse acaba de ser lançado na loja da Renato Dias, 650 - Juiz de Fora, MG", cliente1.getUltimaNotificacao());
        assertEquals("Prezado(a) Gustavo, um novo produto de seu interesse acaba de ser lançado na loja da Renato Dias, 650 - Juiz de Fora, MG", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente(){
        Loja loja = new Loja("Renato Dias", 650, "Juiz de Fora", "MG");
        Cliente cliente = new Cliente("Lucas");
        loja.lancarNovoProduto();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNoticarClientesDaLojaDaCidadeDeSaoPaulo() {
        Loja loja1 = new Loja("Renato Dias", 650, "Juiz de Fora", "MG");
        Loja loja2 = new Loja("Murilo da Fonseca", 480, "São Paulo", "SP");
        Cliente cliente1 = new Cliente("William");
        Cliente cliente2 = new Cliente("Amanda");
        Cliente cliente3 = new Cliente("Pedro");
        cliente1.addCliente(loja1);
        cliente2.addCliente(loja2);
        cliente3.addCliente(loja2);
        loja2.lancarNovoProduto();
        assertEquals(null, cliente1.getUltimaNotificacao());
        assertEquals("Prezado(a) Amanda, um novo produto de seu interesse acaba de ser lançado na loja da Murilo da Fonseca, 480 - São Paulo, SP", cliente2.getUltimaNotificacao());
        assertEquals("Prezado(a) Pedro, um novo produto de seu interesse acaba de ser lançado na loja da Murilo da Fonseca, 480 - São Paulo, SP", cliente3.getUltimaNotificacao());
    }
}