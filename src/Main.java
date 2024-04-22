import java.util.Scanner;

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
		
		Usuario usuarioTeste = new Usuario("Teste", "admin", "123");

	    System.out.printf("========== BIBLIOTECA PESSOAL ==========%n" +
		                  "|          Seja bem-vindo(a)!          |%n" +
		                  "========================================%n");
		System.out.println();
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
		            break;
		        case 1:
					String nomeC1;
					// Tratar Estantes com o mesmo nome 
					// Verificar se a estante realmente foi adicionada antes de exibir a mesagem de "Estante adicionada com sucesso"
					System.out.printf("Digite o nome da Estante: ");
                    nomeC1 = sc.nextLine();
					usuarioTeste.addEstante(new Estante(nomeC1));
					System.out.printf("%s adicionada com sucesso!\n", nomeC1);
					System.out.printf("N de Estantes do usuário: %d\n", usuarioTeste.getListaEstantes().size());
					break;
		        case 2:
					String nomeC2;
					System.out.printf("Digite o nome da estante que desaja visualizar: ");
					nomeC2 = sc.nextLine();
					usuarioTeste.buscarEstante(nomeC2).mostrarTextos();
					break;
		        case 3: 
					String nomeC3;
					System.out.printf("Digite o nome da estante que desaja visualizar: ");
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
							String nomeLivro, nomeAutor, nomeEditora, nomeGenero, dataPublicacao, dataInicio, dataTermino;
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
							sc.nextLine();
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
							sc.nextLine();
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
							// Criar um construtor sem essas informações
							if (foiIniciado){
								System.out.printf("Digite a Data que comecou a ler(dd/mm/aa):%n Se ainda não começou a ler deixe em branco");
								dataInicio = sc.nextLine();	
							}
							if (foiIniciado && foiLido){
								System.out.printf("Digite a Data que terminou de ler(dd/mm/aa):%n Se ainda não terminou a ler deixe em branco");
							}
							// Criar livro e adicionar a estante;
							break;

						case 2:
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
}


