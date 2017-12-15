package lab6;

/* Aluno : Herculys Sabino */

import java.util.*;

public class CD{
	
	private ArrayList<String> faixas = new ArrayList<String>();
	private int M;
	private String album, artista, musicaM;

	public CD(String album, String artista, int M) throws Exception
	{
		if (album == null || album.trim().isEmpty())
		{
			throw new Exception ("O Titulo do album está vazio.");
		}
                if (artista == null || artista.trim().isEmpty())
                {
                	throw new Exception ("O Artista do album está vazio.");
                }
                if (M <= 0)
                {
                	throw new Exception ("O Numero de faixas é 0");
                }
		this.artista = artista;
		this.album = album;
		this.M = M;
                this.musicaM = "";
                adicionafaixasVaziasCD();
	}
	
	public CD(String album, String artista) throws Exception 
	{
		if (album == null || album.trim().isEmpty())
		{
			throw new Exception ("O Titulo do album está vazio.");
		}
                if (artista == null || artista.trim().isEmpty())
                {
                	throw new Exception ("O Artista do album está vazio.");
                }
		this.artista = artista;
		this.album = album;
		this.M = 10;
		this.musicaM = "";
                adicionafaixasVaziasCD();
	}
        
    private void adicionafaixasVaziasCD () 
    {
    	for (int i = 0; i < M; i++)
    	{
    		faixas.add(i, "");
		}
    }

	public boolean adicionaMusica(String novaMusica) 
	{
		int indice = faixas.indexOf("");
		if (indice <= faixas.size() && indice != -1 && novaMusica != null)
		{
			faixas.set(indice, novaMusica);
			return true;
		}
		return false;
	}
	
	public int getM()
	{
		return M;
	}

	public String getmusicaM () 
	{
		return musicaM;
	}

	public String getAlbum() 
	{
		return album;
	}
	
	public String getArtista() 
	{
		return artista;
	}
	
	public String getMusica(int i)
	{
		if (i >= M || i < 0) 
		{
			return null;
		}
		return faixas.get(i-1);
	}
	
	public void setmusicaM (String musicaM) throws Exception 
	{
		if (!(faixas.contains(musicaM))) 
		{
			throw new Exception("Musica não encontrada");
		}
		this.musicaM = musicaM;
	}
	
	@Override
	public String toString()
	{
		String resultado = "\nAlbum: " + album + ", Artista: " + artista;
		for (String msc: faixas)
		{
			resultado += msc; 
		}
		return resultado;
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faixas == null) ? 0 : faixas.hashCode());
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object album)
	{
		if (album instanceof CD)
		{
			CD newAlbum = (CD)album;
			return album.equals(newAlbum.getAlbum()) && artista.equals(newAlbum.getArtista());
		}
		return false;
	}
}