package algo3.algocity.modelo;

import org.junit.Test;

public class CoordenadaTest {
	
	@Test (expected = CoordenadaInvalidaExcepcion.class) 
	public void valoresDeCoordenadaNegativosArrojaExcepcion(){
		new Coordenada(-1,0);
		
	}
	

}
