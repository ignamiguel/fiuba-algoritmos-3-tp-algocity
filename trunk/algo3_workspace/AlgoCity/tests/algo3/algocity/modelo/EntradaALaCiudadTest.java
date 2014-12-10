package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntradaALaCiudadTest {

	@Test
	public void testMapaLlanoTieneConstruidaUnaEntradaALaCiudad(){
		Mapa mapa = new Mapa(new MapaLlano());
		Hectarea hectarea =  mapa.getHectarea(mapa.obtenerEntradaALaCiudad());
		assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Ruta));
	}
	
	@Test
	public void testSeLePuedenConstruirConexionesALaEntradaDeLaCiudad(){
		Mapa mapa = new Mapa(new MapaLlano());
		Hectarea hectarea =  mapa.getHectarea(mapa.obtenerEntradaALaCiudad());
		
		hectarea.conectar(new Tuberia());
		hectarea.conectar(new LineaDeTension());
		
		assertEquals(true, hectarea.tieneConexion(TipoDeConexion.Ruta));
		assertEquals(true, hectarea.tieneConexion(TipoDeConexion.LineaDeTension));
		assertEquals(true, hectarea.tieneConexion(TipoDeConexion.Tuberia));
		
	}
	
	@Test
	public void testNoSeLePuedeConstruirUnaRutaALaEntradaDeLaCiudad(){
		Mapa mapa = new Mapa(new MapaLlano());
		Hectarea hectarea =  mapa.getHectarea(mapa.obtenerEntradaALaCiudad());
		
		assertEquals(false,hectarea.conectar(new Ruta()));
	}
	
	@Test
	public void testNoSeLePuedeConstruirOtraContruccionALaEntradaDeLaCiudad(){
		Mapa mapa = new Mapa(new MapaLlano());
		Hectarea hectarea =  mapa.getHectarea(mapa.obtenerEntradaALaCiudad());
		
		assertEquals(false,hectarea.construir(new Residencia()));
	}

	@Test
	public void testNoSePuedePropagaTransitoALasHectareaVecinasSinRuta(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad();

		mapa.propagarServicio(entrada);
		
		Coordenada vecina = entrada;
		vecina.aumentarX(1);
		assertEquals(false, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
		
		vecina = entrada;
		vecina.disminuirY(1);
		assertEquals(false, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
		
		vecina = entrada;
		vecina.aumentarY(1);
		assertEquals(false, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
	}
	
	@Test
	public void testEntradaAlTransitoPropagaTransitoALaHectareaVecinaDelSurConRuta(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad();
		
		Coordenada vecina = entrada.copiar();
		vecina.aumentarX(1);
		assertEquals(true, mapa.conectar(new Ruta(), vecina));
		
		mapa.propagarServicio(entrada);
		
		assertEquals(true, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
		
	}
	
	@Test
	public void testEntradaAlTransitoPropagaTransitoALaHectareaVecinaDelSurYAlaQueEstaAlSurDeEsaConRuta(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad();
		
		Coordenada vecina = entrada.copiar();
		vecina.aumentarX(1);
		assertEquals(true, mapa.conectar(new Ruta(), vecina));
		assertEquals(true, mapa.getHectarea(vecina).tieneConexion(TipoDeConexion.Ruta));
		vecina.aumentarX(1);
		assertEquals(true, mapa.conectar(new Ruta(), vecina));
		assertEquals(true, mapa.getHectarea(vecina).tieneConexion(TipoDeConexion.Ruta));
		
		mapa.propagarServicio(entrada);
		
		vecina = entrada.copiar();
		vecina.aumentarX(1);
		assertEquals(true, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
		vecina.aumentarX(1);
		assertEquals(true, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
		
	}
	
	@Test
	public void testEntradaAlTransitoPropagaTransitoALaHectareaVecinaDelEsteConRuta(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad();
		
		Coordenada vecina = entrada.copiar();
		vecina.aumentarY(1);
		assertEquals(true, mapa.conectar(new Ruta(), vecina));
		
		mapa.propagarServicio(entrada);
		
		assertEquals(true, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
		
	}
	
	@Test
	public void testEntradaAlTransitoPropagaTransitoALaHectareaVecinaDelEsteYAlaQueEstaAlEsteDeEsaConRuta(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad();
		
		Coordenada vecina = entrada.copiar();
		vecina.aumentarY(1);
		assertEquals(true, mapa.conectar(new Ruta(), vecina));
		assertEquals(true, mapa.getHectarea(vecina).tieneConexion(TipoDeConexion.Ruta));
		vecina.aumentarY(1);
		assertEquals(true, mapa.conectar(new Ruta(), vecina));
		assertEquals(true, mapa.getHectarea(vecina).tieneConexion(TipoDeConexion.Ruta));
		
		mapa.propagarServicio(entrada);
		
		vecina = entrada.copiar();
		vecina.aumentarY(1);
		assertEquals(true, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
		vecina.aumentarY(1);
		assertEquals(true, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
		
	}
	
	@Test
	public void testEntradaAlTransitoPropagaTransitoALaHectareaVecinaDelOesteConRuta(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad();
		
		Coordenada vecina = entrada.copiar();
		vecina.disminuirY(1);
		assertEquals(true, mapa.conectar(new Ruta(), vecina));
		
		mapa.propagarServicio(entrada);
		
		assertEquals(true, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
		
	}
	
	@Test
	public void testEntradaAlTransitoPropagaTransitoALaHectareaVecinaDelOesteYAlaQueEstaAlOesteDeEsaConRuta(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad();
		
		Coordenada vecina = entrada.copiar();
		vecina.disminuirY(1);
		assertEquals(true, mapa.conectar(new Ruta(), vecina));
		assertEquals(true, mapa.getHectarea(vecina).tieneConexion(TipoDeConexion.Ruta));
		vecina.disminuirY(1);
		assertEquals(true, mapa.conectar(new Ruta(), vecina));
		assertEquals(true, mapa.getHectarea(vecina).tieneConexion(TipoDeConexion.Ruta));
		
		mapa.propagarServicio(entrada);
		
		vecina = entrada.copiar();
		vecina.disminuirY(1);
		assertEquals(true, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));
		vecina.disminuirY(1);
		assertEquals(true, mapa.getHectarea(vecina).estaActivo(TipoDeServicio.AccesoAlTransito));	
	}
	
	@Test
	public void testEntradaAlTransitoPropagaTransitoATodasLasHectareasQueEstanAlineadasAlSurConRuta(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad().copiar();
		
		entrada.aumentarX(1);
		
		while(entrada.obtenerX() < mapa.getTamanio()){
			assertEquals(true, mapa.conectar(new Ruta(), entrada));
			assertEquals(true, mapa.getHectarea(entrada).tieneConexion(TipoDeConexion.Ruta));
			entrada.aumentarX(1);
		}
		
		entrada = mapa.obtenerEntradaALaCiudad().copiar();
		mapa.propagarServicio(entrada);
		
		while(entrada.obtenerX() < mapa.getTamanio()){
			assertEquals(true, mapa.getHectarea(entrada).estaActivo(TipoDeServicio.AccesoAlTransito));
			entrada.aumentarX(1);
		}
	}
	
	@Test
	public void testEntradaAlTransitoPropagaTransitoATodasLasHectareasQueEstanAlineadasAlesteConRuta(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad().copiar();
		
		entrada.aumentarY(1);
		
		while(entrada.obtenerY() < mapa.getTamanio()){
			assertEquals(true, mapa.conectar(new Ruta(), entrada));
			assertEquals(true, mapa.getHectarea(entrada).tieneConexion(TipoDeConexion.Ruta));
			entrada.aumentarY(1);
		}
		
		entrada = mapa.obtenerEntradaALaCiudad().copiar();
		mapa.propagarServicio(entrada);
		
		while(entrada.obtenerY() < mapa.getTamanio()){
			assertEquals(true, mapa.getHectarea(entrada).estaActivo(TipoDeServicio.AccesoAlTransito));
			entrada.aumentarY(1);
		}
	}
	
	@Test
	public void testEntradaAlTransitoPropagaTransitoATodasLasHectareasQueEstanAlineadasAlOesteConRuta(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad().copiar();
		
		entrada.disminuirY(1);
		
		while(entrada.obtenerY() >= 0){
			assertEquals(true, mapa.conectar(new Ruta(), entrada));
			assertEquals(true, mapa.getHectarea(entrada).tieneConexion(TipoDeConexion.Ruta));
			entrada.disminuirY(1);
		}
		
		entrada = mapa.obtenerEntradaALaCiudad().copiar();
		mapa.propagarServicio(entrada);
		
		while(entrada.obtenerY() >= 0){
			assertEquals(true, mapa.getHectarea(entrada).estaActivo(TipoDeServicio.AccesoAlTransito));
			entrada.disminuirY(1);
		}
	}
	
	@Test
	public void testEntradaAlaCiudadPropagaTransitoATodoElMapaConectadoConRuta(){
		Mapa mapa = new Mapa( new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad().copiar();
		
		for(int i=0; i < mapa.getTamanio();i++){
			for(int j=0; j< mapa.getTamanio(); j++){
				Coordenada coord = new Coordenada(i,j);
				mapa.conectar(new Ruta(), coord);
				assertEquals(true, mapa.getHectarea(coord).tieneConexion(TipoDeConexion.Ruta));
			}
		}
		
		entrada = mapa.obtenerEntradaALaCiudad().copiar();
		mapa.propagarServicio(entrada);
		
		for(int i=0; i < mapa.getTamanio();i++){
			for(int j=0; j< mapa.getTamanio(); j++){
				Coordenada coord2 = new Coordenada(i,j);
				assertEquals(true, mapa.getHectarea(coord2).estaActivo(TipoDeServicio.AccesoAlTransito));
			}
		}
	}
	
	@Test
	public void testEntradaPropagaTransitoALaRutaConectadaPeroNoPropagaALaRutaQueNoEstaConectada(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad().copiar();
		
		entrada.aumentarX(1);
		
		while(entrada.obtenerX() < mapa.getTamanio()){
			assertEquals(true, mapa.conectar(new Ruta(), entrada));
			assertEquals(true, mapa.getHectarea(entrada).tieneConexion(TipoDeConexion.Ruta));
			entrada.aumentarX(1);
		}
		
		
		for(int i=0; i < mapa.getTamanio();i++){
			Coordenada coord = new Coordenada(i,10);
			assertEquals(true, mapa.conectar(new Ruta(), coord));
			assertEquals(true, mapa.getHectarea(coord).tieneConexion(TipoDeConexion.Ruta));
		}
		
		entrada = mapa.obtenerEntradaALaCiudad().copiar();
		mapa.propagarServicio(entrada);
		
		while(entrada.obtenerX() < mapa.getTamanio()){
			assertEquals(true, mapa.getHectarea(entrada).estaActivo(TipoDeServicio.AccesoAlTransito));
			entrada.aumentarX(1);
		}
		
		for(int i=0; i < mapa.getTamanio();i++){
			Coordenada coord = new Coordenada(i,10);
			assertEquals(false, mapa.getHectarea(coord).estaActivo(TipoDeServicio.AccesoAlTransito));
		}
		
	}
	
	@Test
	public void testEntradaPropagaTransitoALaRutaConectadaPeroYPropagaALaRutaEnOtraColumnaUnidaPorUnRutaEnElMedio(){
		Mapa mapa = new Mapa(new MapaLlano());
		Coordenada entrada = mapa.obtenerEntradaALaCiudad().copiar();
		
		entrada.aumentarX(1);
		
		while(entrada.obtenerX() < mapa.getTamanio()){
			assertEquals(true, mapa.conectar(new Ruta(), entrada));
			assertEquals(true, mapa.getHectarea(entrada).tieneConexion(TipoDeConexion.Ruta));
			entrada.aumentarX(1);
		}
		
		
		for(int i=0; i < mapa.getTamanio();i++){
			Coordenada coord = new Coordenada(i,10);
			assertEquals(true, mapa.conectar(new Ruta(), coord));
			assertEquals(true, mapa.getHectarea(coord).tieneConexion(TipoDeConexion.Ruta));
		}
		
		mapa.conectar(new Ruta(), new Coordenada(19,11));
		
		entrada = mapa.obtenerEntradaALaCiudad().copiar();
		mapa.propagarServicio(entrada);
		
		while(entrada.obtenerX() < mapa.getTamanio()){
			assertEquals(true, mapa.getHectarea(entrada).estaActivo(TipoDeServicio.AccesoAlTransito));
			entrada.aumentarX(1);
		}
		
		for(int i=0; i < mapa.getTamanio();i++){
			Coordenada coord = new Coordenada(i,10);
			assertEquals(true, mapa.getHectarea(coord).estaActivo(TipoDeServicio.AccesoAlTransito));
		}
		
	}
}

