package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaTest {

	@Test
	public void testCrearMapaConExitoTest(){
		Mapa mapa = new Mapa();
		assertNotNull(mapa);
	}
	
	@Test
	public void testMapaContieneTerrenoEn0_0(){
		Mapa mapa = new Mapa();
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0,0));
		assertEquals(hectarea.obtenerNombre(), "Terreno");
	}
	
	@Test
	public void testMapaContieneTerrenoEn10_10(){
		Mapa mapa = new Mapa();
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(10,10));
		assertEquals(hectarea.obtenerNombre(), "Terreno");

	}
	
	@Test
	public void testMapaContieneAguaEn0_20(){
		Mapa mapa = new Mapa();
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0,20));
		assertEquals(hectarea.obtenerNombre(), "Agua");

	}
	
	@Test
	public void testMapaContieneAguaEn24_24(){
		Mapa mapa = new Mapa();
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(24,24));
		assertEquals(hectarea.obtenerNombre(), "Agua");

	}
	
	@Test
	public void testMapaContieneTerrenoEn19_19(){
		
		Mapa mapa = new Mapa();
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(19,19));
		assertEquals(hectarea.obtenerNombre(), "Terreno");

	}
}
