package classes;

import java.util.ArrayList;
import java.util.Date;

import classes.enums.StatusTexto;

public abstract class Texto {
    // Atributos
    public static final String SEPARADOR_STRING = ",";
    private String nomeTexto;
    private ArrayList<String> nomeAutores;
    private Date dataPublicacao;
    private int numPaginas;
    private Date inicioLeitura;
    private Date terminoLeitura;
    private StatusTexto status;

    // Contrutor com todas os atributos
    public Texto(String nomeTexto, ArrayList<String> nomeAutores, Date dataPublicacao, Date inicioLeitura, Date terminoLeitura, int numPaginas, StatusTexto status){
        // Tratamento de Erros depois.
        this.nomeTexto = nomeTexto; // Padronizar Strings de nomes. Cada inicial maiúscula e o resto minúsculo
        this.nomeAutores = nomeAutores;  
        this.dataPublicacao = dataPublicacao;
        this.inicioLeitura = inicioLeitura;
        this.terminoLeitura = terminoLeitura;
        this.numPaginas = numPaginas; // Número de páginas negativa. Avisar ao usuário que o número de páginas foi negativo, caso seja, atribuir 0 ao número da páginas
        this.status = status;
    }

    //sem inicio e fim = nao li
    public Texto(String nomeTexto, ArrayList<String> nomeAutores, Date dataPublicacao, int numPaginas, StatusTexto status){
        this.nomeTexto = nomeTexto;
        this.nomeAutores = nomeAutores;  
        this.dataPublicacao = dataPublicacao;
        this.numPaginas = numPaginas;
        this.status = status;
    }

    //lendo, sem fim de leitura
    public Texto(String nomeTexto, ArrayList<String> nomeAutores, Date dataPublicacao, Date inicioLeitura, int numPaginas, StatusTexto status){
        this.nomeTexto = nomeTexto; 
        this.nomeAutores = nomeAutores;  
        this.dataPublicacao = dataPublicacao;
        this.inicioLeitura = inicioLeitura;
        this.numPaginas = numPaginas; 
        this.status = status;
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
        return getNomeTexto() + " | " + getNomeAutor() + " | " + dataPublicacao.toString() + 
               " | " + inicioLeitura.toString() + " | " + terminoLeitura.toString() + " | " + getNumPaginas() + " | " + status.name();
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
    public Date getDataPublicacao(){
        return dataPublicacao;
    }
    public Date getInicioLeitura(){
        return inicioLeitura;
    }
    public void setInicioLeitura(Date inicioLeitura){
        this.inicioLeitura = inicioLeitura;  
    }

    public void setTerminoLeitura(Date terminoLeitura){
        this.terminoLeitura = terminoLeitura;
    }

    public Date getTerminoLeitura(){
        return terminoLeitura;
    }
    public int getNumPaginas() {
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    public StatusTexto getStatus(){
        return status;
    }
    // Testes de Métodos 
    //public static void main(String[] args){}
}