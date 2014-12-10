package algo3.algocity.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import algo3.algocity.controlador.*;
import algo3.algocity.modelo.*;

public class VistaHectarea extends JPanel implements Observer {

	private static final long serialVersionUID = -973667959098244571L;

	private Juego juego;
	private Hectarea hectarea;
	private Color color;

	private Coordenada coordenada;

	public void update(Observable o, Object arg) {
		this.updateVista();
	}

	// Old Constructor
	public VistaHectarea(Hectarea hectarea) {
		this.hectarea = hectarea;
		hectarea.addObserver(this);
		this.addMouseListener(new ControladorMouse(hectarea));
	}
	
	public VistaHectarea(Juego juego, Coordenada coordenada) {
		this.juego = juego;
		this.hectarea = this.juego.getMapa().obtenerHectarea(coordenada);
		this.hectarea.addObserver(this);
		this.coordenada = coordenada;
		this.addMouseListener(new ControladorMouse(juego, this.coordenada));
	}

	protected void updateVista() {
		if (this.hectarea.getClass().equals(Terreno.class)) {
			if (hectarea.estaVacia())
				this.color = new Color(122, 186, 122);
			else
				this.color = new Color(255, 228, 196);
		} else {
			this.color = new Color(51, 102, 153);
		}

		repaint();
		return;
	}

	public void paintComponent(Graphics grafico) {
		super.paintComponent(grafico);
		grafico.setColor(color);
		Dimension dimension = getSize();

		grafico.fill3DRect(0, 0, dimension.width, dimension.height, true);
	}
}
