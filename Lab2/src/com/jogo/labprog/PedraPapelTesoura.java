package com.jogo.labprog;

import java.util.Scanner;

/*
 * Aluno: Herculys
 */
public class PedraPapelTesoura {

	
	public static void main(String[] args) {
	
	   int rodando = 1;
	   while (rodando >=1)
	   {
        			
    	   int jogador1 = 1, jogador2 = 1, n = 3, resultado, i;
    	   String string1 = null, string2 = null;
           Scanner sc = new Scanner (System.in);

           System.out.println("Pedra (1), Papel (2), Tesoura (3), Encerrar programa (-1)?");
           jogador1 = sc.nextInt();

           switch (jogador1)
           {
               case 1:
                   string1 = "PEDRA";
                   break;
               case 2:
                   string1 = "PAPEL";
                   break;
               case 3:
                   string1 = "TESOURA";
                   break;
               case -1:
            	   System.out.println("Programa encerrado!");
            	   break;
               default:
                   System.out.println("Informe uma opção valida");
                   break;
           }
           
           if (jogador1 == -1)
           {
        	   break;
           }
           System.out.println("\nPedra (1), Papel (2), Tesoura (3), Encerrar programa (-1)?");
           jogador2 = sc.nextInt();
          
           switch (jogador2)
           {
               case 1:
                   string2 = "PEDRA";
                   break;
               case 2:
                   string2 = "PAPEL";
                   break;
               case 3:
                   string2 = "TESOURA";
                   break;
               case -1:
            	   System.out.println("Programa encerrado!");
            	   break;
               default:
                   System.out.println("Informe uma opção valida");
                   break;
           }
           if (jogador2 == -1)
           {
        	   break;
           }
           resultado = (n + jogador1 - jogador2)%n;
          
           //System.out.println("Resultado = ");
           //System.out.println(resultado);
           
           if (resultado > 0 && resultado <= (n/2))
           {
        	   System.out.println(string1 + " - " + string2);
               System.out.println("Jogador 1 Venceu!\n");
           }

           if (resultado > (n/2))
           {
        	   System.out.println(string1 + " - " + string2);
               System.out.println("Jogador 2 Venceu!\n");
           }
           if (resultado == 0)
           {
        	   System.out.println(string1 + " - " + string2);
               System.out.println("Empate!\n");
           }
           
        	
        }
               
    
	}

}
