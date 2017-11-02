package lab5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaRobo {
	private Sala salaRobo;
	private Robo robo;
	private final int NUM_LINHAS = 10;
	private final int NUM_COLUNAS = 10;
	private final int ENERGIA = 10;

	@Before
	public void criaObjetos() throws Exception {
		salaRobo = new Sala(NUM_LINHAS, NUM_COLUNAS);
	}
	
	@Test
	public void testaCriaRobo() throws Exception
	{
		try {
			new Robo(10, 10, -1);
			Assert.fail("Esperava excecao, pois a quantidade de energia esta negativa.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Energia negativa.",
					e.getMessage());
		}
		
		try {
			new Robo(10, 10, 0);
			Assert.fail("Esperava excecao, pois a quantidade de energia é 0.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Enegia é 0.",
					e.getMessage());
		}
		
		try {
			new Robo(-1, -1, 10);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na horizontal (linhas) e na vertical (colunas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}
/*
		try {
			new Robo(0, 0);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na horizontal (linhas) e na vertical (colunas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}

		try {
			new Robo(10, 0);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na vertical (colunas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}

		try {
			new Robo(0, 10);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na horizontal (linhas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}

		try {
			new Robo(0, 0);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na horizontal (linhas) e na vertical (colunas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}
			*/
	}

}
