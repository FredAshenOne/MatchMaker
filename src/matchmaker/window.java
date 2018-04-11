package matchmaker;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class window extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPeso;
	private JTextField txtDueno;
	Functions f = new Functions();
	JLabel lblNombre,lblPeso,lblDueno;
	JButton btnAgregar,btnEmparejar;
	JScrollPane scrollp = new JScrollPane();
	JList<Gallo> list = new JList<Gallo>();
	DefaultTableModel model = new DefaultTableModel();

	DefaultTableModel model1 = new DefaultTableModel();
	private JTextField txtAnillo;
	List<Gallo> lista = new ArrayList<Gallo>();
	private JTable table;
	MatchKeys m = new MatchKeys();


	public window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 767, 378);
		contentPane.add(panel);
		panel.setLayout(null);
		
		




		txtNombre = new JTextField();
		txtNombre.setBounds(10, 98, 138, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 73, 138, 14);
		panel.add(lblNombre);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBounds(10, 129, 138, 14);
		panel.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(10, 154, 138, 20);
		panel.add(txtPeso);
		txtPeso.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 264, 138, 20);
		btnAgregar.addActionListener(this);
		panel.add(btnAgregar);
		
		lblDueno = new JLabel("Due\u00F1o");
		lblDueno.setHorizontalAlignment(SwingConstants.CENTER);
		lblDueno.setBounds(10, 11, 138, 20);
		panel.add(lblDueno);
		
		txtDueno = new JTextField();
		txtDueno.setBounds(10, 42, 138, 20);
		panel.add(txtDueno);
		txtDueno.setColumns(10);
		
		scrollp = new JScrollPane();
		scrollp.setBounds(158, 11, 314, 356);
		panel.add(scrollp);
		
		table = new JTable();
		scrollp.setViewportView(table);
		
		model.addColumn("Partido");
		model.addColumn("Gallo");
		model.addColumn("Peso");
		model.addColumn("Anillo");
		
		
		JLabel lblAnillo = new JLabel("Anillo");
		lblAnillo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnillo.setBounds(10, 185, 138, 20);
		panel.add(lblAnillo);
		
		txtAnillo = new JTextField();
		txtAnillo.setBounds(10, 216, 138, 20);
		panel.add(txtAnillo);
		txtAnillo.setColumns(10);
		table.setModel(model);
		
		btnEmparejar = new JButton("Emparejar");
		btnEmparejar.addActionListener(this);
		btnEmparejar.setBounds(10, 328, 138, 20);
		panel.add(btnEmparejar);
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
		}	
		if(e.getSource() == btnEmparejar){
			f.matcher(lista,model1);
			table.setModel(model1);
			scrollp.setBounds(158, 11, 600, 356);			
		}
	}	
}
