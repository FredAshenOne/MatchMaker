package matchmaker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class window extends JFrame implements ActionListener,MouseListener{

	
	private static final long serialVersionUID = 1L;
	Style s = new Style();
	private JPanel dataPane = new JPanel(),contentPane= new JPanel(), headerPane = new JPanel();
	private JTextField txtNombre,txtPeso,txtDueno,txtAnillo;	
	Functions f = new Functions();
	JLabel lblNombre,lblPeso,lblDueno,lblEvento,lblFecha,lblRonda;
	JButton btnAgregar,btnEmparejar,btnReiniciar,btnExport,btnRegresar;
	JScrollPane scrollp = new JScrollPane();
	DefaultTableModel model = new DefaultTableModel(),model1 = new DefaultTableModel();
	public String ronda,evento,fecha;
	List<Gallo> lista = new ArrayList<Gallo>();
	private JTable table;
	MatchKeys m = new MatchKeys();
	

	


	public window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		dataPane.setBounds(0, 46, 512, 420);
		contentPane.add(dataPane);
		dataPane.setLayout(null);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 98, 138, 20);
		dataPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNombre = new JLabel("Gallo");
		lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 73, 138, 14);
		dataPane.add(lblNombre);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBounds(10, 129, 138, 14);
		dataPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(10, 154, 138, 20);
		dataPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		btnAgregar.setBounds(10, 247, 138, 20);
		btnAgregar.addActionListener(this);
		dataPane.add(btnAgregar);
		
		lblDueno = new JLabel("Partido");
		lblDueno.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblDueno.setHorizontalAlignment(SwingConstants.CENTER);
		lblDueno.setBounds(10, 11, 138, 20);
		dataPane.add(lblDueno);
		
		txtDueno = new JTextField();
		txtDueno.setBounds(10, 42, 138, 20);
		dataPane.add(txtDueno);
		txtDueno.setColumns(10);
		
		scrollp = new JScrollPane();
		scrollp.setBounds(158, 11, 314, 356);
		dataPane.add(scrollp);
		
		table = new JTable();
		scrollp.setViewportView(table);
		
		model.addColumn("Partido");
		model.addColumn("Gallo");
		model.addColumn("Peso");
		model.addColumn("Anillo");
		
		
		JLabel lblAnillo = new JLabel("Anillo");
		lblAnillo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblAnillo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnillo.setBounds(10, 185, 138, 20);
		dataPane.add(lblAnillo);
		
		txtAnillo = new JTextField();
		txtAnillo.setBounds(10, 216, 138, 20);
		dataPane.add(txtAnillo);
		txtAnillo.setColumns(10);
		table.setModel(model);
		
		btnEmparejar = new JButton("Emparejar");
		btnEmparejar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		btnEmparejar.setEnabled(false);
		btnEmparejar.addActionListener(this);
		btnEmparejar.setBounds(10, 278, 138, 20);
		dataPane.add(btnEmparejar);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		btnReiniciar.setBounds(10, 309, 138, 20);
		dataPane.add(btnReiniciar);
		
		btnExport = new JButton();
		btnExport.setBounds(59, 340, 30,29);
		btnExport.setIcon(new ImageIcon("docs/excel.png"));
		dataPane.add(btnExport);
		btnReiniciar.addActionListener(this);
		btnExport.addActionListener(this);
		btnExport.setEnabled(false);
		btnExport.setBorder(null);
		
		headerPane = new JPanel();
		headerPane.setBounds(0, 0, 512, 47);
		contentPane.add(headerPane);
		headerPane.setLayout(null);
		
		lblEvento = new JLabel("");
		lblEvento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblEvento.setBounds(72, 19, 80, 14);
		headerPane.add(lblEvento);
		
		lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblFecha.setBounds(207, 19, 125, 14);
		headerPane.add(lblFecha);
		
		lblRonda = new JLabel("Ronda: ");
		lblRonda.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblRonda.setBounds(345, 17, 137, 19);
		headerPane.add(lblRonda);
		lblFecha.setForeground(Color.decode("#009688"));
		lblRonda.setForeground(Color.decode("#009688"));
		lblEvento.setForeground(Color.decode("#009688"));
		
		btnRegresar = new JButton();
		btnRegresar.setBounds(10, 11, 25, 23);
		headerPane.add(btnRegresar);
		s.imgBtn(btnRegresar, "views/backblue.png");
		s.btnPointer(btnRegresar);
		s.btnPointer(btnAgregar);
		s.btnPointer(btnExport);
		s.btnPointer(btnReiniciar);
		s.btnPointer(btnEmparejar);
		s.mdPanel(headerPane, Color.white);
		s.mdPanel(dataPane, Color.white);
		s.mdBtn(btnAgregar, s.c, Color.white);
		s.mdBtn(btnEmparejar, s.c, Color.white);
		s.mdBtn(btnReiniciar, s.c, Color.white);
		s.mdPanelScroll(scrollp, Color.white);
		btnEmparejar.addMouseListener(this);
		btnAgregar.addMouseListener(this);
		btnReiniciar.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAgregar) {
			Gallo g = new Gallo();
			if(txtDueno.getText().length() > 0 && txtNombre.getText().length() > 0 && txtPeso.getText().length() > 0)				
				g.setDueno(txtDueno.getText());
				g.setNombre(txtNombre.getText());
				g.setPeso(Integer.parseInt(txtPeso.getText()));
				g.setAnillo(Integer.parseInt(txtAnillo.getText()));
				g.setStatus("noEmparejado");
				lista.add(g);
				f.repaintTable(model,lista);
				f.resetTxtFields(txtDueno, txtNombre, txtPeso, txtAnillo);
				if(f.sizeChecker(lista)) {
					btnEmparejar.setEnabled(false);
				}else {btnEmparejar.setEnabled(true);}
		}	
		if(e.getSource() == btnEmparejar){
			
			f.matcher(lista,model1);
			table.setModel(model1);
			headerPane.setBounds(0, 0, 950, 47);
			dataPane.setBounds(0, 46, 950, 480);
			scrollp.setBounds(158, 11, 750, 370);
			setBounds(100, 100, 950, 480);
			btnEmparejar.setEnabled(false);
			s.mdBtn(btnEmparejar, s.c, Color.WHITE);
			f.disabler(txtPeso, txtNombre, txtAnillo, txtDueno, btnAgregar,false);
			btnExport.setEnabled(true);
			
		}
		if(e.getSource() == btnReiniciar) {
			
			model1.setRowCount(0);
			model.setRowCount(0);
			model1.setColumnCount(10);
			f.disabler(txtPeso, txtNombre, txtAnillo, txtDueno, btnAgregar, true);
			table.setModel(model);
			scrollp.setBounds(158, 11, 314, 356);
			setBounds(100, 100, 509, 480);
			model.setNumRows(0);
			btnExport.setEnabled(false);
			
		}
		if(e.getSource() == btnExport) {
			 
			f.exportTable(model1, lblEvento.getText(),lblRonda.getText(),fecha);
		}
		if(e.getSource() == btnRegresar) {		
		}
	}
	public void removeRows(DefaultTableModel model) {
		while(model.getRowCount()>0) {
			model.removeRow(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnReiniciar) {
			s.btnHover(btnReiniciar, Color.WHITE, s.c, s.c);
		}
		else if(e.getSource() == btnAgregar) {
			if(btnAgregar.isEnabled()) {
				s.btnHover(btnAgregar, Color.WHITE, s.c, s.c);
			}
		}else if(e.getSource() == btnEmparejar) {
			if(btnEmparejar.isEnabled()) {
				s.btnHover(btnEmparejar, Color.WHITE, s.c, s.c);
			}
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnReiniciar) {
			s.mdBtn(btnReiniciar, s.c, Color.white);
		}
		else if(e.getSource() == btnAgregar) {
			
				s.mdBtn(btnAgregar, s.c, Color.white);
			
		}else if(e.getSource() == btnEmparejar) {
			if(btnEmparejar.isEnabled()) {
				s.mdBtn(btnEmparejar, s.c, Color.white);
			}
		}		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
