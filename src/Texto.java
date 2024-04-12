abstract class Texto {
    // Atributos
    private String nomeTexto;
    private String nomeAutor;
    private String dataPublicacao;
    private String inicioLeitura;
    private String terminoLeitura;
    private int numPaginas;
    private boolean foiLido; // Para entrar no Obj. Estante de livros "Lidos"
    private boolean foiIniciado; // Para entrar no Obj. Estante de livros "Lendo Agora"

    // Construtor
    public Texto(String nomeTexto, String nomeAutor, String dataPublicacao, String inicioLeitura, String terminoLeitura, int numPaginas, boolean foiLido, boolean foiIniciado){
        // Tratamento de Erros depois.
        this.nomeTexto = nomeTexto; // Padronizar Strings de nomes. Cada inicial maiúscula e o resto minúsculo
        this.nomeAutor = nomeAutor;  
        this.dataPublicacao = dataPublicacao;
        this.inicioLeitura = inicioLeitura;
        this.terminoLeitura = terminoLeitura;
        this.numPaginas = numPaginas; // Número de páginas negativa. Avisar ao usuário que o número de páginas foi negativo, caso seja, atribuir 0 ao número da páginas
        this.foiLido = foiLido;
        this.foiIniciado = foiIniciado;
        
    }

    // Getters e Setters
    public String getNomeTexto() {
        return nomeTexto;
    }
    public void setNomeTexto(String nomeTexto) {
        this.nomeTexto = nomeTexto;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getInicioLeitura() {
        return inicioLeitura;
    }
    public void setInicioLeitura(String inicioLeitura) {
        this.inicioLeitura = inicioLeitura;
    }

    public String getTerminoLeitura() {
        return terminoLeitura;
    }
    public void setTerminoLeitura(String terminoLeitura) {
        this.terminoLeitura = terminoLeitura;
    }

    public int getNumPaginas() {
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public boolean getFoiLido() {
        return foiLido;
    }
    public void setFoiLido(boolean foiLido) {
        this.foiLido = foiLido;
    }
    
    public boolean getFoiIniciado() {
        return foiIniciado;
    }
    public void setFoiIniciado(boolean foiIniciado) {
        this.foiIniciado = foiIniciado;
    }
    
    // Métodos
    public void lerTexto(){} // Utilizar uma API externa para conseguir ler PDF's em java

    // Testes de Métodos 
    //public static void main(String[] args){}
}