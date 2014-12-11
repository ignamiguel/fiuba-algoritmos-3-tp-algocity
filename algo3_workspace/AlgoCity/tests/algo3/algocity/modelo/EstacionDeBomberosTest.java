package algo3.algocity.modelo;

import org.junit.Assert;
import org.junit.Test;

public class EstacionDeBomberosTest {

	@Test
	public void crearUnaEstacionDeBomberos(){
		
		EstacionDeBomberos e = new EstacionDeBomberos();
		String resultado = e.getEtiqueta();
		Assert.assertTrue(resultado.equals("Estacion de Bomberos"));
		
	}
	
	@Test
	public void repararUnaResidenciaAfectadaPorGodzilla(){		
		
		Residencia casa = new Residencia();

		Godzilla godzilla = new Godzilla();		
				
		casa.afectarCon(godzilla);
		
		int salud = casa.getSalud();
		
		Assert.assertEquals(0, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(casa);
		
		salud = casa.getSalud();	
		
		Assert.assertEquals(10, salud);		
		
	}
	
	@Test
	public void repararUnComercioAfectadoPorGodzilla(){		
		
		Comercio comercio = new Comercio();

		Godzilla godzilla = new Godzilla();		
				
		comercio.afectarCon(godzilla);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(comercio);
		
		int salud = comercio.getSalud();	
		
		Assert.assertEquals(32, salud);		
		
	}
	
	@Test
	public void repararUnaIndustriaAfectadaPorGodzilla(){		
		
		Industria industria = new Industria();

		Godzilla godzilla = new Godzilla();		
				
		industria.afectarCon(godzilla);
		
		int salud = industria.getSalud();	
		
		Assert.assertEquals(60, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(industria);
		
		salud = industria.getSalud();	
		
		Assert.assertEquals(63, salud);		
		
	}
	
	@Test
	public void repararUnaCentralEolicaAfectadaPorGodzilla(){		
		
		CentralEolica cEolica = new CentralEolica();

		Godzilla godzilla = new Godzilla();		
				
		cEolica.afectarCon(godzilla);
		
		int salud = cEolica.getSalud();	
		
		Assert.assertEquals(65, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(cEolica);
		
		salud = cEolica.getSalud();	
		
		Assert.assertEquals(80, salud);		
		
	}
	
	@Test
	public void repararUnaCentralMineraAfectadaPorGodzilla(){		
		
		CentralMineral cMinera = new CentralMineral();

		Godzilla godzilla = new Godzilla();		
				
		cMinera.afectarCon(godzilla);
		
		int salud = cMinera.getSalud();	
		
		Assert.assertEquals(65, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(cMinera);
		
		salud = cMinera.getSalud();	
		
		Assert.assertEquals(75, salud);	
		
	}
	
	@Test
	public void repararUnaCentralNuclearAfectadaPorGodzilla(){		
		
		CentralNuclear cNuclear = new CentralNuclear();

		Godzilla godzilla = new Godzilla();		
				
		cNuclear.afectarCon(godzilla);
		
		int salud = cNuclear.getSalud();	
		
		Assert.assertEquals(65, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(cNuclear);
		
		salud = cNuclear.getSalud();	
		
		Assert.assertEquals(68, salud);	
		
	}
	
	@Test
	public void repararUnaCentralNuclearAfectadaPorGodzillaEnUnaHectarea(){		
		
		Terreno terreno = new Terreno();
		
		CentralNuclear cNuclear = new CentralNuclear();

		Godzilla godzilla = new Godzilla();		
			
		terreno.construir(cNuclear);
		
		terreno.afectarCon(godzilla);
		
		int salud = cNuclear.getSalud();	
		
		Assert.assertEquals(65, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.reparar(terreno);
		
		salud = cNuclear.getSalud();	
		
		Assert.assertEquals(68, salud);	
		
	}
	
	@Test
	public void repararUnaCentralNuclearAfectadaPorGodzillaEnUnaMapa(){		
		Mapa mapa = new Mapa(new MapaConPlaya());
		
		CentralNuclear cNuclear = new CentralNuclear();

		Godzilla godzilla = new Godzilla();		
			
		mapa.construir(cNuclear,new Coordenada(2,2));
		
		godzilla.atacarSinRandomParaTest(mapa, new Coordenada(2,0), new CaminarDerecho());
		
		int salud = cNuclear.getSalud();	
		
		Assert.assertEquals(65, salud);
		
		EstacionDeBomberos estacion = new EstacionDeBomberos();
		
		estacion.repararAverias(mapa);
		
		salud = cNuclear.getSalud();	
		
		Assert.assertEquals(68, salud);	
		
	}
	
}
