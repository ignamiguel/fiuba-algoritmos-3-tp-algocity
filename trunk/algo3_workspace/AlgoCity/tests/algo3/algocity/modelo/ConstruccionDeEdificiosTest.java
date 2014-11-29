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
		assertEquals(unTerreno.obtenerSuConstruccion(),unaResidencia);

	}
	
	@Test	
	public void testConstruirResidenciaEnAgua(){
		
		Residencia unaResidencia = new Residencia();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaResidencia);
		Assert.assertNotSame(unaHectareaAgua.obtenerSuConstruccion(), unaResidencia);
		assertEquals(unaHectareaAgua.obtenerSuConstruccion(),null);
	}
	
	@Test	
	public void testConstruirComercioEnTerreno(){
		
		Comercio unComercio = new Comercio();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unComercio);
		assertEquals(unTerreno.obtenerSuConstruccion(),unComercio);

	}
	
	@Test	
	public void testConstruirComercioEnAgua(){
		
		Comercio unComercio = new Comercio();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unComercio);
		Assert.assertNotSame(unaHectareaAgua.obtenerSuConstruccion(), unComercio);
		assertEquals(unaHectareaAgua.obtenerSuConstruccion(),null);
	}
	
	@Test	
	public void testConstruirIndustriaEnTerreno(){
		
		Industria unaIndustria = new Industria();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaIndustria);
		assertEquals(unTerreno.obtenerSuConstruccion(),unaIndustria);

	}
	
	@Test	
	public void testConstruirIndustriaEnAgua(){
		
		Industria unaIndustria = new Industria();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaIndustria);
		Assert.assertNotSame(unaHectareaAgua.obtenerSuConstruccion(), unaIndustria);
		assertEquals(unaHectareaAgua.obtenerSuConstruccion(),null);
	}
	
	@Test	
	public void testConstruirCentralEolicaEnTerreno(){
		
		CentralEolica unaCentralEolica = new CentralEolica();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaCentralEolica);
		assertEquals(unTerreno.obtenerSuConstruccion(),unaCentralEolica);

	}
	
	@Test	
	public void testConstruirCentralEolicaEnAgua(){
		
		CentralEolica unaCentralEolica = new CentralEolica();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaCentralEolica);
		Assert.assertNotSame(unaHectareaAgua.obtenerSuConstruccion(), unaCentralEolica);
		assertEquals(unaHectareaAgua.obtenerSuConstruccion(),null);
	}
	
	@Test	
	public void testConstruirCentralMineralEnTerreno(){
		
		CentralMineral unaCentralMineral = new CentralMineral();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaCentralMineral);
		assertEquals(unTerreno.obtenerSuConstruccion(),unaCentralMineral);

	}
	
	@Test	
	public void testConstruirCentralMineralEnAgua(){
		
		CentralMineral unaCentralMineral = new CentralMineral();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaCentralMineral);
		Assert.assertNotSame(unaHectareaAgua.obtenerSuConstruccion(), unaCentralMineral);
		assertEquals(unaHectareaAgua.obtenerSuConstruccion(),null);
	}
	
	@Test	
	public void testConstruirCentralNuclearEnTerreno(){
		
		CentralNuclear unaCentralNuclear = new CentralNuclear();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaCentralNuclear);
		assertEquals(unTerreno.obtenerSuConstruccion(),unaCentralNuclear);

	}
	
	@Test	
	public void testConstruirCentralNuclearEnAgua(){
		
		CentralNuclear unaCentralNuclear = new CentralNuclear();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaCentralNuclear);
		Assert.assertNotSame(unaHectareaAgua.obtenerSuConstruccion(), unaCentralNuclear);
		assertEquals(unaHectareaAgua.obtenerSuConstruccion(),null);
	}
	
	@Test	
	public void testConstruirPozoDeAguaEnAgua(){
		
		PozoDeAgua unPozoDeAgua = new PozoDeAgua();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unPozoDeAgua);
		assertEquals(unaHectareaAgua.obtenerSuConstruccion(),unPozoDeAgua);

	}
	
	@Test	
	public void testConstruirPozoDeAguaEnTerreno(){
		
		PozoDeAgua unPozoDeAgua = new PozoDeAgua();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unPozoDeAgua);
		Assert.assertNotSame(unTerreno.obtenerSuConstruccion(), unPozoDeAgua);
		assertEquals(unTerreno.obtenerSuConstruccion(),null);
	}
	
	@Test	
	public void testConstruirEstacionDeBomberosEnTerreno(){
		
		EstacionDeBomberos unaEstacionDeBomberos = new EstacionDeBomberos();
		Terreno unTerreno = new Terreno();
		unTerreno.construir(unaEstacionDeBomberos);
		assertEquals(unTerreno.obtenerSuConstruccion(),unaEstacionDeBomberos);

	}
	
	@Test	
	public void testConstruirEstacionDeBomberosEnAgua(){
		
		EstacionDeBomberos unaEstacionDeBomberos = new EstacionDeBomberos();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.construir(unaEstacionDeBomberos);
		Assert.assertNotSame(unaHectareaAgua.obtenerSuConstruccion(), unaEstacionDeBomberos);
		assertEquals(unaHectareaAgua.obtenerSuConstruccion(),null);
	}
}
