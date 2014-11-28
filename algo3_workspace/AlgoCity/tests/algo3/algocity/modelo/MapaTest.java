package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaTest {

	@Test
	public void testCrearMapaConExitoTest(){
		Mapa mapa = new Mapa(new MapaLlano());
		assertNotNull(mapa);
	}
	
	@Test
	public void testMapaContieneTerrenoEn0_0ConMapaLlano(){
		Mapa mapa = new Mapa(new MapaLlano());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0,0));
		assertEquals(hectarea.obtenerNombre(), "Terreno");
	}
	
	@Test
	public void testMapaContieneTerrenoEn10_10ConMapaLlano(){
		Mapa mapa = new Mapa(new MapaLlano());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(10,10));
		assertEquals(hectarea.obtenerNombre(), "Terreno");

	}
	
	@Test
	public void testMapaContieneTerrenoEn10_10ConMapaConPlaya(){
		Mapa mapa = new Mapa(new MapaLlano());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(10,10));
		assertEquals(hectarea.obtenerNombre(), "Terreno");

	}
	
	
	@Test
	public void testMapaContieneAguaEn0_20ConMapaConPlaya(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0,20));
		assertEquals(hectarea.obtenerNombre(), "Agua");

	}
	
	@Test
	public void testMapaContieneAguaEn24_24ConMapaConPlaya(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(24,24));
		assertEquals(hectarea.obtenerNombre(), "Agua");

	}
	
	@Test
	public void testMapaContieneTerrenoEn19_19ConMapaConPlaya(){
		
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(19,19));
		assertEquals(hectarea.obtenerNombre(), "Terreno");

	}
	@Test
	public void testMapaCreaLineaDeTensionVerticalmente(){
		
		IGeneradorDeMapa unGenerador = new ClasePruebaParaGenerarMapa();
		
		Mapa unMapa = new Mapa(unGenerador);
		
		LineaDeTension unaLinea = new LineaDeTension();
		
		unMapa.crearLineaDeTensionDesdeHasta(new Coordenada(1,2),new Coordenada(4,2));
		//proximo a modificar, Pablo
		assertEquals((((Terreno) (unMapa.obtenerHectarea(new Coordenada(3,2)))).tieneLuz()),true);
		
		
		
		
	}
}
