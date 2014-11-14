package edificios;

import static org.junit.Assert.*;

import org.junit.Test;



public class TestEdificios {
	
	
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
	
}
