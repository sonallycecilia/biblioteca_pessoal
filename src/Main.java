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

		int opcaoMenu;
		String nomeEstante;
		Livro livro;
		Artigo artigo;
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
					boolean pasta;
					// Tratar Estantes com o mesmo nome 
					// Verificar se a estante realmente foi adicionada antes de exibir a mesagem de "Estante adicionada com sucesso"
					System.out.printf("Digite o nome da Estante: ");
                    nomeEstante = sc.nextLine();
					
					pasta = verificarPasta(diretorioDB, nomeEstante);
					if (pasta){
						pasta = new File(diretorioDB, nomeEstante).mkdir();
						usuarioTeste.addEstante(new Estante(nomeEstante));
						criarArquivo(diretorioDB, nomeEstante, "Todos");
						criarArquivo(diretorioDB, nomeEstante, "Favoritos");
						System.out.printf("%s adicionada com sucesso!\n", nomeEstante);
						System.out.printf("N de Estantes do usuário: %d\n", usuarioTeste.getListaEstantes().size()); //não seria melhor arquivos?
					}
					else 
						System.out.println("Erro ao criar Estante.");
		
					break;

		        case 2:
					System.out.printf("Digite o nome da estante que deseja visualizar: ");
					nomeEstante = sc.nextLine();
					usuarioTeste.buscarEstante(nomeEstante).mostrarTextos();
					break;

		        case 3: 
					System.out.printf("Digite o nome da estante que desaja remover: ");
					nomeEstante = sc.nextLine();
					usuarioTeste.getListaEstantes().remove(usuarioTeste.buscarEstante(nomeEstante));
					break;

					case 4:
					System.out.printf("O que deseja adicionar? %n" + 
									  "[1] - Livro%n" + 
									  "[2] - Texto%n");
  					opcaoMenu = sc.nextInt();
  					sc.nextLine();
					if (opcaoMenu == 1){ 
						livro = Livro.criarLivro(sc);
						if (livro != null){
							usuarioTeste.addTexto("Todos", livro);
							System.out.println(livro);
							//logica de adicionar
						}
						else
							System.out.println("Erro ao criar livro.");
					}
					if (opcaoMenu == 2){
						artigo = Artigo.criarArtigo(sc);

						if (artigo != null){
							usuarioTeste.addTexto("Todos", artigo);
							System.out.println(artigo);
						}
						else
							System.out.println("Erro ao criar artigo.");
					}
					else 
						System.out.println("Opcao Invalida, digite 1 ou 2");

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
	public static void criarArquivo(File diretorio, String nomeEstante, String nomeArquivo){
		String path = diretorio.getName() + "\\" + nomeEstante + "\\" + nomeArquivo + ".txt"; //criando o arquivo com base no nome informado pelo usuário
		File aq = new File(path);
		if (!aq.exists()){
			try (FileWriter arquivo = new FileWriter(path)){
				System.out.println(nomeArquivo + " criado com sucesso.");
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