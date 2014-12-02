package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConexionesTest {

	@Test
	public void construirRutaEnTerrenoAgregaLaConexionRuta() {

		Ruta ruta = new Ruta();
		Terreno terreno = new Terreno();		
		assertEquals(false, terreno.tieneConexion(TipoDeConexion.Ruta));		
		terreno.conectar(ruta);		
		assertEquals(true, terreno.tieneConexion(TipoDeConexion.Ruta));

	}
	
	@Test
	public void construirTuberiaEnTerrenoAgregaLaConexionTuberia() {

		Tuberia tuberia = new Tuberia();
		Terreno terreno = new Terreno();		
		assertEquals(false, terreno.tieneConexion(TipoDeConexion.Tuberia));		
		terreno.conectar(tuberia);		
		assertEquals(true, terreno.tieneConexion(TipoDeConexion.Tuberia));	
	}
	
	@Test
	public void construirLineaDeTensionEnTerrenoAgregaLaConexionLineasDeTension() {

		LineaDeTension ldt = new LineaDeTension();
		Terreno terreno = new Terreno();		
		assertEquals(false, terreno.tieneConexion(TipoDeConexion.LineaDeTension));		
		terreno.conectar(ldt);		
		assertEquals(true, terreno.tieneConexion(TipoDeConexion.LineaDeTension));
	}

	@Test
	public void construirTuberiaEnAguaAgregaLaConexionTuberia() {

		Tuberia tuberia = new Tuberia();
		Agua agua = new Agua();		
		assertEquals(false, agua.tieneConexion(TipoDeConexion.Tuberia));		
		agua.conectar(tuberia);		
		assertEquals(true, agua.tieneConexion(TipoDeConexion.Tuberia));	

	}
		
	
	/* Revisar los test de abajo con la nueva implementacion de conexiones y servicios */
	
	@Test
	public void testConstruirUnaRutaEnUnMapaTestEn3_1y3_2() {
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		mapa.conectar(new Ruta(), new Coordenada(3, 1), new Coordenada(3, 2));
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 1)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 2)).estaConectada(
						new Ruta()), true);
	}

	@Test
	public void testConstruirUnaRutaEnUnMapaTestDesde3_1Hasta3_4() {
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		mapa.conectar(new Ruta(), new Coordenada(3, 1), new Coordenada(3, 4));
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 1)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 2)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 3)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 4)).estaConectada(
						new Ruta()), true);
	}

	@Test
	public void testConstruirUnaRutaEnUnMapaTestDesde0_3Hasta4_3() {
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		mapa.conectar(new Ruta(), new Coordenada(0, 3), new Coordenada(4, 3));
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(0, 3)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(1, 3)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(2, 3)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 3)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(4, 3)).estaConectada(
						new Ruta()), true);

	}

	@Test
	public void testConstruirUnaRutaDesde1_1Hasta3_3() {
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		mapa.conectar(new Ruta(), new Coordenada(1, 1), new Coordenada(3, 3));

		assertEquals(
				mapa.obtenerHectarea(new Coordenada(1, 1)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(2, 1)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 1)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 2)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 3)).estaConectada(
						new Ruta()), true);
	}

	@Test
	public void testConstruirUnaRutaDesde0_0Hasta4_4() {
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		mapa.conectar(new Ruta(), new Coordenada(0, 0), new Coordenada(4, 4));

		assertEquals(
				mapa.obtenerHectarea(new Coordenada(0, 0)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(1, 0)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(2, 0)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(3, 0)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(4, 0)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(4, 1)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(4, 2)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(4, 3)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(4, 4)).estaConectada(
						new Ruta()), true);
	}

	@Test
	public void testConstruirUnaRutaDesde1_0Hasta1_4YNoTienenAccesoAlTransito() {
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		mapa.conectar(new Ruta(), new Coordenada(1, 0), new Coordenada(1, 4));

		assertEquals(
				mapa.obtenerHectarea(new Coordenada(1, 0)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(1, 1)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(1, 2)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(1, 3)).estaConectada(
						new Ruta()), true);
		assertEquals(
				mapa.obtenerHectarea(new Coordenada(1, 4)).estaConectada(
						new Ruta()), true);

		assertEquals(mapa.obtenerHectarea(new Coordenada(1, 0))
				.tieneAccesoAlTransito(), false);
		assertEquals(mapa.obtenerHectarea(new Coordenada(1, 1))
				.tieneAccesoAlTransito(), false);
		assertEquals(mapa.obtenerHectarea(new Coordenada(1, 2))
				.tieneAccesoAlTransito(), false);
		assertEquals(mapa.obtenerHectarea(new Coordenada(1, 3))
				.tieneAccesoAlTransito(), false);
		assertEquals(mapa.obtenerHectarea(new Coordenada(1, 4))
				.tieneAccesoAlTransito(), false);
	}

	@Test
	public void testMapaDeTamanio25GeneraUnaEntradaAlaCiudadEnLaCoordenada0_12() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0, 12));
		assertEquals(hectarea.obtenerNombre(), "Entrada a la ciudad");
	}

	@Test
	public void testMapaDeTamanio5GeneraUnaEntradaAlaCiudadEnLaCoordenada0_2() {
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0, 2));
		assertEquals(hectarea.obtenerNombre(), "Entrada a la ciudad");
	}

	@Test
	public void testMapaDeTamanio5GeneraUnaEntradaAlaCiudadEnLaCoordenada0_2YTieneAccesoAlTransito() {
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0, 2));
		assertEquals(hectarea.obtenerNombre(), "Entrada a la ciudad");
		assertEquals(hectarea.tieneAccesoAlTransito(), true);
	}

	@Test
	public void testEntradaALaCiudadPropagaElTransitoAHectareaVecina() {
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		Hectarea entrada = mapa.obtenerHectarea(new Coordenada(0, 2));

		mapa.conectar(new Ruta(), new Coordenada(0, 3), new Coordenada(0, 4));

		assertEquals(entrada.obtenerNombre(), "Entrada a la ciudad");
		assertEquals(entrada.tieneAccesoAlTransito(), true);

		Hectarea hectarea1 = mapa.obtenerHectarea(new Coordenada(0, 3));
		Hectarea hectarea2 = mapa.obtenerHectarea(new Coordenada(0, 4));

		assertEquals(hectarea1.tieneAccesoAlTransito(), false);
		assertEquals(hectarea2.tieneAccesoAlTransito(), false);

		// entrada.propagarTransito();

		assertEquals(hectarea1.tieneAccesoAlTransito(), true);
		assertEquals(hectarea2.tieneAccesoAlTransito(), true);

	}

	// Falta implementaciones de construir ruta al lado de punto de entrada de
	// gente.

}
