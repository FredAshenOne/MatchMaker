package matchmaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
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
	JButton btnAgregar,btnEmparejar,btnReiniciar,btnExport;
	JScrollPane scrollp = new JScrollPane();
	JList<Gallo> list = new JList<Gallo>();
	DefaultTableModel model = new DefaultTableModel();
	public String ronda,evento,fecha;
	DefaultTableModel model1 = new DefaultTableModel();
	private JTextField txtAnillo;
	List<Gallo> lista = new ArrayList<Gallo>();
	private JTable table;
	MatchKeys m = new MatchKeys();
	private JPanel panel_1;
	public JLabel lblEvento,lblFecha,lblRonda;

	


	public window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 46, 767, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 98, 138, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNombre = new JLabel("Gallo");
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
		btnAgregar.setBounds(10, 247, 138, 20);
		btnAgregar.addActionListener(this);
		panel.add(btnAgregar);
		
		lblDueno = new JLabel("Partido");
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
		btnEmparejar.setEnabled(false);
		btnEmparejar.addActionListener(this);
		btnEmparejar.setBounds(10, 278, 138, 20);
		panel.add(btnEmparejar);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(10, 309, 138, 20);
		panel.add(btnReiniciar);
		
		btnExport = new JButton();
		btnExport.setBounds(59, 340, 30,29);
		btnExport.setIcon(new ImageIcon("docs/excel.png"));
		panel.add(btnExport);
		btnReiniciar.addActionListener(this);
		btnExport.addActionListener(this);
		btnExport.setEnabled(false);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 463, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblEvento = new JLabel("");
		lblEvento.setBounds(29, 11, 80, 14);
		panel_1.add(lblEvento);
		
		lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(153, 11, 104, 14);
		panel_1.add(lblFecha);
		
		lblRonda = new JLabel("Ronda: ");
		lblRonda.setBounds(300, 11, 137, 19);
		panel_1.add(lblRonda);
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
			scrollp.setBounds(158, 11, 600, 356);
			setBounds(100, 100, 800, 417);
			btnEmparejar.setEnabled(false);
			f.disabler(txtPeso, txtNombre, txtAnillo, txtDueno, btnAgregar,false);
			btnExport.setEnabled(true);
			
		}
		if(e.getSource() == btnReiniciar) {
			
			model1.setNumRows(0);
			model1.setColumnCount(10);
			f.disabler(txtPeso, txtNombre, txtAnillo, txtDueno, btnAgregar, true);
			table.setModel(model);
			scrollp.setBounds(158, 11, 314, 356);
			setBounds(100, 100, 496, 417);
			model.setNumRows(0);
			btnExport.setEnabled(false);
			
		}
		if(e.getSource() == btnExport) {
			f.exportTable(model1, lblEvento.getText(),lblRonda.getText());
		}
	}	
}
