package algo3.algocity.modelo;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class AguaTest {

	@Test	
	public void ConstruirUnPozoDeAguaEnAgua(){
		
		PozoDeAgua pda = new PozoDeAgua();
		
		Agua agua = new Agua();
		
		agua.construir(pda);
		
		assertEquals(agua.obtenerSuConstruccion(), pda );
	}
	
	@Test	
	public void ConstruirUnaCentralElectricaEnAgua(){
		
		// Declaro una varibale CentralElectria
		// para tratarlas de forma generica		
		CentralElectrica ce = new CentralEolica();
		
		Agua agua = new Agua();
		
		agua.construir(ce);
		
		assertEquals(agua.obtenerSuConstruccion(), null);
	}
	
	@Test	
	public void ConstruirUnaEstacionDeBomberosEnAgua(){		
			
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		Agua agua = new Agua();
		
		agua.construir(edb);
		
		assertEquals(agua.obtenerSuConstruccion(), null);
	}
	
	@Test	
	public void ConstruirUnEdificioEnAgua(){		
			
		Edificio e = new Residencia();
		
		Agua agua = new Agua();
		
		agua.construir(e);
		
		assertEquals(agua.obtenerSuConstruccion(), null);
	}
	
	@Test	
	public void ConstruirUnPozoDeAguaEnAguaQueYaTieneUnPozoDeAgua(){
		
		PozoDeAgua pda = new PozoDeAgua();
		
		Agua agua = new Agua();
		
		agua.construir(pda);
		
		PozoDeAgua otroPda = new PozoDeAgua();
		
		agua.construir(otroPda);
		
		assertEquals(agua.obtenerSuConstruccion(), pda);
		
		Assert.assertNotSame(agua.obtenerSuConstruccion(),otroPda);
		
	}	
	
}
