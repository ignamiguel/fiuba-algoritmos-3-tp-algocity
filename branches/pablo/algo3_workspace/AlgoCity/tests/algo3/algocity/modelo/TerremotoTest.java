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
		Comercio comercio = new Comercio();

		
		
		
		Mapa mapa = new Mapa(new MapaLlano());
		mapa.construir(unaCentral, new Coordenada(2,5));
		mapa.construir(residencia, new Coordenada(5,5));
		mapa.construir(comercio, new Coordenada(5,3));
		
		
		Terremoto terremoto = new Terremoto();
		terremoto.atacarConRandom(mapa);
		
		
		assertEquals(residencia.obtenerSalud(),0);
		assertEquals(comercio.obtenerSalud(),0);//deberia ser 3
		assertEquals(unaCentral.obtenerSalud(),5);
		//System.out.println(terremoto.obtenerDanio());
	}
}
