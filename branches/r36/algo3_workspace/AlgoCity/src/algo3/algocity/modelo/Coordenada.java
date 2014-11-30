package algo3.algocity.modelo;

public class Coordenada {
	int x;
	int y;

	public Coordenada(int x, int y) {
		if (x < 0) {
			throw new CoordenadaInvalidaExcepcion();
		}
		
		if(y < 0 ){
			throw new CoordenadaInvalidaExcepcion();
		}

		this.x = x;
		this.y = y;
	}

	public int obtenerX() {
		return this.x;
	}

	public int obtenerY() {
		return this.y;
	}

	public void aumentarX(int a) {
		this.x = (this.x + a);
	}

	public void aumentarY(int b) {
		this.y = (this.y + b);
	}

	public void disminuirX(int a) {
		this.x = (this.x - a);
	}

	public void disminuirY(int b) {
		this.y = (this.y - b);
	}

}
