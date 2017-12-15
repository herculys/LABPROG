package lab7;

/* Aluno : Herculys Sabino */

import java.util.ArrayList;
import java.util.List;

public class Professores extends Contribuintes 
{
	private final static double TRIBUTACAO_UM_SALARIO = 0.05;
	private final static double TRIBUTACAO_ATE_CINCO_SALARIOS = 0.1;
	private final static double TRIBUTACAO_ACIMA_CINCO_SALARIOS = 0.2;
	private final static double SALARIO_MINIMO_BRUTO = 724.0;
	private double salario, despesaMaterialDidatico;
	private static double somaRiquezasProf, limiarRiquezaProf;
	private static List<Professores> professores = new ArrayList<Professores>();
	
	public Professores(String nomeContribuinte, String numeroContribuinte, double salarioMensal, double despesas, double valorCarro, double valorCasa) throws Exception 
	{
		super(nomeContribuinte, numeroContribuinte, valorCarro, valorCasa);
		if (salarioMensal < 0 || despesas < 0) throw new Exception("Os valores n�o podem ser negativos.");
		this.salario = salarioMensal;
		this.despesaMaterialDidatico = despesas;
		calculaTributacao();
		descontoTributacao();
		if (!verificaSeExiste(nomeContribuinte, numeroContribuinte)) 
		{
			professores.add(this);
			numeroDeContribuintes++;
		}
	}

	@Override
	protected void calculaTributacao() 
	{
		if (salario / SALARIO_MINIMO_BRUTO <= 1) 
		{
			tributacao = salario * TRIBUTACAO_UM_SALARIO;
		}
		else if (salario / SALARIO_MINIMO_BRUTO > 1 && salario / SALARIO_MINIMO_BRUTO <= 5)
		{
			tributacao = salario * TRIBUTACAO_ATE_CINCO_SALARIOS;
		}
		else tributacao = salario * TRIBUTACAO_ACIMA_CINCO_SALARIOS;
	}

	@Override
	protected void descontoTributacao()
	{
		descontos = despesaMaterialDidatico * 0.5;
	}
	
	private static void atualizaLimiarRiqueza () 
	{
		somaRiquezasProf = 0.0;
		limiarRiquezaProf = 0.0;
		for (Professores a: professores) {
			somaRiquezasProf += (a.sinaisRiqueza);
		}
		limiarRiquezaProf = (somaRiquezasProf / professores.size()) * 1.5;
	}
	
	public static void atualizaContribuintesLimiarRiqueza () 
	{
		atualizaLimiarRiqueza();
		for (Professores a: professores)
		{
			if (a.sinaisRiqueza >= limiarRiquezaProf) 
			{
				a.setRiquezaExcessiva(true);
			}
		}
	}
	
	private boolean verificaSeExiste (String nome, String numero) 
	{
		for (Professores a: professores) 
		{
			if (a.getNomeContribuinte().equals(nome) || a.getNumeroContribuinte().equals(numero)) 
			{
				return true;
			}
		}
		return false;
	}
	
	public double getDespesas () 
	{
		return despesaMaterialDidatico;
	}
	
	public double getSalario () 
	{
		return salario;
	}
	
	public static List<Professores> getProfessores () 
	{
		return professores;
	}
	
	public static double getLimiarRiqueza () 
	{
		return limiarRiquezaProf;
	}

	@Override
	public boolean equals (Object obj)
	{
		if (!(obj instanceof Professores))
		{
			return false;
		}
		Professores outroTaxista = (Professores) obj;
		return outroTaxista.getNomeContribuinte().equals(getNomeContribuinte()) && outroTaxista.getNumeroContribuinte().equals(getNumeroContribuinte());
	}
	
	public static String consultaContribuinte (String nome, String numeroContr) 
	{
		for (Professores a: professores) 
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