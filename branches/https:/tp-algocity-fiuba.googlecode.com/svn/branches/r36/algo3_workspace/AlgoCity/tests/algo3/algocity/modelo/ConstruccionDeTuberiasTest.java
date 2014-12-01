package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;


public class ConstruccionDeTuberiasTest {

	@Test	
	public void testConstruirTuberiaEnTerreno(){
		
		Tuberia unaTuberia = new Tuberia();
		Terreno unTerreno = new Terreno();
		unTerreno.agregarServicio(unaTuberia);
		assertEquals(unTerreno.tieneElServicio(unaTuberia),true);

	}
	
	@Test	
	public void testConstruirTuberiaEnAgua(){
		
		Tuberia unaTuberia = new Tuberia();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.agregarServicio(unaTuberia);
		assertEquals(unaHectareaAgua.tieneElServicio(unaTuberia),true);

	}

	
	@Test	
	public void testEsPosibleConstruirTuberiaAlLadoDePozoDeAgua(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea= mapa.obtenerHectarea(new Coordenada(0,20));
		PozoDeAgua unPozo = new PozoDeAgua();
		Coordenada coordAux = new Coordenada (0,21);
		Tuberia tuberia = new Tuberia();
		hectarea.construir(unPozo);
		mapa.crearTuberia(coordAux);
		Hectarea hectareaContinua= mapa.obtenerHectarea(coordAux);
		assertEquals(hectareaContinua.tieneElServicio( tuberia),true);
	
	}
	
	@Test	
	public void testNoEsPosibleConstruirTuberiaSinTuberiasAdyacentes(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		Coordenada coordAux = new Coordenada (0,21);
		mapa.crearTuberia(coordAux);
		Hectarea hectarea= mapa.obtenerHectarea(coordAux);
		assertEquals(hectarea.tieneElServicio(new Tuberia()),false);
	
	}
	
	@Test	
	public void testEsPosibleConstruirTuberiaAbajoDeOtraTuberia(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea= mapa.obtenerHectarea(new Coordenada(0,20));
		PozoDeAgua unPozo = new PozoDeAgua();
		Coordenada coordAux = new Coordenada (0,21);
		hectarea.construir(unPozo);
		mapa.crearTuberia(coordAux);
		mapa.crearTuberia(new Coordenada(0,22));
		Hectarea hectareaContinua= mapa.obtenerHectarea(new Coordenada (0,22));
		assertEquals(hectareaContinua.tieneElServicio( new Tuberia()),true);
	
	}
	
	@Test	
	public void testEsPosibleConstruirTuberiaALaDerechaDeOtraTuberia(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea= mapa.obtenerHectarea(new Coordenada(0,20));
		PozoDeAgua unPozo = new PozoDeAgua();
		Coordenada coordAux = new Coordenada (0,21);
		hectarea.construir(unPozo);
		mapa.crearTuberia(coordAux);
		mapa.crearTuberia(new Coordenada(1,21));
		Hectarea hectareaContinua= mapa.obtenerHectarea(new Coordenada (1,21));
		assertEquals(hectareaContinua.tieneElServicio( new Tuberia()),true);
	
	}
	
	@Test	
	public void testEsPosibleConstruirTuberiaALaIzquierdaDeOtraTuberia(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea= mapa.obtenerHectarea(new Coordenada(24,24));
		PozoDeAgua unPozo = new PozoDeAgua();
		Coordenada coordAux = new Coordenada (23,24);
		hectarea.construir(unPozo);
		mapa.crearTuberia(coordAux);
		mapa.crearTuberia(new Coordenada(22,24));
		Hectarea hectareaContinua= mapa.obtenerHectarea(new Coordenada (22,24));
		assertEquals(hectareaContinua.tieneElServicio( new Tuberia()),true);
	
	}
	
	@Test	
	public void testEsPosibleConstruirTuberiaArribaDeOtraTuberia(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea= mapa.obtenerHectarea(new Coordenada(24,24));
		PozoDeAgua unPozo = new PozoDeAgua();
		Coordenada coordAux = new Coordenada (23,24);
		hectarea.construir(unPozo);
		mapa.crearTuberia(coordAux);
		mapa.crearTuberia(new Coordenada(23,23));
		Hectarea hectareaContinua= mapa.obtenerHectarea(new Coordenada (23,23));
		assertEquals(hectareaContinua.tieneElServicio( new Tuberia()),true);
	
	}
	
	
	
}
