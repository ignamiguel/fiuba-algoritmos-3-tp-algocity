package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GodzillaTest {

	@Test
	public void testGodzillaSeCreaConExito(){
		Godzilla godzilla = new Godzilla();
		assertNotNull(godzilla);
	}
	
	@Test
	public void testGodzillaSeCreaEnLaCoordenada0_0(){
		Godzilla godzilla = new Godzilla();
		assertEquals( (godzilla.obtenerCoordenada()).obtenerX() , 0 );
		assertEquals( (godzilla.obtenerCoordenada()).obtenerY() , 0 );
	}
	
	
}
