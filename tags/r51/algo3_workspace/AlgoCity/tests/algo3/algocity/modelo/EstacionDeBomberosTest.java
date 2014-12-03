package algo3.algocity.modelo;

import org.junit.Assert;
import org.junit.Test;

public class EstacionDeBomberosTest {

	@Test
	public void crearUnaEstacionDeBomberos(){
		
		EstacionDeBomberos e = new EstacionDeBomberos();
		String resultado = e.obtenerNombre();
		Assert.assertTrue(resultado.equals("Estacion de Bomberos"));
		
	}
	
	@Test
	public void repararUnaResidenciaAfectadaPorGodzilla(){		
		
		Residencia casa = new Residencia();

		Godzilla godzilla = new Godzilla();		
				
		casa.afectarCon(godzilla);
		
		int salud = casa.obtenerSalud();
		
		Assert.assertEquals(0, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(casa);
		
		salud = casa.obtenerSalud();	
		
		Assert.assertEquals(10, salud);		
		
	}
	
	@Test
	public void repararUnComercioAfectadoPorGodzilla(){		
		
		Comercio comercio = new Comercio();

		Godzilla godzilla = new Godzilla();		
				
		comercio.afectarCon(godzilla);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(comercio);
		
		int salud = comercio.obtenerSalud();	
		
		Assert.assertEquals(32, salud);		
		
	}
	
	@Test
	public void repararUnaIndustriaAfectadaPorGodzilla(){		
		
		Industria industria = new Industria();

		Godzilla godzilla = new Godzilla();		
				
		industria.afectarCon(godzilla);
		
		int salud = industria.obtenerSalud();	
		
		Assert.assertEquals(60, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(industria);
		
		salud = industria.obtenerSalud();	
		
		Assert.assertEquals(63, salud);		
		
	}
	
	@Test
	public void repararUnaCentralEolicaAfectadaPorGodzilla(){		
		
		CentralEolica cEolica = new CentralEolica();

		Godzilla godzilla = new Godzilla();		
				
		cEolica.afectarCon(godzilla);
		
		int salud = cEolica.obtenerSalud();	
		
		Assert.assertEquals(65, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(cEolica);
		
		salud = cEolica.obtenerSalud();	
		
		Assert.assertEquals(80, salud);		
		
	}
	
	@Test
	public void repararUnaCentralMineraAfectadaPorGodzilla(){		
		
		CentralMineral cMinera = new CentralMineral();

		Godzilla godzilla = new Godzilla();		
				
		cMinera.afectarCon(godzilla);
		
		int salud = cMinera.obtenerSalud();	
		
		Assert.assertEquals(65, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(cMinera);
		
		salud = cMinera.obtenerSalud();	
		
		Assert.assertEquals(75, salud);	
		
	}
	
	@Test
	public void repararUnaCentralNuclearAfectadaPorGodzilla(){		
		
		CentralNuclear cNuclear = new CentralNuclear();

		Godzilla godzilla = new Godzilla();		
				
		cNuclear.afectarCon(godzilla);
		
		int salud = cNuclear.obtenerSalud();	
		
		Assert.assertEquals(65, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(cNuclear);
		
		salud = cNuclear.obtenerSalud();	
		
		Assert.assertEquals(68, salud);	
		
	}
}
