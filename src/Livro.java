public class Livro {
    // atributos subclasse
    private String nomeEditora;
    private String edicao;
    private String genero;

    // construtor
    public Livro(String nomeEditora, String edicao, String genero) {
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
    public String getEdicao() {
        return edicao;
    }
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
