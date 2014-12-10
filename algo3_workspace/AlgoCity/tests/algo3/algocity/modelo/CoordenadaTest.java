package algo3.algocity.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//import org.junit.Test;

public class CoordenadaTest {

	/*@Test(expected = CoordenadaInvalidaExcepcion.class)
	public void valoresDeCoordenadaNegativosArrojaExcepcion() {
		new Coordenada(-1, 0);

	}*/
	
	@Test
	public void construyoCoordenadaConXigual1eYigual5(){

		Coordenada coor = new Coordenada(1,5);
		
		assertEquals(1, coor.obtenerX());
		assertEquals(5, coor.obtenerY());
		
	}
	
	@Test
	public void aumentoXen1AunaCoordenada(){

		Coordenada coor = new Coordenada(1,5);
		coor.aumentarX(1);
		assertEquals(2, coor.obtenerX());
		assertEquals(5, coor.obtenerY());
		
	}
	
	@Test
	public void aumentoYen10AunaCoordenada(){

		Coordenada coor = new Coordenada(1,5);
		coor.aumentarY(7);
		assertEquals(1, coor.obtenerX());
		assertEquals(12, coor.obtenerY());
		
	}
	
	

}
