package algo3.algocity.modelo;

public class AtaqueGodzillaMock implements IAtaqueGodzilla {

	private Coordenada ubicacion;
	private ICaminable estiloDeCaminar;

	public AtaqueGodzillaMock(Coordenada coordenada,
			ICaminable caminador) {
		this.ubicacion = coordenada;
		this.estiloDeCaminar = caminador;
	}

	@Override
	public Coordenada getUbicacion() {	
		return this.ubicacion;
	}

	@Override
	public ICaminable getCaminador() {
		return this.estiloDeCaminar;
	}

}
