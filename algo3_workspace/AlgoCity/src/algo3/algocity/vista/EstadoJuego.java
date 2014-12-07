package algo3.algocity.vista;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JPanel;

public class EstadoJuego extends JPanel {

	private static final String DIA = "Dia:";

	private static final String DINERO = "Dinero:";

	private static final String POBLACION = "Poblacion:";

	private static final long serialVersionUID = -6414260109880384968L;

	private Label poblacion;
	private Label dinero;
	private Label dia;
	private Label jugador;

	public EstadoJuego() {
		setLayout(new FlowLayout());
		Dimension tamanio = new Dimension(120, 20);
		poblacion = new Label(POBLACION + "0");
		poblacion.setPreferredSize(tamanio);
		dinero = new Label(DINERO + "100000");
		dinero.setPreferredSize(tamanio);
		dia = new Label(DIA + "1");
		dia.setPreferredSize(tamanio);
		jugador = new Label("Pepito");
		jugador.setPreferredSize(tamanio);
		this.add(poblacion);
		this.add(dinero);
		this.add(dia);
		this.add(jugador);
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

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
