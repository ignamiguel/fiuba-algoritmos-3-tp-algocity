package algo3.algocity.modelo;

public class Coordenada {
	int x;
	int y;

	public Coordenada(int x, int y) {
		if (x < 0) {
			throw new CoordenadaInvalidaExcepcion();
		}

		if (y < 0) {
			throw new CoordenadaInvalidaExcepcion();
		}

		this.x = x;
		this.y = y;
	}

	public Coordenada moverDerecha() {
		this.x += 1;
		return this;
	}

	public Coordenada moverIzquierda() {
		this.x -= 1;
		return this;
	}

	public Coordenada moverArriba() {
		this.y += 1;
		return this;
	}

	public Coordenada moverAbajo() {
		this.y -= 1;
		return this;
	}

	public Coordenada copiar() {
		return new Coordenada(this.x, this.y);
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

	public boolean validarCoordenada(Mapa mapa) {
		if (this.x <= 0 || this.y <= 0)
			return false;
		if (this.x > mapa.obtenerTamanio() || this.y > mapa.obtenerTamanio())
			return false;
		return true;
	}

}
