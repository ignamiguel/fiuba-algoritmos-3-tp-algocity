package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PozoDeAguaTest {

	@Test
	public void testPuedoConstruirUnPozoDeAguaEnUnMapa(){
		Mapa mapa = new Mapa( new MapaConPlaya() );
		PozoDeAgua pozo = new PozoDeAgua();
		assertEquals(true,mapa.construir(pozo, new Coordenada(22,22)));
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaDeArribaConUnaTuberia(){
		Mapa mapa = new Mapa( new MapaConPlaya() );
		PozoDeAgua pozo = new PozoDeAgua();
		
		assertEquals(true,mapa.construir(pozo, new Coordenada(22,22)));
		
		Tuberia tuberia = new Tuberia();
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(21,22)));
		
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(22,22));
		
		hectarea.propagar(pozo, mapa);
		
		assertEquals(true,(mapa.obtenerHectarea(new Coordenada(21,22))).estaActivo(pozo.obtenerServicio()));
		
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaDeArribaYALaQueEStaArribaDeEsaConUnaTuberia(){
		Mapa mapa = new Mapa( new MapaConPlaya() );
		PozoDeAgua pozo = new PozoDeAgua();
		
		assertEquals(true,mapa.construir(pozo, new Coordenada(22,22)));
		
		Tuberia tuberia = new Tuberia();
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(21,22)));
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(20,22)));
		
		Hectarea hectareaConPozo = mapa.obtenerHectarea(new Coordenada(22,22));
		
		hectareaConPozo.propagar(pozo, mapa);
		

		assertEquals(true,(mapa.obtenerHectarea(new Coordenada(21,22))).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,(mapa.obtenerHectarea(new Coordenada(20,22))).estaActivo(pozo.obtenerServicio()));
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaDeLaDerechaConUnaTuberia(){
		Mapa mapa = new Mapa( new MapaConPlaya() );
		PozoDeAgua pozo = new PozoDeAgua();
		
		assertEquals(true,mapa.construir(pozo, new Coordenada(22,22)));
		
		Tuberia tuberia = new Tuberia();
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(22,23)));
		
		Hectarea hectareaConPozo = mapa.obtenerHectarea(new Coordenada(22,22));
		
		hectareaConPozo.propagar(pozo, mapa);
		
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(22,23));
		
		assertEquals(true,hectarea.estaActivo(pozo.obtenerServicio()));
		
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaDeLaDerechaYALaQueEstaAlaDerechaDeEsaConUnaTuberia(){
		Mapa mapa = new Mapa( new MapaConPlaya() );
		PozoDeAgua pozo = new PozoDeAgua();
		
		assertEquals(true,mapa.construir(pozo, new Coordenada(21,21)));
		
		Tuberia tuberia = new Tuberia();
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(21,22)));
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(21,23)));
		
		Hectarea hectareaConPozo = mapa.obtenerHectarea(new Coordenada(21,21));
		
		hectareaConPozo.propagar(pozo, mapa);
		

		assertEquals(true,(mapa.obtenerHectarea(new Coordenada(21,22))).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,(mapa.obtenerHectarea(new Coordenada(21,23))).estaActivo(pozo.obtenerServicio()));
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaQueEstaAbajoConUnaTuberia(){
		Mapa mapa = new Mapa( new MapaConPlaya() );
		PozoDeAgua pozo = new PozoDeAgua();
		
		assertEquals(true,mapa.construir(pozo, new Coordenada(22,22)));
		
		Tuberia tuberia = new Tuberia();
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(23,22)));
		
		Hectarea hectareaConPozo = mapa.obtenerHectarea(new Coordenada(22,22));
		
		hectareaConPozo.propagar(pozo, mapa);
		
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(23,22));
		
		assertEquals(true,hectarea.estaActivo(pozo.obtenerServicio()));
		
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaQueEstaAbajoYLaQueEstaAbajoDeEsaConUnaTuberia(){
		Mapa mapa = new Mapa( new MapaConPlaya() );
		PozoDeAgua pozo = new PozoDeAgua();
		
		assertEquals(true,mapa.construir(pozo, new Coordenada(21,21)));
		
		Tuberia tuberia = new Tuberia();
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(22,21)));
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(23,21)));
		
		Hectarea hectareaConPozo = mapa.obtenerHectarea(new Coordenada(21,21));
		
		hectareaConPozo.propagar(pozo, mapa);
		

		assertEquals(true,(mapa.obtenerHectarea(new Coordenada(22,21))).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,(mapa.obtenerHectarea(new Coordenada(23,21))).estaActivo(pozo.obtenerServicio()));
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaQueEstaALaIzquierdaConUnaTuberia(){
		Mapa mapa = new Mapa( new MapaConPlaya() );
		PozoDeAgua pozo = new PozoDeAgua();
		
		assertEquals(true,mapa.construir(pozo, new Coordenada(22,22)));
		
		Tuberia tuberia = new Tuberia();
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(22,21)));
		
		Hectarea hectareaConPozo = mapa.obtenerHectarea(new Coordenada(22,22));
		
		hectareaConPozo.propagar(pozo, mapa);
		
		Hectarea hectarea = mapa.obtenerHectarea(new Coordenada(22,21));
		
		assertEquals(true,hectarea.estaActivo(pozo.obtenerServicio()));
		
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaALaHectareaQueEstaALaIzquierdaYLaQueEstaAlaIzquierdaDeEsaConUnaTuberia(){
		Mapa mapa = new Mapa( new MapaConPlaya() );
		PozoDeAgua pozo = new PozoDeAgua();
		
		assertEquals(true,mapa.construir(pozo, new Coordenada(21,21)));
		
		Tuberia tuberia = new Tuberia();
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(21,20)));
		
		assertEquals(true,mapa.conectar(tuberia, new Coordenada(21,19)));
		
		Hectarea hectareaConPozo = mapa.obtenerHectarea(new Coordenada(21,21));
		
		hectareaConPozo.propagar(pozo, mapa);

		assertEquals(true,(mapa.obtenerHectarea(new Coordenada(21,20))).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,(mapa.obtenerHectarea(new Coordenada(21,19))).estaActivo(pozo.obtenerServicio()));
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaATodasLasHectareasQueLaRodeanConTuberias(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Tuberia tuberia = new Tuberia();
		
		Coordenada norte = new Coordenada (20,21);
		Coordenada este = new Coordenada (21,22);
		Coordenada sur = new Coordenada (22,22);
		Coordenada oeste = new Coordenada (21,20);
		
		assertEquals(true,mapa.construir(pozo, new Coordenada(21,21)));
		
		Hectarea hectareaConPozo = mapa.obtenerHectarea(new Coordenada(21,21));
		
		assertEquals(true,mapa.conectar(tuberia, norte));
		assertEquals(true,mapa.conectar(tuberia, este));
		assertEquals(true,mapa.conectar(tuberia, sur));
		assertEquals(true,mapa.conectar(tuberia, oeste));
		
		hectareaConPozo.propagar(pozo, mapa);
		
		assertEquals(true,mapa.obtenerHectarea(norte).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,mapa.obtenerHectarea(este).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,mapa.obtenerHectarea(sur).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,mapa.obtenerHectarea(oeste).estaActivo(pozo.obtenerServicio()));
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaATodasLasHectareasQueLaRodeanYLasQueEstanEnLasEsquinasConTuberias(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		Tuberia tuberia = new Tuberia();
		
		Coordenada norte = new Coordenada (20,21);
		Coordenada este = new Coordenada (21,22);
		Coordenada sur = new Coordenada (22,21);
		Coordenada oeste = new Coordenada (21,20);
		
		Coordenada esquina1 = new Coordenada (20,20);
		Coordenada esquina2 = new Coordenada (20,22);
		Coordenada esquina3 = new Coordenada (22,20);
		Coordenada esquina4 = new Coordenada (22,22);
		
		assertEquals(true,mapa.construir(pozo, new Coordenada(21,21)));
		
		Hectarea hectareaConPozo = mapa.obtenerHectarea(new Coordenada(21,21));
		
		assertEquals(true,mapa.conectar(tuberia, norte));
		assertEquals(true,mapa.conectar(tuberia, este));
		assertEquals(true,mapa.conectar(tuberia, sur));
		assertEquals(true,mapa.conectar(tuberia, oeste));
		
		assertEquals(true,mapa.conectar(tuberia, esquina1));
		assertEquals(true,mapa.conectar(tuberia, esquina2));
		assertEquals(true,mapa.conectar(tuberia, esquina3));
		assertEquals(true,mapa.conectar(tuberia, esquina4));
		
		hectareaConPozo.propagar(pozo, mapa);
		
		assertEquals(true,mapa.obtenerHectarea(norte).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,mapa.obtenerHectarea(este).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,mapa.obtenerHectarea(sur).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,mapa.obtenerHectarea(oeste).estaActivo(pozo.obtenerServicio()));
		
		assertEquals(true,mapa.obtenerHectarea(esquina1).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,mapa.obtenerHectarea(esquina2).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,mapa.obtenerHectarea(esquina3).estaActivo(pozo.obtenerServicio()));
		assertEquals(true,mapa.obtenerHectarea(esquina4).estaActivo(pozo.obtenerServicio()));
	}
	
	@Test
	public void testPozoDeAguaPropagaAguaDesdeCoordenada5_23hasta5_0(){
		Mapa mapa = new Mapa(new MapaConPlaya());
		PozoDeAgua pozo = new PozoDeAgua();
		
		for(int i=0; i<24;i++){
			Tuberia tuberia = new Tuberia();
			assertEquals(true,mapa.conectar(tuberia, new Coordenada(5,i)));
		}
		
		mapa.construir(pozo,new Coordenada(5,23));
		Hectarea hectareaConPozo = mapa.obtenerHectarea(new Coordenada(5,23));
		
		hectareaConPozo.propagar(pozo, mapa);
		
		for(int i=0; i<23;i++){
			assertEquals(true,(mapa.obtenerHectarea(new Coordenada(5,i))).tieneConexion(pozo.obtenerConexion()));
			assertEquals(true,(mapa.obtenerHectarea(new Coordenada(5,i))).estaActivo(pozo.obtenerServicio()));
		}
	}
}