package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

    // é desnecessário criar funções para isso, já existem métodos do ArrayList para isso
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
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    // CRIAR MÉTODO: FILTRAR(), POR NOME, AUTOR, NÚMERO DE PAGINAS, EDITORA, ETC. SOBRECARGA

    public void filtrarNome(File diretorio, String usuario, String estante, String nome) { //adaptar pra printar/procurar de várias estantes?
		String path = diretorio.getName() + "\\" + usuario + "\\" + estante + ".txt";
        String linha;
        boolean achou = false;

		try (BufferedReader arquivo = new BufferedReader(new FileReader(path))) {
			while (((linha = arquivo.readLine()) != null) || achou == false) {
                String[] dados = linha.split(" \\| ");
				if (dados[0].equals(nome)){
                    System.out.printf("Texto encontrado na estante: %s%n", estante);
                    exibirTexto(dados);
                    achou = true;
                }
			}
		} catch (IOException e) {
			System.out.println("Erro ao extrair informações.");
			e.printStackTrace();
		}
        if (!achou){
            System.out.println("Texto não encontrado.");
        }
	}

    public void exibirTexto(String[] dados){
        System.out.println("=========================================");
        System.out.printf("Nome: " + dados[0] +
        "%nAutor: " + dados[1] + 
        "%nPublicação: " + dados[2] + 
        "%nInicio da leitura: " + dados[3] + 
        "%nTermino da leitura: " + dados[4] + 
        "%nNúmero de páginas: " + dados[5] + 
        "%nStatus: " + dados[6] + "%n");
        System.out.println("=========================================");
        
    }

    public void filtrarAutor(String autor){
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (autor.compareTo(texto.buscarNomeAutor(autor)) == 0){
                System.out.println("Texto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nStatus: " +
                        texto.getStatus());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto cujo autor é " + autor + " não foi encontrado");
            //return null; 
        }
    }
    
    public void filtrarPublicacao(Date publicacao){
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
						"%nStatus: " +
                        texto.getStatus());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto cuja data de publicação é " + publicacao + " não foi encontrado");
            //return null; 
        }
    }
    
     public void filtrarInicioLeitura(Date inicioLeitura){
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
						"%nStatus: " +
                        texto.getStatus());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto cujo inicio da leitura é " + inicioLeitura + " não foi encontrado");
            //return null; 
        }
    }
    
         public void filtrarTerminoLeitura(Date terminoLeitura){
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (terminoLeitura.compareTo(texto.getTerminoLeitura()) == 0){
                System.out.println("Texto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nStatus: " +
                        texto.getStatus());
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
						"%nStatus: " +
                        texto.getStatus());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto cujo número de páginas é " + numPaginas + " não foi encontrado");
            //return null; 
        }
    }
    
    public void filtrarLido(){ //esse metodo vai ser sobrecarregado junto com o de filtrar pelo numero de paginas
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (texto.getStatus().ordinal() == 2){
                System.out.println("%nTexto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nStatus: " +
                        texto.getStatus());
						encontrou = 1;
				
				//return texto;
            }
        }
        if (encontrou == 0){
            System.out.printf("O texto não foi encontrado");
            //return null; 
        }
    }
    
    public void filtrarLendo(){ //esse metodo vai ser sobrecarregado junto com o de filtrar pelo numero de paginas
        int encontrou = 0;
        for (Texto texto : listaTextos){
            if (texto.getStatus().ordinal() == 1){
                System.out.println("%nTexto encontrado!%n");
                System.out.printf("Nome: " + texto.getNomeTexto() + 
						"%nAutor: " + texto.getNomeAutor() + 
						"%nPublicação: " + texto.getDataPublicacao() + 
						"%nInicio da leitura: " + texto.getInicioLeitura() + 
						"%nTermino da leitura: " + texto.getTerminoLeitura() + 
						"%nNúmero de páginas: " + texto.getNumPaginas() + 
						"%nStatus: " +
                        texto.getStatus());
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
    public ArrayList<Texto> getListaTextos() {
        return listaTextos;
    }
}
