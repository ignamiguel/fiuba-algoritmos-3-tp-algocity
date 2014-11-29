package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;


public class CentrealesTest {

	@Test	
	public void testCostoNuevaCentralEolica(){
		
		CentralEolica unaCentral = new CentralEolica();
		assertEquals(unaCentral.obtenerCosto(),1000);

	}
	
	@Test
	public void testCostoNuevaCentralNuclear(){
		
		CentralNuclear unaCentral = new CentralNuclear();
		assertEquals(unaCentral.obtenerCosto(),10000);

	}
	@Test
	public void testCostoNuevaCentralMineral(){
		
		CentralMineral unaCentral = new CentralMineral();
		assertEquals(unaCentral.obtenerCosto(),3000);

	}
	@Test
	public void testRadioDeCoverturaCentralEolica(){
		
		CentralEolica unaCentral = new CentralEolica();
		assertEquals(unaCentral.obtenerRadioDeCovertura(),4);

	}
	@Test
	public void testRadioDeCoverturaCentralMineral(){
		
		CentralMineral unaCentral = new CentralMineral();
		assertEquals(unaCentral.obtenerRadioDeCovertura(),10);

	}
	@Test
	public void testRadioDeCoverturaCentralNuclear(){
		
		CentralNuclear unaCentral = new CentralNuclear();
		assertEquals(unaCentral.obtenerRadioDeCovertura(),25);

	}
	@Test
	public void testCapacidadDeAbastecimientoCentralEolica(){
		
		CentralEolica unaCentral = new CentralEolica();
		assertEquals(unaCentral.obtenerCapacidadDeAbastecimiento(),100);

	}
	@Test
	public void testCapacidadDeAbastecimientoCentralMineral(){
		
		CentralMineral unaCentral = new CentralMineral();
		assertEquals(unaCentral.obtenerCapacidadDeAbastecimiento(),400);

	}
	@Test
	public void testCapacidadDeAbastecimientoCentralNuclear(){
		
		CentralNuclear unaCentral = new CentralNuclear();
		assertEquals(unaCentral.obtenerCapacidadDeAbastecimiento(),1000);

	}
	@Test
	public void testPuedeConstruirseEnAguaCentralEolica(){
		
		CentralEolica unaCentral = new CentralEolica();

		assertEquals(unaCentral.puedoEn(new Agua()),false);

	}
	@Test
	public void testPuedeConstruirseEnTerrenoCentralEolica(){
		
		CentralEolica unaCentral = new CentralEolica();

		assertEquals(unaCentral.puedoEn(new Terreno()),true);

	}
	@Test
	public void testPuedeConstruirseEnAguaCentralMineral(){
		
		CentralMineral unaCentral = new CentralMineral();

		assertEquals(unaCentral.puedoEn(new Agua()),false);

	}
	@Test
	public void testPuedeConstruirseEnTerrenoCentralMineral(){
		
		CentralMineral unaCentral = new CentralMineral();

		assertEquals(unaCentral.puedoEn(new Terreno()),true);

	}
	@Test
	public void testPuedeConstruirseEnAguaCentralNuclear(){
		
		CentralNuclear unaCentral = new CentralNuclear();

		assertEquals(unaCentral.puedoEn(new Agua()),false);

	}
	@Test
	public void testPuedeConstruirseEnTerrenoCentralNuclear(){
		
		CentralNuclear unaCentral = new CentralNuclear();

		assertEquals(unaCentral.puedoEn(new Terreno()),true);

	}
	@Test
	public void testEstaActivaCentralEolica(){
		
		CentralEolica unaCentral = new CentralEolica();

		assertEquals(unaCentral.estaConectada(),false);

	}
	@Test
	public void testEstaActivaCentralMineral(){
		
		CentralMineral unaCentral = new CentralMineral();

		assertEquals(unaCentral.estaConectada(),false);

	}
	@Test
	public void testEstaActivaCentralNuclear(){
		
		CentralNuclear unaCentral = new CentralNuclear();

		assertEquals(unaCentral.estaConectada(),false);

	}
	
	
	
}
