package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;


public class EdificiosTest {	
	
	@Test
	public void testConusmoDeResidenciaEs1(){
		Residencia residencia = new Residencia ();
		assertEquals(residencia.obtenerConsumoElectrico(),1);
	}
	
	@Test
	public void testCapacidadDeResidenciaEs100(){
		Residencia residencia = new Residencia ();
		assertEquals(residencia.obtenerCapacidad(),100);
	}
	
	
	@Test
	public void testConusmoDeComercioEs2(){
		Comercio comercio = new Comercio ();
		assertEquals(comercio.obtenerConsumoElectrico(),2);
	}
	
	
	@Test
	public void testConusmoDeIndustriaEs5(){
		Industria industria = new Industria();
		assertEquals(industria.obtenerConsumoElectrico(),5);
	}
	
	@Test
	public void testPuestosDeTrabajoDeIndustriaEs25(){
		Industria industria = new Industria ();
		assertEquals(industria.obtenerPuestosDeTrabajo(),25);
	}
	
	@Test
	public void testCostoDeResidenciaEs5(){
		Residencia residencia = new Residencia();
		assertEquals(residencia.obtenerCosto(),5);
	}
	
	@Test
	public void testCostoDeComercioEs5(){
		Comercio comercio = new Comercio();
		assertEquals(comercio.obtenerCosto(),5);
	}
	
	@Test
	public void testCostoDeIndustriaEs10(){
		Industria industria = new Industria();
		assertEquals(industria.obtenerCosto(),10);
	}
	
	@Test
	public void testPuedoPonerResidenciaEnTerrenoTrue(){
		Residencia residencia = new Residencia();
		Terreno terreno = new Terreno();
		assertEquals(residencia.puedoEn(terreno),true);
	}
	
	@Test
	public void testNoPuedoPonerResidenciaEnAgua(){
		Residencia residencia = new Residencia();
		Agua agua = new Agua();
		assertEquals(residencia.puedoEn(agua),false);
	}
	
	@Test
	public void testNoPuedoPonerIndustriaEnAgua(){
		Industria industria = new Industria();
		Agua agua = new Agua();
		assertEquals(industria.puedoEn(agua),false);
	}
	
	@Test
	public void testPuedoPonerIndustriaEnTerreno(){
		Industria industria = new Industria();
		Terreno terreno = new Terreno();
		assertEquals(industria.puedoEn(terreno),true);
	}
	
	@Test
	public void testResidenciaCreadaTieneSalud100(){
		Residencia residencia = new Residencia();
		assertEquals(residencia.obtenerSalud(),100);
	}
	
	@Test
	public void testComercioCreadoTieneSalud100(){
		Comercio comercio = new Comercio();
		assertEquals(comercio.obtenerSalud(),100);
	}
	
	@Test
	public void testIndustriaCreadaTieneSalud100(){
		Industria industria = new Industria();
		assertEquals(industria.obtenerSalud(),100);
	}
	
	@Test
	public void testResidenciaDanadaPorGodzillaQuedaConSalud0(){
		Residencia residencia = new Residencia();
		Godzilla godzilla = new Godzilla();
		residencia.afectarCon(godzilla);
		assertEquals(residencia.obtenerSalud(),0);
	}
	
	@Test
	public void testResidenciaDanada2vecesPorGodzillaQuedaConSalud0(){
		Residencia residencia = new Residencia();
		Godzilla godzilla = new Godzilla();
		residencia.afectarCon(godzilla);
		residencia.afectarCon(godzilla);
		assertEquals(residencia.obtenerSalud(),0);
	}
	

	@Test
	public void testIndustriaDanadaPorGodzillaQuedaConSalud60(){
		Industria industria = new Industria();
		Godzilla godzilla = new Godzilla();
		industria.afectarCon(godzilla);
		assertEquals(industria.obtenerSalud(),60);
	}
	
	@Test
	public void testIndustriaDanadaPorGodzilla2vecesQuedaConSalud20(){
		Industria industria = new Industria();
		Godzilla godzilla = new Godzilla();
		industria.afectarCon(godzilla);
		industria.afectarCon(godzilla);
		assertEquals(industria.obtenerSalud(),20);
	}
	
	@Test
	public void testIndustriaDanadaPorGodzilla3vecesQuedaConSalud0(){
		Industria industria = new Industria();
		Godzilla godzilla = new Godzilla();
		industria.afectarCon(godzilla);
		industria.afectarCon(godzilla);
		industria.afectarCon(godzilla);
		assertEquals(industria.obtenerSalud(),0);
	}
	
	@Test
	public void testComercioDanadoPorGodzillaQuedaConSalud25(){
		Comercio comercio = new Comercio();
		Godzilla godzilla = new Godzilla();
		comercio.afectarCon(godzilla);
		assertEquals(comercio.obtenerSalud(),25);
	}
	
	
	@Test
	public void testComercioDanadoPorGodzilla2VecesQuedaConSalud0(){
		Comercio comercio = new Comercio();
		Godzilla godzilla = new Godzilla();
		comercio.afectarCon(godzilla);
		comercio.afectarCon(godzilla);
		assertEquals(comercio.obtenerSalud(),0);
	}
	
	@Test
	public void testResidenciaDanadaPorTerremotoDeDanio100QuedaConSalud0(){
		Residencia residencia = new Residencia();
		residencia.afectarCon(new Terremoto());
		assertEquals(residencia.obtenerSalud(),0);
	}
	
	@Test
	public void testIndustriaDanadaPorTerremotoDeDanio100QuedaConSalud0(){
		Industria industria = new Industria();
		industria.afectarCon(new Terremoto());
		assertEquals(industria.obtenerSalud(),0);
	}
	
	@Test
	public void testComercioDanadoPorTerremotoDeDanio100QuedaConSalud0(){
		Comercio comercio = new Comercio();
		comercio.afectarCon(new Terremoto());
		assertEquals(comercio.obtenerSalud(),0);
	}
	
	@Test
	public void testResidenciaDanadaPorTerremotoDeDanio25QuedaConSalud75(){
		Residencia residencia = new Residencia();
		Terremoto terremoto = new Terremoto();
		terremoto.cargarDanio(25);
		residencia.afectarCon(terremoto);
		assertEquals(residencia.obtenerSalud(),75);
	}
	
	@Test
	public void testIndustriaDanadaPorTerremotoDeDanio25QuedaConSalud75(){
		Industria industria = new Industria();
		Terremoto terremoto = new Terremoto();
		terremoto.cargarDanio(25);
		industria.afectarCon(terremoto);
		assertEquals(industria.obtenerSalud(),75);
	}
	
	@Test
	public void testComercioDanadoPorTerremotoDeDanio99QuedaConSalud1(){
		Comercio comercio = new Comercio();
		Terremoto terremoto = new Terremoto();
		terremoto.cargarDanio(99);
		comercio.afectarCon(terremoto);
		assertEquals(comercio.obtenerSalud(),1);
	}
	
	@Test
	public void testIndustriaDanadaPorTerremotoDeDanio20YPorGodzillaQuedaConSalud40(){
		Industria industria = new Industria();
		Terremoto terremoto = new Terremoto();
		terremoto.cargarDanio(20);
		industria.afectarCon(terremoto);
		assertEquals(industria.obtenerSalud(),80);
		industria.afectarCon(new Godzilla());
		assertEquals(industria.obtenerSalud(),40);
	}
	
}
