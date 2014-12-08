package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordenadaTest {

	/*@Test(expected = CoordenadaInvalidaExcepcion.class)
	public void valoresDeCoordenadaNegativosArrojaExcepcion() {
		new Coordenada(-1, 0);

	}*/
	
	@Test
	public void aumentarEnX(){
		
		Coordenada una = new Coordenada(1,1);
		una.aumentarX(1);
		assertEquals(una.obtenerX(),2);
		
		
	}

}
