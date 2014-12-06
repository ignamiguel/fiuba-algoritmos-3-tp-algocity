package algo3.algocity.modelo;

import static org.junit.Assert.*;
import org.junit.Test;

public class AguaTest {

	@Test	
	public void ConstruirUnPozoDeAguaEnAguaVacia(){
		
		PozoDeAgua pda = new PozoDeAgua();
		
		Agua agua = new Agua();
		
		boolean resultado = agua.construir(pda);
		
		assertEquals(true, resultado);
		
		assertEquals(agua.obtenerConstruccion(), pda );
	}
	
	@Test	
	public void ConstruirUnaCentralElectricaEnAguaVacia(){
		
		// Declaro una varibale CentralElectria
		// para tratarlas de forma generica		
		CentralElectrica ce = new CentralEolica();
		
		Agua agua = new Agua();
		
		boolean resultado = agua.construir(ce);		
		
		assertEquals(false, resultado);
		
		assertEquals(agua.obtenerConstruccion(), null);
	}
	
	@Test	
	public void ConstruirUnaEstacionDeBomberosEnAgua(){		
			
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		Agua agua = new Agua();
		
		boolean resultado = agua.construir(edb);
		
		assertEquals(false, resultado);
		
		assertEquals(agua.obtenerConstruccion(), null);
	}
	
	@Test	
	public void ConstruirUnEdificioEnAgua(){		
			
		// Creo un edificio para trataro de forma generica
		Edificio e = new Residencia();
		
		Agua agua = new Agua();
		
		boolean resultado = agua.construir(e);
		
		assertEquals(false, resultado);
		
		assertEquals(agua.obtenerConstruccion(), null);
	}
	
	@Test	
	public void ConstruirUnPozoDeAguaEnAguaQueYaTieneUnPozoDeAgua(){
		
		PozoDeAgua pda = new PozoDeAgua();
		
		Agua agua = new Agua();
		
		boolean resultado = agua.construir(pda);
		
		assertEquals(true, resultado);
		
		PozoDeAgua otroPda = new PozoDeAgua();
		
		resultado = agua.construir(otroPda);
		
		assertEquals(false, resultado);
		
		assertEquals(agua.obtenerConstruccion(), pda);	
		
	}	
	
}
