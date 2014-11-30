package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GodzillaTest {

	@Test
	public void testGodzillaSeCreaConExito() {
		Godzilla godzilla = new Godzilla();
		assertNotNull(godzilla);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaResidencia() {
		Godzilla godzilla = new Godzilla();
		Residencia residencia = new Residencia();
		Terreno terreno = new Terreno();
		assertEquals(terreno.construir(residencia), true);
		terreno.afectarCon(godzilla);
		assertEquals(residencia.obtenerSalud(), 0);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaIndustria() {
		Godzilla godzilla = new Godzilla();
		Industria industria = new Industria();
		Terreno terreno = new Terreno();
		assertEquals(terreno.construir(industria), true);
		terreno.afectarCon(godzilla);
		assertEquals(industria.obtenerSalud(), 60);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaEstacionDeBomberos() {
		Godzilla godzilla = new Godzilla();
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		Terreno terreno = new Terreno();
		assertEquals(terreno.construir(bomberos), true);
		terreno.afectarCon(godzilla);
		assertEquals(bomberos.obtenerSalud(), 0);
	}

	@Test
	public void testGodzillaAtacaAguaConUnPozoDeAgua() {
		Godzilla godzilla = new Godzilla();
		PozoDeAgua pozo = new PozoDeAgua();
		Agua agua = new Agua();
		assertEquals(agua.construir(pozo), true);
		agua.afectarCon(godzilla);
		assertEquals(pozo.obtenerSalud(), 0);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaRutaYLaRutaQuedaDaniada() {

		Godzilla godzilla = new Godzilla();
		RutaPavimentada unaRuta = new RutaPavimentada();
		Terreno unTerreno = new Terreno();
		unTerreno.agregarServicio(unaRuta);

		assertEquals(unTerreno.tieneServicio(unaRuta), true);
		assertEquals(unaRuta.estaDaniada(), false);

		unTerreno.afectarCon(godzilla);

		assertEquals(unaRuta.estaDaniada(), true);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaLineaDeTensionYLaLineaQuedaDaniada() {

		Terreno unTerreno = new Terreno();
		LineaDeTension unaLinea = new LineaDeTension();

		unTerreno.agregarServicio(unaLinea);
		assertEquals(unTerreno.tieneServicio(unaLinea), true);
		assertEquals(unaLinea.estaDaniada(), false);

		unTerreno.afectarCon(new Godzilla());

		assertEquals(unaLinea.estaDaniada(), true);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaTuberiaYNoPierdeElServicio() {

		Terreno unTerreno = new Terreno();
		Tuberia unaTuberia = new Tuberia();

		unTerreno.agregarServicio(unaTuberia);
		assertEquals(unTerreno.tieneServicio(unaTuberia), true);

		unTerreno.afectarCon(new Godzilla());

		assertEquals(unTerreno.tieneServicio(unaTuberia), true);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConLosTresServiciosYRutaYLineasQuedanDaniadasTuberiasNo() {

		Terreno unTerreno = new Terreno();
		LineaDeTension unaLinea = new LineaDeTension();
		RutaPavimentada unaRuta = new RutaPavimentada();
		Tuberia unaTuberia = new Tuberia();

		unTerreno.agregarServicio(unaRuta);
		unTerreno.agregarServicio(unaLinea);
		unTerreno.agregarServicio(unaTuberia);

		assertEquals(unTerreno.tieneServicio(unaTuberia), true);
		assertEquals(unTerreno.tieneServicio(unaLinea), true);
		assertEquals(unTerreno.tieneServicio(unaRuta), true);

		assertEquals(unaLinea.estaDaniada(), false);
		assertEquals(unaRuta.estaDaniada(), false);

		unTerreno.afectarCon(new Godzilla());

		assertEquals(unaLinea.estaDaniada(), true);
		assertEquals(unaRuta.estaDaniada(), true);
		assertEquals(unaTuberia.estaActivo(), true);
	}

	@Test
	public void testGodzillaAtacaAUnMapaLLanoYComienzaEnLaCoordenada3_0YTerminaEnLa3_25() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new MapaLlano());

		assertEquals((godzilla.obtenerCoordenada()).obtenerX(), 3);
		assertEquals((godzilla.obtenerCoordenada()).obtenerY(), 0);

		godzilla.atacar(mapa);

		assertEquals((godzilla.obtenerCoordenada()).obtenerX(), 3);
		assertEquals((godzilla.obtenerCoordenada()).obtenerY(), 25);
	}
	
	@Test
	public void testGodzillaAtacaAUnMapaDeTamanio5YComienzaEnLaCoordenada3_0YTerminaEnLa3_5() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());

		assertEquals((godzilla.obtenerCoordenada()).obtenerX(), 3);
		assertEquals((godzilla.obtenerCoordenada()).obtenerY(), 0);

		godzilla.atacar(mapa);

		assertEquals((godzilla.obtenerCoordenada()).obtenerX(), 3);
		assertEquals((godzilla.obtenerCoordenada()).obtenerY(), 5);
	}
	
	/*@Test
	public void testGodzillaAtacaAUnMapaDeTamanio5AfectandoAEdificiosQueEstanEnLaFila3DelMapa() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		Residencia res1 = new Residencia();
		Residencia res2 = new Residencia();
		Residencia res3 = new Residencia();
		Industria ind1 = new Industria();
		Industria ind2 = new Industria();
		
		mapa.construir(res1, new Coordenada(3,0));
		mapa.construir(res2, new Coordenada(3,1));
		mapa.construir(res3, new Coordenada(3,2));
		mapa.construir(ind1, new Coordenada(3,3));
		mapa.construir(ind2, new Coordenada(3,4));
		
		
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,0))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,1))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,3))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,4))).obtenerConstruccion()).obtenerSalud(), 100);

		godzilla.atacar(mapa);

		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,0))).obtenerConstruccion()).obtenerSalud(), 0);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,1))).obtenerConstruccion()).obtenerSalud(), 0);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 0);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,3))).obtenerConstruccion()).obtenerSalud(), 60);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,4))).obtenerConstruccion()).obtenerSalud(), 60);
	}*/

}
