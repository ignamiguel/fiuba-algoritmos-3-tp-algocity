package algo3.algocity.vista;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;


import javax.swing.JPanel;

public class EstadoJuego extends JPanel{

	private static final long serialVersionUID = -6414260109880384968L;
	
	private static final String DIA = "Dia: ";
	private static final String DINERO = "Dinero: ";
	private static final String POBLACION = "Poblacion: ";
	private Label poblacion;
	private Label dinero;
	private Label dia;
	private Label jugador;

	public EstadoJuego() {
		setLayout(new FlowLayout());
		Dimension tamanio = new Dimension(120, 20);
		this.poblacion = new Label(POBLACION + "0");
		this.poblacion.setPreferredSize(tamanio);
		this.dinero = new Label(DINERO + "100000");
		this.dinero.setPreferredSize(tamanio);
		this.dia = new Label(DIA + "1");
		this.dia.setPreferredSize(tamanio);
		this.jugador = new Label("Jugador1");
		this.jugador.setPreferredSize(tamanio);
		this.add(poblacion);
		this.add(dinero);
		this.add(dia);
		this.add(jugador);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

	}

	public void actualizarPoblacion(int poblacionActual) {
		poblacion.setText(POBLACION.concat(Integer.toString(poblacionActual)));

	}

	public void actualizarDia(int diaActual) {
		dia.setText(DIA.concat(Integer.toString(diaActual)));
	}

	public void actualizarDinero(int dineroActual) {
		dinero.setText(DINERO.concat(Integer.toString(dineroActual)));
	}

	public void actualizarJugador(String jugadorActual) {
		this.jugador.setText(jugadorActual);
	}

	
}
