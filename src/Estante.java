import java.util.ArrayList;
import java.util.Random;

public class Estante {
    // atributos
    private String nome;
    private ArrayList<Texto> listaTextos;
    // construtor
    public Estante (String nome){
        this.nome = nome;
        listaTextos = new ArrayList<Texto>();
    }
    // métodos classe estante
    public void mostrarTextos() {
        if (listaTextos.isEmpty()) { //falta implementar metodo
            System.out.println("A estante está vazia.");
        } else {
            System.out.println("Estante:");
            for (Texto texto : listaTextos) {
                System.out.println("Nome: " + texto.getNomeTexto() + ", Autor: " + texto.getNomeAutor());
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
        Random random = new Random();
        if (listaTextos.isEmpty()) {
            return null; // Retorna null se a lista estiver vazia
        }
        int indiceSorteado = random.nextInt(listaTextos.size());
        return listaTextos.get(indiceSorteado);
    }
    // CRIAR MÉTODO: FILTRAR(), POR NOME, AUTOR, NÚMERO DE PAGINAS, EDITORA, ETC. SOBRECARGA
    
    public void filtrarNome(String nome){
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (nome.compareTo(texto.getNomeTexto()) == 0){
                System.out.println("Texto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nFoi lido: " + texto.getFoiLido() + 
						"%nFoi iniciado: " + texto.getFoiIniciado());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto " + nome + " não foi encontrado");
            //return null; 
        }
    }
    
    public void filtrarAutor(String autor){
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (autor.compareTo(texto.getNomeAutor()) == 0){
                System.out.println("Texto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nFoi lido: " + texto.getFoiLido() + 
						"%nFoi iniciado: " + texto.getFoiIniciado());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto cujo autor é " + autor + " não foi encontrado");
            //return null; 
        }
    }
    
    public void filtrarPublicacao(String publicacao){
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (publicacao.compareTo(texto.getDataPublicacao()) == 0){
                System.out.println("Texto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nFoi lido: " + texto.getFoiLido() + 
						"%nFoi iniciado: " + texto.getFoiIniciado());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto cuja data de publicação é " + publicacao + " não foi encontrado");
            //return null; 
        }
    }
    
     public void filtrarInicioLeitura(String inicioLeitura){
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (inicioLeitura.compareTo(texto.getInicioLeitura()) == 0){
                System.out.println("Texto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nFoi lido: " + texto.getFoiLido() + 
						"%nFoi iniciado: " + texto.getFoiIniciado());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto cujo inicio da leitura é " + inicioLeitura + " não foi encontrado");
            //return null; 
        }
    }
    
         public void filtrarTerminoLeitura(String terminoLeitura){
        int encontrou = 0;
        for (Texto texto : listaTextos){
            String terminoLeituraObj = texto.getTerminoLeitura();
            if (terminoLeitura.compareTo(terminoLeituraObj) == 0){
                System.out.println("Texto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nFoi lido: " + texto.getFoiLido() + 
						"%nFoi iniciado: " + texto.getFoiIniciado());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto cujo termino da leitura é " + terminoLeitura + " não foi encontrado");
            //return null; 
        }
    }
    
    public void filtrar(int numPaginas){ // esse metodo vai ser sobrecarregado junto com o de filtrar por se foi lido ou nao 
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (numPaginas == texto.getNumPaginas()){
                System.out.println("%nTexto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nFoi lido: " + texto.getFoiLido() + 
						"%nFoi iniciado: " + texto.getFoiIniciado());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto cujo número de páginas é " + numPaginas + " não foi encontrado");
            //return null; 
        }
    }
    
    public void filtrar(boolean foiLido){ //esse metodo vai ser sobrecarregado junto com o de filtrar pelo numero de paginas
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (texto.getFoiLido() == foiLido){
                System.out.println("%nTexto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nFoi lido: " + texto.getFoiLido() + 
						"%nFoi iniciado: " + texto.getFoiIniciado());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto não foi encontrado");
            //return null; 
        }
    }
    
    public void filtrarFoiIniciado(boolean foiIniciado){ //esse metodo vai ser sobrecarregado junto com o de filtrar pelo numero de paginas
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (texto.getFoiIniciado() == foiIniciado){
                System.out.println("%nTexto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nFoi lido: " + texto.getFoiLido() + 
						"%nFoi iniciado: " + texto.getFoiIniciado());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto não foi encontrado");
            //return null; 
        }
    }
    
    // setters e getters
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
