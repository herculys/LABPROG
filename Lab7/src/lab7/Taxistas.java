package lab7;

/* Aluno : Herculys Sabino */

import java.util.*;

public class Taxistas extends Rodoviarios
{
	private int passageiros;
	private static double somaBensTaxistas, limiarRiquezaTax;
	public static List<Taxistas> taxistas = new ArrayList<Taxistas>();
	
	public Taxistas(String nomeContribuinte, String numeroContribuinte, double quilometrosPercorridos, int passageiros, double valorCarro, double valorCasa) throws Exception
	{
		super(nomeContribuinte, numeroContribuinte, quilometrosPercorridos, valorCarro, valorCasa);
		if (passageiros < 0) 
		{
			throw new Exception("O n�mero de passageiros n�o pode ser negativo.");
		}
		this.passageiros = passageiros;
		calculaTributacao();
		descontoTributacao();
		if (!verificaSeExiste(nomeContribuinte, numeroContribuinte)) 
		{
			taxistas.add(this);
			numeroDeContribuintes++;
		}
	}
	
	@Override
	public void calculaTributacao() 
	{
		tributacao = passageiros * 0.5;
	}
	
	private boolean verificaSeExiste (String nome, String numero)
	{
		for (Taxistas a: taxistas) 
		{
			if (a.getNomeContribuinte().equals(nome) || a.getNumeroContribuinte().equals(numero)) {
				return true;
			}
		}
		return false;
	}
	
	private static void atualizaLimiarRiqueza ()
	{
		somaBensTaxistas = 0.0;
		limiarRiquezaTax = 0.0;
		for (Taxistas a: taxistas) 
		{
			somaBensTaxistas += (a.sinaisRiqueza);
		}
		limiarRiquezaTax = (somaBensTaxistas / taxistas.size()) * 1.5;
	}
	
	public static void atualizaContribuintesLimiarRiqueza () 
	{
		atualizaLimiarRiqueza();
		for (Taxistas a: taxistas) 
		{
			if (a.sinaisRiqueza >= limiarRiquezaTax) 
			{
				a.setRiquezaExcessiva(true);
			}
		}
	}
	
	public static double getLimiarRiqueza () 
	{
		return limiarRiquezaTax;
	}
	
	public static List<Taxistas> getTaxistas () 
	{
		return taxistas;
	}
	
	public static int getNumeroDeTaxistas () 
	{
		return taxistas.size();
	}
	
	public int getPassageiros ()
	{
		return passageiros;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		if (!(obj instanceof Taxistas)) 
		{
			return false;
		}
		Taxistas outroTaxista = (Taxistas) obj;
		return outroTaxista.getNomeContribuinte().equals(getNomeContribuinte()) && outroTaxista.getNumeroContribuinte().equals(getNumeroContribuinte());
	}
	
	public static String consultaContribuinte (String nome, String numeroContr) 
	{
		for (Taxistas a: taxistas) 
		{
			if (nome.equals(a.getNomeContribuinte()) && numeroContr.equals(a.getNumeroContribuinte())) 
			{
				return "Nome: " + a.getNomeContribuinte() + " - N�mero de contribuinte: " + a.getNumeroContribuinte() +
						"\nTributa��o bruta: R$ " + a.getTributacao() + "\nDescontos: R$ " + a.getDescontos() + "\nTributa��o Total: R$ " + a.getTributacaoTotal() + "\n";
			}
		}
		return "Pessoa n�o encontrada.";
	}
}