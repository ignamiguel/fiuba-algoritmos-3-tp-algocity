package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CentrealesTest {

	@Test
	public void testCostoNuevaCentralEolica() {

		CentralEolica unaCentral = new CentralEolica();
		assertEquals(unaCentral.getCosto(), 1000);

	}

	@Test
	public void testCostoNuevaCentralNuclear() {

		CentralNuclear unaCentral = new CentralNuclear();
		assertEquals(unaCentral.getCosto(), 10000);

	}

	@Test
	public void testCostoNuevaCentralMineral() {

		CentralMineral unaCentral = new CentralMineral();
		assertEquals(unaCentral.getCosto(), 3000);

	}

	// @Test
	// public void testRadioDeCoverturaCentralEolica() {
	// CentralEolica unaCentral = new CentralEolica();
	// assertEquals(unaCentral.obtenerRadioDeCovertura(), 4);
	//
	// }

	// @Test
	// public void testRadioDeCoverturaCentralMineral() {
	//
	// CentralMineral unaCentral = new CentralMineral();
	// assertEquals(unaCentral.obtenerRadioDeCovertura(), 10);
	//
	// }

	@Test
	public void testRadioDeCoverturaCentralNuclear() {

		CentralNuclear unaCentral = new CentralNuclear();
		assertEquals(unaCentral.getRadioDeCovertura(), 25);

	}

	@Test
	public void testCapacidadDeAbastecimientoCentralEolica() {

		CentralEolica unaCentral = new CentralEolica();
		assertEquals(unaCentral.getCapacidadDeAbastecimiento(), 100);

	}

	@Test
	public void testCapacidadDeAbastecimientoCentralMineral() {

		CentralMineral unaCentral = new CentralMineral();
		assertEquals(unaCentral.getCapacidadDeAbastecimiento(), 400);

	}

	@Test
	public void testCapacidadDeAbastecimientoCentralNuclear() {

		CentralNuclear unaCentral = new CentralNuclear();
		assertEquals(unaCentral.getCapacidadDeAbastecimiento(), 1000);

	}

	@Test
	public void testPuedeConstruirseEnAguaCentralEolica() {

		CentralEolica unaCentral = new CentralEolica();

		assertEquals(unaCentral.puedoEn(new Agua()), false);

	}

	@Test
	public void testPuedeConstruirseEnTerrenoCentralEolica() {

		CentralEolica unaCentral = new CentralEolica();

		assertEquals(unaCentral.puedoEn(new Terreno()), true);

	}

	@Test
	public void testPuedeConstruirseEnAguaCentralMineral() {

		CentralMineral unaCentral = new CentralMineral();

		assertEquals(unaCentral.puedoEn(new Agua()), false);

	}

	@Test
	public void testPuedeConstruirseEnTerrenoCentralMineral() {

		CentralMineral unaCentral = new CentralMineral();

		assertEquals(unaCentral.puedoEn(new Terreno()), true);

	}

	@Test
	public void testPuedeConstruirseEnAguaCentralNuclear() {

		CentralNuclear unaCentral = new CentralNuclear();

		assertEquals(unaCentral.puedoEn(new Agua()), false);

	}

	@Test
	public void testPuedeConstruirseEnTerrenoCentralNuclear() {

		CentralNuclear unaCentral = new CentralNuclear();

		assertEquals(unaCentral.puedoEn(new Terreno()), true);

	}

	@Test
	public void testEstaActivaCentralEolica() {

		CentralEolica unaCentral = new CentralEolica();

		assertEquals(unaCentral.estaConectada(), false);

	}

	@Test
	public void testEstaActivaCentralMineral() {

		CentralMineral unaCentral = new CentralMineral();

		assertEquals(unaCentral.estaConectada(), false);

	}

	@Test
	public void testEstaActivaCentralNuclear() {

		CentralNuclear unaCentral = new CentralNuclear();

		assertEquals(unaCentral.estaConectada(), false);

	}


	@Test
	public void testCentalElectricaPropagaElectricidadATodasLasHectareasQueEstanAlineadasAlSurConRutaYConsumenSuAbastecimiento() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		CentralMineral central = new CentralMineral();
		mapa.construir(central, new Coordenada(0, 19));
		mapa.conectar(new Tuberia(), new Coordenada(0, 19));

		mapa.construir(new PozoDeAgua(), new Coordenada(0, 20));
		mapa.conectar(new Tuberia(), new Coordenada(0, 20));

		for (int i = 1; i < mapa.getTamanio(); i++) {
			assertEquals(true,
					mapa.construir(new Industria(), new Coordenada(i, 19)));
			assertEquals(true,
					mapa.conectar(new LineaDeTension(), new Coordenada(i, 19)));
		}

		assertEquals(400, central.getCapacidadDeAbastecimiento());

		// Primero propago el servicio de agua
		mapa.propagarServicio(new Coordenada(0, 20));

		// Segundo propago el servicio electrico
		mapa.propagarServicio(new Coordenada(0, 19));

		for (int i = 1; i < mapa.getTamanio(); i++) {
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(i, 19)))
							.estaActivo(central.getServicioPropagable()));
		}
		assertEquals(280, central.getCapacidadDeAbastecimiento());

	}

}