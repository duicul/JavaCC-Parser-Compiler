package lab4polish;

import javax.swing.JFrame;
import javax.swing.JTree;

public class TreeDisplay {
public TreeDisplay(JTree jt,int width,int height) {
	JFrame f=new JFrame(); 
	f.add(jt);  
	f.setSize(width,height);  
	f.setVisible(true); 
}
}
