package domainvalue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Program extends Domain {
    List<Packet> lp = new ArrayList<Packet>();
	public Program(String name) {
	}
	
	public boolean findClass(String name) {
		for(Packet p:this.lp)
			if(Packet.listcontain(p.lc, name)!=null)
				return true;
		return false;
	}
	
	@Override
	public boolean test(Domain d) {
		for(Packet p : lp)
			if(p.equalname(name))
				return false;
		return true;
	}
	
	public boolean add(Domain p) {
		return lp.add((Packet) p);
	}

	@Override
	public void generatetree(DefaultMutableTreeNode dmt) {
		DefaultMutableTreeNode dmt1=new DefaultMutableTreeNode("Program");
		dmt.add(dmt1);
		for(Packet p:this.lp)
			p.generatetree(dmt1);}

	

}
