package algo3.algocity.vista;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import algo3.algocity.modelo.Juego;


public class Ventana2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana2 frame = new Ventana2();
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
	public Ventana2(final Juego juego) {
		//Juego juego = juego;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Algo City Game");
		//setIconImage(new ImageIcon(getClass().getResource("Imagenes\\logo.gif")).getImage());
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		((JPanel)getContentPane()).setOpaque(false);
		  //ImageIcon uno=new ImageIcon(this.getClass().getResource("Imagenes\\algocity2.jpg"));
		    JLabel fondo= new JLabel();
		    // fondo.setIcon(uno); 
		     getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
		     // fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaJuego vista = new VistaJuego(juego);
				vista.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(152, 111, 101, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio vistaPrincipal = new VentanaInicio(juego);
				vistaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(152, 155, 101, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblIngreseNombre = new JLabel("    Ingrese nombre: ");
		lblIngreseNombre.setForeground(Color.BLACK);
		lblIngreseNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseNombre.setBackground(Color.BLACK);
		lblIngreseNombre.setBounds(152, 21, 130, 27);
		contentPane.add(lblIngreseNombre);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(152, 59, 157, 34);
		contentPane.add(textPane);
	}
}