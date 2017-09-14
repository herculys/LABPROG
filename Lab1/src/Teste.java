import java.util.Scanner;

public class Teste
{

	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		int n = 0, i = 0;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while (i<4)
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
				
		System.out.println("Mínimo = " + min);
		System.out.println("Máximo = " + max);
		
	}

}
