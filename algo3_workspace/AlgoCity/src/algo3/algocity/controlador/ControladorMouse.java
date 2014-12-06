package algo3.algocity.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;

import algo3.algocity.modelo.AlgoCity;
import algo3.algocity.modelo.Hectarea;
import algo3.algocity.vista.VistaHectarea;

public class ControladorMouse extends MouseAdapter {

    private Hectarea hectarea;

    private VistaHectarea vista;

    public ControladorMouse(Hectarea h, VistaHectarea vista) {
        this.hectarea = h;
        this.vista = vista;
    }

    public void mousePressed(MouseEvent mouseEvent) {

        // Ojo al piojo.
        // El manejo de las coordenadas del mouse debe ser encapsulado por la clase Posicion
        // modelo.inicializarModeloDato(new Posicion(mouseEvent.getX(), mouseEvent.getY()));

        //modelo.inicializarModeloDato(vista.posicion);
    	System.out.println("Mouse aprateado!");
    	this.hectarea.cambiar();
    }
}
