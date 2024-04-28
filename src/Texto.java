

import java.util.ArrayList;

abstract class Texto {
    // Atributos
    public static final String SEPARADOR_STRING = ",";
    private String nomeTexto;
    private ArrayList<String> nomeAutores;
    private String dataPublicacao;
    private int numPaginas;
    private String inicioLeitura;
    private String terminoLeitura;
        // Transformar essas infos num Enum.
    private boolean foiLido; // Para entrar no Obj. Estante de livros "Lidos"
    private boolean foiIniciado; // Para entrar no Obj. Estante de livros "Lendo Agora"
    
    // Contrutor com todas os atributos
    public Texto(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, String inicioLeitura, String terminoLeitura, int numPaginas, boolean foiLido, boolean foiIniciado){
        // Tratamento de Erros depois.
        this.nomeTexto = nomeTexto; // Padronizar Strings de nomes. Cada inicial maiúscula e o resto minúsculo
        this.nomeAutores = nomeAutores;  
        this.dataPublicacao = dataPublicacao;
        this.inicioLeitura = inicioLeitura;
        this.terminoLeitura = terminoLeitura;
        this.numPaginas = numPaginas; // Número de páginas negativa. Avisar ao usuário que o número de páginas foi negativo, caso seja, atribuir 0 ao número da páginas
        this.foiLido = foiLido;
        this.foiIniciado = foiIniciado;
        
    }

    // Métodos
    public String buscarNomeAutor(String nomeAutor){
        for (String s: nomeAutores){
            if (nomeAutor == s){
                return s;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return getNomeTexto() + " | " + getNomeAutor() + " | " + getDataPublicacao() + 
               " | " + getInicioLeitura() + " | " + getTerminoLeitura() + " | " + getNumPaginas() + 
               " | " + getFoiLido() + " | " +  getFoiIniciado() + " | ";
    }

    public void lerTexto(){} // Utilizar uma API externa para conseguir ler PDF's em java
    // Getters e Setters
    public String getNomeTexto() {
        return nomeTexto;
    }
    public void setNomeTexto(String nomeTexto) {
        this.nomeTexto = nomeTexto;
    }
    public ArrayList<String> getNomeAutor() {
        return nomeAutores;
    }
    public void setNomeAutor(ArrayList<String> nomeAutores) {
        this.nomeAutores = nomeAutores;
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
    // Testes de Métodos 
    //public static void main(String[] args){}
}