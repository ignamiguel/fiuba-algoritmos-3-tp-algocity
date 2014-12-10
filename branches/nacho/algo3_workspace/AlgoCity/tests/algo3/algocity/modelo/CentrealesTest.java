package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CentrealesTest {

	@Test
	public void testCostoNuevaCentralEolica() {

		CentralEolica unaCentral = new CentralEolica();
		assertEquals(unaCentral.obtenerCosto(), 1000);

	}

	@Test
	public void testCostoNuevaCentralNuclear() {

		CentralNuclear unaCentral = new CentralNuclear();
		assertEquals(unaCentral.obtenerCosto(), 10000);

	}

	@Test
	public void testCostoNuevaCentralMineral() {

		CentralMineral unaCentral = new CentralMineral();
		assertEquals(unaCentral.obtenerCosto(), 3000);

	}

//	@Test
//	public void testRadioDeCoverturaCentralEolica() {
//		CentralEolica unaCentral = new CentralEolica();
//		assertEquals(unaCentral.obtenerRadioDeCovertura(), 4);
//
//	}

//	@Test
//	public void testRadioDeCoverturaCentralMineral() {
//
//		CentralMineral unaCentral = new CentralMineral();
//		assertEquals(unaCentral.obtenerRadioDeCovertura(), 10);
//
//	}

	@Test
	public void testRadioDeCoverturaCentralNuclear() {

		CentralNuclear unaCentral = new CentralNuclear();
		assertEquals(unaCentral.obtenerRadioDeCovertura(), 25);

	}

	@Test
	public void testCapacidadDeAbastecimientoCentralEolica() {

		CentralEolica unaCentral = new CentralEolica();
		assertEquals(unaCentral.obtenerCapacidadDeAbastecimiento(), 100);

	}

	@Test
	public void testCapacidadDeAbastecimientoCentralMineral() {

		CentralMineral unaCentral = new CentralMineral();
		assertEquals(unaCentral.obtenerCapacidadDeAbastecimiento(), 400);

	}

	@Test
	public void testCapacidadDeAbastecimientoCentralNuclear() {

		CentralNuclear unaCentral = new CentralNuclear();
		assertEquals(unaCentral.obtenerCapacidadDeAbastecimiento(), 1000);

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
	public void testCentralEolicaPropagaEnergiaATravezDeLosCableDeTensionArribaDelaCentral() {
		Mapa mapa = new Mapa(new MapaLlano());
		CentralEolica central = new CentralEolica();

		assertEquals(true, mapa.construir(central, new Coordenada(22, 22)));

		LineaDeTension ldt = new LineaDeTension();

		assertEquals(true, mapa.conectar(ldt, new Coordenada(21, 22)));

		mapa.propagarServicio(new Coordenada(22,22));

		assertEquals(true,
				(mapa.obtenerHectarea(new Coordenada(21, 22)))
						.estaActivo(central.obtenerServicioPropagable()));
	}

	@Test
	public void testCentralEolicaPropagaAguaATodasLasHectareasQueLaRodeanYLasQueEstanEnLasEsquinasConTuberias() {
		Mapa mapa = new Mapa(new MapaLlano());
		CentralEolica central = new CentralEolica();
		LineaDeTension ldt = new LineaDeTension();

		Coordenada norte = new Coordenada(20, 21);
		Coordenada este = new Coordenada(21, 22);
		Coordenada sur = new Coordenada(22, 21);
		Coordenada oeste = new Coordenada(21, 20);

		Coordenada esquina1 = new Coordenada(20, 20);
		Coordenada esquina2 = new Coordenada(20, 22);
		Coordenada esquina3 = new Coordenada(22, 20);
		Coordenada esquina4 = new Coordenada(22, 22);

		assertEquals(true, mapa.construir(central, new Coordenada(21, 21)));

		assertEquals(true, mapa.conectar(ldt, norte));
		assertEquals(true, mapa.conectar(ldt, este));
		assertEquals(true, mapa.conectar(ldt, sur));
		assertEquals(true, mapa.conectar(ldt, oeste));

		assertEquals(true, mapa.conectar(ldt, esquina1));
		assertEquals(true, mapa.conectar(ldt, esquina2));
		assertEquals(true, mapa.conectar(ldt, esquina3));
		assertEquals(true, mapa.conectar(ldt, esquina4));

		mapa.propagarServicio(new Coordenada(21,21));

		assertEquals(
				true,
				mapa.obtenerHectarea(norte).estaActivo(
						central.obtenerServicioPropagable()));
		assertEquals(
				true,
				mapa.obtenerHectarea(este).estaActivo(
						central.obtenerServicioPropagable()));
		assertEquals(
				true,
				mapa.obtenerHectarea(sur).estaActivo(
						central.obtenerServicioPropagable()));
		assertEquals(
				true,
				mapa.obtenerHectarea(oeste).estaActivo(
						central.obtenerServicioPropagable()));

		assertEquals(
				true,
				mapa.obtenerHectarea(esquina1).estaActivo(
						central.obtenerServicioPropagable()));
		assertEquals(
				true,
				mapa.obtenerHectarea(esquina2).estaActivo(
						central.obtenerServicioPropagable()));
		assertEquals(
				true,
				mapa.obtenerHectarea(esquina3).estaActivo(
						central.obtenerServicioPropagable()));
		assertEquals(
				true,
				mapa.obtenerHectarea(esquina4).estaActivo(
						central.obtenerServicioPropagable()));
	}

	@Test
	public void testCentralEolicaPropagaEnergiaATravezDeLosCableDeTensionArribaDelaCentralAUnaResidenciaQueLeConsumeCapacidad() {
		Mapa mapa = new Mapa(new MapaLlano());
		Residencia residencia = new Residencia();
		CentralEolica central = new CentralEolica();

		assertEquals(true, mapa.construir(central, new Coordenada(22, 22)));
		assertEquals(true, mapa.construir(residencia, new Coordenada(21, 22)));

		LineaDeTension ldt = new LineaDeTension();

		assertEquals(true, mapa.conectar(ldt, new Coordenada(21, 22)));

		mapa.propagarServicio(new Coordenada(22, 22));

		assertEquals(true,
				(mapa.obtenerHectarea(new Coordenada(21, 22)))
						.estaActivo(central.obtenerServicioPropagable()));
		assertEquals(99, central.obtenerCapacidadDeAbastecimiento());

	}

	@Test
	public void testCentralEolicaPropagaEnergiaATravezDeLosCableDeTensionArribaDelaCentralAUnaResidenciaUnaIndustriaYUnComercioQueLeConsumeCapacidad() {
		Mapa mapa = new Mapa(new MapaLlano());

		Residencia residencia = new Residencia();
		Comercio comercio = new Comercio();
		Industria industria = new Industria();

		CentralEolica central = new CentralEolica();

		assertEquals(true, mapa.construir(central, new Coordenada(22, 22)));
		assertEquals(true, mapa.construir(residencia, new Coordenada(21, 22)));
		assertEquals(true, mapa.construir(comercio, new Coordenada(20, 22)));
		assertEquals(true, mapa.construir(industria, new Coordenada(19, 22)));

		assertEquals(true,
				mapa.conectar(new LineaDeTension(), new Coordenada(21, 22)));
		assertEquals(true,
				mapa.conectar(new LineaDeTension(), new Coordenada(20, 22)));
		assertEquals(true,
				mapa.conectar(new LineaDeTension(), new Coordenada(19, 22)));

		mapa.propagarServicio(new Coordenada(22, 22));

		assertEquals(true,
				(mapa.obtenerHectarea(new Coordenada(21, 22)))
						.estaActivo(central.obtenerServicioPropagable()));
		assertEquals(true,
				(mapa.obtenerHectarea(new Coordenada(20, 22)))
						.estaActivo(central.obtenerServicioPropagable()));
		assertEquals(true,
				(mapa.obtenerHectarea(new Coordenada(19, 22)))
						.estaActivo(central.obtenerServicioPropagable()));
		assertEquals(92, central.obtenerCapacidadDeAbastecimiento());

	}

	@Test
	public void testCentralMineralPropagaEnergiaATravezDeLosCableDeTensionArribaDelaCentralAUnaResidenciaUnaIndustriaYUnComercioQueLeConsumeCapacidad() {
		Mapa mapa = new Mapa(new MapaLlano());

		Residencia residencia = new Residencia();
		Comercio comercio = new Comercio();
		Industria industria = new Industria();

		CentralMineral central = new CentralMineral();

		assertEquals(true, mapa.construir(central, new Coordenada(22, 22)));
		assertEquals(true, mapa.construir(residencia, new Coordenada(21, 22)));
		assertEquals(true, mapa.construir(comercio, new Coordenada(20, 22)));
		assertEquals(true, mapa.construir(industria, new Coordenada(19, 22)));

		assertEquals(true,
				mapa.conectar(new LineaDeTension(), new Coordenada(21, 22)));
		assertEquals(true,
				mapa.conectar(new LineaDeTension(), new Coordenada(20, 22)));
		assertEquals(true,
				mapa.conectar(new LineaDeTension(), new Coordenada(19, 22)));

		mapa.propagarServicio (new Coordenada(22, 22));

		assertEquals(true,
				(mapa.obtenerHectarea(new Coordenada(21, 22)))
						.estaActivo(central.obtenerServicioPropagable()));
		assertEquals(true,
				(mapa.obtenerHectarea(new Coordenada(20, 22)))
						.estaActivo(central.obtenerServicioPropagable()));
		assertEquals(true,
				(mapa.obtenerHectarea(new Coordenada(19, 22)))
						.estaActivo(central.obtenerServicioPropagable()));
		assertEquals(392, central.obtenerCapacidadDeAbastecimiento());
	}

	@Test
	public void testCentalElectricaPropagaElectricidadATodasLasHectareasQueEstanAlineadasAlSurConRutaYConsumenSuAbastecimiento() {
		Mapa mapa = new Mapa(new MapaLlano());
		CentralMineral central = new CentralMineral();
		mapa.construir(central, new Coordenada(0, 15));

		for (int i = 1; i < mapa.getTamanio(); i++) {
			assertEquals(true,
					mapa.construir(new Industria(), new Coordenada(i, 15)));
			assertEquals(true,
					mapa.conectar(new LineaDeTension(), new Coordenada(i, 15)));
		}

		assertEquals(400, central.obtenerCapacidadDeAbastecimiento());

		mapa.propagarServicio(new Coordenada(0, 15));

		for (int i = 1; i < mapa.getTamanio(); i++) {
			assertEquals(true,
					(mapa.obtenerHectarea(new Coordenada(i, 15)))
							.estaActivo(central.obtenerServicioPropagable()));
		}
		assertEquals(280, central.obtenerCapacidadDeAbastecimiento());

	}

}