package matchmaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Style {
	public Font f12 = new Font("Yu Gothic UI Light", Font.ITALIC, 12);
	public Font f16 = new Font("Yu Gothic UI Light", Font.ITALIC, 16);
	Color c = Color.decode("#009688");
	
	public void mdPanel(JPanel panel, Color c) {
		panel.setBorder(null);
		panel.setOpaque(true);
		panel.setBackground(c);
	}
	public void mdPanelScroll(JScrollPane panel, Color c) {
		panel.setBorder(null);
		panel.setOpaque(true);
		panel.setBackground(c);
	}
	public void mdBtn(JButton btn, Color cb,Color cf) {
		btn.setContentAreaFilled(false);
		btn.setBorder(new LineBorder(cb,1,true));
		btn.setOpaque(true);
		btn.setBackground(cb);
		btn.setForeground(cf);
	}
	public void btnPointer(JButton btn) {
		btn.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		new ImageIcon("views/cursor.png").getImage(),
		new Point(0,0), "custom cursor"));
	}
	
	public void mdTxt(JTextField txt,Color bg,Color fg) {
		txt.setBorder(null);
		txt.setOpaque(true);
		txt.setBackground(bg);
		txt.setForeground(fg);
	}
	
	public void imgBtn(JButton btn, String url) {
		btn.setBorder(null);
		btn.setOpaque(true);
		btn.setContentAreaFilled(false);
		btn.setIcon(new ImageIcon(url));
	}
	
	public void btnHover(JButton btn,Color cb,Color cf,Color cbord){
	
		btn.setContentAreaFilled(false);
		btn.setBorder(new LineBorder(cbord,5,true));
		btn.setOpaque(true);
		btn.setBackground(cb);
		btn.setForeground(cf);
		
	}
	
	public void clearData(JTextField t1) {
		t1.setText("");
	}
	
	public boolean maxLength(JTextField txt,JLabel wrn,int ch) {
		if(txt.getText().length() > ch) {
			wrn.setForeground(Color.red);
			wrn.setText("Excede los caracteres permitidos");			
			return true;
		}
		return false;
		
	}
	


}
