package lab5;


/* Aluno 1: Herculys Sabino */
/* Aluno 2: Suelene Clementino */

/**
 * 
 * @author Herculys, Suelene
 * @version 1.0
 */

public class Robo
{
	private Sala salaRobo;
	private int NUM_LINHAS = 10;
	private int NUM_COLUNAS = 10;
	private int linhaAtualRobo;
	private int colunaAtualRobo;
	private int energia;
	private int passos;
	
	public Robo(int linhas, int colunas, int energia) throws Exception
	{
		if(energia < 0)
		{
			throw new Exception("Energia negativa.");
		}
		else if (energia == 0)
		{
			throw new Exception("Enegia é 0.");
		}
		else
		{
			this.NUM_LINHAS = linhas;
			this.NUM_COLUNAS = colunas;
			this.energia = energia;
			salaRobo.criaSala(linhas, colunas);	
		}
	
	}

	public boolean criaRobo() throws Exception
	{
		for(int i=0; i < NUM_LINHAS; i++)
		{
			for(int j = 0; j < NUM_COLUNAS; j++)
			{
				if(salaRobo.isPosicaoLivre(i, j))
				{
					salaRobo.setPosicao(i, j, Sala.OCUPADO);
					linhaAtualRobo = i;
					colunaAtualRobo = j;
					return true;
				}	
			}
		}
		return false;
	}
	
	public int energiaAtual()
	{
		return energia;
	}
	
	public int passosAtuais()
	{
		return passos;
	}
	
	public boolean andarFrente() throws Exception
	{
		if(linhaAtualRobo == (salaRobo.getNumPosicoesHorizontais() - 1))
		{
			return false;
		}
		
		else if(energiaAtual() > 0 && (salaRobo.isPosicaoLivre((linhaAtualRobo+1), colunaAtualRobo)))
		{
			salaRobo.setPosicao(linhaAtualRobo, colunaAtualRobo , Sala.LIVRE);
			linhaAtualRobo++;
			salaRobo.setPosicao(linhaAtualRobo, colunaAtualRobo , Sala.OCUPADO);		
			energia--;
			passos++;
			
			return true;
		}
		return false;
	}
	
	public boolean andarTras() throws Exception
	{
		if(linhaAtualRobo == 0)
		{
			return false;
		}
		else if (energiaAtual() > 0 && salaRobo.isPosicaoLivre((linhaAtualRobo - 1), colunaAtualRobo))
		{
			salaRobo.setPosicao(linhaAtualRobo, colunaAtualRobo, Sala.LIVRE);
			linhaAtualRobo--;
			salaRobo.setPosicao(linhaAtualRobo, colunaAtualRobo, Sala.OCUPADO);
			energia--;
			passos++;
			return true;
		}
		
		return false;
		
	}
	
	public boolean andarEsquerda() throws Exception
	{
		if(colunaAtualRobo == 0)
		{
			return false;
		}
		else if (energiaAtual() > 0 && salaRobo.isPosicaoLivre(linhaAtualRobo, (colunaAtualRobo - 1)))
		{
			salaRobo.setPosicao(linhaAtualRobo, colunaAtualRobo, Sala.LIVRE);
			colunaAtualRobo--;
			salaRobo.setPosicao(linhaAtualRobo, colunaAtualRobo, Sala.OCUPADO);
			energia--;
			passos++;
			return true;
		}
		
		return false;
	}
	
	public boolean andarDireita() throws Exception
	{
		if(colunaAtualRobo == (salaRobo.getNumPosicoesVerticais() - 1))
		{
			return false;
		}
		else if(energiaAtual() > 0 && salaRobo.isPosicaoLivre(linhaAtualRobo, (colunaAtualRobo + 1)))
		{
			salaRobo.setPosicao(linhaAtualRobo, colunaAtualRobo, Sala.LIVRE);
			colunaAtualRobo++;
			salaRobo.setPosicao(linhaAtualRobo, colunaAtualRobo, Sala.OCUPADO);
			energia--;
			passos++;
			return true;
		}
		
		return false;
	}

}