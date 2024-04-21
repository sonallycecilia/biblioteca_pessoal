import java.util.ArrayList;

public class Usuario {
    private String nomeExibicao;
    private String login;
    private String senha;
    private ArrayList<Estante> listaEstantes;
    
    public Usuario(String nomeExibicao, String nome, String senha){
        this.nomeExibicao = nomeExibicao;
        this.login = nome;
        this.senha = senha;
        this.listaEstantes = new ArrayList<Estante>();
    }

    public void addEstante(Estante estante){
        listaEstantes.add(estante);
    }
    public Estante buscarEstante(String nome){
        for(Estante e : listaEstantes){
            if(nome == e.getNome()){
                return e;
            }
        }
        return new Estante(null);
    }

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
