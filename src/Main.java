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
		Usuario usuarioTeste = new Usuario("naly", "admin", "123");

	    System.out.printf("%n========== BIBLIOTECA PESSOAL ==========%n" +
		                  "|           Seja bem-vindo(a)!         |%n" +
		                  "========================================%n");
		System.out.println();

		int opcaoMenu;
		String nomeEstante, nomeUsuario;
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

		        case 1:// Tratar Estantes com o mesmo nome 
					boolean arquivo;
					System.out.printf("Digite o nome da Estante: ");
                    nomeEstante = sc.nextLine();
					
					arquivo = verificarPasta(diretorioDB, nomeEstante);
					if (arquivo){
						criarArquivo(diretorioDB, usuarioTeste.getNomeExibicao(), nomeEstante);
						usuarioTeste.addEstante(new Estante(nomeEstante));
						System.out.printf("'%s' estante adicionada com sucesso!\n", nomeEstante);
						System.out.printf("N de Estantes do usuário: %d\n", usuarioTeste.getListaEstantes().size()); //arrumar isso
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
							usuarioTeste.addTexto("Todos", livro); //arrumar esse metodo
							System.out.println(livro + livro.toString());
							escreverDados(diretorioDB, usuarioTeste.getNomeExibicao(), "Todos", livro.toString());
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
		            int encontrou = 0;
		            System.out.println("Digite o nome do texto que desejas excluir: ");
		            String nome = sc.nextLine();
		            for (Estante estante : usuario.getListaEstantes()){
		                for (Texto texto : estante){
		                    if (nome.compareTo(texto.getNomeTexto()) == 0){
		                        encontrou = 1;
		                        
		                        System.ou.println("Texto encontrado na estante " + estante.getNome())
		                        
		                        estante.removerTexto(texto);
		                        
		                        System.out.println("Texto excluido!");
		                    }
		                }
		            }
		            if (encontrou == 0){
		                System.out.println("Texto nao encontrado");
		            }
					break;
		        case 7:
		            //estante.listar
					break;
		        case 8: 
		            //pesquisar por: nome, num de páginas, autor, editora, revista;
					break;
				case 9:
					boolean pasta;
					// Tratar Estantes com o mesmo nome 
					// Verificar se a estante realmente foi adicionada antes de exibir a mesagem de "Estante adicionada com sucesso"
					System.out.printf("Digite o nome do Usuario: ");
                    nomeUsuario = sc.nextLine();
					
					pasta = verificarPasta(diretorioDB, nomeUsuario);
					if (pasta){
						pasta = new File(diretorioDB, nomeUsuario).mkdir();
						usuarioTeste.addEstante(new Estante(nomeUsuario)); //verificar esse metodo depois
						criarArquivo(diretorioDB, nomeUsuario, "Todos"); //criando uma estante genérica
						System.out.printf("%s usuário criado com sucesso!\n", nomeUsuario);
						System.out.printf("N de Estantes do usuário: %d\n", usuarioTeste.getListaEstantes().size()); //não seria melhor arquivos?
					}
					else 
						System.out.println("Erro ao criar Estante.");

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
						"[9] - Criar Usuário;%n" +
						"[0] - Sair;%n");
		System.out.print("Opcao: ");
	}

	//criando e verificando pasta da estante
	public static boolean verificarPasta(File diretorio, String nome){ //:: referencia metodos sem invocalos (tipo arbitrário: Tipo::método), filtra os arquivos dos listFiles atraves de pastas
		File[] pastas = diretorio.listFiles(File::isDirectory);
		for (File p : pastas){
				if (p.getName() == nome){
					System.out.println("Já existe um usuário com esse nome.");
					return false; //ja existe uma pasta com o nome, portanto cria-la é falso						
				}
			}
			return true;
	}

	public static boolean verificarArquivo(File diretorio, String nome){
		File[] arquivos = diretorio.listFiles(File::isFile);
		for (File a : arquivos){
			if (a.getName() == nome){
				System.out.println("Já existe uma estante com esse nome.");
				return false;
			}
		}
		return true;
	}

	//funções de arquivo
	public static void criarArquivo(File diretorio, String usuario, String nomeArquivo){
		String path = diretorio.getName() + "\\" + usuario + "\\" + nomeArquivo + ".txt"; //criando o arquivo com base no nome informado pelo usuário
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
	public static void escreverDados(File diretorio, String usuario, String estante, String dados){
		String path = diretorio.getName() + "\\" + usuario + "\\" + estante;
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
