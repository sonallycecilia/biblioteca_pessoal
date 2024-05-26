package classes.entities;

import java.util.ArrayList;

import classes.models.Texto;

public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private ArrayList<Estante> listaEstantes;
    
    public Usuario(String nome, String login, String senha){
        this.nome = nome;
        this.login = nome;
        this.senha = senha;
        this.listaEstantes = new ArrayList<Estante>();
    }

    public Usuario(String login, String senha){
        this.login = nome;
        this.senha = senha;
        this.listaEstantes = new ArrayList<Estante>();
    }

    public void addEstante(Estante estante){
        listaEstantes.add(estante);
    }
    public int addTexto(Estante estante, Texto texto){
        for(Estante e: listaEstantes){
            if(estante == e){
                e.adicionarTexto(texto);
                return 1;
            }
        }
        return 0;
    }
    public int addTexto(String nomeEstante, Texto texto){
        for(Estante e: listaEstantes){
            if(nomeEstante == e.getNome()){
                e.adicionarTexto(texto);
                return 1;
            }
        }
        return 0;
    }

    public Estante buscarEstante(String nome){
        for(Estante e : listaEstantes){
            if(nome == e.getNome()){
                return e;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nomeExibicao) {
        this.nome = nomeExibicao;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public ArrayList<Estante> getListaEstantes() {
        return listaEstantes;
    }
    public void setListaEstantes(ArrayList<Estante> listaEstantes) {
        this.listaEstantes = listaEstantes;
    }
    
}
