package algo3.algocity.modelo;

import java.util.Random;

public class Terremoto {

	private double danio;
	private int radioDePropagacion;
	private double disminucionDeDanioPorHectarea;
	private Coordenada ubicacion;
	public Terremoto(){
	
		this.danio = 100;
		this.disminucionDeDanioPorHectarea =  1.5; // ~1.5%
		this.radioDePropagacion = 8;//provisorio

		
	}
/*	private Coordenada generarPosicionAleatoria(Mapa mapa) {
		
		int tamanio  = mapa.obtenerTamanio();
		int cotaDeRandom = tamanio; 
		this.radioDePropagacion = tamanio/3;
		Random xAleatoria = new Random(cotaDeRandom);
		Random yAleatoria = new Random(cotaDeRandom);
		int x = xAleatoria.nextInt();
		int y = yAleatoria.nextInt();
		
		Coordenada unaCoordenada = new Coordenada(x,y);
	
		return unaCoordenada;
	}
								
*/					/*
*							^
*							^
*							|
*							|	
*
**/			
	//solo para testeo, la clase que se usara es la de arriba
	private Coordenada generarPosicionAleatoria(Mapa mapa) {
	
		Coordenada unaCoordenada = new Coordenada(10,10);
		
		return unaCoordenada;
		
	}
	public void atacarConRandom(Mapa mapa){
		
		this.ubicacion = this.generarPosicionAleatoria(mapa);

		this.atacar(ubicacion,mapa);
		
		
	}
	private void atacar(Coordenada nucleo,Mapa mapa) {
		

			Coordenada coordenadaAux = nucleo.copiar();
			Coordenada coordenadaAux2 = nucleo.copiar();
		
			
			
			for(int j =0;j<=(radioDePropagacion/2);j++){
				
				for(int i =((-radioDePropagacion/2)+j);i<=((radioDePropagacion/2)-j);i++){
					
					coordenadaAux.aumentarX(j+1);
					coordenadaAux.aumentarY(i);
					
					if((mapa.coordenadaValida(coordenadaAux))&&(!(mapa.obtenerHectarea(coordenadaAux).estaVacia()))){
						
					
						this.recalcularDanio(coordenadaAux,nucleo);					//afecta en forma de rombo
						mapa.obtenerHectarea(coordenadaAux).afectarCon(this);		//         0
																					//        000
					}																//       00000
																					//       00000
					coordenadaAux.disminuirX(j+1);									//        000
					coordenadaAux.disminuirY(i);									//         0
					
					
					coordenadaAux2.disminuirX(j);
					coordenadaAux2.disminuirY(i);
					
					if((mapa.coordenadaValida(coordenadaAux2))&&(!(mapa.obtenerHectarea(coordenadaAux2).estaVacia()))){
						
						this.recalcularDanio(coordenadaAux2,nucleo);
						mapa.obtenerHectarea(coordenadaAux2).afectarCon(this);
					}
					coordenadaAux2.aumentarX(j);
					coordenadaAux2.aumentarY(i);
					
					
					
				}

			}
		
		
		
		
	}
	private void recalcularDanio(Coordenada cAux, Coordenada nucleo) {
		
		int restaX = (cAux.obtenerX())-(nucleo.obtenerX());
		
		int restaY = (cAux.obtenerY())-(nucleo.obtenerY());
		
		double cuadrados = Math.pow(restaX, 2) + Math.pow(restaY, 2);
		
		double norma = Math.sqrt(cuadrados);
		
		this.cargarDanio((100 - (norma*this.disminucionDeDanioPorHectarea))); 

	}
	//Solo para Tests previos a la propagacion del terremoto
	public void cargarDanio(double danio){
		this.danio = danio;
	}
	
	public int obtenerDanio(){
		return ((int)this.danio);
	}
}
