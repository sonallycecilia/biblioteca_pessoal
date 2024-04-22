import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Fazer o javadoc
public abstract class Main{
	public static void main(String[] args) {
		/*Criação do usuário
		 * puxar dados com as informações do usuário de um arquivo txt(temporariamente)
		 * utilizar uma API de bando de dados depois
		 * Vou criar um usuario para fins de teste
		 */
		 // Talvez isso mude se o escopo de cada operação for redirecionado para um método à parte
		Scanner sc = new Scanner(System.in);
		File diretorioDB = new File(System.getProperty("user.dir") + "\\database\\"); //caminho absoluto
		Usuario usuarioTeste = new Usuario("Teste", "admin", "123");

	    System.out.printf("%n========== BIBLIOTECA PESSOAL ==========%n" +
		                  "|           Seja bem-vindo(a)!         |%n" +
		                  "========================================%n");
		System.out.println();
		System.out.println(diretorioDB);

		int opcaoMenu;
			do{
				menuPrincipal();
				opcaoMenu = sc.nextInt();
				sc.nextLine(); // Ler o \n do buffer para remover da próxima leitura;
				// Limpar a tela e reprintar o menu;
		    	switch(opcaoMenu){
				// Colocar o código de cada caso num método a parte do main
				// Adicionar uma forma de cancelar a operação, caso o usuário desista da opção que foi escolhida
		        case 0:
					System.out.println("Programa encerrado!");
		            break;

		        case 1:
					String nomeC1;
					boolean pasta;
					// Tratar Estantes com o mesmo nome 
					// Verificar se a estante realmente foi adicionada antes de exibir a mesagem de "Estante adicionada com sucesso"
					System.out.printf("Digite o nome da Estante: ");
                    nomeC1 = sc.nextLine();
					
					pasta = verificarPasta(diretorioDB, nomeC1);
					if (pasta){
						pasta = new File(diretorioDB + "\\" + nomeC1).mkdir();
						usuarioTeste.addEstante(new Estante(nomeC1));
						System.out.printf("%s adicionada com sucesso!\n", nomeC1);
						System.out.printf("N de Estantes do usuário: %d\n", usuarioTeste.getListaEstantes().size());
					}
					else {
						System.out.println("Erro ao criar Estante.");
					}

					break;

		        case 2:
					String nomeC2;
					System.out.printf("Digite o nome da estante que deseja visualizar: ");
					nomeC2 = sc.nextLine();
					usuarioTeste.buscarEstante(nomeC2).mostrarTextos();
					break;

		        case 3: 
					String nomeC3;
					System.out.printf("Digite o nome da estante que desaja remover: ");
					nomeC3 = sc.nextLine();
					usuarioTeste.getListaEstantes().remove(usuarioTeste.buscarEstante(nomeC3));
					break;

					case 4: // Isso vai ficar mais prático numa interface gráfica
				    int opcaoC4;
		            System.out.printf("O que deseja adicionar? %n" + 
									  "1. Livro%n" + 
									  "2. Texto%n");
					opcaoC4 = sc.nextInt();
					sc.nextLine();
					switch (opcaoC4) {
						case 1:
							String nomeLivro, nomeAutor, nomeEditora, nomeGenero; 
							String dataPublicacao, dataInicio, dataTermino;
							int numPaginas, numEdicao;
							boolean foiIniciado = false, foiLido = false;
							System.out.printf("Digite o nome do Livro que deseja adicionar: ");
							nomeLivro = sc.nextLine();
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
							System.out.printf("O livro foi Iniciado?%n1. Sim%n2. Não");
							switch (sc.nextInt()) {
								case 1:
									foiIniciado = true;
									break;
								case 2:
									foiIniciado = false;
									break;
							
								default:
									System.out.println("Opcao Invalida, digite 1 ou 2");
									break;
							}
							sc.nextLine(); // Remover o \n do buffer
							System.out.printf("O livro foi Lido?%n1. Sim%nNão");
							switch (sc.nextInt()) {
								case 1:
									foiLido = true;
									break;
								case 2:
									foiLido = false;
									break;
								default:
									System.out.println("Opcao Invalida, digite 1 ou 2");
									break;
							}
							sc.nextLine();// Remover o \n do buffer
							// Criar um construtor sem essas informações
							if (foiIniciado){
								System.out.printf("Digite a Data que comecou a ler(dd/mm/aa):");
								dataInicio = sc.nextLine();
								if (foiLido){
									System.out.printf("Digite a Data que terminou de ler(dd/mm/aa):");
									dataTermino = sc.nextLine();
									usuarioTeste.addTexto("TODOS", new Livro(nomeLivro, nomeAutor, dataPublicacao, dataInicio, dataTermino, numPaginas, foiLido, foiIniciado, nomeEditora, numEdicao, nomeGenero)); 	
								}
								usuarioTeste.addTexto("TODOS", new Livro(nomeLivro, nomeAutor, dataPublicacao, dataInicio, numPaginas, foiLido, foiIniciado, nomeEditora, numEdicao, nomeGenero)); 	
							}
							/* Por Enquanto, o livro vai ser adicionado na estante geral.
						       Depois, mostrar as estante disponíveis para o usuário, 
							   e perguntar em quais estantes ele deseja adicionar*/
							usuarioTeste.addTexto("TODOS", new Livro(nomeLivro, nomeAutor, dataPublicacao, numPaginas, foiLido, foiIniciado, nomeEditora, numEdicao, nomeGenero)); 
							break;
 
						case 2:
							// Cadastrar um artigo
							break;
						default:
							System.out.println("Opcao invalida, digite 1 ou 2");
							break;
					}
					break;
					
		        case 5:
		            //livro.visualizar
					break;
		        case 6: 
		            //livro.excluir
					break;
		        case 7:
		            //estante.listar
					break;
		        case 8: 
		            //pesquisar por: nome, num de páginas, autor, editora, revista;
					break; 
				default:
					System.out.println("Opcao Invalida!");
					break;
		    }
		}while (opcaoMenu != 0);
		sc.close();
	}

	//funcoes do main
	public static void menuPrincipal(){
		System.out.println("===============  MENU  =================");
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
		System.out.print("Opcao: ");
	}

	//criando e verificando pasta da estante
	public static boolean verificarPasta(File diretorio, String nome){
		File[] pastas = diretorio.listFiles(File::isDirectory); //:: referencia metodos sem invocalos (tipo arbitrário: Tipo::método), filtra os arquivos dos listFiles atraves de pastas
			for (File p : pastas){
				if (p.getName() == nome){
					System.out.println("Já existe uma estante com esse nome.");
					return false; //ja existe uma pasta com o nome, portanto cria-la é falso						
				}
			}
			return true;
	}

	//funções de arquivo
	public static void criarArquivo(File diretorio, String nome){
		String path = diretorio.getName() + nome + ".txt"; //criando o arquivo com base no nome informado pelo usuário
		File aq = new File(path);
		if (!aq.exists()){
			try (FileWriter arquivo = new FileWriter(path)){
				System.out.println("Arquivo criado com sucesso.");
			}
			catch (IOException e){
				System.out.println("Erro ao criar arquivo.");
				e.printStackTrace();
			}
		}
	}

	//escrever dados no arquivo
	public static void escreverDados(File diretorio, String nome, String dados){
		String path = diretorio.getName() + nome;
		try (BufferedWriter arquivo = new BufferedWriter(new FileWriter(path, true))){
			arquivo.write(dados);
			arquivo.newLine();
			System.out.println("Informações salvas com sucesso.");
		}
		catch (IOException e){
			System.out.println("Erro ao salvar informações.");
			e.printStackTrace(); //IO exception é gerada as vezes ao tentar abrir um arquivo txt atraves do scanner, por isso temos que adicionar uma execeção, ela imprime o tipo de erro
		}
	}
}