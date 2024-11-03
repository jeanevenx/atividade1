package m2matrizes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operacao {
	
	private List<List<Integer>> linhasMatrizA = new ArrayList<List<Integer>>();
	private List<List<Integer>> linhasMatrizB = new ArrayList<List<Integer>>();
	
	
	public void preencherLinhasDaMatrizA(List<Integer> linha)
	{
		this.linhasMatrizA.add(linha);
	}
	
	public void preencherLinhasDaMatrizB(List<Integer> linha)
	{
		this.linhasMatrizB.add(linha);
	}

	
	public void exibirResultadoDaOperacao() 
	{
		var matrizResultante = Arrays.deepToString(gerarMatrizResultante().toArray());
		var matrizA = Arrays.deepToString(linhasMatrizA.toArray());
		var matrizB = Arrays.deepToString(linhasMatrizB.toArray());
		
		System.out.println("\n\n");
		System.out.print(matrizA + " X ");
		System.out.print(matrizB + " = ");
		System.out.print(matrizResultante);
	}
	
	
	public String validarOperacao()
	{
		
		if(linhasMatrizA.get(0).size() > linhasMatrizB.size()) 
		{
			return "O número de linhas da matriz B deve ser "
					+ "igual ao número de colunas da matriz A.";
		}
		
		if(linhasMatrizA.get(0).size() < linhasMatrizB.size()) 
		{
			return "O número de colunas da matriz A deve ser "
					+ "igual ao número de linhas da matriz B.";
		}
		
		return "";
	}
	
	
	
	private List<List<Integer>> gerarMatrizResultante() 
	{
		var matrizResultante = new ArrayList<List<Integer>>();
		
		for(var linha : linhasMatrizA) 
		{
			int contadorDaMatrizB = 0;
			int valor = 0;
			
			int totalColunasDaMatrizB = linhasMatrizB.get(0).size();
			
			var linhaCalculada = new ArrayList<Integer>();
			
			while(totalColunasDaMatrizB > contadorDaMatrizB)
			{
				valor = 0;
				for(int i = 0; i < linha.size(); i++) 
				{
					var valorColunaMatrizB = linhasMatrizB.get(i).get(contadorDaMatrizB);
					var valorLinhaMatrizA = linha.get(i);
					
					valor += valorLinhaMatrizA * valorColunaMatrizB;
				}
				contadorDaMatrizB++;
				linhaCalculada.add(valor);
			}
			
			matrizResultante.add(linhaCalculada);
		}
		
		
		return matrizResultante;
	}
	
}
