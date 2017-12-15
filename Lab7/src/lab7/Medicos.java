package lab7;

/* Aluno : Herculys Sabino */

import java.util.ArrayList;
import java.util.List;

public class Medicos extends Contribuintes 
{
	private int pacientes;
	private double gastosCongressos;
	private static double somaRiquezasMed, limiarRiquezaMed;
	private static List<Medicos> medicos = new ArrayList<Medicos>();
	
	public Medicos(String nomeContribuinte, String numeroContribuinte, int pacientes, double gastos, double valorCarro, double valorCasa) throws Exception 
	{
		super(nomeContribuinte, numeroContribuinte, valorCarro, valorCasa);
		if (gastos < 0 || pacientes < 0) throw new Exception("O valor dos gastos e pacientes não podem ser negativos.");
		this.pacientes = pacientes;
		this.gastosCongressos = gastos;
		calculaTributacao();
		descontoTributacao();
		if (!verificaSeExiste(nomeContribuinte, numeroContribuinte)) 
		{
			medicos.add(this);
			numeroDeContribuintes++;
		}
	}

	@Override
	protected void descontoTributacao()
	{
		descontos = gastosCongressos;
	}
	
	@Override
	protected void calculaTributacao()
	{
		tributacao = pacientes * 10;
	}

	private boolean verificaSeExiste (String nome, String numero)
	{
		for(Medicos a: medicos){
			if(a.getNomeContribuinte().equals(nome) || a.getNumeroContribuinte().equals(numero))
			{
				return true;
			}
		}
		return false;
	}
	
	private static void atualizaLimiarRiqueza ()
	{
		somaRiquezasMed = 0.0;
		limiarRiquezaMed = 0.0;
		for (Medicos a: medicos) {
			somaRiquezasMed += (a.sinaisRiqueza);
		}
		limiarRiquezaMed = (somaRiquezasMed / medicos.size()) * 1.5;
	}
	
	public static void atualizaContribuintesLimiarRiqueza () 
	{
		atualizaLimiarRiqueza();
		for (Medicos a: medicos) {
			if (a.sinaisRiqueza >= limiarRiquezaMed)
			{
				a.setRiquezaExcessiva(true);
			}
		}
	}
	
	public static List<Medicos> getMedicos ()
	{
		return medicos;
	}
	
	public static double getLimiarRiqueza ()
	{
		return limiarRiquezaMed;
	}
	
	
	public static int getNumeroDeMedicos ()
	{
		return medicos.size();
	}

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 13 * hash + this.pacientes;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.gastosCongressos) ^ (Double.doubleToLongBits(this.gastosCongressos) >>> 32));
        return hash;
    }
    
	@Override
	public boolean equals (Object obj) 
	{
		if (!(obj instanceof Medicos))
		{
			return false;
		}
		Medicos outroMedico = (Medicos) obj;
		return outroMedico.getNomeContribuinte().equals(getNomeContribuinte()) && outroMedico.getNumeroContribuinte().equals(getNumeroContribuinte());
	}

	public static String consultaContribuinte (String nome, String numeroContr) 
	{
		for (Medicos a: medicos) 
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