package classes;
import java.util.ArrayList;
import java.util.Scanner;

public class Artigo extends Texto {
    // atributos subclasse
    private String nomeRevista;
    private ArrayList <String> palavrasChave;

    // construtor completo
    public Artigo(String nomeTexto, String nomeAutor, String dataPublicacao, String inicioLeitura, String terminoLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeRevista, ArrayList<String> palavrasChave) {
        super(nomeTexto, nomeAutor, dataPublicacao, inicioLeitura, terminoLeitura, numPaginas, foiLido, foiIniciado);
        this.nomeRevista = nomeRevista;
        this.palavrasChave = palavrasChave;
    }
    // Construtor sem data do término da leitura
    public Artigo(String nomeTexto, String nomeAutor, String dataPublicacao, String inicioLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeRevista, ArrayList<String> palavrasChave) {
        super(nomeTexto, nomeAutor, dataPublicacao, inicioLeitura, "", numPaginas, foiLido, foiIniciado);
        this.nomeRevista = nomeRevista;
        this.palavrasChave = palavrasChave;
    }
    // Construtor sem data do Início e Término da leitura
    public Artigo(String nomeTexto, String nomeAutor, String dataPublicacao, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeRevista, ArrayList<String> palavrasChave) {
        super(nomeTexto, nomeAutor, dataPublicacao, "", "", numPaginas, foiLido, foiIniciado);
        this.nomeRevista = nomeRevista;
        this.palavrasChave = palavrasChave;
    }

    // métodos getters e setters
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
    public static Artigo criarArtigo(Scanner sc){
        ArrayList<String> palavrasChave = new ArrayList<String>();
        String[] palavrasArray;
        String nomeTexto, nomeAutor, dataPublicacao, nomeRevista, palavras, dataInicio;
        int numPaginas, opcao;
        
        System.out.printf("Digite o nome do Artigo que deseja adicionar: ");
        nomeTexto = sc.nextLine();
        System.out.printf("Digite o nome do(s) Autor(es) do artigo, separar cada autor por vírgulas: "); 
        nomeAutor = sc.nextLine(); // Criar um Array de Strings para os Autores do Artigo 
        System.out.printf("Digite a Data de Publicacao do artigo: ");
        dataPublicacao = sc.nextLine();
        System.out.printf("Digite o Número de Paginas do artigo: ");
        numPaginas = sc.nextInt();
        sc.nextLine(); // "remover" o \n do buffer;
        System.out.printf("Digite o nome da Revista que publicou o artigo: ");
        nomeRevista = sc.nextLine();
        System.out.printf("Digite as palavras-chave do artigo, separe por vírgulas(,): ");
        palavras = sc.nextLine();
        
        palavrasArray = palavras.split(",");
        for(String s : palavrasArray){
            palavrasChave.add(s);
        }
        System.out.printf("O artigo foi Iniciado?%n" +
                          "[1] - Sim%n" + 
                          "[2] - Não%n");
        opcao = sc.nextInt();
        if (opcao == 1){
            System.out.printf("O artigo foi Lido?%n" +
                          "[1] - Sim%n" + 
                          "[2] - Não (em processo)%n");
            opcao = sc.nextInt();
            if (opcao == 1){
                    System.out.printf("Digite a Data que comecou a ler(dd/mm/aa):");
                    dataInicio = sc.nextLine();

                    return new Artigo(nomeTexto, nomeAutor, dataPublicacao, dataInicio, numPaginas, true, true, nomeRevista, palavrasChave);
            }
            else if (opcao == 2){
                return new Artigo(nomeTexto, nomeAutor, dataPublicacao, numPaginas, false, true, nomeRevista, palavrasChave);
            }
            else
                System.out.println("Opcao Invalida, digite 1 ou 2");
        }
        else if (opcao == 2){
            return new Artigo(nomeTexto, nomeAutor, dataPublicacao, numPaginas, false, false, nomeRevista, palavrasChave);
        }
        else
            System.out.println("Opcao Invalida, digite 1 ou 2");
        
        return null;
    }
}
