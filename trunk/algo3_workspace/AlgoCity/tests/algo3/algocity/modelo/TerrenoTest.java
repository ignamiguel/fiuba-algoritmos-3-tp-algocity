package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TerrenoTest {

	@Test	
	public void ConstruirUnPozoDeAguaEnTerrenoVacio(){
		
		PozoDeAgua pda = new PozoDeAgua();
		
		Terreno terreno = new Terreno();
		
		boolean resultado = terreno.construir(pda);
		
		assertEquals(false, resultado);
		
		assertEquals(terreno.getConstruccion(), null);
	}
	
	@Test	
	public void ConstruirUnaCentralElectricaEnTerrenoVacio(){
		
		// Declaro una varibale CentralElectria
		// para tratarlas de forma generica		
		CentralElectrica ce = new CentralEolica();
		
		Terreno terreno = new Terreno();		
		
		boolean resultado = terreno.construir(ce);
		
		assertEquals(true, resultado);
		
		assertEquals(terreno.getConstruccion(), ce);
	}
	
	@Test	
	public void ConstruirUnaEstacionDeBomberosEnTerrenoVacio(){		
			
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		Terreno terreno = new Terreno();
		
		boolean resultado = terreno.construir(edb);
		
		assertEquals(true, resultado);
		
		assertEquals(terreno.getConstruccion(), edb);
	}
	
	@Test	
	public void ConstruirUnEdificioEnTerrenoVacio(){		
			
		Edificio e = new Residencia();
		
		Terreno terreno = new Terreno();
		
	    boolean resultado = terreno.construir(e);
		
	    assertEquals(true, resultado);
	    
		assertEquals(terreno.getConstruccion(), e);
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
		
		assertEquals(terreno.getConstruccion(), edificio);
		
	}
	
}
