package matchmaker;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class window extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPeso;
	private JTextField txtDueno;
	
	JLabel lblNombre,lblPeso,lblDueno;
	JButton btnAgregar;
	Gallo g = new Gallo();
	JList<Gallo> list;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;

	public window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 767, 378);
		contentPane.add(panel);
		panel.setLayout(null);

		model.addColumn("Dueño");
		model.addColumn("Nombre");
		model.addColumn("Peso");



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
		btnAgregar.setBounds(10, 185, 138, 20);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 11, 281, 356);
		panel.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAgregar) {
			if(txtDueno.getText().length() > 0 && txtNombre.getText().length() > 0 && txtPeso.getText().length() > 0)
			model.addRow(new Object[] {
					txtDueno.getText(),txtNombre.getText(),txtPeso.getText()
					});
			txtDueno.setText("");
			txtPeso.setText("");
			txtNombre.setText("");
			

			
		}	
	}	
}
