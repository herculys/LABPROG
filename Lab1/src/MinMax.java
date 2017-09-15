import java.util.Scanner;
/*
 * Aluno: Herculys
 */
public class MinMax 
{

	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		int n = 0, i = 0, entrada = 3;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while (i<entrada)
		{
			System.out.print("Informe um numero: ");
			n = sc.nextInt();
			
			if (n<min)
			{
				min = n;
			}
			
			if (n>max)
			{
				max = n;
			}
			
			i++;
		}
				
		System.out.println("Minimo = " + min);
		System.out.println("Maximo = " + max);
		
	}

}
