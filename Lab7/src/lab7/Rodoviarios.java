package lab7;

/* Aluno : Herculys Sabino */

public abstract class Rodoviarios extends Contribuintes 
{
	protected double quilometros_percorridos;
	
	public Rodoviarios(String nome, String numeroContribuinte, double km_percorridos, double valorCarro, double valorCasa) throws Exception 
	{
		super(nome, numeroContribuinte, valorCarro, valorCasa);
		if (verificaSeENegativo(km_percorridos)) throw new Exception("Os quil�metros percorridos n�o podem ser negativos.");
		this.quilometros_percorridos = km_percorridos;
	}
	
	@Override
	protected void descontoTributacao() 
	{
		this.descontos = 0.01 * quilometros_percorridos;
	}
	
	private boolean verificaSeENegativo (double numero) 
	{
		if (numero < 0)
		{
			return true;
		}
		return false;
	}
}