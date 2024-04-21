import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    System.out.println("========== BIBLIOTECA PESSOAL ==========");
		System.out.println("Seja bem-vindo(a)!!!!!");
		
		int opcao = 1;
		int i = 0;
		do{
            System.out.print("Digite uma opção:");
            Scanner sc = new Scanner(System.in);
		    opcao = sc.nextInt();
		    switch(opcao){
		        case 0:
		            break;
		        case 1:
                    String nome = sc.nextLine();
		            Estante(nome); 
		        case 2:
		            estante.visualizar
		        case 3: //Thales faz
		            estante.excluir
		        case 4:
		            livro.add
		        case 5:
		            livro.visualizar
		        case 6: 
		            livro.excloi
		        case 7:
		            estante.listar
		        case 8:
		            pesquisar
		    }
		}while (opcao != 0);
	}
}
