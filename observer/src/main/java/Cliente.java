import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer{

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void addCliente(Loja loja) {
        loja.addObserver(this);
    }

    public void update(Observable loja, Object arg1) {
        this.ultimaNotificacao = "Prezado(a) " + this.nome + ", um novo produto de seu interesse acaba de ser lançado " + loja.toString();
    }
}