package algo3.algocity.modelo;

public class Terremoto {

	private int averia;
	private Coordenada epicentro;

	public Terremoto() {
		super();
		this.averia = Configuracion.TERREMOTO_AVERIA_EPICENTRO;
		this.epicentro = new Coordenada(0, 0);
	}
	
	public Terremoto(IGeneradorEpicentro ge) {
		super();
		this.averia = Configuracion.TERREMOTO_AVERIA_EPICENTRO;
		this.epicentro = ge.getEpicentro();
	}

	public int getAveria() {
		return this.averia;
	}

	public void disminuirAveria() {
		this.averia -= Configuracion.TERREMOTO_DECRECIMENTO_AVERIA_POR_RADIO;
	}

	public Coordenada getEpicentro() {
		return this.epicentro;
	}

}
