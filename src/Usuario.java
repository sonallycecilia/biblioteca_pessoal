import java.util.ArrayList;

public class Usuario {
    // Atributos
    private String nomeExibicao;
    private String login;
    private String senha;
    private ArrayList<Estante> listaEstantes;
    
    // Construtor
    public Usuario(String nomeExibicao, String nome, String senha){
        this.nomeExibicao = nomeExibicao;
        this.login = nome;
        this.senha = senha;
        this.listaEstantes = new ArrayList<Estante>();
    }

    // Métodos
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

    // getters e setters
    public String getNomeExibicao() {
        return nomeExibicao;
    }
    public void setNomeExibicao(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
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
