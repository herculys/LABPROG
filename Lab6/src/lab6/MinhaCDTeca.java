package lab6;

/* Aluno : Herculys Sabino */

import java.util.*;

public class MinhaCDTeca
{
	private ArrayList<CD> colecaoCDs = new ArrayList<CD>();
	
	public MinhaCDTeca()
	{
		this.colecaoCDs = new ArrayList<CD>();
	}
	
	public boolean removeCDs (ArrayList<CD> cdsARemover) throws Exception
	{
		if (colecaoCDs.size() == 0)
		{
			throw new Exception("Não existem CDs na coleção para remover.");
		}
		boolean removeu = false;
		for (CD a: cdsARemover) 
		{
			CD cdremover = pesquisaCD(a.getAlbum());
			if (cdremover != null) 
			{
				removeCD(a.getAlbum());
				removeu = true;
			}
		}
		return removeu;
	}
	
	public int numeroDeCDs ()
	{
		return colecaoCDs.size();
	}
	
	public CD pesquisaCD (String tituloPesquisado)
	{
		for (CD a: colecaoCDs) 
		{
			if (a.getAlbum().equals(tituloPesquisado)) return a;
		}
		return null;
	}
	
	public void adicionarCDs(ArrayList<CD> colecaoCDsRecebido) throws Exception
	{
		if (colecaoCDsRecebido == null) 
		{
			throw new Exception("A coleção de CDs não pode ser nula.");
		}
		for (int i = 0; i < colecaoCDsRecebido.size(); i++) 
		{
			colecaoCDs.add(colecaoCDsRecebido.get(i));
		}
	}
	
	public CD removeCD (String tituloARemover) 
	{
		for (CD a: colecaoCDs)
		{
			if (a.getAlbum().equals(tituloARemover)) 
			{
				colecaoCDs.remove(a);
				return a;
			}
		}
		return null;
	}
	
	public void adicionarCD(CD inserirCD) throws Exception
	{
		if (inserirCD == null){
			throw new Exception("O CD inserido é nulo");
		}
		colecaoCDs.add(inserirCD);
	}
	
    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.colecaoCDs);
        return hash;
    }
	
	@Override
	public String toString()
	{
		String retorno = new String();
		for (CD a: colecaoCDs) 
		{
			retorno += (a.toString());
		}
		return "CDs na coleção:" + retorno;
	}
    
	@Override
	public boolean equals (Object obj) 
	{
		if (!(obj instanceof MinhaCDTeca)) return false;
		MinhaCDTeca cdTeca2 = (MinhaCDTeca) obj;
		for (CD a: colecaoCDs)
		{
			if (cdTeca2.pesquisaCD(a.getAlbum()) == null) return false;
		}
		return true;
	}
}