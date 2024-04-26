import java.util.ArrayList;
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
<<<<<<< Updated upstream
=======
		String nomeEstante, nomeUsuario;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
					case 4: // Isso vai ficar mais prático numa interface gráfica
				    int opcaoC4;
					String nomeTexto, nomeAutor, nomeEditora, nomeGenero; 
					String dataPublicacao, dataInicio, dataTermino;
					boolean foiIniciado = false, foiLido = false;
					String nomeRevista, palavras;
					String[] palavrasArray;
					ArrayList<String> palavrasChave;
					int numPaginas, numEdicao;
		            System.out.printf("O que deseja adicionar? %n" + 
									  "1. Livro%n" + 
									  "2. Texto%n");
					opcaoC4 = sc.nextInt();
					sc.nextLine();
					switch (opcaoC4) {
						case 1:
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
									usuarioTeste.addTexto("TODOS", new Livro(nomeTexto, nomeAutor, dataPublicacao, dataInicio, dataTermino, numPaginas, foiLido, foiIniciado, nomeEditora, numEdicao, nomeGenero)); 	
								}
								usuarioTeste.addTexto("TODOS", new Livro(nomeTexto, nomeAutor, dataPublicacao, dataInicio, numPaginas, foiLido, foiIniciado, nomeEditora, numEdicao, nomeGenero)); 	
							}
							/* Por Enquanto, o livro vai ser adicionado na estante geral.
						       Depois, mostrar as estante disponíveis para o usuário, 
							   e perguntar em quais estantes ele deseja adicionar*/
							usuarioTeste.addTexto("TODOS", new Livro(nomeTexto, nomeAutor, dataPublicacao, numPaginas, foiLido, foiIniciado, nomeEditora, numEdicao, nomeGenero)); 
							break;
 
						case 2:
							palavrasChave = new ArrayList<String>();
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
							System.out.printf("O artigo foi Iniciado?%n1. Sim%n2. Não");
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
							System.out.printf("O artigo foi Lido?%n1. Sim%nNão");
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
								usuarioTeste.addTexto("TODOS", new Artigo(nomeTexto, nomeAutor, dataPublicacao, dataInicio, numPaginas, foiLido, foiIniciado, nomeRevista, palavrasChave));
								if (foiLido){
									System.out.printf("Digite a Data que terminou de ler(dd/mm/aa):");
									dataTermino = sc.nextLine();
									usuarioTeste.addTexto("TODOS", new Artigo(nomeTexto, nomeAutor, dataPublicacao, dataInicio, dataTermino, numPaginas, foiLido, foiIniciado, nomeRevista, palavrasChave));
								}
									
							}
							usuarioTeste.addTexto("TODOS", new Artigo(nomeTexto, nomeAutor, dataPublicacao, numPaginas, foiLido, foiIniciado, nomeRevista, palavrasChave));
							break;
						default:
							System.out.println("Opcao invalida, digite 1 ou 2");
							break;
					}
					break;
					
=======
				case 4:
					/*Adicionar novas forma de criação de livro, criação mais simples, apenas com o nome e o autor
					  Fazer uma verificação após cada entrada ser lida, se o usuário digitar 0, a operação é finalizada*/ 
					// inicializar as variáveis com seus valores padrão
					String nomeTexto, nomeAutor, nomeEditora, nomeRevista, nomeGenero, palavras, dataPublicacao, dataInicio, dataTermino;
					ArrayList<String> nomeAutores = new ArrayList<String>();
					ArrayList<String> palavrasChave = new ArrayList<String>();
					int numEdicao, numPaginas;
					int opcao, foiLido, foiIniciado;
					Texto texto = null;

					System.out.println("Deseja adicionar um Livro ou um Artigo?" + "%n1. Livro%n2. Artigo%n:");
					do {
						opcao = sc.nextInt();
						sc.nextLine(); // Remover o \n do buffer
					} while (opcao != 1 || opcao != 2);
					System.out.printf("Digite o nome do Texto que deseja adicionar: ");
					nomeTexto = sc.nextLine();
					System.out.printf("Digite o nome do Autor(es) do Texto. Separe por ',': ");
					nomeAutor = sc.nextLine();		
					sc.nextLine(); // Remover o \n do buffer
					System.out.printf("Digite a Data de Publicacao do Texto(dd/mm/aa): ");
					dataPublicacao = sc.nextLine();
					System.out.printf("Digite o Número de Páginas do Texto: ");
					numPaginas = sc.nextInt();
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
						texto = new Livro(nomeTexto, nomeAutores, dataPublicacao, numPaginas, nomeEditora, numEdicao, nomeGenero);
					} else if(opcao == 2){
						System.out.printf("Digite o nome da Revista: ");
						nomeRevista = sc.nextLine(); 
						System.out.printf("Quais sao as palavras chave? Separe por ',': ");
						palavras = sc.nextLine(); 
						// adicionando a String de palavras-chave no ArrayList
						for(String s : palavras.split(Texto.SEPARADOR_STRING)){
							palavrasChave.add(s);
						}
						texto = new Artigo(nomeTexto, nomeAutores, dataPublicacao, numPaginas, nomeRevista, palavrasChave);
					} 
					// leitura de datas
					System.out.println("O Texto foi iniciado?"+"%n1. Sim%n2. Não%n:");
					foiIniciado = sc.nextInt();
					sc.nextLine(); // Remover o \n do buffer
					if(foiIniciado == 1){
						texto.setFoiIniciado(true);
						System.out.println("O Texto foi lido?"+"%n1. Sim%n2. Não%n:");
						foiLido = sc.nextInt();
						sc.nextLine(); // Remover o \n do buffer
						System.out.println("Digite a data que começou a ler(dd/mm/aa):");
						dataInicio = sc.nextLine();
						texto.setInicioLeitura(dataInicio);
						if(foiLido == 1){
							texto.setFoiLido(true);
							System.out.println("Digite a data que terminou de ler(dd/mm/aa):");
							dataTermino = sc.nextLine(); 
							texto.setTerminoLeitura(dataTermino);
						}
					}	
					break;		
>>>>>>> Stashed changes
		        case 5:
		            System.out.printf("Digite o nome do livro que deseja visualizar: ");
					nomeTexto = sc.nextLine();

					break;
		        case 6: 
<<<<<<< Updated upstream
		            //livro.excluir
					break;
		        case 7:
		            //estante.listar
=======
		            int encontrou = 0;
		            System.out.println("Digite o nome do texto que desejas excluir: ");
		            String nome = sc.nextLine();
		            for (Estante estante : usuarioTeste.getListaEstantes()){
		                for (Texto t : estante.getListaTextos()){
		                    if (nome.compareTo(t.getNomeTexto()) == 0){
		                        encontrou = 1;
		                        
		                        System.out.println("Texto encontrado na estante " + estante.getNome());
		                        
		                        estante.removerTexto(t);
		                        
		                        System.out.println("Texto excluido!");
		                    }
		                }
		            }
		            if (encontrou == 0){
		                System.out.println("Texto nao encontrado");
		            }
					break;
		        case 7:
		           		System.out.printf("Estantes de %s", usuarioTeste.getNomeExibicao());
					for (Estante estante : usuarioTeste.getListaEstantes()) {
						System.out.printf("-> %s:", estante.getNome());
						for (Texto t : estante.getListaTextos()) {
							System.out.printf("- %s", t.getNomeTexto());
						}
					}
>>>>>>> Stashed changes
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
	public static boolean verificarPasta(File diretorio, String nome){ //:: referencia metodos sem invocalos (tipo arbitrário: Tipo::método), filtra os arquivos dos listFiles atraves de pastas
		File[] pastas = diretorio.listFiles(File::isDirectory);
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
<<<<<<< Updated upstream
}
=======

	//public static Texto criarTexto(){}
}
>>>>>>> Stashed changes
