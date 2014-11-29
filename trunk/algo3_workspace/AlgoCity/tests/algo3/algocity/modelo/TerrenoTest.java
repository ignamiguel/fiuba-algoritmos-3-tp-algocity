package algo3.algocity.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TerrenoTest {

	@Test	
	public void ConstruirUnPozoDeAguaEnTerreno(){
		
		PozoDeAgua pda = new PozoDeAgua();
		
		Terreno terreno = new Terreno();
		
		boolean resultado = terreno.construir(pda);
		
		assertEquals(false, resultado);
	}
	
	@Test	
	public void ConstruirUnaCentralElectricaEnTerreno(){
		
		// Declaro una varibale CentralElectria
		// para tratarlas de forma generica		
		CentralElectrica ce = new CentralEolica();
		
		Terreno terreno = new Terreno();		
		
		boolean resultado = terreno.construir(ce);
		
		assertEquals(true, resultado);
	}
	
	@Test	
	public void ConstruirUnaEstacionDeBomberosEnTerreno(){		
			
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		Terreno terreno = new Terreno();
		
		boolean resultado = terreno.construir(edb);
		
		assertEquals(true, resultado);
	}
	
	@Test	
	public void ConstruirUnEdificioEnTerreno(){		
			
		Edificio e = new Residencia();
		
		Terreno terreno = new Terreno();
		
		boolean resultado = terreno.construir(e);
		
		assertEquals(true, resultado);
	}
	
	@Test	
	public void ConstruirUnEdificioEnTerenoQueYaTieneUnEdificio(){
		
		// Declaro un variable del tipo Edificio
		// para testear el caso generico
		Edificio edificio = new Residencia();
		
		Terreno terreno = new Terreno();
		
		boolean resultado = terreno.construir(edificio);
		
		assertEquals(true, resultado);
		
		Edificio otroEdificio = new Residencia();
		
		resultado = terreno.construir(otroEdificio);
		
		assertEquals(false, resultado);
		
	}
	
}
