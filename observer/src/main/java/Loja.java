import java.util.Observable;

public class Loja extends Observable {

    private String rua;
    private int numero;
    private String cidade;
    private String estado;

    public Loja(String rua, int numero, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public void lancarNovoProduto() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "na loja da " + rua + ", " + numero + " - " + cidade + ", " + estado;
    }

}