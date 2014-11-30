package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;


public class ConstruccionDeRutaTest {
	
	@Test	
	public void testConstruirRutaEnTerreno(){
		
		RutaPavimentada unaRuta = new RutaPavimentada();
		Terreno unTerreno = new Terreno();
		unTerreno.agregarServicio(unaRuta);
		assertEquals(unTerreno.tieneServicio(unaRuta),true);

	}
	
	@Test	
	public void testConstruirRutaEnAgua(){
		
		RutaPavimentada unaRuta = new RutaPavimentada();
		Agua unaHectareaAgua = new Agua();
		unaHectareaAgua.agregarServicio(unaRuta);
		assertEquals(unaHectareaAgua.tieneServicio(unaRuta),true);

	}
	
	//Falta implementaciones de construir ruta al lado de punto de entrada de gente. 


}
