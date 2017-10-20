package lab4;

import java.util.Scanner;

/* Herculys Sabino */
/* Suelene Clementino */

/**
 * Classe para manipular series matematicas (Usando a ProgressaoAritmetica e a Fibonacci).
 * @author Herculys, Suelene
 * @version 1.1
 */

public class ExplorandoOMundoDasSeries {
	public static void main(String[] args) {
		
		int fiNum1 = 1, fiNum2 = 1, qtElementos = 5; 
		int paNum1 = 2, paNum2 = 4;
		int nTermo = 1;
		
		ProgressaoAritmetica pa = new ProgressaoAritmetica(paNum1, paNum2);
		Fibonacci fi = new Fibonacci();
		
		int rodando = 1;
		
		while (rodando == 1)
		{
			int escolha;
			Scanner sc = new Scanner(System.in);
			System.out.println("\n1. Para criar uma progressão aritmética;");
			System.out.println("2. Para criar uma série de Fibonacci; ");
			System.out.println("3. Para ver o termo “n” da sua PA; ");
			System.out.println("4. Para ver o termo “n” da serie de Fibonacci; ");
			System.out.println("5. Para mostrar os “n” primeiros termos da sua PA e da serie de Fibonacci; ");
			System.out.println("6. Para sair. ");
			
			escolha = sc.nextInt();
			switch (escolha) {
			case 1:
				//System.out.print("Informe o primeiro numero da progressão aritmética: ");
				//paNum1 = sc.nextInt();
				//System.out.print("informe o segundo numero da progressão aritmética: ");
				//paNum2 = sc.nextInt();
				System.out.print("informe a quantidade de elementos: ");
				qtElementos = sc.nextInt();
				pa.criaPa(qtElementos);
				
				break;
			case 2:
				//System.out.print("Informe n1: ");
				//fiNum1 = sc.nextInt();
				//System.out.print("informe n2: ");
				//fiNum2 = sc.nextInt();
				System.out.print("informe a quantidade de elementos: ");
				qtElementos = sc.nextInt();
				fi.fibonacci(fiNum1, fiNum2, qtElementos);
				
				break;
			case 3:
				System.out.println("Informe o termo “n” que deseja verificar: " );
				nTermo = sc.nextInt();
				System.out.println("Termo " + nTermo +" da PA: " + pa.verTermoPa(nTermo));
				break;
			case 4:
				System.out.print("Informe o termo “n” que deseja verificar: ");
				nTermo = sc.nextInt();
				System.out.println("Termo " + nTermo +" da serie de Fibonacci: " + fi.verTermo(nTermo));
				break;
			case 5:
				System.out.println("Informe a quantidade de elementos “n” a serem mostradas: ");
				qtElementos = sc.nextInt();
				System.out.println(qtElementos + " primeiros termos da PA: todos de uma vez: " + pa.geraTermos(qtElementos));
				System.out.println(qtElementos + " primeiros numeros da Serie de Fibonacci: " + fi.serieFibonacci(fiNum1, fiNum2, qtElementos));
				break;
			case 6:
				rodando = 0;
				sc.close();
				break;
			default:
				System.out.println("Opção invalida, por favor insira uma nova entrada.\n");
				break;
			}		
	
		}
	
}

}