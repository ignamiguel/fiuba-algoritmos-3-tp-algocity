package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineasDeTensionTest{

	@Test
	public void testEstadoNuevaLineaDeTension(){
		
		LineaDeTension unaLinea = new LineaDeTension();
		assertEquals(unaLinea.estaDaniada(),false);
		
	}
	@Test
	public void testCompararDosInstanciasDeLineaDeTension(){
		
		LineaDeTension unaLinea = new LineaDeTension();
		LineaDeTension otraLinea = new LineaDeTension();
		Terreno unTerreno = new Terreno();
		unTerreno.agregarServicio(unaLinea);
		assertEquals(unTerreno.tieneElServicio(otraLinea),true);
		
	}
	@Test
	public void testDaniarLineaDeTensionEnDosHectareas(){
		
		Terreno unTerreno = new Terreno();
		Terreno otroTerreno = new Terreno();
		LineaDeTension unaLinea = new LineaDeTension();
		
		unTerreno.agregarServicio(unaLinea);
		otroTerreno.agregarServicio(unaLinea);
		
		unaLinea.afectarCon(new Godzilla());
		
		assertEquals(unTerreno.tieneLuz(),false);
		assertEquals(otroTerreno.tieneLuz(),false);
		

		
	}
	@Test
	public void testRepararLineaDeTensionEnDosHectareas(){
		
		Terreno unTerreno = new Terreno();
		Terreno otroTerreno = new Terreno();
		LineaDeTension unaLinea = new LineaDeTension();
		
		unTerreno.agregarServicio(unaLinea);
		otroTerreno.agregarServicio(unaLinea);
		
		unaLinea.afectarCon(new Godzilla());
		
		assertEquals(unTerreno.tieneLuz(),false);
		assertEquals(otroTerreno.tieneLuz(),false);
		// la lienea de tension no tiene porsentaje de daño, o trasmite o no trasmite energia
		
		unaLinea.reparar(100);
		
		assertEquals(unTerreno.tieneLuz(),true);
		assertEquals(otroTerreno.tieneLuz(),true);
		
	}
	

	
	
}
