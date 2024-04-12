import java.util.ArrayList;
import java.util.Random;

public class Estante {
    private String nome;
    private ArrayList<Texto> listaTextos;

    public Estante (String nome){
        this.nome = nome;
        listaTextos = new ArrayList<>();
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String noome){
        this.nome = noome;
    }

    public void mostrarTextos() {
        if (listaTextos.isEmpty()) { //falta implementar metodo
            System.out.println("A estante está vazia.");
        } else {
            System.out.println("Estante:");
            for (Texto texto : listaTextos) {
                System.out.println("Nome: " + texto.getNome() + ", Autor: " + texto.getNomeAutor());
            }
        }
    }

    public void adicionarTexto(Texto texto) {
        this.listaTextos.add(texto);
    }

    public void removerTexto(Texto texto) {
        this.listaTextos.remove(texto);
    }

    public int totalTextos(){
        return this.listaTextos.size();
    }

    public Texto sortearLeitura(){
        random = new Random();
        if (listaTextos.isEmpty()) {
            return null; // Retorna null se a lista estiver vazia
        }
        int indiceSorteado = random.nextInt(listaTextos.size());
        return listaTextos.get(indiceSorteado);
    }

}