package lab7;

/* Aluno : Herculys Sabino */

public abstract class Contribuintes 
{
	public static int numeroDeContribuintes = 0;
	private String nomeContribuinte, numero;
	private boolean riquezaExcessiva = false;
	private double valorCasa, valorCarro;
	protected double sinaisRiqueza, tributacao, descontos;

	public Contribuintes (String nome, String numeroContribuinte, double valorCarro, double valorCasa) throws Exception 
	{
		 if (!checaString(nome, numeroContribuinte))
		 {
			throw new Exception("O nome não pode ser vazio ou null, nem o número de cadastro.");
		 }
		 this.valorCarro = valorCarro(valorCarro);
		 this.valorCasa = valorCasa(valorCasa);
		 this.sinaisRiqueza = this.valorCarro + this.valorCasa;
		 this.nomeContribuinte = nome;
		 this.numero = numeroContribuinte;
	}
	
	private double valorCasa (double valorCasa) throws Exception
	{
		if (!checaValor(valorCasa)) 
		{
			throw new Exception("O valor da casa não pode ser negativo.");
		}
		return valorCasa;
	}
	
	private double valorCarro (double valorCarro) throws Exception 
	{
		if (!checaValor(valorCarro)) 
		{
			throw new Exception("O valor do carro não pode ser negativo.");
		}
		return valorCarro;
	}
	

	
	public double getValorcarro()
	{
		return valorCarro;
	}
	
	public double getSinaisRiqueza()
	{
		return sinaisRiqueza;
	}
	
	public double getValorcasa()
	{
		return valorCasa;
	}
	public double getDescontos()
	{
		return descontos;
	}

	public String getNomeContribuinte()
	{
		return nomeContribuinte;
	}
	
	public String getNumeroContribuinte()
	{
		return numero;
	}
	
	public double getTributacao()
	{
		return tributacao;
	}
	

	public double getTributacaoTotal()
	{
		if (tributacao - descontos < 0) return 0;
		else return tributacao - descontos;
	}
	
	public boolean getAcimaDaLimiar()
	{
		return riquezaExcessiva;
	}

	public void setRiquezaExcessiva (boolean status)
	{
		riquezaExcessiva = status;
	}

	@Override
	public String toString ()
	{
		return "Nome: " + getNomeContribuinte() + " - Número de contribuinte: " + getNumeroContribuinte();
	}
	
	protected abstract void descontoTributacao ();
	protected abstract void calculaTributacao ();
	private boolean checaString (String nome, String numeroContribuinte)
	{
		if (nome == null || numeroContribuinte == null || nome.equals("") || numeroContribuinte.equals("")) return false;
		return true;
	}
	
	private boolean checaValor (double valor)
	{
		if (valor < 0) return false;
		return true;
	}
}