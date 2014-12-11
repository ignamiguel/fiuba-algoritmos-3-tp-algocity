package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PozoDeAguaTest {

	@Test
	public void testPuedoConstruirUnPozoDeAguaEnUnMapa() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(22,22);
		assertEquals(true, mapa.construir(pozo,c));
	}

	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaDeArribaConUnaTuberia() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(22,22);
		
		assertEquals(true, mapa.construir(pozo, new Coordenada(22, 22)));

		Tuberia tuberia = new Tuberia();

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(21, 22)));

		mapa.propagarServicio(c);

		assertEquals(true,
				(mapa.getHectarea(new Coordenada(21, 22))).tieneConexion(pozo
						.getServicioPropagable()));
	}

	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaDeArribaYALaQueEStaArribaDeEsaConUnaTuberia() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(22,22);

		assertEquals(true, mapa.construir(pozo, new Coordenada(22, 22)));

		Tuberia tuberia = new Tuberia();

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(21, 22)));

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(20, 22)));

		mapa.propagarServicio(c);

		assertEquals(true,
				(mapa.getHectarea(new Coordenada(21, 22))).tieneConexion(pozo
						.getServicioPropagable()));
		assertEquals(true,
				(mapa.getHectarea(new Coordenada(20, 22))).tieneConexion(pozo
						.getServicioPropagable()));
	}

	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaDeLaDerechaConUnaTuberia() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();

		Coordenada c = new Coordenada(22,22);
		
		assertEquals(true, mapa.construir(pozo, new Coordenada(22, 22)));

		Tuberia tuberia = new Tuberia();

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(22, 23)));

		mapa.propagarServicio(c);

		Hectarea hectarea = mapa.getHectarea(new Coordenada(22, 23));

		assertEquals(true,
				hectarea.tieneConexion(pozo.getServicioPropagable()));

	}

	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaDeLaDerechaYALaQueEstaAlaDerechaDeEsaConUnaTuberia() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(21,21);

		assertEquals(true, mapa.construir(pozo, new Coordenada(21, 21)));

		Tuberia tuberia = new Tuberia();

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(21, 22)));

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(21, 23)));

		mapa.propagarServicio(c);

		assertEquals(true,
				(mapa.getHectarea(new Coordenada(21, 22))).tieneConexion(pozo
						.getServicioPropagable()));
		assertEquals(true,
				(mapa.getHectarea(new Coordenada(21, 23))).tieneConexion(pozo
						.getServicioPropagable()));
	}

	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaQueEstaAbajoConUnaTuberia() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(22,22);

		assertEquals(true, mapa.construir(pozo, new Coordenada(22, 22)));

		Tuberia tuberia = new Tuberia();

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(23, 22)));

		mapa.propagarServicio(c);

		Hectarea hectarea = mapa.getHectarea(new Coordenada(23, 22));

		assertEquals(true,
				hectarea.tieneConexion(pozo.getServicioPropagable()));

	}

	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaQueEstaAbajoYLaQueEstaAbajoDeEsaConUnaTuberia() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(21,21);

		assertEquals(true, mapa.construir(pozo, new Coordenada(21, 21)));

		Tuberia tuberia = new Tuberia();

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(22, 21)));

		Tuberia tuberia2 = new Tuberia();

		assertEquals(true, mapa.conectar(tuberia2, new Coordenada(23, 21)));

		mapa.propagarServicio(c);

		assertEquals(true,
				(mapa.getHectarea(new Coordenada(22, 21))).tieneConexion(pozo
						.getServicioPropagable()));
		assertEquals(true,
				(mapa.getHectarea(new Coordenada(23, 21))).tieneConexion(pozo
						.getServicioPropagable()));
	}

	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaQueEstaALaIzquierdaConUnaTuberia() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(22,22);

		assertEquals(true, mapa.construir(pozo, new Coordenada(22, 22)));

		Tuberia tuberia = new Tuberia();

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(22, 21)));

		mapa.propagarServicio(c);

		Hectarea hectarea = mapa.getHectarea(new Coordenada(22, 21));

		assertEquals(true,
				hectarea.tieneConexion(pozo.getServicioPropagable()));

	}

	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaQueEstaALaIzquierdaYLaQueEstaAlaIzquierdaDeEsaConUnaTuberia() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(21,21);

		assertEquals(true, mapa.construir(pozo, new Coordenada(21, 21)));

		Tuberia tuberia = new Tuberia();

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(21, 20)));

		assertEquals(true, mapa.conectar(tuberia, new Coordenada(21, 19)));

		mapa.propagarServicio(c);

		assertEquals(true,
				(mapa.getHectarea(new Coordenada(21, 20))).tieneConexion(pozo
						.getServicioPropagable()));
		assertEquals(true,
				(mapa.getHectarea(new Coordenada(21, 19))).tieneConexion(pozo
						.getServicioPropagable()));
	}

	@Test
	public void testPozoDeAguaPropagaAguaATodasLasHectareasQueLaRodeanConTuberias() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Tuberia tuberia = new Tuberia();
		Coordenada c = new Coordenada(21,21);

		Coordenada norte = new Coordenada(20, 21);
		Coordenada este = new Coordenada(21, 22);
		Coordenada sur = new Coordenada(22, 22);
		Coordenada oeste = new Coordenada(21, 20);

		assertEquals(true, mapa.construir(pozo, new Coordenada(21, 21)));

		assertEquals(true, mapa.conectar(tuberia, norte));
		assertEquals(true, mapa.conectar(tuberia, este));
		assertEquals(true, mapa.conectar(tuberia, sur));
		assertEquals(true, mapa.conectar(tuberia, oeste));

		mapa.propagarServicio(c);

		assertEquals(
				true,
				mapa.getHectarea(norte).tieneConexion(
						pozo.getServicioPropagable()));
		assertEquals(
				true,
				mapa.getHectarea(este).tieneConexion(
						pozo.getServicioPropagable()));
		assertEquals(
				true,
				mapa.getHectarea(sur).tieneConexion(
						pozo.getServicioPropagable()));
		assertEquals(
				true,
				mapa.getHectarea(oeste).tieneConexion(
						pozo.getServicioPropagable()));
	}

	@Test
	public void testPozoDeAguaPropagaAguaATodasLasHectareasQueLaRodeanYLasQueEstanEnLasEsquinasConTuberias() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Tuberia tuberia = new Tuberia();
		Coordenada c = new Coordenada(21,21);

		Coordenada norte = new Coordenada(20, 21);
		Coordenada este = new Coordenada(21, 22);
		Coordenada sur = new Coordenada(22, 21);
		Coordenada oeste = new Coordenada(21, 20);

		Coordenada esquina1 = new Coordenada(20, 20);
		Coordenada esquina2 = new Coordenada(20, 22);
		Coordenada esquina3 = new Coordenada(22, 20);
		Coordenada esquina4 = new Coordenada(22, 22);

		assertEquals(true, mapa.construir(pozo, new Coordenada(21, 21)));

		assertEquals(true, mapa.conectar(tuberia, norte));
		assertEquals(true, mapa.conectar(tuberia, este));
		assertEquals(true, mapa.conectar(tuberia, sur));
		assertEquals(true, mapa.conectar(tuberia, oeste));

		assertEquals(true, mapa.conectar(tuberia, esquina1));
		assertEquals(true, mapa.conectar(tuberia, esquina2));
		assertEquals(true, mapa.conectar(tuberia, esquina3));
		assertEquals(true, mapa.conectar(tuberia, esquina4));

		mapa.propagarServicio(c);

		assertEquals(
				true,
				mapa.getHectarea(norte).tieneConexion(
						pozo.getServicioPropagable()));
		assertEquals(
				true,
				mapa.getHectarea(este).tieneConexion(
						pozo.getServicioPropagable()));
		assertEquals(
				true,
				mapa.getHectarea(sur).tieneConexion(
						pozo.getServicioPropagable()));
		assertEquals(
				true,
				mapa.getHectarea(oeste).tieneConexion(
						pozo.getServicioPropagable()));

		assertEquals(
				true,
				mapa.getHectarea(esquina1).tieneConexion(
						pozo.getServicioPropagable()));
		assertEquals(
				true,
				mapa.getHectarea(esquina2).tieneConexion(
						pozo.getServicioPropagable()));
		assertEquals(
				true,
				mapa.getHectarea(esquina3).tieneConexion(
						pozo.getServicioPropagable()));
		assertEquals(
				true,
				mapa.getHectarea(esquina4).tieneConexion(
						pozo.getServicioPropagable()));
	}

	@Test
	public void testPozoDeAguaPropagaAguaDesdeCoordenada5_23hasta5_0() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(5,23);

		for (int i = 0; i < 24; i++) {
			Tuberia tuberia = new Tuberia();
			assertEquals(true, mapa.conectar(tuberia, new Coordenada(5, i)));
		}

		mapa.construir(pozo, new Coordenada(5, 23));
	
		mapa.propagarServicio(c);

		for (int i = 0; i < 23; i++) {
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(5, i)))
							.tieneConexion(pozo.getConexionNecesaria()));
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(5, i)))
							.tieneConexion(pozo.getServicioPropagable()));
		}
	}

	@Test
	public void testPozoDeAguaPropagaAguaDesdeCoordenada5_23hasta5_0YTambienLasHectareasDesde0_3Hasta24_3() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(5,23);

		for (int i = 0; i < 24; i++) {
			Tuberia tuberia = new Tuberia();
			assertEquals(true, mapa.conectar(tuberia, new Coordenada(5, i)));
		}

		for (int i = 0; i < 5; i++) {
			Tuberia tuberia = new Tuberia();
			assertEquals(true, mapa.conectar(tuberia, new Coordenada(i, 3)));
		}

		for (int i = 6; i < 24; i++) {
			Tuberia tuberia = new Tuberia();
			assertEquals(true, mapa.conectar(tuberia, new Coordenada(i, 3)));
		}

		mapa.construir(pozo, new Coordenada(5, 23));
	
		mapa.propagarServicio(c);

		for (int i = 0; i < 23; i++) {
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(5, i)))
							.tieneConexion(pozo.getConexionNecesaria()));
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(5, i)))
							.tieneConexion(pozo.getServicioPropagable()));
		}

		for (int i = 0; i < 24; i++) {
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(i, 3)))
							.tieneConexion(pozo.getConexionNecesaria()));
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(i, 3)))
							.tieneConexion(pozo.getServicioPropagable()));
		}
	}

	@Test
	public void testPozoDeAguaPropagaAguaDesdeCoordenadaATodoElMapa() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		
		Coordenada c = new Coordenada(5,23);

		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				Tuberia tuberia = new Tuberia();
				assertEquals(true, mapa.conectar(tuberia, new Coordenada(i, j)));
			}
		}

		mapa.construir(pozo, new Coordenada(5, 23));

		mapa.propagarServicio(c);

		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				assertEquals(true,
						(mapa.getHectarea(new Coordenada(i, j)))
								.tieneConexion(pozo.getConexionNecesaria()));
				assertEquals(true,
						(mapa.getHectarea(new Coordenada(i, j)))
								.tieneConexion(pozo.getServicioPropagable()));
			}
		}
	}

	@Test
	public void testPozoDeAguaPropagaAguaATodaHectareasConectadasAlPozoPeroNoAlasQueTieneTuberiaPeroNoEstanConectadas() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(5,23);

		for (int i = 0; i < mapa.getTamanio(); i++) {
			Tuberia tuberia = new Tuberia();
			assertEquals(true, mapa.conectar(tuberia, new Coordenada(5, i)));
		}

		for (int i = 0; i < mapa.getTamanio(); i++) {
			Tuberia tuberia = new Tuberia();
			assertEquals(true, mapa.conectar(tuberia, new Coordenada(7, i)));
		}

		mapa.construir(pozo, new Coordenada(5, 23));
	
		mapa.propagarServicio(c);

		for (int i = 0; i < mapa.getTamanio(); i++) {
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(5, i)))
							.tieneConexion(pozo.getConexionNecesaria()));
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(5, i)))
							.tieneConexion(pozo.getServicioPropagable()));
		}

		for (int i = 0; i < mapa.getTamanio(); i++) {
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(7, i)))
							.tieneConexion(pozo.getConexionNecesaria()));
			assertEquals(false,
					(mapa.getHectarea(new Coordenada(7, i)))
							.tieneConexion(pozo.getServicioPropagable()));
		}
	}

	@Test
	public void testPozoDeAguaPropagaAguaATodaHectareasConectadasEnLaFilaDelPozoYAOtraFilaConTuberiasUnidasPorUnaTuberia() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(5,23);

		for (int i = 0; i < mapa.getTamanio(); i++) {
			Tuberia tuberia = new Tuberia();
			assertEquals(true, mapa.conectar(tuberia, new Coordenada(5, i)));
		}

		for (int i = 0; i < mapa.getTamanio(); i++) {
			Tuberia tuberia = new Tuberia();
			assertEquals(true, mapa.conectar(tuberia, new Coordenada(7, i)));
		}

		Tuberia tuberia = new Tuberia();
		assertEquals(true, mapa.conectar(tuberia, new Coordenada(6, 5)));

		mapa.construir(pozo, new Coordenada(5, 23));
		
		mapa.propagarServicio(c);

		for (int i = 0; i < mapa.getTamanio(); i++) {
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(5, i)))
							.tieneConexion(pozo.getConexionNecesaria()));
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(5, i)))
							.tieneConexion(pozo.getServicioPropagable()));
		}

		for (int i = 0; i < mapa.getTamanio(); i++) {
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(7, i)))
							.tieneConexion(pozo.getConexionNecesaria()));
			assertEquals(true,
					(mapa.getHectarea(new Coordenada(7, i)))
							.tieneConexion(pozo.getServicioPropagable()));
		}

		assertEquals(true,
				(mapa.getHectarea(new Coordenada(6, 5))).tieneConexion(pozo
						.getServicioPropagable()));

	}
}