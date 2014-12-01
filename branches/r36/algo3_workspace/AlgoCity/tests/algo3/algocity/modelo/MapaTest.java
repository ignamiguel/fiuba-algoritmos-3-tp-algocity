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
	public void obtenerUnaCoordenadaFueraDelMapaArrojaExcepcion(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		
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
	
	@Test
	public void construirUnEdificioEnTerrenoVacioDevuelveVerdadero(){
		
		Mapa mapa = new Mapa(new MapaConPlaya());
		
		Edificio e = new Residencia();
		
		boolean resultado = mapa.construir(e, new Coordenada(1,1));
		
		assertEquals(true, resultado);		
	}
	
	@Test
	public void construirUnEdificioEnTerrenoConstruidoDevuelveFalso(){
		
		Mapa mapa = new Mapa(new MapaConPlaya());
		
		Edificio e = new Residencia();
		
		mapa.construir(e, new Coordenada(1,1));		
		
		Edificio otroEdificio = new Residencia();
		
		boolean resultado = mapa.construir(otroEdificio, new Coordenada(1,1));
		
		assertEquals(false, resultado);		
	}
	
	@Test
	public void construirUnPozoDeAguaEnAguaVaciaDevuelveVerdadero(){
		
		Mapa mapa = new Mapa(new MapaConPlaya());
		
		PozoDeAgua pda = new PozoDeAgua();
		
		boolean resultado = mapa.construir(pda, new Coordenada(1,20));
		
		assertEquals(true, resultado);		
		
	}
	
	@Test
	public void construirUnPozoDeAguaEnAguaConstruidaDevuelveFalso(){
		
		Mapa mapa = new Mapa(new MapaConPlaya());
		
		PozoDeAgua pda = new PozoDeAgua();
		
		mapa.construir(pda, new Coordenada(1,20));		
		
		PozoDeAgua otroPda = new PozoDeAgua();
		
		boolean resultado = mapa.construir(otroPda, new Coordenada(1,20));
		
		assertEquals(false, resultado);		
	}
}
