package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Godzilla {

	private Coordenada ubicacion;
	private ICaminable caminador;
	private ArrayList<ICaminable> caminadores;

	public Godzilla() {
		this.caminadores = new ArrayList<ICaminable>();
		this.ubicacion = new Coordenada(3, 0);//default para algunos test

		(this.caminadores).add(new CaminarZigZag());
		(this.caminadores).add(new CaminarDerecho());
	}

	public Coordenada obtenerCoordenada() {
		return ubicacion;
	}

	// Usa random nose como testear, lo dejo implementado pero no tiene tests
	public void atacarConRandom(Mapa mapa) {
		this.caminador = this.generarCaminadorAleatorio(mapa);
		this.ubicacion = (this.caminador).generarCoordenadaAleatoria(mapa);
		this.atacar(mapa);

	}

	// Usa random nose como testear, lo dejo implementado pero no tiene tests
	private ICaminable generarCaminadorAleatorio(Mapa mapa) {
		Random aleatorio = new Random();
		int pos = aleatorio.nextInt(caminadores.size());
		return (ICaminable) this.caminadores.get(pos);
	}

	// Este metodo no deberia usarse en el juego pero me sirve para testear el
	// movimiento
	public void atacarSinRandomParaTest(Mapa mapa, Coordenada coordenada,
			ICaminable caminador) {
		this.ubicacion = coordenada;
		this.caminador = caminador;
		this.atacar(mapa);
	}

	public void avanzarEnY() {
		(this.ubicacion).aumentarY(1);
	}

	public void retrocederEnX() {
		(this.ubicacion).disminuirX(1);

	}

	public void avanzarEnX() {
		(this.ubicacion).aumentarX(1);

	}

	private void atacar(Mapa mapa) {
		(this.caminador).caminarMapa(this, mapa);

	}

}
