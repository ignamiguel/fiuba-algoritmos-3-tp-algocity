package algo3.algocity.modelo;

public class GeneradorEpicentroMock implements IGeneradorEpicentro{

	private Coordenada epicentro;
	
	public GeneradorEpicentroMock(Coordenada coordenada){
		this.epicentro = coordenada;
	}
	
	@Override
	public Coordenada getEpicentro() {
		return this.epicentro;
	}

}
