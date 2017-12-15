package lab7;

/* Aluno : Herculys Sabino */

import java.util.ArrayList;
import java.util.List;

public class Caminhoneiros extends Rodoviarios 
{
	private static final int IMPOSTO = 500;
	private double toneladasAno;
	private static double somaRiquezasCam, limiarRiquezaCam;
	private static List<Caminhoneiros> caminhoneiros = new ArrayList<Caminhoneiros>();
	

	public Caminhoneiros (String nomeContribuinte, String numeroContribuinte, double toneladasAno, double quilometros_percorridos, double valorCarro, double valorCasa) throws Exception
	{
		super(nomeContribuinte, numeroContribuinte, quilometros_percorridos, valorCarro, valorCasa);
		if (verificaSeENegativo(toneladasAno)) 
		{
			throw new Exception("Os quilômetros percorridos e as toneladas não podem ser negativas.");
		}
		this.toneladasAno = toneladasAno;
		calculaTributacao();
		descontoTributacao();
		if (!verificaSeExiste(nomeContribuinte, numeroContribuinte)) 
		{
			caminhoneiros.add(this);
			numeroDeContribuintes++;
		}
	}

	@Override
	public boolean equals (Object obj) 
	{
		if (!(obj instanceof Caminhoneiros))
		{
			return false;
		}
		Caminhoneiros outroCaminhoneiro = (Caminhoneiros) obj;
		return outroCaminhoneiro.getNomeContribuinte().equals(getNomeContribuinte()) && outroCaminhoneiro.getNumeroContribuinte().equals(getNumeroContribuinte());
	}
	
	@Override
	protected void calculaTributacao() 
	{
		if (toneladasAno <= 10) this.tributacao = IMPOSTO;
		else this.tributacao = IMPOSTO + (toneladasAno - 10) * 100;
	}
	
	private boolean verificaSeENegativo (double numero)
	{
		if (numero < 0) 
		{
			return true;
		}
		return false;
	}
	
	private static void atualizaLimiarRiqueza () 
	{
		somaRiquezasCam = 0.0;
		limiarRiquezaCam = 0.0;
		for (Caminhoneiros a: caminhoneiros) 
		{
			somaRiquezasCam += (a.sinaisRiqueza);
		}
		limiarRiquezaCam = (somaRiquezasCam / caminhoneiros.size()) * 1.5;
	}
	
	public static void atualizaContribuintesLimiarRiqueza () 
	{
		atualizaLimiarRiqueza();
		for (Caminhoneiros a: caminhoneiros) 
		{
			if (a.sinaisRiqueza >= limiarRiquezaCam) 
			{
				a.setRiquezaExcessiva(true);
			}
		}
	}
	
	private boolean verificaSeExiste (String nome, String numero) 
	{
		for (Caminhoneiros a: caminhoneiros)
		{
			if (a.getNomeContribuinte().equals(nome) || a.getNumeroContribuinte().equals(numero)) 
			{
				return true;
			}
		}
		return false;
	}
	
	public static double getLimiarRiqueza () 
	{
		return limiarRiquezaCam;
	}
	
	public static List<Caminhoneiros> getCaminhoneiros () 
	{
		return caminhoneiros;
	}
	
	public static int getNumeroDeCaminhoneiros ()
	{
		return caminhoneiros.size();
	}
	
	public static String consultaContribuinte (String nome, String numeroContr) 
	{
		for (Caminhoneiros a: caminhoneiros) 
		{
			if (nome.equals(a.getNomeContribuinte()) && numeroContr.equals(a.getNumeroContribuinte()))
			{
				return "Nome: " + a.getNomeContribuinte() + " - Número de contribuinte: " + a.getNumeroContribuinte() +
						"\nTributação bruta: R$ " + a.getTributacao() + "\nDescontos: R$ " + a.getDescontos() + "\nTributação Total: R$ " + a.getTributacaoTotal() + "\n";
			}
		}
		return "Pessoa não encontrada.";
	}
}