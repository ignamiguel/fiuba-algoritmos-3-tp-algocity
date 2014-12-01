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
	public void testMapaObtenerCordenadaDeHectarea(){
		
		Mapa mapa = new Mapa(new MapaConPlaya());
		Coordenada unaCoordenada = new Coordenada(19,19);
		
		assertEquals((mapa.obtenerHectarea(unaCoordenada).obtenerUbicacion().obtenerX()), unaCoordenada.obtenerX());
		assertEquals((mapa.obtenerHectarea(unaCoordenada).obtenerUbicacion().obtenerY()), unaCoordenada.obtenerY());
	}
	@Test
	public void testMapaCreaLineaDeTensionVerticalmenteDeArribaAAbajo(){
		
		IGeneradorDeMapa unGenerador = new ClasePruebaParaGenerarMapa();
		
		Mapa unMapa = new Mapa(unGenerador);
		
		LineaDeTension unaLinea = new LineaDeTension();
		
		unMapa.crearLineaDeTensionDesdeHasta(new Coordenada(0,2),new Coordenada(3,2));
		
		assertEquals((((Terreno) (unMapa.obtenerHectarea(new Coordenada(2,2)))).tieneLuz()),true);
		
		
		
		
	}
	@Test
	public void testMapaCreaLineaDeTensionVerticalmenteDeAbajoAArriba(){
		
		IGeneradorDeMapa unGenerador = new ClasePruebaParaGenerarMapa();
		
		Mapa unMapa = new Mapa(unGenerador);
		
		LineaDeTension unaLinea = new LineaDeTension();
		
		unMapa.crearLineaDeTensionDesdeHasta(new Coordenada(3,2),new Coordenada(1,2));
		
		assertEquals((((Terreno) (unMapa.obtenerHectarea(new Coordenada(2,2)))).tieneLuz()),true);
		
		
		
		
	}
	@Test
	public void testMapaCreaLineaDeTensionHorizontalmenteDeIzquierdaADerecha(){
		
		IGeneradorDeMapa unGenerador = new ClasePruebaParaGenerarMapa();
		
		Mapa unMapa = new Mapa(unGenerador);
		
		LineaDeTension unaLinea = new LineaDeTension();
		
		unMapa.crearLineaDeTensionDesdeHasta(new Coordenada(0,0),new Coordenada(0,3));
		
		assertEquals((((Terreno) (unMapa.obtenerHectarea(new Coordenada(0,2)))).tieneLuz()),true);
		
		
		
		
	}
	@Test
	public void testMapaCreaLineaDeTensionHorizontalmenteDeDerechaAIzquierda(){
		
		IGeneradorDeMapa unGenerador = new ClasePruebaParaGenerarMapa();
		
		Mapa unMapa = new Mapa(unGenerador);
		
		LineaDeTension unaLinea = new LineaDeTension();
		
		unMapa.crearLineaDeTensionDesdeHasta(new Coordenada(3,3),new Coordenada(3,0));
		
		assertEquals((((Terreno) (unMapa.obtenerHectarea(new Coordenada(2,0)))).tieneLuz()),true);
		
		
		
		
	}
}
