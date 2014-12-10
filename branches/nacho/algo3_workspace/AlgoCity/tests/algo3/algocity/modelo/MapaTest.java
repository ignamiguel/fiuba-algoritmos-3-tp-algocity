package algo3.algocity.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MapaTest {

	@Test
	public void testCrearMapaConExitoTest() {
		Mapa mapa = new Mapa(new MapaLlano());
		assertNotNull(mapa);
	}

	@Test
	public void testMapaContieneTerrenoEn0_0ConMapaLlano() {
		Mapa mapa = new Mapa(new MapaLlano());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0, 0));
		assertEquals(hectarea.obtenerNombre(), "Terreno");
	}

	@Test
	public void testMapaContieneTerrenoEn10_10ConMapaLlano() {
		Mapa mapa = new Mapa(new MapaLlano());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(10, 10));
		assertEquals(hectarea.obtenerNombre(), "Terreno");

	}

	@Test
	public void testMapaContieneTerrenoEn10_10ConMapaConPlaya() {
		Mapa mapa = new Mapa(new MapaLlano());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(10, 10));
		assertEquals(hectarea.obtenerNombre(), "Terreno");

	}

	@Test
	public void testMapaContieneAguaEn0_20ConMapaConPlaya() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(0, 20));
		assertEquals(hectarea.obtenerNombre(), "Agua");

	}

	@Test
	public void testMapaContieneAguaEn24_24ConMapaConPlaya() {
		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(24, 24));
		assertEquals(hectarea.obtenerNombre(), "Agua");

	}

	@Test
	public void testMapaContieneTerrenoEn19_19ConMapaConPlaya() {

		Mapa mapa = new Mapa(new MapaConPlaya());
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(19, 19));
		assertEquals(hectarea.obtenerNombre(), "Terreno");

	}

	@Test
	public void construirUnEdificioEnTerrenoVacioDevuelveVerdadero() {

		Mapa mapa = new Mapa(new MapaConPlaya());

		Edificio e = new Residencia();

		boolean resultado = mapa.construir(e, new Coordenada(1, 1));

		assertEquals(true, resultado);
	}

	@Test
	public void construirUnEdificioEnTerrenoConstruidoDevuelveFalso() {

		Mapa mapa = new Mapa(new MapaConPlaya());

		Edificio e = new Residencia();

		mapa.construir(e, new Coordenada(1, 1));

		Edificio otroEdificio = new Residencia();

		boolean resultado = mapa.construir(otroEdificio, new Coordenada(1, 1));

		assertEquals(false, resultado);
	}

	@Test
	public void construirUnPozoDeAguaEnAguaVaciaDevuelveVerdadero() {

		Mapa mapa = new Mapa(new MapaConPlaya());

		PozoDeAgua pda = new PozoDeAgua();

		boolean resultado = mapa.construir(pda, new Coordenada(1, 20));

		assertEquals(true, resultado);

	}

	@Test
	public void construirUnPozoDeAguaEnAguaConstruidaDevuelveFalso() {

		Mapa mapa = new Mapa(new MapaConPlaya());

		PozoDeAgua pda = new PozoDeAgua();

		mapa.construir(pda, new Coordenada(1, 20));

		PozoDeAgua otroPda = new PozoDeAgua();

		boolean resultado = mapa.construir(otroPda, new Coordenada(1, 20));

		assertEquals(false, resultado);
	}

	@Test
	public void testMapaObtenerCordenadaDeHectarea() {

		Mapa mapa = new Mapa(new MapaConPlaya());
		Coordenada unaCoordenada = new Coordenada(19, 19);

		assertEquals(
				(mapa.obtenerHectarea(unaCoordenada).obtenerUbicacion()
						.obtenerX()),
				unaCoordenada.obtenerX());
		assertEquals(
				(mapa.obtenerHectarea(unaCoordenada).obtenerUbicacion()
						.obtenerY()),
				unaCoordenada.obtenerY());
	}

	@Test
	public void propagarServicioDeCentralEolicaSoloPorRadio() {
		Mapa mapa = new Mapa(new MapaConPlaya());

		CentralEolica ce = new CentralEolica();

		Coordenada origen = new Coordenada(10, 10);

		//mapa.construirX(ce, origen);
		mapa.construir(ce, origen);

		Coordenada arriba = new Coordenada(10, 9);
		Coordenada derecha = new Coordenada(11, 10);
		Coordenada abajo = new Coordenada(10, 11);
		Coordenada izquierda = new Coordenada(9, 10);

		// Pruebo que "todo" el MAPA no tiene servicio electrico
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {

				assertEquals(false, mapa.obtenerHectarea(new Coordenada(i, j))
						.estaActivo(TipoDeServicio.Electrico));
			}
		}

		mapa.propagarServicio(origen);
		
		
		ArrayList<Coordenada> coordenadasConServicio = new ArrayList<Coordenada>();
		
		coordenadasConServicio.add(arriba);
		coordenadasConServicio.add(abajo);
		coordenadasConServicio.add(izquierda);
		coordenadasConServicio.add(derecha);
		
		// El algoritmo tambien activa
		// el servicio en la hectarea origen
		coordenadasConServicio.add(origen);

		// Ahora estas hectareas
		// tienen servicio		
		for (Coordenada c : coordenadasConServicio) {
			assertEquals(
					true,
					mapa.obtenerHectarea(c).estaActivo(
							TipoDeServicio.Electrico));
		}	

		// No se modifica la capacidad de abastecimiento
		// porque las hectareas no tienen construcciones
		assertEquals(100, ce.obtenerCapacidadDeAbastecimiento());

		// Pruebo que el resto del MAPA no tiene servicio electrico
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				Coordenada c = new Coordenada(i, j);

				if (coordenadasConServicio.contains(c))
					continue;

				assertEquals(
						false,
						mapa.obtenerHectarea(c).estaActivo(
								TipoDeServicio.Electrico));
			}
		}

	}

	@Test
	public void propagarServicioDeCentralEolicaPorRadioYLineasDeTension() {
		Mapa mapa = new Mapa(new MapaConPlaya());

		CentralEolica ce = new CentralEolica();

		Coordenada origen = new Coordenada(10, 10);

		mapa.construir(ce, origen);

		Coordenada arriba = new Coordenada(10, 9);
		Coordenada arribaArriba = new Coordenada(10, 8);
		mapa.conectar(new LineaDeTension(), arribaArriba);

		Coordenada derecha = new Coordenada(11, 10);
		Coordenada derechaDerecha = new Coordenada(12, 10);
		mapa.conectar(new LineaDeTension(), derechaDerecha);

		Coordenada abajo = new Coordenada(10, 11);
		Coordenada abajoAbajo = new Coordenada(10, 12);
		mapa.conectar(new LineaDeTension(), abajoAbajo);

		Coordenada izquierda = new Coordenada(9, 10);
		Coordenada izquierdaIzquierda = new Coordenada(8, 10);
		mapa.conectar(new LineaDeTension(), izquierdaIzquierda);

		// Pruebo que "todo" el MAPA no tiene servicio electrico
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {

				assertEquals(false, mapa.obtenerHectarea(new Coordenada(i, j))
						.estaActivo(TipoDeServicio.Electrico));
			}
		}

		mapa.propagarServicio(origen);

		// Ahora tienen servicio las del radio = 1
		assertEquals(
				true,
				mapa.obtenerHectarea(arriba).estaActivo(
						TipoDeServicio.Electrico));
		assertEquals(
				true,
				mapa.obtenerHectarea(derecha).estaActivo(
						TipoDeServicio.Electrico));
		assertEquals(true,
				mapa.obtenerHectarea(abajo)
						.estaActivo(TipoDeServicio.Electrico));
		assertEquals(
				true,
				mapa.obtenerHectarea(izquierda).estaActivo(
						TipoDeServicio.Electrico));

		// Tambien algunas de radio = 2 con lineas de tension
		assertEquals(
				true,
				mapa.obtenerHectarea(arribaArriba).estaActivo(
						TipoDeServicio.Electrico));
		assertEquals(
				true,
				mapa.obtenerHectarea(derechaDerecha).estaActivo(
						TipoDeServicio.Electrico));
		assertEquals(
				true,
				mapa.obtenerHectarea(abajoAbajo).estaActivo(
						TipoDeServicio.Electrico));
		assertEquals(
				true,
				mapa.obtenerHectarea(izquierdaIzquierda).estaActivo(
						TipoDeServicio.Electrico));

		// No se modifica la capacidad de abastecimiento
		// porque las hectareas no tienen construcciones
		assertEquals(100, ce.obtenerCapacidadDeAbastecimiento());

		ArrayList<Coordenada> coordsConServicio = new ArrayList<Coordenada>();
		
		coordsConServicio.add(abajo);
		coordsConServicio.add(abajoAbajo);
		coordsConServicio.add(derecha);
		coordsConServicio.add(derechaDerecha);
		coordsConServicio.add(arriba);
		coordsConServicio.add(arribaArriba);
		coordsConServicio.add(izquierda);
		coordsConServicio.add(izquierdaIzquierda);
		coordsConServicio.add(origen);
		
		// Pruebo que el resto del MAPA no tiene servicio electrico
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				Coordenada c = new Coordenada(i, j);

				if (coordsConServicio.contains(c))
					continue;

				assertEquals(
						false,
						mapa.obtenerHectarea(c).estaActivo(
								TipoDeServicio.Electrico));
			}
		}

	}

	@Test
	public void propagarServicioDeCentralMineralSoloPorRadio() {
		Mapa mapa = new Mapa(new MapaConPlaya());

		CentralMineral cm = new CentralMineral();

		Coordenada origen = new Coordenada(10, 10);

		mapa.construir(cm, origen);
		
		ArrayList<Coordenada> coordenadasConServicio = new ArrayList<Coordenada>();

		// radio = 1
		Coordenada a1 = new Coordenada(10, 9);
		coordenadasConServicio.add(a1);
		Coordenada a2 = new Coordenada(11, 10);
		coordenadasConServicio.add(a2);
		Coordenada a3 = new Coordenada(10, 11);
		coordenadasConServicio.add(a3);
		Coordenada a4 = new Coordenada(9, 10);
		coordenadasConServicio.add(a4);

		// radio = 2
		Coordenada b1 = new Coordenada(10, 8);
		coordenadasConServicio.add(b1);
		Coordenada b2 = new Coordenada(11, 9);
		coordenadasConServicio.add(b2);
		Coordenada b3 = new Coordenada(9, 9);
		coordenadasConServicio.add(b3);
		Coordenada b4 = new Coordenada(8, 10);
		coordenadasConServicio.add(b4);
		Coordenada b5 = new Coordenada(9, 11);
		coordenadasConServicio.add(b5);
		Coordenada b6 = new Coordenada(10, 12);
		coordenadasConServicio.add(b6);
		Coordenada b7 = new Coordenada(11, 11);
		coordenadasConServicio.add(b7);
		Coordenada b8 = new Coordenada(12, 10);
		coordenadasConServicio.add(b8);
		
		// radio = 3
		Coordenada c1 = new Coordenada(10, 7);
		coordenadasConServicio.add(c1);
		Coordenada c2 = new Coordenada(9, 8);
		coordenadasConServicio.add(c2);
		Coordenada c3 = new Coordenada(8, 9);
		coordenadasConServicio.add(c3);
		Coordenada c4 = new Coordenada(7, 10);
		coordenadasConServicio.add(c4);		
		Coordenada c5 = new Coordenada(8, 11);
		coordenadasConServicio.add(c5);
		Coordenada c6 = new Coordenada(9, 12);
		coordenadasConServicio.add(c6);
		Coordenada c7 = new Coordenada(10, 13);
		coordenadasConServicio.add(c7);
		Coordenada c8 = new Coordenada(11, 12);
		coordenadasConServicio.add(c8);
		Coordenada c9 = new Coordenada(12, 11);
		coordenadasConServicio.add(c9);
		Coordenada c10 = new Coordenada(13, 10);
		coordenadasConServicio.add(c10);
		Coordenada c11 = new Coordenada(12, 9);
		coordenadasConServicio.add(c11);
		Coordenada c12 = new Coordenada(11, 8);
		coordenadasConServicio.add(c12);
		
		
		
		// Pruebo que "todo" el MAPA no tiene servicio electrico
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				assertEquals(false, mapa.obtenerHectarea(new Coordenada(i, j))
						.estaActivo(TipoDeServicio.Electrico));
			}
		}

		mapa.propagarServicio(origen);			
		
		
		// El algoritmo tambien activa
		// el servicio en la hectarea origen
		coordenadasConServicio.add(origen);

		// Ahora estas hectareas
		// tienen servicio		
		for (Coordenada c : coordenadasConServicio) {
			assertEquals(
					true,
					mapa.obtenerHectarea(c).estaActivo(
							TipoDeServicio.Electrico));
		}	

		// No se modifica la capacidad de abastecimiento
		// porque las hectareas no tienen construcciones
		assertEquals(400, cm.obtenerCapacidadDeAbastecimiento());

		// Pruebo que el resto del MAPA no tiene servicio electrico
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				Coordenada c = new Coordenada(i, j);

				if (coordenadasConServicio.contains(c))
					continue;

				assertEquals(
						false,
						mapa.obtenerHectarea(c).estaActivo(
								TipoDeServicio.Electrico));
			}
		}
	}

	@Test
	public void propagarServicioDeCentralMineralSoloPorRadioyPorConexion() {
		Mapa mapa = new Mapa(new MapaConPlaya());

		CentralMineral cm = new CentralMineral();

		Coordenada origen = new Coordenada(10, 10);

		mapa.construir(cm, origen);
		
		ArrayList<Coordenada> coordenadasConServicio = new ArrayList<Coordenada>();

		// radio = 1
		Coordenada a1 = new Coordenada(10, 9);
		coordenadasConServicio.add(a1);
		Coordenada a2 = new Coordenada(11, 10);
		coordenadasConServicio.add(a2);
		Coordenada a3 = new Coordenada(10, 11);
		coordenadasConServicio.add(a3);
		Coordenada a4 = new Coordenada(9, 10);
		coordenadasConServicio.add(a4);

		// radio = 2
		Coordenada b1 = new Coordenada(10, 8);
		coordenadasConServicio.add(b1);
		Coordenada b2 = new Coordenada(11, 9);
		coordenadasConServicio.add(b2);
		Coordenada b3 = new Coordenada(9, 9);
		coordenadasConServicio.add(b3);
		Coordenada b4 = new Coordenada(8, 10);
		coordenadasConServicio.add(b4);
		Coordenada b5 = new Coordenada(9, 11);
		coordenadasConServicio.add(b5);
		Coordenada b6 = new Coordenada(10, 12);
		coordenadasConServicio.add(b6);
		Coordenada b7 = new Coordenada(11, 11);
		coordenadasConServicio.add(b7);
		Coordenada b8 = new Coordenada(12, 10);
		coordenadasConServicio.add(b8);
		
		// radio = 3
		Coordenada c1 = new Coordenada(10, 7);
		coordenadasConServicio.add(c1);
		Coordenada c2 = new Coordenada(9, 8);
		coordenadasConServicio.add(c2);
		Coordenada c3 = new Coordenada(8, 9);
		coordenadasConServicio.add(c3);
		Coordenada c4 = new Coordenada(7, 10);
		coordenadasConServicio.add(c4);		
		Coordenada c5 = new Coordenada(8, 11);
		coordenadasConServicio.add(c5);
		Coordenada c6 = new Coordenada(9, 12);
		coordenadasConServicio.add(c6);
		Coordenada c7 = new Coordenada(10, 13);
		coordenadasConServicio.add(c7);
		Coordenada c8 = new Coordenada(11, 12);
		coordenadasConServicio.add(c8);
		Coordenada c9 = new Coordenada(12, 11);
		coordenadasConServicio.add(c9);
		Coordenada c10 = new Coordenada(13, 10);
		coordenadasConServicio.add(c10);
		Coordenada c11 = new Coordenada(12, 9);
		coordenadasConServicio.add(c11);
		Coordenada c12 = new Coordenada(11, 8);
		coordenadasConServicio.add(c12);
		
		// Agrego dos hectareas 
		// con conexion fuera del radio
		// para propagar el servicio
		Coordenada extraArriba = new Coordenada(10, 6);
		mapa.conectar(new LineaDeTension(), extraArriba);		
		coordenadasConServicio.add(extraArriba);
		
		Coordenada extraDerecha = new Coordenada(10, 6);
		mapa.conectar(new LineaDeTension(), extraDerecha);
		coordenadasConServicio.add(extraDerecha);		
		
		// Pruebo que "todo" el MAPA no tiene servicio electrico
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				assertEquals(false, mapa.obtenerHectarea(new Coordenada(i, j))
						.estaActivo(TipoDeServicio.Electrico));
			}
		}

		mapa.propagarServicio(origen);			
		
		
		// El algoritmo tambien activa
		// el servicio en la hectarea origen
		coordenadasConServicio.add(origen);

		// Ahora estas hectareas
		// tienen servicio		
		for (Coordenada c : coordenadasConServicio) {
			assertEquals(
					true,
					mapa.obtenerHectarea(c).estaActivo(
							TipoDeServicio.Electrico));
		}	

		// No se modifica la capacidad de abastecimiento
		// porque las hectareas no tienen construcciones
		assertEquals(400, cm.obtenerCapacidadDeAbastecimiento());

		// Pruebo que el resto del MAPA no tiene servicio electrico
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				Coordenada c = new Coordenada(i, j);

				if (coordenadasConServicio.contains(c))
					continue;

				assertEquals(
						false,
						mapa.obtenerHectarea(c).estaActivo(
								TipoDeServicio.Electrico));
			}
		}
	}
	
	
}
