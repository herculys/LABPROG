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
    	   boolean hastrue1, hastrue2;
           Scanner sc = new Scanner (System.in);

           System.out.println("Jogador 1: Pedra (1), Papel (2), Tesoura (3), Encerrar programa (-1)?");
           jogador1 = sc.nextInt();
                     
           switch (jogador1)
           {
               case 1:
                   string1 = "PEDRA";
                   hastrue1 = true;
                   System.out.println("Jogador 2: Pedra (1), Papel (2), Tesoura (3), Encerrar programa (-1)?");
                   jogador2 = sc.nextInt();
                   break;
               case 2:
                   string1 = "PAPEL";
                   hastrue1 = true;
                   System.out.println("Jogador 2: Pedra (1), Papel (2), Tesoura (3), Encerrar programa (-1)?");
                   jogador2 = sc.nextInt();
                   break;
               case 3:
                   string1 = "TESOURA";
                   hastrue1 = true;
                   System.out.println("Jogador 2: Pedra (1), Papel (2), Tesoura (3), Encerrar programa (-1)?");
                   jogador2 = sc.nextInt();
                   break;
               case -1:
            	   System.out.println("Programa encerrado!");
            	   hastrue1 = false;
            	   break;
               default:
                   System.out.println("Informe uma opção valida");
                   hastrue1 = false;
                   break;
           }
           
           if (jogador1 == -1)
           {
        	   break;
           }
  
           switch (jogador2)
           {
               case 1:
                   string2 = "PEDRA";
                   hastrue2 = true;
                   break;
               case 2:
                   string2 = "PAPEL";
                   hastrue2 = true;
                   break;
               case 3:
                   string2 = "TESOURA";
                   hastrue2 = true;
                   break;
               case -1:
            	   System.out.println("Programa encerrado!");
            	   hastrue2 = false;
            	   break;
               default:
                   System.out.println("Informe uma opção valida");
                   hastrue2 = false;
                   break;
           }
           
           if (jogador2 == -1)
            
           {
        	   break;
           }
           
           
           resultado = (n + jogador1 - jogador2)%n;
          
           //System.out.println("Resultado = ");
           //System.out.println(resultado);
           
           if (hastrue1 == true && hastrue2 == true)
           {
        	   
               if (resultado > 0 && resultado <= (n/2))
               {
            	   System.out.println(string1 + " - " + string2);
                   System.out.println("Jogador 1 Ganhou!\n");
               }

               if (resultado > (n/2))
               {
            	   System.out.println(string1 + " - " + string2);
                   System.out.println("Jogador 2 Ganhou!\n");
               }
               if (resultado == 0)
               {
            	   System.out.println(string1 + " - " + string2);
                   System.out.println("Empate!\n");
               }   
           }
        }    
	}
}
