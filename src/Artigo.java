
import java.util.ArrayList;

public class Artigo extends Texto {
    // atributos subclasse
    private String nomeRevista;
    private ArrayList <String> palavrasChave;

    // Construtor completo
    public Artigo(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, String inicioLeitura, String terminoLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeRevista, ArrayList<String> palavrasChave) {
        super(nomeTexto, nomeAutores, dataPublicacao, inicioLeitura, terminoLeitura, numPaginas, foiLido, foiIniciado);
        this.nomeRevista = nomeRevista;
        this.palavrasChave = palavrasChave;
    }
    // Construtor sem inicio/termino de leitura e sem foiLido ou foiIniciado
    public Artigo(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, int numPaginas, String nomeRevista, ArrayList<String> palavrasChave){
        super(nomeTexto, nomeAutores, dataPublicacao, null, null, numPaginas, false, false);
        this.nomeRevista = nomeRevista;
        this.palavrasChave = palavrasChave;
    }
    // Construtor sem data do término da leitura
    public Artigo(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, String inicioLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeRevista, ArrayList<String> palavrasChave) {
        super(nomeTexto, nomeAutores, dataPublicacao, inicioLeitura, null, numPaginas, foiLido, foiIniciado);
        this.nomeRevista = nomeRevista;
        this.palavrasChave = palavrasChave;
    }
    // Construtor sem data do Início e Término da leitura
    public Artigo(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeRevista, ArrayList<String> palavrasChave) {
        super(nomeTexto, nomeAutores, dataPublicacao, null, null, numPaginas, foiLido, foiIniciado);
        this.nomeRevista = nomeRevista;
        this.palavrasChave = palavrasChave;
    }
    // Métodos
    @Override
    public String toString(){
        return super.toString() + " | " + getNomeRevista() + " | " + getPalavrasChave().toString();
    }
    // getters e setters
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
