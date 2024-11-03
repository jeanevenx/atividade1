package m2matrizes;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        
        System.out.println("[==========================================]");
        System.out.println(" CALCULADOR DE PRODUTO ENTRE DUAS MATRIZES");
        System.out.println("[==========================================]");
        
        var linhaMatriz = new ArrayList<Integer>();
        var operacao = new Operacao();
        
        String matriz = "primeira";
        boolean terminouPreencherMatrizA = false;
        boolean terminouPreencherMatrizB = false;

        Scanner scanner = new Scanner(System.in);
        
        realizarOperacao(linhaMatriz, operacao, matriz, terminouPreencherMatrizA, terminouPreencherMatrizB, scanner);
       
        var validacao = operacao.validarOperacao();
        
        if(!validacao.isBlank()) 
        {
        	System.out.println(validacao);
            
            System.out.print("Digite 1 para tentar novamente");
            int input = scanner.nextInt();
            
            if(input == 1) 
            {
            	realizarOperacao(linhaMatriz, operacao, matriz, terminouPreencherMatrizA, terminouPreencherMatrizB, scanner);
            	
            	if(!operacao.validarOperacao().isBlank()) 
            	{
            		System.out.println(operacao.validarOperacao());
            		System.exit(0);
            	}
            }
            
            else
            {
            	System.exit(0);
            }
        }
        	
        operacao.exibirResultadoDaOperacao();
        

        scanner.close();
    }

	private static void realizarOperacao(ArrayList<Integer> linhaMatriz, Operacao operacao, String matriz,
			boolean terminouPreencherMatrizA, boolean terminouPreencherMatrizB, Scanner scanner) {
		do {
            int linha = 0;
            int coluna = 0;

            informarMatrizASerPreenchida(matriz);
            System.out.print("Quantidade de linhas da matriz: ");
            linha = scanner.nextInt();
            System.out.print("Quantidade de colunas da matriz: ");
            coluna = scanner.nextInt();
            
            if (linha <= 0 || coluna <= 0) {
                System.out.println("Quantidade de linhas ou colunas deve ser maior que zero.");
                continue;
            }
            int linhaAtual = 1;
            while (linha > 0) {
                
                linhaMatriz.clear(); 
                
                for (int i = 0; i < coluna; i++) {
                	System.out.print("Digite o elemento " + (i + 1) + " da linha " + linhaAtual + ":");
                    int valor = scanner.nextInt();
                    linhaMatriz.add(valor);
                }

                if (!terminouPreencherMatrizA) {
                    operacao.preencherLinhasDaMatrizA(new ArrayList<>(linhaMatriz));
                    linha--;

                    if (linha == 0)
                        terminouPreencherMatrizA = true;
                    
                } else if (!terminouPreencherMatrizB) {
                    operacao.preencherLinhasDaMatrizB(new ArrayList<>(linhaMatriz));
                    linha--;

                    if (linha == 0)
                        terminouPreencherMatrizB = true;
                }
                linhaAtual++;
            }
            
            matriz = "segunda";
            linhaAtual = 1;
        } while (!terminouPreencherMatrizA || !terminouPreencherMatrizB);
	}
    
    public static void informarMatrizASerPreenchida(String matriz) {
        System.out.println("Informe as dimensões da " + matriz + " matriz");
    }
}
