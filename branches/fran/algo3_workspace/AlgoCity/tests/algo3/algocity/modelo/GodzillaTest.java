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
		assertEquals(residencia.getSalud(), 0);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaIndustria() {
		Godzilla godzilla = new Godzilla();
		Industria industria = new Industria();
		Terreno terreno = new Terreno();
		assertEquals(terreno.construir(industria), true);
		terreno.afectarCon(godzilla);
		assertEquals(industria.getSalud(), 60);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaEstacionDeBomberos() {
		Godzilla godzilla = new Godzilla();
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		Terreno terreno = new Terreno();
		assertEquals(terreno.construir(bomberos), true);
		terreno.afectarCon(godzilla);
		assertEquals(bomberos.getSalud(), 0);
	}

	@Test
	public void testGodzillaAtacaAguaConUnPozoDeAgua() {
		Godzilla godzilla = new Godzilla();
		PozoDeAgua pozo = new PozoDeAgua();
		Agua agua = new Agua();
		assertEquals(agua.construir(pozo), true);
		agua.afectarCon(godzilla);
		assertEquals(pozo.getSalud(), 0);
	}

	
	@Test
	public void testGodzillaAtacaUnTerrenoConUnaRutaYLaRutaQuedaDaniada() {

		Godzilla godzilla = new Godzilla();
		Ruta unaRuta = new Ruta();
		Terreno unTerreno = new Terreno();
		unTerreno.conectar(unaRuta);

		assertEquals(unTerreno.tieneConexion(TipoDeConexion.Ruta), true);
		assertEquals(unaRuta.getSalud(), 100);

		unTerreno.afectarCon(godzilla);

		assertEquals(unaRuta.getSalud(), 20);
	}

	@Test
	public void testGodzillaAtacaUnTerrenoConUnaLineaDeTensionYLaLineaQuedaDaniada() {

		Terreno unTerreno = new Terreno();
		LineaDeTension unaLinea = new LineaDeTension();

		unTerreno.conectar(unaLinea);
		assertEquals(unTerreno.tieneConexion(TipoDeConexion.LineaDeTension), true);
		assertEquals(unaLinea.getSalud(), 100);

		unTerreno.afectarCon(new Godzilla());

		assertEquals(unaLinea.getSalud(), 0);
	}


	@Test
	public void testGodzillaAtacaUnTerrenoConLosTresServiciosYRutaYLineasQuedanDaniadasTuberiasNo() {

		Terreno unTerreno = new Terreno();
		LineaDeTension unaLinea = new LineaDeTension();
		Ruta unaRuta = new Ruta();
		Tuberia unaTuberia = new Tuberia();

		unTerreno.conectar(unaRuta);
		unTerreno.conectar(unaLinea);
		unTerreno.conectar(unaTuberia);

		assertEquals(unTerreno.tieneConexion(TipoDeConexion.Tuberia), true);
		assertEquals(unTerreno.tieneConexion(TipoDeConexion.LineaDeTension), true);
		assertEquals(unTerreno.tieneConexion(TipoDeConexion.Ruta), true);

		assertEquals(unaLinea.getSalud(), 100);
		assertEquals(unaRuta.getSalud(), 100);

		unTerreno.afectarCon(new Godzilla());

		assertEquals(unaLinea.getSalud(), 0);
		assertEquals(unaRuta.getSalud(), 20);
		assertEquals(unaTuberia.getSalud(), 100);
	}
	
	@Test
	public void testGodzillaAtacaAUnMapaLLanoYComienzaEnLaCoordenada3_0YTerminaEnLa3_25() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new MapaLlano());
		IAtaqueGodzilla generadorGodzilla = new AtaqueGodzillaMock(new Coordenada(3,0), new CaminarDerecho());
		godzilla.atacar(mapa, generadorGodzilla);

		assertEquals((godzilla.getCoordenada()).obtenerX(), 3);
		assertEquals((godzilla.getCoordenada()).obtenerY(), 25);
	}
	
	@Test
	public void testGodzillaAtacaAUnMapaDeTamanio5YComienzaEnLaCoordenada3_0YTerminaEnLa3_5() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());

		IAtaqueGodzilla generadorGodzilla = new AtaqueGodzillaMock(new Coordenada(3,0), new CaminarDerecho());
		godzilla.atacar(mapa, generadorGodzilla);

		assertEquals((godzilla.getCoordenada()).obtenerX(), 3);
		assertEquals((godzilla.getCoordenada()).obtenerY(), 5);
	}
	
	@Test
	public void testGodzillaAtacaAUnMapaDeTamanio5AfectandoAUnaIndustriaEnLaCoordenada3_2() {
		Godzilla godzilla = new Godzilla();
		Mapa mapa = new Mapa(new ClasePruebaParaGenerarMapa());
		Edificio ind = new Industria();
		
		mapa.construir(ind, new Coordenada(3,2));
		
		
		assertEquals(((mapa.getHectarea(new Coordenada(3,2))).getConstruccion()).getSalud(), 100);

		IAtaqueGodzilla generadorGodzilla = new AtaqueGodzillaMock(new Coordenada(3,0), new CaminarDerecho());
		godzilla.atacar(mapa, generadorGodzilla);
		
		ind = (Industria) mapa.getHectarea(new Coordenada(3,2)).getConstruccion();
		assertEquals(ind.getSalud(), 60);
		
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
		
		
		assertEquals(((mapa.getHectarea(new Coordenada(3,0))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,1))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,2))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,3))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,4))).getConstruccion()).getSalud(), 100);

		IAtaqueGodzilla generadorGodzilla = new AtaqueGodzillaMock(new Coordenada(3,0), new CaminarDerecho());
		godzilla.atacar(mapa, generadorGodzilla);

		assertEquals(((mapa.getHectarea(new Coordenada(3,0))).getConstruccion()).getSalud(), 0);
		assertEquals(((mapa.getHectarea(new Coordenada(3,1))).getConstruccion()).getSalud(), 0);
		assertEquals(((mapa.getHectarea(new Coordenada(3,2))).getConstruccion()).getSalud(), 0);
		assertEquals(((mapa.getHectarea(new Coordenada(3,3))).getConstruccion()).getSalud(), 0);
		assertEquals(((mapa.getHectarea(new Coordenada(3,4))).getConstruccion()).getSalud(), 0);
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
		
		
		assertEquals(((mapa.getHectarea(new Coordenada(3,0))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,1))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,2))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,4))).getConstruccion()).getSalud(), 100);

		IAtaqueGodzilla generadorGodzilla = new AtaqueGodzillaMock(new Coordenada(3,0), new CaminarDerecho());
		godzilla.atacar(mapa, generadorGodzilla);

		assertEquals(((mapa.getHectarea(new Coordenada(3,0))).getConstruccion()).getSalud(), 0);
		assertEquals(((mapa.getHectarea(new Coordenada(3,1))).getConstruccion()).getSalud(), 25);
		assertEquals(((mapa.getHectarea(new Coordenada(3,2))).getConstruccion()).getSalud(), 60);
		assertEquals(((mapa.getHectarea(new Coordenada(3,4))).getConstruccion()).getSalud(), 65);
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
		

		assertEquals(((mapa.getHectarea(new Coordenada(3,0))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(2,1))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,2))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(4,3))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,4))).getConstruccion()).getSalud(), 100);
		
		IAtaqueGodzilla ataqueGodzilla = new AtaqueGodzillaMock(new Coordenada(3,0), new CaminarZigZag());
		godzilla.atacar(mapa, ataqueGodzilla);
		
		assertEquals(((mapa.getHectarea(new Coordenada(3,0))).getConstruccion()).getSalud(), 00);
		assertEquals(((mapa.getHectarea(new Coordenada(2,1))).getConstruccion()).getSalud(), 00);
		assertEquals(((mapa.getHectarea(new Coordenada(3,2))).getConstruccion()).getSalud(), 00);
		assertEquals(((mapa.getHectarea(new Coordenada(4,3))).getConstruccion()).getSalud(), 00);
		assertEquals(((mapa.getHectarea(new Coordenada(3,4))).getConstruccion()).getSalud(), 00);
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
		

		assertEquals(((mapa.getHectarea(new Coordenada(3,0))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,1))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,2))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,3))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,4))).getConstruccion()).getSalud(), 100);
		
		IAtaqueGodzilla ataqueGodzilla = new AtaqueGodzillaMock(new Coordenada(3,0), new CaminarZigZag());
		godzilla.atacar(mapa, ataqueGodzilla);
	
		assertEquals(((mapa.getHectarea(new Coordenada(3,0))).getConstruccion()).getSalud(), 00);
		assertEquals(((mapa.getHectarea(new Coordenada(3,1))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,2))).getConstruccion()).getSalud(), 00);
		assertEquals(((mapa.getHectarea(new Coordenada(3,3))).getConstruccion()).getSalud(), 100);
		assertEquals(((mapa.getHectarea(new Coordenada(3,4))).getConstruccion()).getSalud(), 00);
	}

}
