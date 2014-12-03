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

	/*
	@Test
	public void testGodzillaAtacaUnTerrenoConUnaRutaYLaRutaQuedaDaniada() {

		Godzilla godzilla = new Godzilla();
		Ruta unaRuta = new Ruta();
		Terreno unTerreno = new Terreno();
		unTerreno.agregarServicio(unaRuta);

		assertEquals(unTerreno.estaConectada(unaRuta), true);
		assertEquals(unaRuta.estaDaniada(), false);

		unTerreno.afectarCon(godzilla);

		assertEquals(unaRuta.estaDaniada(), true);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaLineaDeTensionYLaLineaQuedaDaniada() {

		Terreno unTerreno = new Terreno();
		LineaDeTension unaLinea = new LineaDeTension();

		unTerreno.agregarServicio(unaLinea);
		assertEquals(unTerreno.estaConectada(unaLinea), true);
		assertEquals(unaLinea.estaDaniada(), false);

		unTerreno.afectarCon(new Godzilla());

		assertEquals(unaLinea.estaDaniada(), true);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaTuberiaYNoPierdeElServicio() {

		Terreno unTerreno = new Terreno();
		Tuberia unaTuberia = new Tuberia();

		unTerreno.agregarServicio(unaTuberia);
		assertEquals(unTerreno.estaConectada(unaTuberia), true);

		unTerreno.afectarCon(new Godzilla());

		assertEquals(unTerreno.estaConectada(unaTuberia), true);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConLosTresServiciosYRutaYLineasQuedanDaniadasTuberiasNo() {

		Terreno unTerreno = new Terreno();
		LineaDeTension unaLinea = new LineaDeTension();
		Ruta unaRuta = new Ruta();
		Tuberia unaTuberia = new Tuberia();

		unTerreno.agregarServicio(unaRuta);
		unTerreno.agregarServicio(unaLinea);
		unTerreno.agregarServicio(unaTuberia);

		assertEquals(unTerreno.estaConectada(unaTuberia), true);
		assertEquals(unTerreno.estaConectada(unaLinea), true);
		assertEquals(unTerreno.estaConectada(unaRuta), true);

		assertEquals(unaLinea.estaDaniada(), false);
		assertEquals(unaRuta.estaDaniada(), false);

		unTerreno.afectarCon(new Godzilla());

		assertEquals(unaLinea.estaDaniada(), true);
		assertEquals(unaRuta.estaDaniada(), true);
		assertEquals(unaTuberia.estaActiva(), true);
	}

	*/
	
	@Test
	public void testGodzillaAtacaAUnMapaLLanoYComienzaEnLaCoordenada3_0YTerminaEnLa3_25() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new MapaLlano());

		godzilla.atacarSinRandomParaTest(mapa, new Coordenada(3,0), new CaminarDerecho());

		assertEquals((godzilla.obtenerCoordenada()).obtenerX(), 3);
		assertEquals((godzilla.obtenerCoordenada()).obtenerY(), 25);
	}
	
	@Test
	public void testGodzillaAtacaAUnMapaDeTamanio5YComienzaEnLaCoordenada3_0YTerminaEnLa3_5() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());

		godzilla.atacarSinRandomParaTest(mapa, new Coordenada(3,0), new CaminarDerecho());

		assertEquals((godzilla.obtenerCoordenada()).obtenerX(), 3);
		assertEquals((godzilla.obtenerCoordenada()).obtenerY(), 5);
	}
	
	@Test
	public void testGodzillaAtacaAUnMapaDeTamanio5AfectandoAUnaIndustriaEnLaCoordenada3_2() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		Edificio ind = new Industria();
		
		mapa.construir(ind, new Coordenada(3,2));
		
		
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 100);

		godzilla.atacarSinRandomParaTest(mapa, new Coordenada(3,0), new CaminarDerecho());
		
		ind = (Industria) mapa.obtenerHectarea(new Coordenada(3,2)).obtenerConstruccion();
		assertEquals(ind.obtenerSalud(), 60);
		
	}
	
	@Test
	public void testGodzillaAtacaAUnMapaDeTamanio5AfectandoAEdificiosQueEstanEnLaFila3DelMapa() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		Residencia res1 = new Residencia();
		Residencia res2 = new Residencia();
		Residencia res3 = new Residencia();
		Residencia res4 = new Residencia();
		Residencia res5 = new Residencia();
		
		mapa.construir(res1, new Coordenada(3,0));
		mapa.construir(res2, new Coordenada(3,1));
		mapa.construir(res3, new Coordenada(3,2));
		mapa.construir(res4, new Coordenada(3,3));
		mapa.construir(res5, new Coordenada(3,4));
		
		
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,0))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,1))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,3))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,4))).obtenerConstruccion()).obtenerSalud(), 100);

		godzilla.atacarSinRandomParaTest(mapa, new Coordenada(3,0), new CaminarDerecho());

		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,0))).obtenerConstruccion()).obtenerSalud(), 0);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,1))).obtenerConstruccion()).obtenerSalud(), 0);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 0);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,3))).obtenerConstruccion()).obtenerSalud(), 0);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,4))).obtenerConstruccion()).obtenerSalud(), 0);
	}
	
	@Test
	public void testGodzillaAtacaAUnMapaDeTamanio5AfectandoAConstruccionesQueEstanEnLaFila3DelMapa() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		Residencia residencia = new Residencia();
		Comercio comercio = new Comercio();
		Industria industria = new Industria();
		CentralMineral centralMineral = new CentralMineral();
		
		mapa.construir(residencia, new Coordenada(3,0));
		mapa.construir(comercio, new Coordenada(3,1));
		mapa.construir(industria, new Coordenada(3,2));
		mapa.construir(centralMineral, new Coordenada(3,4));
		
		
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,0))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,1))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,4))).obtenerConstruccion()).obtenerSalud(), 100);

		godzilla.atacarSinRandomParaTest(mapa, new Coordenada(3,0), new CaminarDerecho());

		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,0))).obtenerConstruccion()).obtenerSalud(), 0);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,1))).obtenerConstruccion()).obtenerSalud(), 25);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 60);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,4))).obtenerConstruccion()).obtenerSalud(), 65);
	}
	
	@Test
	public void testGodzillaAtacaUnMapaDeTamanio5CaminandoEnZigzagDaniandoResidencias(){
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		Residencia res1 = new Residencia();
		Residencia res2 = new Residencia();
		Residencia res3 = new Residencia();
		Residencia res4 = new Residencia();
		Residencia res5 = new Residencia();
		
		mapa.construir(res1, new Coordenada(3,0));
		mapa.construir(res2, new Coordenada(2,1));
		mapa.construir(res3, new Coordenada(3,2));
		mapa.construir(res4, new Coordenada(4,3));
		mapa.construir(res5, new Coordenada(3,4));
		

		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,0))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(2,1))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(4,3))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,4))).obtenerConstruccion()).obtenerSalud(), 100);
		
		godzilla.atacarSinRandomParaTest(mapa, new Coordenada(3,0), new CaminarZigZag());
	
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,0))).obtenerConstruccion()).obtenerSalud(), 00);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(2,1))).obtenerConstruccion()).obtenerSalud(), 00);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 00);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(4,3))).obtenerConstruccion()).obtenerSalud(), 00);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,4))).obtenerConstruccion()).obtenerSalud(), 00);
	}
	
	@Test
	public void testGodzillaAtacaUnMapaDeTamanio5CaminandoEnZigzagDaniandoResidenciasQueSeEncuentranAlineadas(){
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		Residencia res1 = new Residencia();
		Residencia res2 = new Residencia();
		Residencia res3 = new Residencia();
		Residencia res4 = new Residencia();
		Residencia res5 = new Residencia();
		
		mapa.construir(res1, new Coordenada(3,0));
		mapa.construir(res2, new Coordenada(3,1));
		mapa.construir(res3, new Coordenada(3,2));
		mapa.construir(res4, new Coordenada(3,3));
		mapa.construir(res5, new Coordenada(3,4));
		

		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,0))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,1))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,3))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,4))).obtenerConstruccion()).obtenerSalud(), 100);
		
		godzilla.atacarSinRandomParaTest(mapa, new Coordenada(3,0), new CaminarZigZag());
	
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,0))).obtenerConstruccion()).obtenerSalud(), 00);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,1))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,2))).obtenerConstruccion()).obtenerSalud(), 00);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,3))).obtenerConstruccion()).obtenerSalud(), 100);
		assertEquals(((mapa.obtenerHectarea(new Coordenada(3,4))).obtenerConstruccion()).obtenerSalud(), 00);
	}

}
