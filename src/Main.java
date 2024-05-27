import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import classes.entities.Estante;
import classes.entities.Usuario;
import classes.enums.StatusTexto;
import classes.models.Artigo;
import classes.models.Livro;
import classes.models.Texto;

public abstract class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	    System.out.printf("%n===========  BIBLIOTECA PESSOAL ===========%n" +
		                  "=            Seja bem-vindo(a)!           =%n" +
		                  "===========================================%n");
		System.out.println();

		int opcaoMenu;
		do{
			menuLogin();
			opcaoMenu = sc.nextInt();
			sc.nextLine();

			if (opcaoMenu == 1){
				String nomeUsuario;
				File diretorioDB = new File(System.getProperty("user.dir") + "\\database\\usuarios\\");
				System.out.printf("Digite o nome do Usuario: ");
				nomeUsuario = sc.nextLine();

				Usuario.criarPastaUsuario(diretorioDB, nomeUsuario);
			}

			if(opcaoMenu == 2){
				String nomeLogin, senhaLogin;
				System.out.print("Digite o Login: ");
				nomeLogin = formatarEntrada(sc.nextLine());
				System.out.print("Digite a senha: ");
				senhaLogin = formatarEntrada(sc.nextLine());

				Usuario usuario = new Usuario("nomeLogin", "senhaLogin");
				File diretorioDB = new File(System.getProperty("user.dir") + "\\database\\usuarios\\" + nomeLogin);
			
				do{
					menuPrincipal();
					opcaoMenu = sc.nextInt();
					sc.nextLine(); // Ler o \n do buffer 
		    		switch(opcaoMenu){
		        	case 0:
						System.out.println("Programa encerrado!");
		            	break;
					
					case 1:// criar estante
						String nomeEstante;
						System.out.printf("Digite o nome da Estante: ");
						nomeEstante = formatarEntrada(sc.nextLine());
						Estante.verificarPastaDoUsuario(diretorioDB, nomeEstante); //verificando se existe estante
						if (arquivo){
							Estante.criarArquivo(diretorioDB, nomeEstante);
							System.out.printf("'%s' estante adicionada com sucesso para o usuario '%s'!\n", nomeEstante, usuario.getLogin());
						}
						else 
							System.out.println("Erro ao criar Estante.");
	
						break;

		        case 2:
					System.out.printf("Digite o nome da estante que deseja visualizar: ");
					nomeEstante = sc.nextLine();
					System.out.printf(Estante.mostrarTextos(diretorioDB, nomeEstante));
					break;

		        case 3: 
					// Arrumar isso aqui, ta prestando não
					String nomeC3;
					System.out.printf("Digite o nome da estante que desaja remover: ");
					nomeC3 = sc.nextLine();
					break;

				case 4:
					/*Adicionar novas forma de criação de livro, criação mais simples, apenas com o nome e o autor
					  Fazer uma verificação após cada entrada ser lida, se o usuário digitar 0, a operação é finalizada*/ 
					// inicializar as variáveis com seus valores padrão
					String nomeTexto, nomeAutor, nomeEditora, nomeRevista, nomeGenero, palavras;
					String dataPublicacao, dataInicio, dataTermino;
					StatusTexto status;
					ArrayList<String> nomeAutores = new ArrayList<String>();
					ArrayList<String> palavrasChave = new ArrayList<String>();
					int numEdicao, numPaginas;
					int opcao;
					Texto texto = null;

					do {
						System.out.printf("Deseja adicionar um Livro ou um Artigo?" + 
									  "%n[1] Livro" +
									  "%n[2] Artigo: ");
						opcao = sc.nextInt();
					} while (opcao != 1 && opcao != 2);
					sc.nextLine();
					System.out.printf("Digite o nome do Texto que deseja adicionar: ");
					nomeTexto = sc.nextLine();
					System.out.printf("Digite o nome do Autor(es) do Texto. Separe por ',': ");
					nomeAutor = sc.nextLine();		
					System.out.printf("Digite a Data de Publicacao do Texto (dd/mm/aaaa): ");
					dataPublicacao = sc.nextLine();
					System.out.printf("Digite o Número de Páginas do Texto: ");
					numPaginas = sc.nextInt();

					do {
						System.out.printf("Qual o status do texto?" + 
									  "%n[0] Não lido;" +
									  "%n[1] Lendo;" +
									  "%n[2] Lido;" +
									  "%n[3] Abandonado" +
									  "%n[4] Emprestado: ");
						status = StatusTexto.values()[sc.nextInt()];
					} while (status.ordinal() < 0 && status.ordinal() > 4);
					sc.nextLine(); //limpando buffer
					
					if(opcao == 1){
						System.out.printf("Digite o nome da Editora: ");
						nomeEditora = sc.nextLine();
						System.out.printf("Qual o numero da edicao? ");
						numEdicao = sc.nextInt();
						sc.nextLine(); // Remover o \n do buffer
						System.out.printf("Qual é o gênero do livro? : ");
						nomeGenero = sc.nextLine();

						// adicionando a String de nome dos autores no ArrayList
						for(String s : nomeAutor.split(Texto.SEPARADOR_STRING)){
							nomeAutores.add(s);
						}
						//adicionando sem inicio e fim
						texto = new Livro(nomeTexto, nomeAutores, dataPublicacao, numPaginas, status, nomeEditora, numEdicao, nomeGenero);

					} else if(opcao == 2){
						System.out.printf("Digite o nome da Revista: ");
						nomeRevista = sc.nextLine(); 
						System.out.printf("Quais sao as palavras chave? Separe por ',': ");
						palavras = sc.nextLine(); 
						// adicionando a String de palavras-chave no ArrayList
						for(String s : palavras.split(Texto.SEPARADOR_STRING)){
							palavrasChave.add(s);
						}
						texto = new Artigo(nomeTexto, nomeAutores, dataPublicacao, numPaginas, status, nomeRevista, palavrasChave);
					} 

					if((status.ordinal()) != 0){ //se foi iniciado
						System.out.println("Digite a data que começou a ler(dd/mm/aa):");
						dataInicio = sc.nextLine();
						texto.setInicioLeitura(dataInicio);
						if((status.ordinal()) == 2){ //se foi lido
							System.out.println("Digite a data que terminou de ler(dd/mm/aa):");
							dataTermino = sc.nextLine(); 
							texto.setTerminoLeitura(dataTermino);
						}
					}	

					Estante.escreverDados(diretorioDB, "Todos", texto.toString());
					break;		
		        
				case 5:
		            System.out.printf("Digite o nome do livro que deseja visualizar: ");
					String nome = sc.nextLine();
					Estante.filtrarNome(diretorioDB, "Todos", nome);

					break;
				case 6: 
					System.out.println("Digite o nome do texto que desejas excluir: ");
					String nome1 = sc.nextLine();
					Estante.excluirLivro(diretorioDB, "Todos", nome1);
					
					break;
		        case 7:
					break;
		        case 8: 
		            //pesquisar por: nome, num de páginas, autor, editora, revista;
				break;
		}while (opcao != 0);
	}

	//funcoes do main
	public static void menuLogin(){
		System.out.println("================  LOGIN  ==================");
		System.out.printf("[0] - Sair%n" +
						  "[1] - Criar Usuario%n" +
						  "[2] - Logar%n");
		System.out.println("===========================================");
		System.out.print("OPCAO: ");

	}

	public static void menuPrincipal(){
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
						"[0] - Sair;%n");
		System.out.println("==========================================");
		System.out.print("OPCAO: ");
	}

	public static String formatarEntrada(String entrada){
		entrada.replaceAll("\\s+", "");
		entrada.toUpperCase();
		return entrada;
	}
}