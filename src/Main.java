import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import classes.entities.Estante;
import classes.entities.Usuario;
import classes.enums.StatusTexto;
import classes.models.Artigo;
import classes.models.Livro;
import classes.models.Texto;
import database.mysql.DAO.UsuarioDAO;

public abstract class Main{
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat padrao = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		File diretorioDB = new File(System.getProperty("user.dir") + "\\database\\usuarios\\"); //caminho absoluto
		Usuario usuarioTeste = new Usuario("Naly", "admin", "123");
		new UsuarioDAO().cadastrarUsuario(usuarioTeste);

	    System.out.printf("%n========== BIBLIOTECA PESSOAL ==========%n" +
		                  "=          Seja bem-vindo(a)!          =%n" +
		                  "========================================%n");
		System.out.println();

		int opcaoMenu;
		String nomeEstante, nomeUsuario;
		Estante estante = new Estante("Estante");
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
					
					arquivo = verificarPastaDoUsuario(diretorioDB, nomeEstante); //verificando se existe estante
					if (arquivo){
						criarArquivo(diretorioDB, usuarioTeste.getNome(), nomeEstante);
						usuarioTeste.addEstante(new Estante(nomeEstante));
						System.out.printf("'%s' estante adicionada com sucesso!\n", nomeEstante);
						System.out.printf("N de Estantes do usuário: %d\n", usuarioTeste.getListaEstantes().size()); //arrumar isso
					}
					else 
						System.out.println("Erro ao criar Estante.");
	
				break;

		        case 2:
					// Arrumar isso aqui, ta prestando não
					System.out.printf("Digite o nome da estante que deseja visualizar: ");
					nomeEstante = sc.nextLine();
					System.out.printf(extrairDadosArquivo(diretorioDB, usuarioTeste.getNome(), nomeEstante));
					break;

		        case 3: 
					// Arrumar isso aqui, ta prestando não
					String nomeC3;
					System.out.printf("Digite o nome da estante que desaja remover: ");
					nomeC3 = sc.nextLine();
					usuarioTeste.getListaEstantes().remove(usuarioTeste.buscarEstante(nomeC3));
					break;

				case 4:
					/*Adicionar novas forma de criação de livro, criação mais simples, apenas com o nome e o autor
					  Fazer uma verificação após cada entrada ser lida, se o usuário digitar 0, a operação é finalizada*/ 
					// inicializar as variáveis com seus valores padrão
					String nomeTexto, nomeAutor, nomeEditora, nomeRevista, nomeGenero, palavras;
					Date dataPublicacao, dataInicio, dataTermino;
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
					dataPublicacao = padrao.parse(sc.nextLine());
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
						dataInicio = padrao.parse(sc.nextLine());
						texto.setInicioLeitura(dataInicio);
						if((status.ordinal()) == 2){ //se foi lido
							System.out.println("Digite a data que terminou de ler(dd/mm/aa):");
							dataTermino = padrao.parse(sc.nextLine()); 
							texto.setTerminoLeitura(dataTermino);
						}
					}	

					escreverDados(diretorioDB, usuarioTeste.getNome(), "Todos", texto.toString());
					break;		
		        
					case 5:
					
		            System.out.printf("Digite o nome do livro que deseja visualizar: ");
					String nome = sc.nextLine();
					estante.filtrarNome(diretorioDB, usuarioTeste.getNome(), "Todos", nome);

					break;
				case 6: 
					System.out.println("Digite o nome do texto que desejas excluir: ");
					String nome1 = sc.nextLine();
					estante.excluirLivro(diretorioDB, usuarioTeste.getNome(), "Todos", nome1);
					
					break;
		        case 7:
		           		System.out.printf("Estantes de %s", usuarioTeste.getNome());
					for (Estante e : usuarioTeste.getListaEstantes()) {
						System.out.printf("-> %s:", e.getNome());
						for (Texto t : e.getListaTextos()) {
							System.out.printf("- %s", t.getNomeTexto());
						}
					}
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
					
					pasta = verificarPastaDoUsuario(diretorioDB, nomeUsuario);
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

	//criando e verificando pasta da estante
	public static boolean verificarPastaDoUsuario(File diretorio, String nome){ //:: referencia metodos sem invocalos (tipo arbitrário: Tipo::método), filtra os arquivos dos listFiles atraves de pastas
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
		String path = diretorio.getName() + "\\" + usuario + "\\" + estante + ".txt";
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

	public static String extrairDadosArquivo(File diretorio, String usuario, String estante) {
		String path = diretorio.getName() + "\\" + usuario + "\\" + estante + ".txt";
		StringBuilder dados = new StringBuilder();
		
		try (BufferedReader arquivo = new BufferedReader(new FileReader(path))) {
			String linha;
			while ((linha = arquivo.readLine()) != null) {
				dados.append(linha).append("\n");
			}
		} catch (IOException e) {
			System.out.println("Erro ao extrair informações");
			e.printStackTrace();
		}
		return dados.toString();
	}
}