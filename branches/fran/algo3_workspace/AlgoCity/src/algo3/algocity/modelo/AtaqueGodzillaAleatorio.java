package algo3.algocity.modelo;

import java.util.Random;

public class AtaqueGodzillaAleatorio implements IAtaqueGodzilla {

	
	private ICaminable caminador;
	private Coordenada ubicacion;

	public AtaqueGodzillaAleatorio(Mapa mapa){
		Random aleatorio = new Random();
		int num = aleatorio.nextInt(mapa.getTamanio() - 4) + 3;
		this.ubicacion = new Coordenada(num, 0);
		num = aleatorio.nextInt(2);
		if(num == 0) this.caminador = new CaminarDerecho();
		if(num == 1) this.caminador = new CaminarZigZag();
	}
	@Override
	public Coordenada getUbicacion() {
		return ubicacion;
	}

	@Override
	public ICaminable getCaminador() {
		return caminador;
	}

}
