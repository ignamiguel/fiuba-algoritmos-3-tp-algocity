package algo3.algocity.controlador;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.modelo.Comercio;
import algo3.algocity.modelo.Hectarea;
import algo3.algocity.modelo.Industria;
import algo3.algocity.modelo.LineaDeTension;
import algo3.algocity.modelo.Residencia;
import algo3.algocity.modelo.Ruta;
import algo3.algocity.modelo.Tuberia;

public class FabricaOpcionesMenuTerreno implements IFabricaOpcionesMenu {

	@Override
	public void popularMenu(final Hectarea current, PopupMenu editMenu) {
		MenuItem cutMenuItem = null;
		if (current.estaVacia()) {
			cutMenuItem = new MenuItem("Construir Residencia");
			cutMenuItem.setEnabled(true);
			cutMenuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Residencia residencia = new Residencia();
					current.construir(residencia);
				}

			});
			editMenu.add(cutMenuItem);

			cutMenuItem = new MenuItem("Construir Comercio");
			cutMenuItem.setEnabled(true);
			cutMenuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Comercio comercio = new Comercio();
					current.construir(comercio);
				}

			});
			editMenu.add(cutMenuItem);
			cutMenuItem = new MenuItem("Construir Industria");
			cutMenuItem.setEnabled(true);
			cutMenuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Industria industria = new Industria();
					current.construir(industria);
				}

			});
			editMenu.add(cutMenuItem);
			editMenu.addSeparator();
		}

		cutMenuItem = new MenuItem("Conectar Ruta");
		cutMenuItem.setEnabled(true);
		cutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Ruta ruta = new Ruta();
				current.conectar(ruta);
			}

		});
		editMenu.add(cutMenuItem);
		cutMenuItem = new MenuItem("Conectar Tuberia");
		cutMenuItem.setEnabled(true);
		cutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Tuberia tuberia = new Tuberia();
				current.conectar(tuberia);
			}

		});
		editMenu.add(cutMenuItem);

		cutMenuItem = new MenuItem("Conectar Linea De Tension");
		cutMenuItem.setEnabled(true);
		cutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				LineaDeTension lineaDeTension = new LineaDeTension();
				current.conectar(lineaDeTension);
			}

		});
		editMenu.add(cutMenuItem);
	}

}
