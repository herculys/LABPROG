package lab4;

import java.util.Arrays;

/* Herculys Sabino */
/* Suelene Clementino */

/**
 * Classe usada para representar uma progressao aritmetica.
 * @author Herculys, Suelene
 * @version 1.1
 */

public class ProgressaoAritmetica
{
	private int primeiroTermo;
	private int razao;
	private int termoGerado;
	private int termoAtual;
	private int termosV[];
	private String nTermo;
	
	/**
	 * Construtor de uma progressao aritmetica.
	 * 
	 * @param primeiro 
	 * O primeiro termo da progressao aritmetica.
	 * 
	 * @param razao
	 * A razao da progressao aritmetica.
	 */
	
	public ProgressaoAritmetica(int primeiro, int razao) 
	{
		this.primeiroTermo = primeiro;
		this.razao = razao;
	} 
	
	/**
	 * Recupera a razao a progressao aritmetica.
	 * 
	 * @return razao 
	 * A razao da progressao aritmetica
	 * 
	 */
	public int getRazao()
	{
		return this.razao;
	}
	
	/**
	 * Calcula o proximo termo da progressao aritmetica. O termo gerado passa a ser o termo atual da progressao.
	 * 
	 * @return termoAtual 
	 * O proximo termo da progessao aritmetica
	 */
	
	public int proximo()
	{		
		termoAtual+=getRazao();
		return termoAtual;
	}
	
	/**
	 * Reinicia a progressao aritmetica para o seu primeiro termo. O primeiro termo passa a ser o termo atual da progressao.
	 * 
	 * @return termoAtual
	 * O primeiro termo da progressao aritmetica
	 */
	public int primeiro()
	{
		termoAtual = primeiroTermo;
		return termoAtual;
	}
	
	/**
	 * Calcula o n-esimo termo da progessao aritmetica. n representa a posicao do termo na progessao (comecando de 1). Caso seja fornecido um valor de n menor ou igual a 0, deve ser retornado o primeiro termo da progressao. O termo gerado passa a ser o termo atual da progressao.
	 * 
	 * @param n
	 * 	O n-esimo termo a ser calculado.
	 * 
	 * @return
	 * 	O n-esimo termo calculado, ou o primeiro termo, se n menor ou igual a 0.
	 */
	public int termo(int n)
	{
		if (n <= 0)
		{	
			return primeiroTermo;
		} 
		else 
		{
			termoGerado = primeiroTermo + (n - 1) * razao;
			termoAtual = termoGerado;
			return termoAtual;
		}
	}
	
	/**
	 * Gera os "n" primeiros termos (1 .. n) da progressao aritmetica em uma String. Caso seja fornecido um valor de n menor ou igual a 0, deve ser retornado o primeiro termo da progressao. O ultimo termo gerado passa a ser o termo atual da progessao.
	 * 
	 * @param n
	 * 	A quantidade de termos a ser gerada da progressao
	 * 
	 * @return
	 * 	a string (formato: [termo1 termo2 ... termon ] representando os termos gerados da progressao
	 */
	public String geraTermos(int n)
	{	
		String termos;
		if (n <= 0) {
			termos = Integer.toString(primeiroTermo);
			return termos;
		}
		
		termosV = new int[n];
		for (int i = 0; i < n; i++) {			
			termosV[i] = termo(i+1);
		}
		String termoArray = Arrays.toString(termosV);
		termoAtual = termo(n);
		return termoArray;
	}
	
	/**
	 * Metodo para ver o termo n da Pa.
	 * 
	 * @param n
	 * Posição a ser checada.
	 * 
	 * @return
	 * O valor da posição checada.
	 */
	public String verTermoPa(int n)
	{
		nTermo = Integer.toString(termosV[n-1]);;
		return nTermo;
		
	}
	
	/**
	 * Metodo para criar uma Pa.
	 * 
	 * @param n 
	 * Quantidade de elementos da Pa.
	 */
	
	public void criaPa(int n)
	{
		termosV = new int[n];
		for (int i = 0; i < n; i++) {			
			termosV[i] = termo(i+1);
		}
	}
	
	
}