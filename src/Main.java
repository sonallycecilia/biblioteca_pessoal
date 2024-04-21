import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	    System.out.printf("========== BIBLIOTECA PESSOAL ==========%n" +
		                  "|          Seja bem-vindo(a)!          |%n" +
		                  "========================================%n");
		System.out.println();

		int opcao = 1;
		Scanner sc = new Scanner(System.in);

		do{
			menuPrincipal();
		    opcao = sc.nextInt();
			System.out.println();

		    switch(opcao){
		        case 0:
		            break;
		        case 1:
                    String nome = sc.nextLine();
		            Estante estante = new Estante(nome); 
		        case 2:
		            //estante.visualizar;
		        case 3: //Thales faz
		            //estante.excluir
		        case 4:
		            //livro.add
		        case 5:
		            //livro.visualizar
		        case 6: 
		            //livro.excluir
		        case 7:
		            //estante.listar
		        case 8:
		            //pesquisar;
		    }
		}while (opcao != 0);
	}

	//funcoes do main
	public static void menuPrincipal(){
		System.out.println("===============  MENU  =================");
		System.out.printf("DIGITE:%n" +
						"[1] - Criar Nova Estante;%n" +
						"[2] - Vizualizar Estante;%n" +
						"[3] - Excluir Estante;%n" +
						"[4] - Adicionar Livro a Estante;%n" +
						"[5] - Vizualizar Livro;%n" +
						"[6] - Excluir Livro;%n" +
						"[7] - Listar Estantes;%n" +
						"[8] - Pesquisar na Estante;%n" +
						"[0] - Sair;%n");
		System.out.print("Opcao: ");
	}
}


