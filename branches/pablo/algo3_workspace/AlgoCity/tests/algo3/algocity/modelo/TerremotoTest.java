package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TerremotoTest {
	
	@Test
	public void testTerremotoCreadoConExito(){
		Terremoto terremoto = new Terremoto();
		assertNotNull(terremoto);
	}
	
	@Test
	public void testTerremotoCreadoTieneDanio100(){
		Terremoto terremoto = new Terremoto();
		assertEquals(terremoto.obtenerDanio(),100);
	}
	
	@Test
	public void testTerremotoCargadoCon10DeDanio(){
		Terremoto terremoto = new Terremoto();
		terremoto.cargarDanio(10);
		assertEquals(terremoto.obtenerDanio(),10);
	}
	@Test
	public void testTerremotoGeneraDanioPorArea(){
		
		Residencia residencia = new Residencia ();
		CentralEolica unaCentral = new CentralEolica();
		Residencia residencia3 = new Residencia();
		Residencia residencia2 = new Residencia ();
		Residencia residencia4 = new Residencia();

		
		
		
		Mapa mapa = new Mapa(new MapaLlano());
		mapa.construir(unaCentral, new Coordenada(3,5));
		mapa.construir(residencia, new Coordenada(5,5));
		mapa.construir(residencia3, new Coordenada(5,3));
		mapa.construir(residencia2, new Coordenada(5,2));
		mapa.construir(residencia4, new Coordenada(7,4));
		
		
		Terremoto terremoto = new Terremoto();
		terremoto.atacarConRandom(mapa);
		
		
		assertEquals(residencia.obtenerSalud(),0);
		assertEquals(residencia2.obtenerSalud(),100);// se salva, fuera de rango 
		assertEquals(residencia3.obtenerSalud(),3);
		assertEquals(unaCentral.obtenerSalud(),3);
		assertEquals(residencia4.obtenerSalud(),4);
		
	}
}
