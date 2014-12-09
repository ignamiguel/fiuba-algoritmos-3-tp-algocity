package algo3.algocity.vista;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.PasarTurno;
import algo3.algocity.modelo.Coordenada;
import algo3.algocity.modelo.Juego;

public class VistaJuego extends JFrame implements Observer {

	private Juego juego;
	private Container contenedor;
	private PasarTurno pasarTurno;
	private static final long serialVersionUID = 6156376075508293279L;

	public VistaJuego(Juego juego) {
		this.juego = juego;
		this.juego.addObserver(this);
		this.setTitle("AlgoCity");
		contenedor = getContentPane();
		GridLayout layoutMapa = new GridLayout(
				juego.getMapa().obtenerTamanio(), juego.getMapa()
						.obtenerTamanio());
		contenedor.setLayout(layoutMapa);

		int at = 0;

		for (int x = 0; x < juego.getMapa().obtenerTamanio(); x++) {

			for (int y = 0; y < juego.getMapa().obtenerTamanio(); y++) {

				contenedor.add(new VistaHectarea(juego.getMapa()
						.obtenerHectarea(new Coordenada(x, y))), at);
				at++;
			}
		}

		this.inicializarMenu();
		this.inicializarVentana();
		this.update();
	}

	private void inicializarMenu() {
		// create a menu bar
		final MenuBar menuBar = new MenuBar();

		// create menus
		Menu archivoMenu = new Menu("Archivo");
		Menu turnoMenu = new Menu("Turno");
		final Menu acercaDeMenu = new Menu("Acerca de");

		// create menu items
		MenuItem nuevoMenuItem = new MenuItem("Nuevo");
		nuevoMenuItem.setActionCommand("Nuevo");

		MenuItem abrirMenuItem = new MenuItem("Abrir");
		abrirMenuItem.setActionCommand("Abrir");

		MenuItem guardarMenuItem = new MenuItem("Guardar");
		guardarMenuItem.setActionCommand("Guardar");

		MenuItem salirMenuItem = new MenuItem("Salir");
		salirMenuItem.setActionCommand("Salir");

		MenuItem pasarMenuItem = new MenuItem("Pasar");
		pasarMenuItem.setActionCommand("Pasar");

		MenuItemListener menuItemListener = new MenuItemListener();

		nuevoMenuItem.addActionListener(menuItemListener);
		abrirMenuItem.addActionListener(menuItemListener);
		guardarMenuItem.addActionListener(menuItemListener);
		salirMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(VistaJuego.this,
						" Esta seguro? ") == JOptionPane.YES_OPTION) {

					VistaJuego.this.processWindowEvent(new WindowEvent(
							VistaJuego.this, WindowEvent.WINDOW_CLOSING));
				}
			}

		});
		// Guardamos instancia para poder setear el juego actual al cargar uno
		// nuevo
		pasarTurno = new PasarTurno(juego);
		pasarMenuItem.addActionListener(pasarTurno);

		// add menu items to menus
		archivoMenu.add(nuevoMenuItem);
		archivoMenu.addSeparator();
		archivoMenu.add(abrirMenuItem);
		archivoMenu.add(guardarMenuItem);
		archivoMenu.addSeparator();
		archivoMenu.add(salirMenuItem);

		turnoMenu.add(pasarMenuItem);

		// add menu to menubar
		menuBar.add(archivoMenu);
		menuBar.add(turnoMenu);
		menuBar.add(acercaDeMenu);

		// add menubar to the frame
		this.setMenuBar(menuBar);
	}

	class MenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	private void inicializarVentana() {

		this.setSize(800, 700);

		this.setLocation(8, 0);

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void update() {
		this.update(null, null);
	}

	@Override
	public void update(Observable o, Object arg) {

		int at = 0;
		for (int x = 0; x < juego.getMapa().obtenerTamanio(); x++) {

			for (int y = 0; y < juego.getMapa().obtenerTamanio(); y++) {
				((VistaHectarea) contenedor.getComponent(at)).updateVista();
				at++;
			}
		}

	}

}
