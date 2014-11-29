package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Assert;
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
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0,20));
		PozoDeAgua unPozo = new PozoDeAgua();
		Coordenada coordAux = new Coordenada (0,21);
		Tuberia tuberia = new Tuberia();
		hectarea.construir(unPozo);
		mapa.crearTuberia(coordAux);
		Hectarea hectareaContinua= mapa.obtenerHectarea(coordAux);
		assertEquals(hectareaContinua.tieneElServicio( tuberia),true);	
	
	}
}
