import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.InputMismatchException;
import java.io.IOException;

import classes.*;
import classes.enums.*;

// PADRÃO DE STRING: TRIMM E UPPER
// Fazer o javadoc
public abstract class Main {
	public static void main(String[] args) {

		/*
		 * Criação do usuário
		 * puxar dados com as informações do usuário de um arquivo txt(temporariamente)
		 * utilizar uma API de bando de dados depois
		 * Vou criar um usuario para fins de teste
		 */
		// Talvez isso mude se o escopo de cada operação for redirecionado para um
		// método à parte
		Scanner sc = new Scanner(System.in);
		File diretorioDB = new File(System.getProperty("user.dir") + "\\database\\"); // caminho absoluto
		diretorioDB.mkdir();
		Usuario usuarioTeste = new Usuario("Naly", "admin", "123");
		File usuarioDB = new File(diretorioDB, usuarioTeste.getNomeExibicao());
		usuarioDB.mkdir();
		System.out.printf("%n========== BIBLIOTECA PESSOAL ==========%n" +
				"=          Seja bem-vindo(a)!          =%n" +
				"========================================%n" +
				"%n");
		int opcaoMenu;
		String nomeEstante, nomeUsuario;
		File arquivoEstante;
		do {
			menuPrincipal();
			try {
				opcaoMenu = sc.nextInt();
			} catch (InputMismatchException e) {
				e.printStackTrace(System.err);
				opcaoMenu = -1;
			}
			sc.nextLine();
			// Limpar a tela e reprintar o menu. Procurar uma API interna pra isso
			switch (opcaoMenu) {
				case 0 -> {
					// Salvar os dados
					System.out.println("Programa encerrado!");
				}

				case 1 -> {
					// Tratar Estantes com o mesmo nome
					System.out.printf("Digite o nome da Estante: ");
					nomeEstante = sc.nextLine().toUpperCase().trim();
					System.out.println(nomeEstante); // TESTE
					criarArquivoEstante(diretorioDB, usuarioTeste.getNomeExibicao(), nomeEstante);
				}

				case 2 -> {
					// Arrumar isso aqui, ta prestando não
					System.out.printf("Digite o nome da estante que deseja visualizar: ");
					nomeEstante = sc.nextLine().toUpperCase().trim();
					System.out.printf(extrairDados(diretorioDB, usuarioTeste.getNomeExibicao(), nomeEstante));
				}

				case 3 -> {
					System.out.printf("Digite o nome da estante que desaja remover: ");
					nomeEstante = sc.nextLine().toUpperCase().trim();
					arquivoEstante = new File(diretorioDB, nomeEstante);
					try {
						if (arquivoEstante.delete()) {
							System.out.printf(nomeEstante + " removida com sucesso!\n");
						}
					} catch (IOException e) {
						System.out.println("Erro ao remover estante");
						e.printStackTrace(System.err);
					}
				}

				case 4 -> {
					String nomeTexto, nomeAutor, nomeEditora, nomeRevista, nomeGenero, palavras;
					String dataPublicacao, dataInicio, dataTermino;
					StatusTexto status;
					ArrayList<String> nomeAutores = new ArrayList<>();
					ArrayList<String> palavrasChave = new ArrayList<>();
					int numEdicao, numPaginas;
					int opcao;
					Texto texto = null;
					do {
						System.out.printf("Deseja adicionar um Livro ou um Artigo?" +
								"%n[1] Livro" +
								"%n[2] Artigo: ");
						try {
							opcao = sc.nextInt();
						} catch (InputMismatchException e) {
							System.err.println("Digite 1 ou 2!");
							e.printStackTrace(System.err);
						}
						sc.nextLine();

					} while (opcao != 1 && opcao != 2);
					System.out.printf("Digite o nome do Texto que deseja adicionar: ");
					nomeTexto = sc.nextLine().toUpperCase().trim();
					System.out.printf("Digite o nome do Autor(es) do Texto. Separe por ',': ");
					nomeAutor = sc.nextLine().toUpperCase().trim();
					// Finalizar a construção aqui
					do {
						System.out.printf("Digite a Data de Publicacao do Texto. formato: dd/mm/aaaa: ");
						dataPublicacao = sc.nextLine().trim();
					} while (!Texto.ehData(dataPublicacao));
					do {
						System.out.printf("Digite o Número de Páginas do Texto: ");
						try {
							numPaginas = sc.nextInt();
							break;
						} catch (InputMismatchException e) {
							System.out.println("Digite um numero inteiro!!");
							e.printStackTrace();
						}
						sc.nextLine();
					} while (!Character.isDigit(numPaginas));
					do {
						System.out.printf("Qual o status do texto?" +
								"%n[0] Não lido;" +
								"%n[1] Lendo;" +
								"%n[2] Lido;" +
								"%n[3] Abandonado");
						try {
							status = StatusTexto.values()[sc.nextInt()];
						} catch (InputMismatchException e) {
							System.out.println("Digite um numero entre 0 e 3!");
							e.printStackTrace(System.err);
						}
						sc.nextLine();
					} while (status.ordinal() < 0 && status.ordinal() > 3);
					if (opcao == 1) {
						System.out.printf("Digite o nome da Editora: ");
						nomeEditora = sc.nextLine();
						nomeEditora.toUpperCase().trim();
						do {
							System.out.printf("Qual o numero da edicao? ");
							try {
								numEdicao = sc.nextInt();
							} catch (InputMismatchException e) {
								System.out.println("Digite um numero inteiro!");
								e.printStackTrace(System.err);
							}
							sc.nextLine(); 
						} while (!Character.isDigit(numEdicao));
						System.out.printf("Qual é o gênero do livro? : ");
						nomeGenero = sc.nextLine();
						nomeGenero.toUpperCase().trim();
						// adicionando a String de nome dos autores no ArrayList
						for (String s : nomeAutor.split(Texto.SEPARADOR_STRING)) {
							nomeAutores.add(s);
						}
						// adicionando sem inicio e fim
						texto = new Livro(nomeTexto, nomeAutores, dataPublicacao, numPaginas, status, nomeEditora,
								numEdicao, nomeGenero);

					} else if (opcao == 2) {
						System.out.printf("Digite o nome da Revista: ");
						nomeRevista = sc.nextLine().toUpperCase().trim();
						System.out.printf("Quais sao as palavras chave? Separe por ',': ");
						palavras = sc.nextLine().toUpperCase().trim();
						// adicionando a String de palavras-chave no ArrayList
						for (String s : palavras.split(Texto.SEPARADOR_STRING)) {
							palavrasChave.add(s);
						}
						texto = new Artigo(nomeTexto, nomeAutores, dataPublicacao, numPaginas, status, nomeRevista,
								palavrasChave);
					}
					if ((status.ordinal()) != 0) { // se foi iniciado
						do {
							System.out.println("Digite a data que começou a ler(dd/mm/aa):");
							dataInicio = sc.nextLine().trim();
						} while (!Texto.ehData(dataPublicacao));
						texto.setInicioLeitura(dataInicio);
						if ((status.ordinal()) == 2) { // se foi lido
							do {
								System.out.println("Digite a data que terminou de ler(dd/mm/aa):");
								dataTermino = sc.nextLine().trim();
							} while (!Texto.ehData(dataTermino));
							texto.setTerminoLeitura(dataTermino);
						}
					}
					escreverDados(diretorioDB, usuarioTeste.getNomeExibicao(), "Todos", texto.toString());
				}

				case 5 -> {
					System.out.printf("Digite o nome do livro que deseja visualizar: ");
					String nome = sc.nextLine();
					estante.filtrarNome(diretorioDB, usuarioTeste.getNomeExibicao(), "Todos", nome);
				}

				case 6 -> {
					System.out.println("Digite o nome do texto que desejas excluir: ");
					String nome1 = sc.nextLine();
					estante.excluirLivro(diretorioDB, usuarioTeste.getNomeExibicao(), "Todos", nome1);
				}

				case 7 -> {
					System.out.printf("Estantes de %s", usuarioTeste.getNomeExibicao());
					for (Estante e : usuarioTeste.getListaEstantes()) {
						System.out.printf("-> %s:", e.getNome());
						for (Texto t : e.getListaTextos()) {
							System.out.printf("- %s", t.getNomeTexto());
						}
					}
				}

				case 8 -> {
				}
				case 9 -> {
					boolean pasta;
					// Tratar Estantes com o mesmo nome
					// Verificar se a estante realmente foi adicionada antes de exibir a mesagem de
					// "Estante adicionada com sucesso"
					System.out.printf("Digite o nome do Usuario: ");
					nomeUsuario = sc.nextLine();

					pasta = verificarPastaDoUsuario(diretorioDB, nomeUsuario);
					if (pasta) {
						pasta = new File(diretorioDB, nomeUsuario).mkdir();
						usuarioTeste.addEstante(new Estante(nomeUsuario)); // verificar esse metodo depois
						criarArquivoEstante(diretorioDB, nomeUsuario, "Todos"); // criando uma estante genérica
						System.out.printf("%s usuário criado com sucesso!\n", nomeUsuario);
						System.out.printf("N de Estantes do usuário: %d\n", usuarioTeste.getListaEstantes().size()); // não
																														// seria
																														// melhor
																														// arquivos?
					} else
						System.out.println("Erro ao criar Estante.");
				}
				default -> {
					System.out.println("Opcao Invalida!");
				}
			}
		} while (opcaoMenu != 0);
		sc.close();
	}

	// Pesquisar mais sobre o try com recursos
	private static void criarArquivoEstante(File diretorio, String nomeUsuario, String nomeEstante) {
		File arquivoEstante = new File(diretorio.getPath() + "\\" + nomeUsuario + "\\" + nomeEstante);
		try {
			if (arquivoEstante.createNewFile()) {
				System.out.printf(arquivoEstante.getName() + " criada com sucesso!");
			} else {
				System.out.println("Ja existe uma Estante com esse nome");
			}
		} catch (IOException e) {
			System.out.println("Erro ao criar estante.");
			e.printStackTrace(System.err);
		}
	}

	// Colocar o código de cada caso num método a parte do main
	// Adicionar uma forma de cancelar a operação, caso o usuário desista da opção
	// que foi escolhida
	// pesquisar por: nome, num de páginas, autor, editora, revista;

	// funcoes do main
	public static void menuPrincipal() {
		System.out.println("================  MENU  ==================");
		System.out.printf("DIGITE:%n" +
				"[1] - Criar Nova Estante;%n" +
				"[2] - Vizualizar Estante;%n" +
				"[3] - Excluir Estante;%n" +
				"[4] - Adicionar Texto(Livro ou Artigo) a Estante;%n" +
				"[5] - Vizualizar Texto;%n" +
				"[6] - Excluir Texto;%n" +
				"[7] - Listar Estantes;%n" +
				"[8] - Pesquisar;%n" +
				"[9] - Criar Usuário;%n" +
				"[0] - Sair;%n");
		System.out.println("==========================================");
		System.out.print("OPÇÃO: ");
	}

	// //criando e verificando pasta da estante
	// public static boolean criarPasta(File diretorio, String nome){ //::
	// referencia metodos sem invocalos (tipo arbitrário: Tipo::método), filtra os
	// arquivos dos listFiles atraves de pastas
	// File[] pastas = diretorio.listFiles(File::isDirectory);
	// for (File p : pastas){
	// if (p.getName() == nome){
	// System.out.println("Já existe um usuário com esse nome.");
	// return false; //ja existe uma pasta com o nome, portanto cria-la é falso
	// }
	// }
	// return true;
	// }

	// public static boolean verificarArquivo(File diretorio, String nome){
	// File[] arquivos = diretorio.listFiles(File::isFile);
	// for (File a : arquivos){
	// if (a.getName() == nome){
	// System.out.println("Já existe uma estante com esse nome.");
	// return false;
	// }
	// }
	// return true;
	// }

	// //funções de arquivo
	// public static void criarArquivo(File diretorio, String usuario, String
	// nomeArquivo){
	// String path = diretorio.getName() + "\\" + usuario + "\\" + nomeArquivo +
	// ".txt"; //criando o arquivo com base no nome informado pelo usuário
	// File aq = new File(path);
	// if (!aq.exists()){
	// try (FileWriter arquivo = new FileWriter(path)){
	// System.out.println(nomeArquivo + " criado com sucesso.");
	// }
	// catch (IOException e){
	// System.out.println("Erro ao criar arquivo.");
	// e.printStackTrace();
	// }
	// }
	// }

	// escrever dados no arquivo
	public static void escreverDados(File diretorio, String usuario, String estante, String dados) {
		String path = diretorio.getName() + "\\" + usuario + "\\" + estante + ".txt";
		try (BufferedWriter arquivo = new BufferedWriter(new FileWriter(path, true))) {
			arquivo.write(dados);
			arquivo.newLine();
			System.out.println("Informações salvas com sucesso.");
		} catch (IOException e) {
			System.out.println("Erro ao salvar informações.");
			e.printStackTrace(System.err); // IO exception é gerada as vezes ao tentar abrir um arquivo txt atraves do
											// scanner, por isso temos que adicionar uma execeção, ela imprime o tipo de
											// erro
		}
	}

	public static String extrairDados(File diretorio, String nomeUsuario, String nomeEstante) {
		String path = diretorio.getName() + "\\" + nomeUsuario + "\\" + nomeEstante + ".txt";
		StringBuilder dados = new StringBuilder();
		Integer i = 1;

		try (BufferedReader arquivo = new BufferedReader(new FileReader(path))) {
			String linha;
			while ((linha = arquivo.readLine()) != null) {
				// Formatar melhor esses dados
				dados.append(i.toString() + ". ").append(linha).append("\n");
			}
		} catch (IOException e) {
			System.out.println("Erro ao extrair informações");
			e.printStackTrace(System.err);
		}
		return dados.toString();
	}
}