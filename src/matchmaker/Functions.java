package matchmaker;

import java.util.Comparator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Functions {
	
	public List<Gallo> lista1;
	int pelea = 0;
	DefaultTableModel model1 = new DefaultTableModel();
	
	
	public void repaintTable(DefaultTableModel model, List<Gallo> lista){
		model.setNumRows(0);
		for(int i = 0;i < lista.size();i++ ) {
			model.addRow(new Object[] {
					lista.get(i).getDueno(),lista.get(i).getNombre(),lista.get(i).getPeso(),lista.get(i).getAnillo()
			});
		}
	}
	
	public void resetTxtFields(JTextField t1,JTextField t2,JTextField t3,JTextField t4){
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
	}
	
	public void matcher(List<Gallo> list,DefaultTableModel model1) {
		model1.addColumn("Pelea");
		model1.addColumn("Partido");
		model1.addColumn("Gallo");
		model1.addColumn("Peso");
		model1.addColumn("Anillo");
		model1.addColumn("Vs");
		model1.addColumn("Gallo");
		model1.addColumn("Peso");
		model1.addColumn("Anillo");
		model1.addColumn("Partido");
		

		
		list.sort(new Comparator<Gallo>() {
			@Override
			public int compare(Gallo g1, Gallo g2) {
				return g1.getPeso() - g2.getPeso();
			}
		});
		
		for(Gallo gallo1:list) {
			if(gallo1.getStatus().equals("noEmparejado")) {
				for(Gallo gallo2:list) {
					if(gallo2.getStatus().equals("noEmparejado") && (!gallo1.getDueno().equals(gallo2.getDueno()))) {
						model1.addRow(new Object[] {
								pelea,gallo1.getDueno(),gallo1.getNombre(),gallo1.getPeso(),gallo1.getAnillo(),"-",gallo2.getNombre(),gallo2.getPeso(),gallo2.getAnillo(),gallo2.getDueno()
							});
						gallo1.setStatus("emparejado");
						gallo2.setStatus("emparejado");
						pelea++;
					}
				} 
							
			}
		}
		
	}

}
