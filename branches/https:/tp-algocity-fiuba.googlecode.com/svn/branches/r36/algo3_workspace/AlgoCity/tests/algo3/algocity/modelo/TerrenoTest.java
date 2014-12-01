package algo3.algocity.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TerrenoTest {

	@Test	
	public void ConstruirUnPozoDeAguaEnTerreno(){
		
		PozoDeAgua pda = new PozoDeAgua();
		
		Terreno terreno = new Terreno();
		
		terreno.construir(pda);
		
		assertEquals(terreno.obtenerSuConstruccion(), null);
	}
	
	@Test	
	public void ConstruirUnaCentralElectricaEnTerreno(){
		
		// Declaro una varibale CentralElectria
		// para tratarlas de forma generica		
		CentralElectrica ce = new CentralEolica();
		
		Terreno terreno = new Terreno();		
		
		terreno.construir(ce);
		
		assertEquals(terreno.obtenerSuConstruccion(), ce);
	}
	
	@Test	
	public void ConstruirUnaEstacionDeBomberosEnTerreno(){		
			
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		Terreno terreno = new Terreno();
		
		terreno.construir(edb);
		
		assertEquals(terreno.obtenerSuConstruccion(), edb);
	}
	
	@Test	
	public void ConstruirUnEdificioEnTerreno(){		
			
		Edificio e = new Residencia();
		
		Terreno terreno = new Terreno();
		
	    terreno.construir(e);
		
		assertEquals(terreno.obtenerSuConstruccion(), e);
	}
	
	@Test	
	public void ConstruirUnEdificioEnTerenoQueYaTieneUnEdificio(){
		
		// Declaro un variable del tipo Edificio
		// para testear el caso generico
		Edificio edificio = new Residencia();
		
		Terreno terreno = new Terreno();
		
		terreno.construir(edificio);
		
		assertEquals(terreno.obtenerSuConstruccion(), edificio);
		
		Edificio otroEdificio = new Residencia();
		
		terreno.construir(otroEdificio);
		
		Assert.assertNotSame(terreno.obtenerSuConstruccion(),otroEdificio);
		
	}
	
}
