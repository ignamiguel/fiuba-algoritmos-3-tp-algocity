package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegracionTest {

	@Test
	public void testUnaCiudadSinConstruccionesNoVariaLosHabitantesPasandoTurno(){
		Juego juego = new Juego();
		assertEquals(0,juego.getCiudadanos());
		
		juego.turnoAvanzar();
		juego.turnoAvanzar();
		juego.turnoAvanzar();
		
		assertEquals(0,juego.getCiudadanos());
	}
	
	@Test
	public void testUnaCiudadSinIndustriasNoVarianLosHabitantesPasandoTurno(){
		Juego juego = new Juego();
		
		Residencia residencia = new Residencia();
		assertEquals(true,juego.insertar(residencia, new Coordenada(0,0)));
		
		assertEquals(0,juego.getCiudadanos());
		
		juego.turnoAvanzar();
		
		assertEquals(0,juego.getCiudadanos());
	}
	
	@Test
	public void testInicioUnJuegoInsertoPozoDeAguaYTuberiasHorizontalAlMapaPasaElTurnoYTienenAguaLasHectareas(){
		Juego juego = new Juego();
		PozoDeAgua pozo = new PozoDeAgua();
		Coordenada c = new Coordenada(5,24);
		
		juego.insertar(pozo, c);
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			Coordenada coordenada = new Coordenada(5,i);
			Hectarea hectarea = juego.getMapa().obtenerHectarea(coordenada);
			assertEquals(true,juego.insertar(new Tuberia(), coordenada));
			assertEquals(false,hectarea.estaActivo(TipoDeServicio.Cloacas));
		}
		
		juego.turnoAvanzar();
		
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			Coordenada coordenada = new Coordenada(5,i);
			Hectarea hectarea = juego.getMapa().obtenerHectarea(coordenada);
			assertEquals(true,hectarea.estaActivo(TipoDeServicio.Cloacas));
		}	
	}
	
	@Test
	public void testInicioUnJuegoPropagoLosTresServiciosALaTotalidadDelMapaEnLaMedidaQueSePuedeCrearLaconexion(){
		Juego juego = new Juego();
		PozoDeAgua pozo = new PozoDeAgua();
		
		Coordenada c = new Coordenada(5,24);
		CentralNuclear central = new CentralNuclear();
		
		juego.insertar(pozo, c);
		
		c = new Coordenada(10,10);
		
		juego.insertar(central, c);
		
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			for(int j=0; j < (juego.getMapa()).getTamanio();j++){
				Coordenada coordenada = new Coordenada(i,j);
				juego.insertar(new Tuberia(), coordenada);
				juego.insertar(new Ruta(), coordenada);
				juego.insertar(new LineaDeTension(), coordenada);
			}
		}
		
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			for(int j=0; j < 20;j++){
				Coordenada coordenada = new Coordenada(i,j);
				Hectarea hectarea = juego.getMapa().obtenerHectarea(coordenada);
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.LineaDeTension));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Tuberia));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Ruta));
				
				assertEquals(false,hectarea.estaActivo(TipoDeServicio.Electrico));
				assertEquals(false,hectarea.estaActivo(TipoDeServicio.Cloacas));
				assertEquals(false,hectarea.estaActivo(TipoDeServicio.AccesoAlTransito));
			}
		}
		
		juego.turnoAvanzar();
		
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			for(int j=0; j < 20;j++){
				Coordenada coordenada = new Coordenada(i,j);
				Hectarea hectarea = juego.getMapa().obtenerHectarea(coordenada);
				
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.LineaDeTension));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Tuberia));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Ruta));
				
				assertEquals(true,hectarea.estaActivo(TipoDeServicio.Electrico));
				assertEquals(true,hectarea.estaActivo(TipoDeServicio.Cloacas));
				assertEquals(true,hectarea.estaActivo(TipoDeServicio.AccesoAlTransito));
			}
		}
	}
	
	@Test
	public void testMapaConTodosLosServiciosAumentanLosHabitantesConIndustriasYResidencias(){
		Juego juego = new Juego();
		PozoDeAgua pozo = new PozoDeAgua();
		
		Coordenada c = new Coordenada(5,24);
		CentralNuclear central = new CentralNuclear();
		
		juego.insertar(pozo, c);
		
		c = new Coordenada(10,10);
		
		juego.insertar(central, c);
		
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			for(int j=0; j < (juego.getMapa()).getTamanio();j++){
				Coordenada coordenada = new Coordenada(i,j);
				juego.insertar(new Tuberia(), coordenada);
				juego.insertar(new Ruta(), coordenada);
				juego.insertar(new LineaDeTension(), coordenada);
			}
		}
		
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			for(int j=0; j < 20;j++){
				Coordenada coordenada = new Coordenada(i,j);
				Hectarea hectarea = juego.getMapa().obtenerHectarea(coordenada);
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.LineaDeTension));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Tuberia));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Ruta));
				
				assertEquals(false,hectarea.estaActivo(TipoDeServicio.Electrico));
				assertEquals(false,hectarea.estaActivo(TipoDeServicio.Cloacas));
				assertEquals(false,hectarea.estaActivo(TipoDeServicio.AccesoAlTransito));
			}
		}
		
		juego.turnoAvanzar();
		
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			for(int j=0; j < 20;j++){
				Coordenada coordenada = new Coordenada(i,j);
				Hectarea hectarea = juego.getMapa().obtenerHectarea(coordenada);
				
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.LineaDeTension));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Tuberia));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Ruta));
				
				assertEquals(true,hectarea.estaActivo(TipoDeServicio.Electrico));
				assertEquals(true,hectarea.estaActivo(TipoDeServicio.Cloacas));
				assertEquals(true,hectarea.estaActivo(TipoDeServicio.AccesoAlTransito));
			}
		}
		
		juego.insertar(new Residencia(),new Coordenada(5,5));
		juego.insertar(new Industria(),new Coordenada(5,19));
		
		assertEquals(0,juego.getCiudadanos());
		
		juego.turnoAvanzar();
		
		assertEquals(100,juego.getCiudadanos());
	}
	
	@Test
	public void testMapaConTodosLosServiciosYUnaIndustriaYUnaResidenciaAumentanLosHabitantesHasta25(){
		Juego juego = new Juego();
		PozoDeAgua pozo = new PozoDeAgua();
		
		Coordenada c = new Coordenada(5,24);
		CentralNuclear central = new CentralNuclear();
		
		juego.insertar(pozo, c);
		
		c = new Coordenada(10,10);
		
		juego.insertar(central, c);
		
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			for(int j=0; j < (juego.getMapa()).getTamanio();j++){
				Coordenada coordenada = new Coordenada(i,j);
				juego.insertar(new Tuberia(), coordenada);
				juego.insertar(new Ruta(), coordenada);
				juego.insertar(new LineaDeTension(), coordenada);
			}
		}
		
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			for(int j=0; j < 20;j++){
				Coordenada coordenada = new Coordenada(i,j);
				Hectarea hectarea = juego.getMapa().obtenerHectarea(coordenada);
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.LineaDeTension));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Tuberia));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Ruta));
				
				assertEquals(false,hectarea.estaActivo(TipoDeServicio.Electrico));
				assertEquals(false,hectarea.estaActivo(TipoDeServicio.Cloacas));
				assertEquals(false,hectarea.estaActivo(TipoDeServicio.AccesoAlTransito));
			}
		}
		
		juego.turnoAvanzar();
		
		for(int i=0; i < (juego.getMapa()).getTamanio(); i++){
			for(int j=0; j < 20;j++){
				Coordenada coordenada = new Coordenada(i,j);
				Hectarea hectarea = juego.getMapa().obtenerHectarea(coordenada);
				
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.LineaDeTension));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Tuberia));
				assertEquals(true,hectarea.tieneConexion(TipoDeConexion.Ruta));
				
				assertEquals(true,hectarea.estaActivo(TipoDeServicio.Electrico));
				assertEquals(true,hectarea.estaActivo(TipoDeServicio.Cloacas));
				assertEquals(true,hectarea.estaActivo(TipoDeServicio.AccesoAlTransito));
			}
		}
		
		juego.insertar(new Residencia(),new Coordenada(5,5));
		juego.insertar(new Industria(),new Coordenada(5,19));
		
		assertEquals(0,juego.getCiudadanos());
		
		juego.turnoAvanzar();
		
		assertEquals(100,juego.getCiudadanos());
		
		juego.turnoAvanzar();
		
		assertEquals(25,juego.getCiudadanos());
		
		juego.turnoAvanzar();
		
		assertEquals(25,juego.getCiudadanos());
		
		juego.turnoAvanzar();
		
		assertEquals(25,juego.getCiudadanos());
		
	}
}
