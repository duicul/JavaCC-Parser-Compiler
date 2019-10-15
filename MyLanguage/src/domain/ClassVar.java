package domain;

import javax.swing.tree.DefaultMutableTreeNode;

public class ClassVar extends Var{
    private String access;
	public ClassVar(String type,String name,String val,String access) {
		super(type,name,val);
		this.access=access;
	}
    
	public String toString() {
		return this.access+" "+super.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ClassVar) {
			ClassVar a=(ClassVar)o;
			return this.name.equals(a.name);}
		return false;
	}
	
	@Override
	public void generatetree(DefaultMutableTreeNode dmt) {
		dmt.add(new DefaultMutableTreeNode(this.access+" "+this.type+" "+this.name+"="+this.val));}
}
