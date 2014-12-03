package algo3.algocity.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ServiciosTest {

	@Test
	public void activarAccesoAlTransitoEnTerrenoAgregaElServicioAccesoAlTransito() {
		
		Terreno terreno = new Terreno();		
		assertEquals(false, terreno.estaActivo(TipoDeServicio.AccesoAlTransito));		
		terreno.activar(TipoDeServicio.AccesoAlTransito);		
		assertEquals(true, terreno.estaActivo(TipoDeServicio.AccesoAlTransito));
	}
	
	@Test
	public void activarElectricidadEnTerrenoAgregaElServicioElectrico() {
		
		Terreno terreno = new Terreno();		
		assertEquals(false, terreno.estaActivo(TipoDeServicio.Electrico));		
		terreno.activar(TipoDeServicio.Electrico);		
		assertEquals(true, terreno.estaActivo(TipoDeServicio.Electrico));

	}
	
	@Test
	public void activarCloacasEnTerrenoAgregaElServicioCloacal() {
		
		Terreno terreno = new Terreno();		
		assertEquals(false, terreno.estaActivo(TipoDeServicio.Cloacas));		
		terreno.activar(TipoDeServicio.Cloacas);		
		assertEquals(true, terreno.estaActivo(TipoDeServicio.Cloacas));

	}
	
	@Test
	public void desactivarAccesoAlTransitoEnTerrenoQuitaElServicioAccesoAlTransito() {		
		Terreno terreno = new Terreno();			
		terreno.activar(TipoDeServicio.AccesoAlTransito);		
		assertEquals(true, terreno.estaActivo(TipoDeServicio.AccesoAlTransito));
		// Activo otro servicio para testear que no lo desactiva
		terreno.activar(TipoDeServicio.Electrico);
		terreno.desactivar(TipoDeServicio.AccesoAlTransito);
		assertEquals(false, terreno.estaActivo(TipoDeServicio.AccesoAlTransito));
		assertEquals(true, terreno.estaActivo(TipoDeServicio.Electrico));
	}
	
	@Test
	public void desactivarElectricidadEnTerrenoQuitaElServicioElectrico() {		
		Terreno terreno = new Terreno();			
		terreno.activar(TipoDeServicio.Electrico);		
		assertEquals(true, terreno.estaActivo(TipoDeServicio.Electrico));
		// Activo otro servicio para testear que no lo desactiva
		terreno.activar(TipoDeServicio.Cloacas);
		terreno.desactivar(TipoDeServicio.Electrico);
		assertEquals(false, terreno.estaActivo(TipoDeServicio.Electrico));
		assertEquals(true, terreno.estaActivo(TipoDeServicio.Cloacas));
	}
	
	@Test
	public void desactivarCloacasEnTerrenoQuitaElServicioCloacal() {		
		Terreno terreno = new Terreno();			
		terreno.activar(TipoDeServicio.Cloacas);		
		assertEquals(true, terreno.estaActivo(TipoDeServicio.Cloacas));
		// Activo otro servicio para testear que no lo desactiva
		terreno.activar(TipoDeServicio.AccesoAlTransito);
		terreno.desactivar(TipoDeServicio.Cloacas);
		assertEquals(false, terreno.estaActivo(TipoDeServicio.Cloacas));
		assertEquals(true, terreno.estaActivo(TipoDeServicio.AccesoAlTransito));
	}
	
}
