package classes.entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import classes.models.Texto;

public class Usuario {
    private String nome;
    private String login;
    private String senha;

    public Usuario(String nome, String login, String senha){
        this.nome = nome;
        this.login = nome;
        this.senha = senha;
    }

    public Usuario(String login, String senha){
        this.login = nome;
        this.senha = senha;
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

    //arquivos
    public static void criarPastaUsuario(File diretorio, String nomeUsuario){
		String path = diretorio.getName() + "\\" + nomeUsuario; 
		File aq = new File(path);
		if (!aq.exists()){
			try {
				aq.createNewFile();
				System.out.println(nomeUsuario + " criado com sucesso.");
			}
			catch (IOException e){
				System.out.println("Erro ao criar usuario.");
				e.printStackTrace();
			}
		} else
			System.out.println("Ja existe um usuario com este nome!");
	}
}
