package matchmaker;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField textEvento,textRonda,txtDia,txtMes,txtAño;
	JButton btnContinuar = new JButton("Continuar");
	Style s = new Style();
	window w = new window();
	JLabel lblWarn = new JLabel("");
	public Menu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 286, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblRonda = new JLabel("Ronda: ");
		lblRonda.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblRonda.setBounds(76, 49, 49, 19);
		panel.add(lblRonda);
		
		textRonda = new JTextField();
		textRonda.setBounds(122, 48, 86, 20);
		panel.add(textRonda);
		textRonda.setColumns(10);
		
		JLabel lblEventol = new JLabel("Evento: ");
		lblEventol.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblEventol.setBounds(76, 24, 46, 14);
		panel.add(lblEventol);
		
		textEvento = new JTextField();
		textEvento.setBounds(122, 21, 86, 20);
		panel.add(textEvento);
		textEvento.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblFecha.setBounds(120, 79, 46, 14);
		panel.add(lblFecha);
		s.mdPanel(panel, Color.WHITE);
		
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				s.btnHover(btnContinuar, Color.white, Color.decode("#009688"), Color.decode("#009688"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s.mdBtn(btnContinuar, Color.decode("#009688"), Color.WHITE);
			}
		});
		btnContinuar.setBounds(104, 147, 89, 23);
		panel.add(btnContinuar);
		
		s.mdTxt(textRonda, Color.white, Color.BLACK);
		s.mdTxt(textEvento, Color.WHITE, Color.black);
		s.mdBtn(btnContinuar, Color.decode("#009688"), Color.WHITE);
		
		txtDia = new JTextField();
		txtDia.setBounds(65, 97, 33, 20);
		panel.add(txtDia);
		txtDia.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(142, 97, 33, 20);
		panel.add(txtMes);
		
		txtAño = new JTextField();
		txtAño.setColumns(10);
		txtAño.setBounds(221, 97, 33, 20);
		panel.add(txtAño);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblDia.setBounds(22, 99, 33, 14);
		panel.add(lblDia);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblMes.setBounds(110, 99, 33, 14);
		panel.add(lblMes);
		
		JLabel lblAño = new JLabel("A\u00F1o");
		lblAño.setHorizontalAlignment(SwingConstants.CENTER);
		lblAño.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblAño.setBounds(185, 100, 33, 14);
		panel.add(lblAño);
		btnContinuar.addActionListener(this);
	
		lblWarn.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarn.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		lblWarn.setBounds(10, 122, 266, 14);
		panel.add(lblWarn);
		lblWarn.setForeground(Color.RED);
		w.btnRegresar.addActionListener(this);
		textEvento.setBorder(BorderFactory.createLineBorder(Color.decode("#B0BEC5"),1));
		textRonda.setBorder(BorderFactory.createLineBorder(Color.decode("#B0BEC5"),1));
		this.setResizable(false);
		s.btnPointer(btnContinuar);
	
	}
	
	public Boolean datosCompletos(JTextField evento,JTextField ronda,JTextField dia,JTextField mes,JTextField año,JLabel lbl){
		if(año.getText().length() < 4 || mes.getText().length() < 2 || dia.getText().length() < 2 || ronda.getText().length() < 1 || evento.getText().length()<1) {
			lbl.setText("Datos Incompletos");
			return false;
		}else if(año.getText().length() > 4 || mes.getText().length() > 2 || dia.getText().length() > 2) {
			lbl.setText("Algunos campos exceden el limite de caracteres");
			return false;
		}
		return true;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == w.btnRegresar) {
			lblWarn.setText("");
			w.lblEvento.setText("");
			w.lblFecha.setText("");
			w.lblRonda.setText("");
			this.setVisible(true);
			w.setVisible(false);
			
		}
		if(e.getSource() ==	btnContinuar) {
			if(datosCompletos(textEvento,textRonda,txtDia,txtMes,txtAño,lblWarn)) {		
				w.setVisible(true);
				setVisible(false);
				w.lblRonda.setText(w.lblRonda.getText()+textRonda.getText());
				w.lblEvento.setText(w.lblEvento.getText()+textEvento.getText());
				w.fecha = w.lblFecha.getText()+txtDia.getText()+"/"+txtMes.getText()+"/"+txtAño.getText();
				w.lblFecha.setText(w.fecha);
			}
		}
		
	}
}
