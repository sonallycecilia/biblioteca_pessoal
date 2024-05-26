package classes.entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import classes.models.Texto;

public class Estante {
    // atributos
    private String nome;

    // construtor
    public Estante (String nome){
        this.nome = nome;
    }

    //arquivos
    public String mostrarTextosEstante(File diretorio, String estante) {
		String caminho = diretorio.getName() + "\\" + estante + ".txt";
		StringBuilder dados = new StringBuilder();
		try (BufferedReader arquivo = new BufferedReader(new FileReader(caminho))) {
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

    public static void escreverDadosEstante(File diretorio, String estante, String dados){
		String caminho = diretorio.getName() + "\\" + estante + ".txt";
		try (BufferedWriter arquivo = new BufferedWriter(new FileWriter(caminho, true))){
			arquivo.write(dados);
			arquivo.newLine();
			System.out.println("Informações salvas com sucesso.");
		}
		catch (IOException e){
			System.out.println("Erro ao salvar informações.");
			e.printStackTrace(); //IO exception é gerada as vezes ao tentar abrir um arquivo txt atraves do scanner, por isso temos que adicionar uma execeção, ela imprime o tipo de erro
		}
	}

    public void excluirLivro(File diretorio, String estante, String nome){
        String path = diretorio.getName() + "\\" + estante + ".txt";
        String pathTemp = diretorio.getName() + "\\" + estante + "Temp.txt";
        String linha;
        boolean achou = false;
    
        try (BufferedReader arquivo = new BufferedReader(new FileReader(path));
             BufferedWriter arquivoTemp = new BufferedWriter(new FileWriter(pathTemp))) {
            while (((linha = arquivo.readLine()) != null)) {
                String[] dados = linha.split(" \\| ");
                if (dados[0].equals(nome)){
                    System.out.printf("Texto encontrado na estante: %s%n", estante);
                    achou = true;
                    continue; 
                }
                else{
                    arquivoTemp.write(linha);
                    arquivoTemp.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler dados do arquivo.");
            e.printStackTrace();
        }
        if (!achou){
            System.out.println("Texto não encontrado.");
        }
        else{
            File arquivoOriginal = new File(path);
            File arquivoTemporario = new File(pathTemp);
            if (arquivoOriginal.delete()){
                arquivoTemporario.renameTo(arquivoOriginal);      
            }
            else{
                System.out.println("Erro na substituição de arquivos.");
            }
        }
    }

    //filtros
    public void exibirTexto(String[] dados){
        System.out.println("=========================================");
        System.out.printf("Nome: " + dados[0] +
        "%nAutor: " + dados[1] + 
        "%nPublicação: " + dados[2] + 
        "%nInicio da leitura: " + dados[3] + 
        "%nTermino da leitura: " + dados[4] + 
        "%nNúmero de páginas: " + dados[5] + 
        "%nStatus: " + dados[6] + "%n");
        System.out.println("=========================================");
        
    }

    public void filtrarNome(File diretorio, String estante, String nome) {
		String path = diretorio.getName() + "\\" + estante + ".txt";
        String linha;
        boolean achou = false;

		try (BufferedReader arquivo = new BufferedReader(new FileReader(path))) {
			while (((linha = arquivo.readLine()) != null) || achou == false) {
                String[] dados = linha.split(" \\| ");
				if (dados[0].equals(nome)){
                    System.out.printf("Texto encontrado na estante: %s%n", estante);
                    exibirTexto(dados);
                    achou = true;
                }
			}
		} catch (IOException e) {
			System.out.println("Erro ao extrair informações.");
			e.printStackTrace();
		}
        if (!achou){
            System.out.println("Texto não encontrado.");
        }
	}

    public void filtrarAutor(File diretorio, String estante, String autor) {
		String path = diretorio.getName() + "\\" + estante + ".txt";
        String linha;
        boolean achou = false;

		try (BufferedReader arquivo = new BufferedReader(new FileReader(path))) {
			while (((linha = arquivo.readLine()) != null) || achou == false) {
                String[] dados = linha.split(" \\| ");
				
                if (dados[1].equals(autor)){
                    System.out.printf("Texto encontrado na estante: %s%n", estante);
                    exibirTexto(dados);
                    achou = true;
                }

                String[] autores = dados[1].split(","); //se houver mais de 1
                for (String a : autores){
                    if(a.equals(autor)){
                        System.out.printf("Texto encontrado na estante: %s%n", estante);
                        exibirTexto(dados);
                        achou = true;
                    }
                }
			}
		} catch (IOException e) {
			System.out.println("Erro ao extrair informações.");
			e.printStackTrace();
		}
        if (!achou){
            System.out.println("Texto não encontrado.");
        }
	}

    // setters e getters
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public ArrayList<Texto> getListaTextos() {
        return listaTextos;
    }
}
