package matchmaker;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Functions {
	
	public List<Gallo> lista1;
	int pelea = 1;
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
				for(Gallo gallo2:list) {
					if(gallo2.getStatus().equals("noEmparejado") && gallo1.getStatus().equals("noEmparejado") && (!gallo1.getDueno().equals(gallo2.getDueno()))) {
						model1.addRow(new Object[] {
								pelea,gallo1.getDueno(),gallo1.getNombre(),gallo1.getPeso(),gallo1.getAnillo(),"-",gallo2.getNombre(),gallo2.getPeso(),gallo2.getAnillo(),gallo2.getDueno()
							});
						gallo1.setStatus("emparejado");
						gallo2.setStatus("emparejado");
						pelea++;
					}
				} 
							
			
		}
		list.clear();
		
	}

	public void disabler(JTextField t1,JTextField t4, JTextField t2, JTextField t3, JButton b1,boolean choice) {
		t1.setEnabled(choice);
		t2.setEnabled(choice);
		t3.setEnabled(choice);
		t4.setEnabled(choice);
		b1.setEnabled(choice);
	}
	
	public boolean sizeChecker(List<Gallo> list) {
		if(list.size()%2 == 0) {
			return false;
		}
		return true;
		
	}
	
	
    public void exportTable(DefaultTableModel model,String txt_evento,String txt_ronda) {
    	
       XSSFWorkbook wb = new XSSFWorkbook();
       XSSFSheet sh = wb.createSheet();
       XSSFRow rows,ronda=sh.createRow(1),evento = sh.createRow(0),fecha = sh.createRow(2),row = sh.createRow(3);
       evento.createCell(0).setCellValue(txt_evento);
       CellRangeAddress r1 = new CellRangeAddress(0,0,0,9);
       sh.addMergedRegion(r1);
       sh.addMergedRegion(new CellRangeAddress(1,1,0,9));
       sh.addMergedRegion(new CellRangeAddress(2,2,0,9));
   
       ronda.createCell(0).setCellValue(txt_ronda);
       row.createCell(0).setCellValue("PELEA");
       row.createCell(1).setCellValue("PARTIDO");       
       row.createCell(2).setCellValue("GALLO");
       row.createCell(3).setCellValue("PESO");
       row.createCell(4).setCellValue("ANILLO");
       row.createCell(5).setCellValue("VS");
       row.createCell(6).setCellValue("GALLO");
       row.createCell(7).setCellValue("PESO");
       row.createCell(8).setCellValue("ANILLO");
       row.createCell(9).setCellValue("PARTIDO");
      
       for(int i = 0;i < model.getRowCount();i++) {
    	   rows = sh.createRow(i+3);
    	   rows.createCell(0).setCellValue(model.getValueAt(i,0).toString());
    	   rows.createCell(1).setCellValue(model.getValueAt(i,1).toString());
    	   rows.createCell(2).setCellValue(model.getValueAt(i,2).toString());
    	   rows.createCell(3).setCellValue(model.getValueAt(i,3).toString());
    	   rows.createCell(4).setCellValue(model.getValueAt(i,4).toString());
    	   rows.createCell(5).setCellValue(model.getValueAt(i,5).toString());
    	   rows.createCell(6).setCellValue(model.getValueAt(i,6).toString());
    	   rows.createCell(7).setCellValue(model.getValueAt(i,7).toString());
    	   rows.createCell(8).setCellValue(model.getValueAt(i,8).toString());
    	   rows.createCell(9).setCellValue(model.getValueAt(i,9).toString());
       }
       
       try {
    	   wb.write(new FileOutputStream(new File("peleas.xlsx")));
    	   Desktop.getDesktop().open(new File("peleas.xlsx"));
       }catch (Exception ex) {
    	   
       }
        
    }
}
