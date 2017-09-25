package lab03;

/*
 * Aluno: Herculys
 */

import java.util.Scanner;

public class JogoDaVelhaModularizado {
	public static void main(String args[]){
		Scanner entrada = new Scanner(System.in);
		Metodos methods = new Metodos();
		String playing = "s";
		while (playing.equals("s"))
		{
			methods.iniciarOJogo();	
			System.out.println("\nDeseja continuar jogando [s/n]?");
			playing = entrada.nextLine();
			if (playing.equals("s"))
			{
				System.out.println("Você reiniciou o jogo");
				methods.iniciarOJogo();	
				
			} else
			{
				System.out.println("Você terminou o jogo.");
				break;
			}
		}
		
	}
}