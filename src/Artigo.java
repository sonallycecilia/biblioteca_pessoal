import java.util.ArrayList;

public class Artigo extends Texto {
    // atributos subclasse
    private String nomeRevista;
    private ArrayList <String> palavrasChave;

    // construtor
    public Artigo(String nomeTexto, String nomeAutor, String dataPublicacao, String inicioLeitura, String terminoLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeRevista, ArrayList<String> palavrasChave) {
        super(nomeTexto, nomeAutor, dataPublicacao, inicioLeitura, terminoLeitura, numPaginas, foiLido, foiIniciado);
        this.nomeRevista = nomeRevista;
        this.palavrasChave = palavrasChave;
    }

    // métodos getters e setters
    public String getNomeRevista() {
        return nomeRevista;
    }
    public void setNomeRevista(String nomeRevista) {
        this.nomeRevista = nomeRevista;
    }
    public ArrayList<String> getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(ArrayList<String> palavrasChave) {
        this.palavrasChave = palavrasChave;
    }
}
