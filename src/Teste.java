import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        System.out.println("programa iniciado");
        ArrayList<String> nomeAutores = new ArrayList<String>();
        String nomeAutor;
        Scanner sc = new Scanner(System.in);
    
        nomeAutor = sc.nextLine();
        nomeAutores.add(nomeAutor);
        mostrarAutores(nomeAutores);    

        sc.close();
    }

    private static void mostrarAutores(ArrayList<String> nomeAutores) {
        for(String s : nomeAutores){
            System.out.printf("ArrayList: ");
            System.out.println(s);
        }
    }
}
