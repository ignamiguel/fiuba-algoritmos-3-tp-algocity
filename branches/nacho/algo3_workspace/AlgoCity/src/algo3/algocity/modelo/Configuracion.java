package algo3.algocity.modelo;

public class Configuracion {
	
	// General
	static final int DINERO_INICIAL = 100000;
	static final int SALUD_INICIAL = 100;
	static final int TURNO_INICIAL = 1;
	static final int CIUDADANOS_INICIALES = 0;
	static final String JUGADOR_DEFAULT = "JugadorDefault";
	
	static final int TURNO_RECAUDADOR = 5;
	static final int VISITANTES_POR_TURNO = 100;
	static final int IMPUESTOS_POR_CIUDADANO = 10;
	
	static final int PROBABILIDAD_DE_CATASTROFE = 20;
	
	// Costos de construccion
	static final int COSTO_RESIDENCIA = 5;
	static final int COSTO_COMERCIO = 5;
	static final int COSTO_INDUSTRIA = 10;
	static final int COSTO_CENTRAL_EOLICA = 1000;
	static final int COSTO_CENTRAl_MINERAL = 3000;
	static final int COSTO_CENTRAl_NUCLEAR = 10000;
	static final int COSTO_POZO_DE_AGUA = 250;
	static final int COSTO_ESTACION_DE_BOMBEROS = 1500;
	static final int COSTO_RUTA = 10;
	static final int COSTO_LINEA_DE_TENSION = 5;
	static final int COSTO_TUBERIA = 5;
	
	// Consumos electricos
	static final int CONSUMO_ELECTRICO_RESIDENCIA = 1;
	static final int CONSUMO_ELECTRICO_COMERCIO = 2;
	static final int CONSUMO_ELECTRICO_INDUSTRIA = 5;
	static final int CONSUMO_ELECTRICO_CENTRAL_ELECTRICA = 0;
	static final int CONSUMO_ELECTRICO_POZO = 0;
	
	// Capacidad de abastecimiento
	static final int CAPACIDAD_ABAS_CENTRAL_EOLICA = 100;
	static final int CAPACIDAD_ABAS_CENTRAL_MINERAL = 400;
	static final int CAPACIDAD_ABAS_CENTRAL_NUCLEAR = 1000;
	
	// Radios de covertura sin conexion
	static final int RADIO_COVERT_CENTRAL_EOLICA = 1;
	static final int RADIO_COVERT_CENTRAL_MINERAL = 3;
	static final int RADIO_COVERT_CENTRAL_NUCLEAR = 5;
	static final int RADIO_COVERT_POZO_AGUA = 0;
	static final int RADIO_COVERT_ENTRADA_CIUDAD = 0;
	
	// Alojamientos
	static final int ALOJAMIENTO_RESIDENCIA = 100;
	
	// Empleos
	static final int EMPLEOS_INDUSTRIA = 25;
	
	// Averias de Godzilla
	static final int AVERIA_DE_GODZILLA_A_RESIDENCIA = 100;
	static final int AVERIA_DE_GODZILLA_A_COMERCIO = 75;
	static final int AVERIA_DE_GODZILLA_A_INDUSTRIA = 40;
	static final int AVERIA_DE_GODZILLA_A_CENTRAL_ELECTRICA = 35;
	static final int AVERIA_DE_GODZILLA_A_LINEA_DE_TENSION = 100;
	static final int AVERIA_DE_GODZILLA_A_RUTA = 80;	
	static final int AVERIA_DE_GODZILLA_A_TUBERIA = 0;
	
	// Averia de Terremoto
	static final int TERREMOTO_AVERIA_EPICENTRO = 100;
	static final int TERREMOTO_DECRECIMENTO_AVERIA_POR_RADIO = 10;
	
	// Capacidad de reparacion de bomberos
	static final int REPARACION_A_RESIDENCIA = 10;
	static final int REPARACION_A_COMERCIO = 7;
	static final int REPARACION_A_INDUSTRIA = 3;
	static final int REPARACION_A_CENTRAl_EOLICA = 15;
	static final int REPACACION_A_CENTRAL_MINERAL = 10;
	static final int REPACACION_A_CENTRAL_NUCLEAR = 3;
	static final int REPACACION_A_RUTA = 100;
	static final int REPACACION_A_LINEA_DE_TENSION = 100;
	
	// Etiquetas para los elementos del juego
	static final String ETIQUETA_RESIDENCIA = "Residencia";
	static final String ETIQUETA_COMERCIO = "Comercio";
	static final String ETIQUETA_INDUSTRIA = "Industria";
	static final String ETIQUETA_CENTRAL_EOLICA = "Central Eolica";
	static final String ETIQUETA_CENTRAL_MINERAL = "Central Mineral";
	static final String ETIQUETA_CENTRAL_NUCLEAR = "Central Nuclear";
	static final String ETIQUETA_ENTRADA_A_LA_CIUDAD = "Entrada a la Ciudad";
	static final String ETIQUETA_POZO_DE_AGUA = "Pozo de Agua";
	static final String ETIQUETA_ESTACION_DE_BOMBEROS = "Estacion de Bomberos";
	static final String ETIQUETA_AGUA = "Agua";
	static final String ETIQUETA_TERRENO = "Terreno";
	static final String ETIQUETA_TUBERIA = "Tuberia";
	static final String ETIQUETA_RUTA = "Ruta";
	static final String ETIQUETA_LINEA_DE_TENSION = "Linea de Tension";
	static final String ETIQUETA_ACCESO_AL_TRANSITO = "Acceso al Tránsito";
	static final String ETIQUETA_CLOACAS = "Cloacas";
	static final String ETIQUETA_ELECTRICO = "Eléctrico";
	
}
