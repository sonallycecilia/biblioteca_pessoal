<<<<<<< Updated upstream
=======
import java.util.ArrayList;

>>>>>>> Stashed changes
public class Livro extends Texto {
    // atributos subclasse
    private String nomeEditora;
    private int numEdicao;
    private String nomeGenero;

    // Construtor com Todas as informações
    public Livro(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, String inicioLeitura, String terminoLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeEditora, int numEdicao, String nomeGenero) {
        super(nomeTexto, nomeAutores, dataPublicacao, inicioLeitura, terminoLeitura, numPaginas, foiLido, foiIniciado);
        this.nomeEditora = nomeEditora;
        this.numEdicao = numEdicao;
        this.nomeGenero = nomeGenero;
    }
    // Construtor sem inicio/termino de leitura e sem foiLido ou foiIniciado
    public Livro(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, int numPaginas, String nomeEditora, int numEdicao, String nomeGenero){
        super(nomeTexto, nomeAutores, dataPublicacao, null, null, numPaginas, false, false);
        this.nomeEditora = nomeEditora;
        this.numEdicao = numEdicao;
        this.nomeGenero = nomeGenero;
    }
<<<<<<< Updated upstream
    // Construtor com sem a data do Término da Leitura
    public Livro(String nomeTexto, String nomeAutor, String dataPublicacao, String inicioLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeEditora, int edicao, String genero) {
        super(nomeTexto, nomeAutor, dataPublicacao, inicioLeitura, " ", numPaginas, foiLido, foiIniciado);
=======
    // Construtor sem a data do Término da Leitura
    public Livro(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, String inicioLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeEditora, int numEdicao, String nomeGenero) {
        super(nomeTexto, nomeAutores, dataPublicacao, inicioLeitura, null, numPaginas, foiLido, foiIniciado);
>>>>>>> Stashed changes
        this.nomeEditora = nomeEditora;
        this.numEdicao = numEdicao;
        this.nomeGenero = nomeGenero;
    }
    // Construtor sem a data do Começo e Término da Leitura
    public Livro(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeEditora, int numEdicao, String nomeGenero) {
        super(nomeTexto, nomeAutores, dataPublicacao, null, null, numPaginas, foiLido, foiIniciado);
        this.nomeEditora = nomeEditora;
        this.numEdicao = numEdicao;
        this.nomeGenero = nomeGenero;
    }
    // Métodos
    @Override
    public String toString(){
        return super.toString() + " | " + getNomeEditora() + " | " + getnumEdicao() + " | " + getnomeGenero();
    }
    // getters e setters
    public String getNomeEditora() {
        return nomeEditora;
    }
    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }
    public int getnumEdicao() {
        return numEdicao;
    }
    public void setnumEdicao(int numEdicao) {
        this.numEdicao = numEdicao;
    }
    public String getnomeGenero() {
        return nomeGenero;
    }
<<<<<<< Updated upstream
    public void setGenero(String genero) {
        this.genero = genero;
=======
    public void setnomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
>>>>>>> Stashed changes
    }
}
