package parservalue;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.WindowConstants;

public class TreeDisplay {
public TreeDisplay(JTree jt,int width,int height) {
	JFrame f=new JFrame(); 
	f.add(jt);  
	f.setSize(width,height);  
	f.setVisible(true); 
	f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}
}
