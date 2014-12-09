package algo3.algocity.controlador;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.modelo.*;

public class FabricaOpcionesMenuTerreno implements IFabricaOpcionesMenu {

	@Override
	public void popularMenu(final Hectarea current, PopupMenu editMenu) {
		MenuItem menuItem = null;
		if (current.estaVacia()) {
			menuItem = new MenuItem("Construir Residencia");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Residencia residencia = new Residencia();
					current.construir(residencia);
				}

			});
			editMenu.add(menuItem);

			menuItem = new MenuItem("Construir Comercio");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Comercio comercio = new Comercio();
					current.construir(comercio);
				}

			});
			editMenu.add(menuItem);
			menuItem = new MenuItem("Construir Industria");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Industria industria = new Industria();
					current.construir(industria);
				}

			});
			editMenu.add(menuItem);
			
			menuItem = new MenuItem("Construir Central Eolica");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					CentralEolica ce = new CentralEolica();
					current.construir(ce);
				}

			});
			editMenu.add(menuItem);
			
			menuItem = new MenuItem("Construir Central Mineal");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					CentralMineral cm = new CentralMineral();
					current.construir(cm);
				}

			});
			editMenu.add(menuItem);
			
			menuItem = new MenuItem("Construir Central Nucelar");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					CentralNuclear cn = new CentralNuclear();
					current.construir(cn);
				}

			});
			editMenu.add(menuItem);			
			editMenu.addSeparator();
		}

		menuItem = new MenuItem("Conectar Ruta");
		menuItem.setEnabled(true);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Ruta ruta = new Ruta();
				current.conectar(ruta);
			}

		});
		editMenu.add(menuItem);
		menuItem = new MenuItem("Conectar Tuberia");
		menuItem.setEnabled(true);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Tuberia tuberia = new Tuberia();
				current.conectar(tuberia);
			}

		});
		editMenu.add(menuItem);

		menuItem = new MenuItem("Conectar Linea De Tension");
		menuItem.setEnabled(true);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				LineaDeTension lineaDeTension = new LineaDeTension();
				current.conectar(lineaDeTension);
			}

		});
		editMenu.add(menuItem);
	}

}
