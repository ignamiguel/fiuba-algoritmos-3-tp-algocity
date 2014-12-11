package algo3.algocity.modelo;

import java.util.Random;

public class GeneradorEpicentro implements IGeneradorEpicentro{

	private Coordenada epicentro;
	Random randomGenerator = new Random();
	
	public GeneradorEpicentro(int tamanio){
		int x = randomGenerator.nextInt(tamanio - 1);		
		int y = randomGenerator.nextInt(tamanio - 1);		
		this.epicentro = new Coordenada(x, y);
	}
	
	@Override
	public Coordenada getEpicentro() {
		return this.epicentro;
	}

}
