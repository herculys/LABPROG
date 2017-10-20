package lab4;

import java.util.Arrays;

/* Herculys Sabino */
/* Suelene Clementino */

/**
 * Classe usada para representar a Serie de Fibonacci.
 * @author Herculys, Suelene.
 * @version 1.1
 */

public class Fibonacci {
	
	private int sequencia[];
	private String fibonacciVetor;
	private int nFibonacci;
	private String ntermo;
	
	/**
	 * Metodo usado para criar a série de Fibonacci.
	 * 
	 * @param num1
	 * Numero1 da equação de Fibonacci.
	 * 
	 * @param num2
	 * Numero2 da equação de Fibonacci.
	 * 
	 * @param qtElementos
	 * Quantidade de elementos da serie de Fibonacci.
	 */
	public void fibonacci(int num1, int num2, int qtElementos)
	{       
		sequencia = new int[qtElementos];
		
		for(int i = 0; i < qtElementos; i++){
            num1 = num1 + num2;
            num2 = num1 - num2;	
            sequencia[i] = num1;
        }      
	}
	
	/**
	 * Metodo usado para imprimir os n primeiros termos da serie de Fibonacci.
	 * 
	 * @param num1
	 * Numero1 da equação de Fibonacci.
	 * 
	 * @param num2
	 * Numero 2 da equação de Fibonacci.
	 * 
	 * @param qtElementos
	 * Quantidade de elementos da serie de Fibonacci.
	 * 
	 * @return
	 * String com elementos do vetor.
	 */
	public String serieFibonacci(int num1, int num2, int qtElementos)
	{
		sequencia = new int[qtElementos];
			
		for(int i = 0; i < qtElementos; i++){
            num1 = num1 + num2;
            num2 = num1 - num2;	
            sequencia[i] = num1;
        }  
		fibonacciVetor = Arrays.toString(sequencia);
		return fibonacciVetor;  
	}
	
	/**
	 * Metodo para ver o termo n da Serie de Fibonacci.
	 * 
	 * @param n
	 * Posição a ser checada.
	 * 
	 * @return
	 * O valor da posição checada.
	 */
	
	public String verTermo(int n)
	{
		ntermo = Integer.toString(sequencia[n-1]);;
		return ntermo;
	}

}