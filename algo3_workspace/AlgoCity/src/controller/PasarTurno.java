package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.modelo.Juego;

public class PasarTurno implements ActionListener {

	private Juego juego;

	public PasarTurno(Juego juego) {
		super();
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		juego.pasarTurno();
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

}
