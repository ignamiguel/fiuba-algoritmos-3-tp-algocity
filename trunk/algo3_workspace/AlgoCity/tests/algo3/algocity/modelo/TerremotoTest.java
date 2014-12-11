package algo3.algocity.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TerremotoTest {

	@Test
	public void testTerremotoCreadoConExito() {
		IGeneradorEpicentro ge = new GeneradorEpicentroMock(new Coordenada(10,
				10));
		Terremoto terremoto = new Terremoto(ge);
		assertNotNull(terremoto);
	}

	@Test
	public void testTerremotoCreadoTieneDanio100() {
		IGeneradorEpicentro ge = new GeneradorEpicentroMock(new Coordenada(10,
				10));
		Terremoto terremoto = new Terremoto(ge);
		assertEquals(terremoto.getAveria(), 100);
	}

	@Test
	public void terremotoCausaAveriasTotalesAResidenciaEnElEpicentro() {
		Mapa mapa = new Mapa(new MapaLlano());

		mapa.construir(new Residencia(), new Coordenada(10, 10));

		IGeneradorEpicentro ge = new GeneradorEpicentroMock(new Coordenada(10,
				10));

		Terremoto t = new Terremoto(ge);

		mapa.afectarConTerremoto(t);

		Construccion c = mapa.getHectarea(new Coordenada(10, 10))
				.getConstruccion();

		assertEquals(0, c.getSalud());
	}

	@Test
	public void terremotoDecreceAveriasEnXPuntosAlAlejarse1Hectarea() {
		Mapa mapa = new Mapa(new MapaLlano());

		mapa.construir(new Residencia(), new Coordenada(10, 10));

		// Agrego residencias vecinos
		mapa.construir(new Residencia(), new Coordenada(9, 10));
		mapa.construir(new Residencia(), new Coordenada(11, 10));
		mapa.construir(new Residencia(), new Coordenada(10, 9));
		mapa.construir(new Residencia(), new Coordenada(10, 11));

		// Creo un generador de epicentros mock
		// indicando el epicentro
		IGeneradorEpicentro ge = new GeneradorEpicentroMock(new Coordenada(10,
				10));
		Terremoto t = new Terremoto(ge);

		mapa.afectarConTerremoto(t);

		// Verifico daños
		Construccion c_epicentro = mapa.getHectarea(new Coordenada(10, 10))
				.getConstruccion();

		Construccion c_norte = mapa.getHectarea(new Coordenada(9, 10))
				.getConstruccion();
		Construccion c_sur = mapa.getHectarea(new Coordenada(11, 10))
				.getConstruccion();
		Construccion c_este = mapa.getHectarea(new Coordenada(10, 9))
				.getConstruccion();
		Construccion c_oeste = mapa.getHectarea(new Coordenada(10, 11))
				.getConstruccion();

		int saludRestante = Configuracion.TERREMOTO_DECRECIMENTO_AVERIA_POR_RADIO;

		// El terremoto decrece 2 puntos a medida
		// que se aleja del epicentro
		assertEquals(0, c_epicentro.getSalud());
		assertEquals(saludRestante, c_norte.getSalud());
		assertEquals(saludRestante, c_sur.getSalud());
		assertEquals(saludRestante, c_este.getSalud());
		assertEquals(saludRestante, c_oeste.getSalud());
	}

	@Test
	public void terremotoDecreceAveriasEnXXPuntosAlAlejarse2Hectarea() {
		Mapa mapa = new Mapa(new MapaLlano());

		mapa.construir(new Residencia(), new Coordenada(10, 10));

		// Agrego residencias vecinos a 2 hectareas de distancia
		List<Coordenada> vecinos = new ArrayList<Coordenada>();

		vecinos.add(new Coordenada(8, 10));
		vecinos.add(new Coordenada(12, 10));
		vecinos.add(new Coordenada(10, 8));
		vecinos.add(new Coordenada(10, 12));
		vecinos.add(new Coordenada(9, 9));
		vecinos.add(new Coordenada(11, 11));
		vecinos.add(new Coordenada(9, 11));
		vecinos.add(new Coordenada(11, 9));

		for (Coordenada coordenada : vecinos) {
			mapa.construir(new Residencia(), coordenada);
		}

		IGeneradorEpicentro ge = new GeneradorEpicentroMock(new Coordenada(10,
				10));
		Terremoto t = new Terremoto(ge);

		mapa.afectarConTerremoto(t);

		// Verifico daños
		Construccion c_epicentro = mapa.getHectarea(new Coordenada(10, 10))
				.getConstruccion();

		assertEquals(0, c_epicentro.getSalud());

		int saludRestante = (Configuracion.TERREMOTO_DECRECIMENTO_AVERIA_POR_RADIO * 2);

		// El terremoto decrece 4 puntos si
		// es una distancia de 2 hectareas
		for (Coordenada coordenada : vecinos) {
			assertEquals(saludRestante, mapa.getHectarea(coordenada)
					.getConstruccion().getSalud());
		}

	}

	@Test
	public void terremotoUtilizaUnMockParaGenerarEpicentro() {
		Mapa mapa = new Mapa(new MapaLlano());

		mapa.construir(new Residencia(), new Coordenada(10, 10));

		IGeneradorEpicentro ge = new GeneradorEpicentroMock(new Coordenada(10,
				10));

		Terremoto t = new Terremoto(ge);

		mapa.afectarConTerremoto(t);

		Construccion c = mapa.getHectarea(new Coordenada(10, 10))
				.getConstruccion();

		assertEquals(0, c.getSalud());
	}

	@Test
	public void verificoQueGeneradorEpicentroSiempreEstaEnRangoDeMapa() {
		Mapa mapa = new Mapa(new MapaLlano());

		int tamanio = mapa.getTamanio();

		IGeneradorEpicentro ge = new GeneradorEpicentro(tamanio);

		int x = ge.getEpicentro().obtenerX();
		int y = ge.getEpicentro().obtenerY();
		assertTrue((0 <= x) && (x < tamanio));

		assertTrue((0 <= y) && (y < tamanio));

	}

	@Test
	public void testDeMapaPlayaConTerremotoYConstrucciones() {
		Mapa mapa = new Mapa(new MapaLlano());

		// Populo el mapa con residencias
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				mapa.construir(new Residencia(), new Coordenada(i, j));
			}
		}

		// Genero un mock para el epicentro
		IGeneradorEpicentro ge = new GeneradorEpicentroMock(new Coordenada(10,
				10));
		Terremoto t = new Terremoto(ge);

		mapa.afectarConTerremoto(t);

		// Verifico averias en hectareas "claves"
		// sobre los ejes de las x hacia arriba.
		int averia = Configuracion.TERREMOTO_AVERIA_EPICENTRO;
		for (int i = 9; i >= 0; i--) {
			averia = averia
					- Configuracion.TERREMOTO_DECRECIMENTO_AVERIA_POR_RADIO;
			int saludRestante = (Configuracion.SALUD_INICIAL - averia);

			assertEquals(saludRestante, mapa.getHectarea(new Coordenada(i, 10))
					.getConstruccion().getSalud());
		}

		// Sobre los ejes de las x hacia abajo.
		averia = Configuracion.TERREMOTO_AVERIA_EPICENTRO;
		for (int i = 11; i < mapa.getTamanio(); i++) {
			averia = averia
					- Configuracion.TERREMOTO_DECRECIMENTO_AVERIA_POR_RADIO;

			if (averia < 0)
				break;

			int saludRestante = (Configuracion.SALUD_INICIAL - averia);

			assertEquals(saludRestante, mapa.getHectarea(new Coordenada(i, 10))
					.getConstruccion().getSalud());
		}

		// Sobre los ejes de las y hacia izquierda.
		averia = Configuracion.TERREMOTO_AVERIA_EPICENTRO;
		for (int i = 9; i >= 0; i--) {
			averia = averia
					- Configuracion.TERREMOTO_DECRECIMENTO_AVERIA_POR_RADIO;
			int saludRestante = (Configuracion.SALUD_INICIAL - averia);

			assertEquals(saludRestante, mapa.getHectarea(new Coordenada(10, i))
					.getConstruccion().getSalud());
		}

		// Sobre los ejes de las y hacia derecha.
		averia = Configuracion.TERREMOTO_AVERIA_EPICENTRO;
		for (int i = 11; i < mapa.getTamanio(); i++) {
			averia = averia
					- Configuracion.TERREMOTO_DECRECIMENTO_AVERIA_POR_RADIO;

			if (averia < 0)
				break;

			int saludRestante = (Configuracion.SALUD_INICIAL - averia);

			assertEquals(saludRestante, mapa.getHectarea(new Coordenada(10, i))
					.getConstruccion().getSalud());
		}

	}
}
