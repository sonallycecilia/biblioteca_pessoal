package classes;
import java.util.Scanner;

public class Livro extends Texto {
    // atributos subclasse
    private String nomeEditora;
    private int edicao;
    private String genero;

    // Construtor com Todas as informações
    public Livro(String nomeTexto, String nomeAutor, String dataPublicacao, String inicioLeitura, String terminoLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeEditora, int edicao, String genero) {
        super(nomeTexto, nomeAutor, dataPublicacao, inicioLeitura, terminoLeitura, numPaginas, foiLido, foiIniciado);
        this.nomeEditora = nomeEditora;
        this.edicao = edicao;
        this.genero = genero;
    }
    // Construtor sem a data do Término da Leitura
    public Livro(String nomeTexto, String nomeAutor, String dataPublicacao, String inicioLeitura, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeEditora, int edicao, String genero) {
        super(nomeTexto, nomeAutor, dataPublicacao, inicioLeitura, " ", numPaginas, foiLido, foiIniciado);
        this.nomeEditora = nomeEditora;
        this.edicao = edicao;
        this.genero = genero;
    }
    // Construtor sem a data do Começo e Término da Leitura
    public Livro(String nomeTexto, String nomeAutor, String dataPublicacao, int numPaginas, boolean foiLido, boolean foiIniciado, String nomeEditora, int edicao, String genero) {
        super(nomeTexto, nomeAutor, dataPublicacao, " ", " ", numPaginas, foiLido, foiIniciado);
        this.nomeEditora = nomeEditora;
        this.edicao = edicao;
        this.genero = genero;
    }
    
    // getters e setters
    public String getNomeEditora() {
        return nomeEditora;
    }
    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }
    public int getEdicao() {
        return edicao;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString(){
        return getNomeTexto() + " | " + getNomeAutor() + " | " + getDataPublicacao() + 
               " | " + getInicioLeitura() + " | " + getTerminoLeitura() + " | " + getNumPaginas() + 
               " | " + getFoiLido() + " | " +  getFoiIniciado() + " | " + getNomeEditora() +
               " | " + getEdicao() + " | " + getGenero();
    }

    public static Livro criarLivro(Scanner sc){ //passando scanner como parametro pq o vs da warnning pra fechar, assim o sc ´é fechado em main
        String nomeTexto, nomeAutor, nomeEditora, nomeGenero, dataPublicacao, dataInicio, dataTermino;
        int numEdicao, numPaginas;
        int opcao;
        
        System.out.printf("Digite o nome do Livro que deseja adicionar: ");
		nomeTexto = sc.nextLine();
        System.out.printf("Digite o nome do Autor do livro: ");
        nomeAutor = sc.nextLine();
        System.out.printf("Digite o nome da Editora do livro: ");
        nomeEditora = sc.nextLine();
        System.out.printf("Digite o nome o Gênero do livro: ");
        nomeGenero = sc.nextLine();
        System.out.printf("Digite o número da Edicao do livro: ");
        numEdicao = sc.nextInt();
        sc.nextLine(); // Remover o \n do buffer
        System.out.printf("Digite a Data de Publicacao do livro(dd/mm/aa): ");
        dataPublicacao = sc.nextLine();
        System.out.printf("Digite o Número de Páginas do livro: ");
        numPaginas = sc.nextInt();
        sc.nextLine();
        
        System.out.printf("O livro foi Iniciado?" +
						  "%n[1] - Sim" +
						  "%n[2] - Não");
        opcao = sc.nextInt();
        sc.nextLine();
        if (opcao == 1) {
            System.out.printf("O livro foi Lido?" +
                              "%n[1] - Sim" +
                              "%n[2] - Não");
            opcao = sc.nextInt();
            sc.nextLine();
				if (opcao == 1) {
                    System.out.printf("Digite a Data que comecou a ler(dd/mm/aa):");
                    dataInicio = sc.nextLine();
                    System.out.printf("Digite a Data que terminou de ler(dd/mm/aa):");
                    dataTermino = sc.nextLine();
                    sc.nextLine(); //limpando buffer
                        
                    return new Livro(nomeTexto, nomeAutor, dataPublicacao, dataInicio, dataTermino, numPaginas, true, true, nomeEditora, numEdicao, nomeGenero);
                }
                else if (opcao == 2){   //isso esta errado, pois se temos data de inicio, significa que o livro esta sendo lido
                    return new Livro(nomeTexto, nomeAutor, dataPublicacao, numPaginas, false, true, nomeEditora, numEdicao, nomeGenero);
                }
                else {
					    System.out.println("Opcao Invalida, digite 1 ou 2");
				}
        }
        else if (opcao == 2){
                return new Livro(nomeTexto, nomeAutor, dataPublicacao, numPaginas, false, false, nomeEditora, numEdicao, nomeGenero);
        }
        else {
            System.out.println("Opcao Invalida, digite 1 ou 2");
        }
        return null;
    }
}
