package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TerremotoTest {
	
	@Test
	public void testTerremotoCreadoConExito(){
		Terremoto terremoto = new Terremoto();
		assertNotNull(terremoto);
	}
	
	@Test
	public void testTerremotoCreadoTieneDanio100(){
		Terremoto terremoto = new Terremoto();
		assertEquals(terremoto.obtenerDanio(),100);
	}
	
	@Test
	public void testTerremotoCargadoCon10DeDanio(){
		Terremoto terremoto = new Terremoto();
		terremoto.cargarDanio(10);
		assertEquals(terremoto.obtenerDanio(),10);
	}
}
