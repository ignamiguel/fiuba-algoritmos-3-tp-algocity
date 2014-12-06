package algo3.algocity.modelo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ConjuntoTest {
	
	@Test
	public void agregoUnElementoAlConjuntoYPreguntoSiExiste(){

		// Declaro un set y le agrego una hectarea
		Set<Hectarea> conjunto = new HashSet<Hectarea>();
		Terreno t = new Terreno();
		
		conjunto.add(t);
		
		assertEquals(true, conjunto.contains(t));
	}
	
	@Test
	public void unElementoQueNoPertenece(){
		
		Set<Hectarea> conjunto = new HashSet<Hectarea>();
		Terreno t = new Terreno();		
		
		assertEquals(false, conjunto.contains(t));
		
	}
	
	@Test
	public void agregoYRemuevoVariosElementos(){
		
		Set<Hectarea> conjunto = new HashSet<Hectarea>();
		Terreno t1 = new Terreno();		
		Terreno t2 = new Terreno();
		Terreno t3 = new Terreno();
		Terreno t4 = new Terreno();
		Terreno t5 = new Terreno();
		
		conjunto.add(t1);
		conjunto.add(t2);
		conjunto.add(t3);
		conjunto.add(t4);
		conjunto.add(t5);
		
		// Agregarlo de nuevo no tira excepcion
		conjunto.add(t1);	
		
		assertEquals(true, conjunto.contains(t1));
		assertEquals(true, conjunto.contains(t2));
		assertEquals(true, conjunto.contains(t3));
		assertEquals(true, conjunto.contains(t4));
		assertEquals(true, conjunto.contains(t5));
		
		conjunto.remove(t1);
		
		assertEquals(false, conjunto.contains(t1));
		
		// Remover uno que no esta no tira expecion
		conjunto.remove(t1);
		
		conjunto.remove(t2);
		conjunto.remove(t3);
		conjunto.remove(t4);
		
		assertEquals(false, conjunto.contains(t2));
		assertEquals(false, conjunto.contains(t3));
		assertEquals(false, conjunto.contains(t4));
		
		
	}
	

}
