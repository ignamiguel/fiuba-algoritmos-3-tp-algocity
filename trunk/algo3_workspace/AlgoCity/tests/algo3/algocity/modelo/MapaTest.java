package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaTest {

	@Test
	public void CrearMapaConExitoTest(){
		Mapa mapa = new Mapa();
		assertNotNull(mapa);
	}
	
	@Test
	public void MapaContieneTerreno(){
		Mapa mapa = new Mapa();
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0,0));
		assertEquals(hectarea.obtenerNombre(), "Terreno");
	}
}
