package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ConstruccionDeEdificiosTest {
	
	@Test	
	public void testConstruirResidenciaEnTerreno(){
		
		Residencia unaResidencia = new Residencia();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaResidencia);
		assertEquals(unTerreno.obtenerConstruccion(),unaResidencia);

	}
	
	@Test	
	public void testConstruirResidenciaEnAgua(){
		
		Residencia unaResidencia = new Residencia();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaResidencia);
		Assert.assertNotSame(unaHectareaAgua.obtenerConstruccion(), unaResidencia);
		assertEquals(unaHectareaAgua.obtenerConstruccion(),null);
	}
	
	@Test	
	public void testConstruirComercioEnTerreno(){
		
		Comercio unComercio = new Comercio();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unComercio);
		assertEquals(unTerreno.obtenerConstruccion(),unComercio);

	}
	
	@Test	
	public void testConstruirComercioEnAgua(){
		
		Comercio unComercio = new Comercio();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unComercio);
		Assert.assertNotSame(unaHectareaAgua.obtenerConstruccion(), unComercio);
		assertEquals(unaHectareaAgua.obtenerConstruccion(),null);
	}
	
	@Test	
	public void testConstruirIndustriaEnTerreno(){
		
		Industria unaIndustria = new Industria();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaIndustria);
		assertEquals(unTerreno.obtenerConstruccion(),unaIndustria);

	}
	
	@Test	
	public void testConstruirIndustriaEnAgua(){
		
		Industria unaIndustria = new Industria();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaIndustria);
		Assert.assertNotSame(unaHectareaAgua.obtenerConstruccion(), unaIndustria);
		assertEquals(unaHectareaAgua.obtenerConstruccion(),null);
	}
	
	@Test	
	public void testConstruirCentralEolicaEnTerreno(){
		
		CentralEolica unaCentralEolica = new CentralEolica();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaCentralEolica);
		assertEquals(unTerreno.obtenerConstruccion(),unaCentralEolica);

	}
	
	@Test	
	public void testConstruirCentralEolicaEnAgua(){
		
		CentralEolica unaCentralEolica = new CentralEolica();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaCentralEolica);
		Assert.assertNotSame(unaHectareaAgua.obtenerConstruccion(), unaCentralEolica);
		assertEquals(unaHectareaAgua.obtenerConstruccion(),null);
	}
	
	@Test	
	public void testConstruirCentralMineralEnTerreno(){
		
		CentralMineral unaCentralMineral = new CentralMineral();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaCentralMineral);
		assertEquals(unTerreno.obtenerConstruccion(),unaCentralMineral);

	}
	
	@Test	
	public void testConstruirCentralMineralEnAgua(){
		
		CentralMineral unaCentralMineral = new CentralMineral();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaCentralMineral);
		Assert.assertNotSame(unaHectareaAgua.obtenerConstruccion(), unaCentralMineral);
		assertEquals(unaHectareaAgua.obtenerConstruccion(),null);
	}
	
	@Test	
	public void testConstruirCentralNuclearEnTerreno(){
		
		CentralNuclear unaCentralNuclear = new CentralNuclear();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaCentralNuclear);
		assertEquals(unTerreno.obtenerConstruccion(),unaCentralNuclear);

	}
	
	@Test	
	public void testConstruirCentralNuclearEnAgua(){
		
		CentralNuclear unaCentralNuclear = new CentralNuclear();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaCentralNuclear);
		Assert.assertNotSame(unaHectareaAgua.obtenerConstruccion(), unaCentralNuclear);
		assertEquals(unaHectareaAgua.obtenerConstruccion(),null);
	}
	
	@Test	
	public void testConstruirPozoDeAguaEnAgua(){
		
		PozoDeAgua unPozoDeAgua = new PozoDeAgua();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unPozoDeAgua);
		assertEquals(unaHectareaAgua.obtenerConstruccion(),unPozoDeAgua);

	}
	
	@Test	
	public void testConstruirPozoDeAguaEnTerreno(){
		
		PozoDeAgua unPozoDeAgua = new PozoDeAgua();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unPozoDeAgua);
		Assert.assertNotSame(unTerreno.obtenerConstruccion(), unPozoDeAgua);
		assertEquals(unTerreno.obtenerConstruccion(),null);
	}
	
	@Test	
	public void testConstruirEstacionDeBomberosEnTerreno(){
		
		EstacionDeBomberos unaEstacionDeBomberos = new EstacionDeBomberos();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaEstacionDeBomberos);
		assertEquals(unTerreno.obtenerConstruccion(),unaEstacionDeBomberos);

	}
	
	@Test	
	public void testConstruirEstacionDeBomberosEnAgua(){
		
		EstacionDeBomberos unaEstacionDeBomberos = new EstacionDeBomberos();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaEstacionDeBomberos);
		Assert.assertNotSame(unaHectareaAgua.obtenerConstruccion(), unaEstacionDeBomberos);
		assertEquals(unaHectareaAgua.obtenerConstruccion(),null);
	}
}
