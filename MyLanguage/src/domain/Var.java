package domain;

import javax.swing.tree.DefaultMutableTreeNode;

public class Var extends Domain {
	protected String name,val,type;
	public Var(String type,String name,String val) {
		this.type=type;
		this.name=name;
		this.val=val;
	}

	@Override
	public boolean test(Domain d) {
		Domain dom=this;
		for(dom=this;dom.upper!=null&&!(dom instanceof Program);dom=dom.upper);
		if(dom instanceof Program)
		if(((Program)dom).findClass(this.type)) 
		    return true;
		
		return false;
	}

	@Override
	public boolean add(Domain d) {
		return false;
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return this.type+" "+this.val+" "+this.name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Var) {
			Var a=(Var)o;
			return this.name.equals(a.name);}
		return false;
	}

	@Override
	public void generatetree(DefaultMutableTreeNode dmt) {
		dmt.add(new DefaultMutableTreeNode(this.type+" "+this.name+"="+this.val));}

}
