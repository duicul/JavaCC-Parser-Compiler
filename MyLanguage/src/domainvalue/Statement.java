package domainvalue;

import javax.swing.tree.DefaultMutableTreeNode;

public class Statement extends Domain {
	public final Condition c;
	private Statement s=null;
	
	public Statement(String name,Condition c) {
		this.name=name;
		this.c=c;}
	
	@Override
	public boolean test(Domain d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Domain d) throws DomainException {
		if(d instanceof Statement) {
			this.s=(Statement)d;
			return true;
		}
		return false;
	}

	@Override
	public void generatetree(DefaultMutableTreeNode dmt) {
		// TODO Auto-generated method stub

	}

}
