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
/*	@Test//se probo con nucleo en (5,5) y radio 4
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
		
	}*/
	/*
	@Test//se probo con nucleo en (0,0) y radio 4
	public void testTerremotoConNucleoEnVerticeDelMapa(){ 
	
		Residencia residencia = new Residencia ();
		CentralEolica unaCentral = new CentralEolica();
		Residencia residencia3 = new Residencia();
		Residencia residencia2 = new Residencia ();
		Residencia residencia4 = new Residencia();
																		
		Mapa mapa = new Mapa(new MapaLlano());
		mapa.construir(unaCentral, new Coordenada(0,0));
		mapa.construir(residencia, new Coordenada(0,1));
		mapa.construir(residencia3, new Coordenada(1,0));
		mapa.construir(residencia2, new Coordenada(1,1));
		mapa.construir(residencia4, new Coordenada(0,2));

		Terremoto terremoto = new Terremoto();
		terremoto.atacarConRandom(mapa);
		
		assertEquals(residencia.obtenerSalud(),2);
		assertEquals(residencia2.obtenerSalud(),3);
		assertEquals(residencia3.obtenerSalud(),2);
		assertEquals(unaCentral.obtenerSalud(),0);
		assertEquals(residencia4.obtenerSalud(),3);
	}*/
	@Test//se probo con nucleo en (10,10) y radio 8
	public void testTerremotoConRadio_8_YEnElCentroDelMapa(){
		
		Residencia residencia = new Residencia ();
		CentralEolica unaCentral = new CentralEolica();
		Residencia residencia3 = new Residencia();
		Residencia residencia2 = new Residencia ();
		Residencia residencia4 = new Residencia();
																		
		Mapa mapa = new Mapa(new MapaLlano());
		mapa.construir(unaCentral, new Coordenada(6,10));
		mapa.construir(residencia, new Coordenada(10,6));
		mapa.construir(residencia3, new Coordenada(8,8));
		mapa.construir(residencia2, new Coordenada(14,11));
		mapa.construir(residencia4, new Coordenada(9,7));

		Terremoto terremoto = new Terremoto();
		terremoto.atacarConRandom(mapa);
		
		assertEquals(residencia.obtenerSalud(),6);
		assertEquals(residencia2.obtenerSalud(),7);
		assertEquals(residencia3.obtenerSalud(),5);
		assertEquals(unaCentral.obtenerSalud(),6);
		assertEquals(residencia4.obtenerSalud(),5);
	}
	
}
