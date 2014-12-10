package algo3.algocity.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocity.controlador.*;
import algo3.algocity.modelo.*;

public class VistaHectarea extends JPanel implements Observer {

	private static final long serialVersionUID = -973667959098244571L;

	// protected Juego juego;
	private Hectarea hectarea;
	private Color color;
	private ImageIcon image;

	private Coordenada coordenada;

	public void update(Observable o, Object arg) {
		this.updateVista();
	}

	public VistaHectarea(Hectarea hectarea) {
		this.hectarea = hectarea;
		hectarea.addObserver(this);
		this.addMouseListener(new ControladorMouse(hectarea));
		
	}
	
	public VistaHectarea(Hectarea hectarea, Coordenada coordenada) {
		this.hectarea = hectarea;
		hectarea.addObserver(this);
		this.coordenada = coordenada;
		this.addMouseListener(new ControladorMouse(hectarea, this.coordenada));
	}

	protected void updateVista() {
		if(!(this.hectarea.estaVacia())){
			image= new ImageIcon(getClass().getResource("/imagenes/edificio.gif"));
		}
		else{
			if (this.hectarea.getClass().equals(Terreno.class))
			{	this.color = new Color(122, 186, 122);
				
			}
			else{
				this.color = new Color(51, 102, 153);
			}
		}
		repaint();
		return;
	}

	public void paintComponent(Graphics grafico) {
		Dimension dimension = getSize();
		if(!(this.hectarea.estaVacia())){
			grafico.drawImage(image.getImage(), 0, 0, dimension.width, dimension.height, null);
	        setOpaque(false);
		}
		else{
			super.paintComponent(grafico);
			grafico.setColor(color);
			grafico.fill3DRect(0, 0, dimension.width, dimension.height, true);
			
		}
	
	}
}
