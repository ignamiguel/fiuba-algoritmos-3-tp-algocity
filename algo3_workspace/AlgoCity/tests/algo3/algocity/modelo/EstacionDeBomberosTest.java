package algo3.algocity.modelo;

import org.junit.Assert;
import org.junit.Test;



public class EstacionDeBomberosTest {

	@Test
	public void CrearUnaEstacionDeBomberos(){
		
		EstacionDeBomberos e = new EstacionDeBomberos();
		String resultado = e.obtenerNombre();
		Assert.assertTrue(resultado.equals("Estacion de Bomberos"));
		
	}
}
