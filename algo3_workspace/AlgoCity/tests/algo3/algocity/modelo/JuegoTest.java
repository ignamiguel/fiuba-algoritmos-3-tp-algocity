package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuegoTest {

	@Test
	public void crearUnJuego() {
		Juego juego = new Juego();

		assertNotNull("Instancia de un juego", juego);
	}

	@Test
	public void crearUnJuegoConMapaPlayaParaVerTerreno(){
		Juego juego = new Juego();
		
		String resultado = juego.verMapa(new Coordenada(0,0));		
		
		assertEquals("Terreno", resultado);
	}
	
	@Test
	public void crearUnJuegoConMapaPlayaParaVerAgua(){
		Juego juego = new Juego();
		
		String resultado = juego.verMapa(new Coordenada(0,20));		
		
		assertEquals("Agua", resultado);
	}
	
	@Test
	public void insertarUnaResidenciaEnJuego(){
		Juego juego = new Juego();
		
		Residencia casa = new Residencia();
		
		boolean resultado = juego.insertar(casa, new Coordenada(0, 0));
		
		assertEquals(true, resultado);
		
	}
	
	@Test
	public void insertarUnaCentralEolicaEnJuego(){
		Juego juego = new Juego();
		
		CentralEolica central = new CentralEolica();
		
		boolean resultado = juego.insertar(central, new Coordenada(0, 0));
		
		assertEquals(true, resultado);
		
	}

	@Test
	public void insertarUnPozoDeAguaEnJuego(){
		Juego juego = new Juego();
		
		PozoDeAgua pda = new PozoDeAgua();
		
		boolean resultado = juego.insertar(pda, new Coordenada(0, 20));
		
		assertEquals(true, resultado);
		
	}

	@Test
	public void insertarUnaEstacionDeBomberosEnJuego(){
		Juego juego = new Juego();
		
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		boolean resultado = juego.insertar(edb, new Coordenada(0, 0));
		
		assertEquals(true, resultado);
	}
	
	@Test
	public void crearUnJuegoConValoresIniciales(){
		Juego juego = new Juego();
		
		int dinero = juego.verDinero();
		
		assertEquals(100000, dinero);
		
	}

	@Test
	public void insertarUnaResidenciaEnJuegoCuesta5(){
		Juego juego = new Juego();
		
		Residencia casa = new Residencia();
		
		juego.insertar(casa, new Coordenada(0, 0));
		
		int dinero = juego.verDinero();
		
		assertEquals(99995, dinero);		
		
	}
	
	@Test
	public void insertarUnComercioEnJuegoCuesta5(){
		Juego juego = new Juego();
		
		Comercio comercio = new Comercio();
		
		juego.insertar(comercio, new Coordenada(0, 0));
		
		int dinero = juego.verDinero();
		
		assertEquals(99995, dinero);		
		
	}
	
	@Test
	public void insertarUnaIndustriaEnJuegoCuesta10(){
		Juego juego = new Juego();
		
		Industria industria = new Industria();
		
		juego.insertar(industria, new Coordenada(0, 0));
		
		int dinero = juego.verDinero();
		
		assertEquals(99990, dinero);		
		
	}
	
	@Test
	public void insertarUnaCentralEolicaEnJuegoCuesta1000(){
		Juego juego = new Juego();
		
		CentralEolica ce = new CentralEolica();
		
		juego.insertar(ce, new Coordenada(0, 0));
		
		int dinero = juego.verDinero();
		
		assertEquals(99000, dinero);		
		
	}
	
	@Test
	public void insertarUnaCentralMineralEnJuegoCuesta3000(){
		Juego juego = new Juego();
		
		CentralMineral cm = new CentralMineral();
		
		juego.insertar(cm, new Coordenada(0, 0));
		
		int dinero = juego.verDinero();
		
		assertEquals(97000, dinero);		
		
	}
	
	@Test
	public void insertarUnaCentralNuclearEnJuegoCuesta10000(){
		Juego juego = new Juego();
		
		CentralNuclear cn = new CentralNuclear();
		
		juego.insertar(cn, new Coordenada(0, 0));
		
		int dinero = juego.verDinero();
		
		assertEquals(90000, dinero);		
		
	}
	
	@Test
	public void insertarUnaEstacionDeBomberosEnJuegoCuesta1500(){
		Juego juego = new Juego();
		
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		juego.insertar(edb, new Coordenada(0, 0));
		
		int dinero = juego.verDinero();
		
		assertEquals(98500, dinero);
	}

}
