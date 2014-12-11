package algo3.algocity.vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Button;

import algo3.algocity.modelo.Juego;



public class VentanaInicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaInicio(final Juego juego) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 335);
		setTitle("Algo City Game");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		((JPanel)getContentPane()).setOpaque(false);

		
		
		Button button = new Button("Iniciar Juego");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana2 ventana= new Ventana2(juego);
				ventana.setVisible(true);
				dispose();
				
			}
		});
		button.setBounds(152, 76, 114, 36);
		contentPane.add(button);
		
		Button button_1 = new Button("Continuar Partida");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana2 ventana= new Ventana2(juego);
				ventana.setVisible(true);
				dispose();
				
			}
		});
		button_1.setBounds(152, 132, 114, 36);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Salir");
		button_2.setBounds(152, 188, 114, 36);
		contentPane.add(button_2);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
