package lab5;

import java.util.Arrays;

/* Aluno 1: Herculys Sabino */
/* Aluno 2: Suelene Clementino */

/**
 * 
 * @author Herculys , Suelene
 * @version 0.2
 * 
 */

public class Sala
{
	private int sala[][];
	private int NUM_LINHAS;
	private int NUM_COLUNAS;
	public static int OCUPADO = 1;
	public static int LIVRE = 0;
	
	/**
	 * 
	 * @param linhas
	 * @param colunas
	 * @throws Exception
	 */
	
	public Sala(int linhas, int colunas) throws Exception
	{
		this.NUM_LINHAS = linhas;
		this.NUM_COLUNAS = colunas;
		criaSala(linhas, colunas);	
	}
	
	public void criaSala(int linhas, int colunas) throws Exception
	{
		if (linhas > 0 && colunas > 0)
		{
			sala = new int[linhas][colunas];
		}
		else
		{
			throw new Exception("Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero");
		}	
	}
		
	public int getNumPosicoesHorizontais()
	{
		int  linhas = sala.length;	
		return linhas;
	}
	
	public int getNumPosicoesVerticais()
	{
		int coluna;
		if (sala[0] != null)
		{
			coluna = sala[0].length;
		}
		else
		{
			coluna = -1;
		}
		return coluna;
	}
	
	public boolean isVazia()
	{
		for(int i = 0; i < sala.length; i++)
		{
			for(int k = 0; k < sala[0].length; k++)
			{
				if(sala[i][k] == OCUPADO)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean inserirObstaculo(int linha, int coluna)
	{
		if(posicaoValida(linha, coluna))
		{
			sala[linha][coluna] = OCUPADO;
			return true;
		} 
		return false;
		
	}
	
	public boolean posicaoValida(int linha, int coluna) 
	{
		if((linha >= 0 && linha < NUM_LINHAS) && (coluna >= 0 && coluna < NUM_COLUNAS))
		{
			return true;
		}
		return false;
	}
	
	public boolean isPosicaoLivre (int linha, int coluna) throws Exception
	{
		if(posicaoValida(linha, coluna))
		{
			if (sala[linha][coluna] == LIVRE)
			{
				return true;
			} else
			{
				return false;	
			}
		}
		throw new Exception("Posicao inexistente.");
		
	}
	
	public boolean setPosicao (int linha, int coluna, int disponibilidade)
	{
		if(posicaoValida(linha, coluna))
		{
			sala[linha][coluna] = disponibilidade;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object outraSala) 
	{
		Sala novaSala = (Sala)outraSala;

		if(outraSala != null) 
		{
			if(getNumPosicoesVerticais() == novaSala.getNumPosicoesVerticais() && getNumPosicoesHorizontais() == novaSala.getNumPosicoesHorizontais()) 
			{
				for(int i = 0; i < getNumPosicoesVerticais(); i++)
				{
					for(int k = 0; k < getNumPosicoesHorizontais(); k++)
					{
						if(sala[i][k] != novaSala.sala[i][k])
						{
							return false;
						}
					}
				}
				return true;
			}
		}
		return false;
	}
}