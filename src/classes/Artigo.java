package classes;

import java.util.ArrayList;

import classes.enums.StatusTexto;

public class Artigo extends Texto {
    // atributos subclasse
    private String nomeRevista;
    private ArrayList <String> palavrasChave;

    // Construtor completo
    public Artigo(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, String inicioLeitura, String terminoLeitura, int numPaginas, StatusTexto status, String nomeRevista, ArrayList<String> palavrasChave) {
        super(nomeTexto, nomeAutores, dataPublicacao, inicioLeitura, terminoLeitura, numPaginas, status);
        this.nomeRevista = nomeRevista;
        this.palavrasChave = palavrasChave;
    }
    // Construtor sem inicio/termino de leitura e sem foiLido ou foiIniciado
    public Artigo(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, int numPaginas, StatusTexto status, String nomeRevista, ArrayList<String> palavrasChave){
        super(nomeTexto, nomeAutores, dataPublicacao, numPaginas, status);
        this.nomeRevista = nomeRevista;
        this.palavrasChave = palavrasChave;
    }
    // Construtor sem data do término da leitura
    public Artigo(String nomeTexto, ArrayList<String> nomeAutores, String dataPublicacao, String inicioLeitura, int numPaginas, StatusTexto status, String nomeRevista, ArrayList<String> palavrasChave) {
        super(nomeTexto, nomeAutores, dataPublicacao, inicioLeitura, numPaginas, status);
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
