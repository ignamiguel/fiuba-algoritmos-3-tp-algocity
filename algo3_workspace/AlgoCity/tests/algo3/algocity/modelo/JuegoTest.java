package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuegoTest {

	@Test
	public void crearUnJuego() {
		Juego juego = new Juego();

		assertNotNull("Instancia de un juego", juego);
	}

	@Test
	public void crearUnJuegoConMapaPlayaParaVerTerreno(){
		Juego juego = new Juego();
		
		String resultado = juego.verMapa(new Coordenada(0,0));		
		
		assertEquals("Terreno", resultado);
	}
	
	@Test
	public void crearUnJuegoConMapaPlayaParaVerAgua(){
		Juego juego = new Juego();
		
		String resultado = juego.verMapa(new Coordenada(0,20));		
		
		assertEquals("Agua", resultado);
	}

}
