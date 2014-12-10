package algo3.algocity.modelo;

public enum TipoDeServicio {
	
	AccesoAlTransito,
	Electrico,
	Cloacas,;

	public static String getEtiqueta(TipoDeServicio servicio) {
		switch (servicio) {
		case AccesoAlTransito:
			return Configuracion.ETIQUETA_ACCESO_AL_TRANSITO;
			
		case Electrico:
			return Configuracion.ETIQUETA_ELECTRICO;
			
		case Cloacas:
			return Configuracion.ETIQUETA_CLOACAS;
			
		default:
			return "";			
		}
		
	}

}
