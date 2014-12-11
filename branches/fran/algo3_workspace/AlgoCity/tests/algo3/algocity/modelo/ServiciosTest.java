package algo3.algocity.modelo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ServiciosTest {
	
	@Test
	public void pruebaDeListaDeServiciosVacia(){
		List<TipoDeServicio> serviciosRequeridos = new ArrayList<TipoDeServicio>();
		List<TipoDeServicio> serviciosDisponibles = new ArrayList<TipoDeServicio>();
		
		assertEquals(true, serviciosDisponibles.containsAll(serviciosRequeridos));
		
		serviciosDisponibles.add(TipoDeServicio.AccesoAlTransito);
		serviciosDisponibles.add(TipoDeServicio.Cloacas);
		
		assertEquals(true, serviciosDisponibles.containsAll(serviciosRequeridos));
		
	}

	@Test
	public void activarAccesoAlTransitoEnTerrenoAgregaElServicioAccesoAlTransito() {
		
		Terreno terreno = new Terreno();		
		assertEquals(false, terreno.tieneConexion(TipoDeServicio.AccesoAlTransito));		
		terreno.activar(TipoDeServicio.AccesoAlTransito);		
		assertEquals(true, terreno.tieneConexion(TipoDeServicio.AccesoAlTransito));
	}
	
	@Test
	public void activarElectricidadEnTerrenoAgregaElServicioElectrico() {
		
		Terreno terreno = new Terreno();		
		assertEquals(false, terreno.tieneConexion(TipoDeServicio.Electrico));		
		terreno.activar(TipoDeServicio.Electrico);		
		assertEquals(true, terreno.tieneConexion(TipoDeServicio.Electrico));

	}
	
	@Test
	public void activarCloacasEnTerrenoAgregaElServicioCloacal() {
		
		Terreno terreno = new Terreno();		
		assertEquals(false, terreno.tieneConexion(TipoDeServicio.Cloacas));		
		terreno.activar(TipoDeServicio.Cloacas);		
		assertEquals(true, terreno.tieneConexion(TipoDeServicio.Cloacas));

	}
	
	@Test
	public void desactivarAccesoAlTransitoEnTerrenoQuitaElServicioAccesoAlTransito() {		
		Terreno terreno = new Terreno();			
		terreno.activar(TipoDeServicio.AccesoAlTransito);		
		assertEquals(true, terreno.tieneConexion(TipoDeServicio.AccesoAlTransito));
		// Activo otro servicio para testear que no lo desactiva
		terreno.activar(TipoDeServicio.Electrico);
		terreno.desactivar(TipoDeServicio.AccesoAlTransito);
		assertEquals(false, terreno.tieneConexion(TipoDeServicio.AccesoAlTransito));
		assertEquals(true, terreno.tieneConexion(TipoDeServicio.Electrico));
	}
	
	@Test
	public void desactivarElectricidadEnTerrenoQuitaElServicioElectrico() {		
		Terreno terreno = new Terreno();			
		terreno.activar(TipoDeServicio.Electrico);		
		assertEquals(true, terreno.tieneConexion(TipoDeServicio.Electrico));
		// Activo otro servicio para testear que no lo desactiva
		terreno.activar(TipoDeServicio.Cloacas);
		terreno.desactivar(TipoDeServicio.Electrico);
		assertEquals(false, terreno.tieneConexion(TipoDeServicio.Electrico));
		assertEquals(true, terreno.tieneConexion(TipoDeServicio.Cloacas));
	}
	
	@Test
	public void desactivarCloacasEnTerrenoQuitaElServicioCloacal() {		
		Terreno terreno = new Terreno();			
		terreno.activar(TipoDeServicio.Cloacas);		
		assertEquals(true, terreno.tieneConexion(TipoDeServicio.Cloacas));
		// Activo otro servicio para testear que no lo desactiva
		terreno.activar(TipoDeServicio.AccesoAlTransito);
		terreno.desactivar(TipoDeServicio.Cloacas);
		assertEquals(false, terreno.tieneConexion(TipoDeServicio.Cloacas));
		assertEquals(true, terreno.tieneConexion(TipoDeServicio.AccesoAlTransito));
	}
	
}
