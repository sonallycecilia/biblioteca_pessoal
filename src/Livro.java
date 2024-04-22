public class Livro extends Texto {
    // atributos subclasse
    private String nomeEditora;
    private int edicao;
    private String genero;

    // Construtor com Todas as informações
    public Livro(String nomeTexto, String nomeAutor, String dataPublicacao, String inicioLeitura, String terminoLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeEditora, int edicao, String genero) {
        super(nomeTexto, nomeAutor, dataPublicacao, inicioLeitura, terminoLeitura, numPaginas, foiLido, foiIniciado);
        this.nomeEditora = nomeEditora;
        this.edicao = edicao;
        this.genero = genero;
    }
    // Construtor com sem a data do Término da Leitura
    public Livro(String nomeTexto, String nomeAutor, String dataPublicacao, String inicioLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeEditora, int edicao, String genero) {
        super(nomeTexto, nomeAutor, dataPublicacao, inicioLeitura, " ", numPaginas, foiLido, foiIniciado);
        this.nomeEditora = nomeEditora;
        this.edicao = edicao;
        this.genero = genero;
    }
    // Construtor sem a data do Começo e Término da Leitura
    public Livro(String nomeTexto, String nomeAutor, String dataPublicacao, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeEditora, int edicao, String genero) {
        super(nomeTexto, nomeAutor, dataPublicacao, " ", " ", numPaginas, foiLido, foiIniciado);
        this.nomeEditora = nomeEditora;
        this.edicao = edicao;
        this.genero = genero;
    }
    
    // getters e setters
    public String getNomeEditora() {
        return nomeEditora;
    }
    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }
    public int getEdicao() {
        return edicao;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
