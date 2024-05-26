package classes.models;

import java.util.ArrayList;
import java.util.Date;

import classes.enums.StatusTexto;

public class Livro extends Texto {
    // atributos subclasse
    private String nomeEditora;
    private int numEdicao;
    private String nomeGenero;

    // Construtor com Todas as informações, livro lido e add a estante
    public Livro(String nomeTexto, ArrayList<String> nomeAutores, Date dataPublicacao, Date inicioLeitura, Date terminoLeitura, int numPaginas, StatusTexto status, String nomeEditora, int numEdicao, String nomeGenero) {
        super(nomeTexto, nomeAutores, dataPublicacao, inicioLeitura, terminoLeitura, numPaginas, status);
        this.nomeEditora = nomeEditora;
        this.numEdicao = numEdicao;
        this.nomeGenero = nomeGenero;
    }
    // Construtor sem inicio/termino de leitura e sem foiLido ou foiIniciado, ou seja, livro pra ler
    public Livro(String nomeTexto, ArrayList<String> nomeAutores, Date dataPublicacao, int numPaginas, StatusTexto status, String nomeEditora, int numEdicao, String nomeGenero) {
        super(nomeTexto, nomeAutores, dataPublicacao, numPaginas, status);
        this.nomeEditora = nomeEditora;
        this.numEdicao = numEdicao;
        this.nomeGenero = nomeGenero;
    }
    // Construtor sem a data do Término da Leitura, ou seja, lendo
    public Livro(String nomeTexto, ArrayList<String> nomeAutores, Date dataPublicacao, Date inicioLeitura, int numPaginas, StatusTexto status, String nomeEditora, int numEdicao, String nomeGenero) {
        super(nomeTexto, nomeAutores, dataPublicacao, inicioLeitura, numPaginas, status);
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
    public void setnomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }
}

