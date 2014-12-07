package algo3.algocity.vista;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.JList;


public class VistaJuegoFinal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaJuegoFinal frame = new VistaJuegoFinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaJuegoFinal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 347);
		setTitle("Algo City Game");
		setIconImage(new ImageIcon(getClass().getResource("Imagenes\\logo.gif")).getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 400, 55);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JMenu mnConstruir = new JMenu("Construir");
		menuBar.add(mnConstruir);
		
		JMenu mnConexion = new JMenu("Conexion");
		mnConstruir.add(mnConexion);
		
		JMenuItem mntmTuberia = new JMenuItem("Tuberia");
		mnConexion.add(mntmTuberia);
		
		JMenuItem mntmLineadetension = new JMenuItem("LineaDeTension");
		mnConexion.add(mntmLineadetension);
		
		JMenuItem mntmRuta = new JMenuItem("Ruta");
		mnConexion.add(mntmRuta);
		
		JMenu mnConstruccion = new JMenu("Construccion");
		mnConstruir.add(mnConstruccion);
		
		JMenu mnCentralelectrica = new JMenu("CentralElectrica");
		mnConstruccion.add(mnCentralelectrica);
		
		JMenuItem mntmCentralEolica = new JMenuItem("Central Eolica");
		mnCentralelectrica.add(mntmCentralEolica);
		mntmCentralEolica.setEnabled(false);
		
		JMenuItem mntmCentralMineral = new JMenuItem("Central Mineral");
		mnCentralelectrica.add(mntmCentralMineral);
		
		JMenuItem mntmCentralNuclear = new JMenuItem("Central Nuclear");
		mnCentralelectrica.add(mntmCentralNuclear);
		
		JMenuItem mntmPozoDeAgua = new JMenuItem("Pozo De Agua");
		mnConstruccion.add(mntmPozoDeAgua);
		
		JMenuItem mntmEstacionDeBomberos = new JMenuItem("Estacion De Bomberos");
		mnConstruccion.add(mntmEstacionDeBomberos);
		
		JMenuItem mntmComercio = new JMenuItem("Comercio");
		mnConstruccion.add(mntmComercio);
		
		JMenu mnTurno = new JMenu("Turno");
		menuBar.add(mnTurno);
		
		JMenuItem mntmSiguienteturno = new JMenuItem("SiguienteTurno");
		mnTurno.add(mntmSiguienteturno);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
