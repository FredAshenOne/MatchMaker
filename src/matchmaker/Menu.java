package matchmaker;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Menu extends JFrame {
	
	private JPanel contentPane;
	private JTextField textRonda;
	private JTextField textEvento;
	public Menu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		window w = new window();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 286, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblRonda = new JLabel("Ronda: ");
		lblRonda.setBounds(76, 49, 49, 19);
		panel.add(lblRonda);
		
		textRonda = new JTextField();
		textRonda.setBounds(122, 48, 86, 20);
		panel.add(textRonda);
		textRonda.setColumns(10);
		
		JLabel lblEventol = new JLabel("Evento: ");
		lblEventol.setBounds(76, 24, 46, 14);
		panel.add(lblEventol);
		
		textEvento = new JTextField();
		textEvento.setBounds(122, 21, 86, 20);
		panel.add(textEvento);
		textEvento.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(76, 79, 46, 14);
		panel.add(lblFecha);
		

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w.setVisible(true);
				setVisible(false);
				w.lblRonda.setText(w.lblRonda.getText()+textRonda.getText());
				w.lblEvento.setText(w.lblEvento.getText()+textEvento.getText());
			}
		});
		btnContinuar.setBounds(93, 128, 89, 23);
		panel.add(btnContinuar);
		
		
	}
}
