package domain;

import javax.swing.tree.DefaultMutableTreeNode;

public class Condition extends Domain {
	public final Expression e;
	
	public Condition(String name,Expression e) {
		this.name=name;
		this.e=e;
	}
	
	@Override
	public boolean test(Domain d) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean add(Domain d) throws DomainException {
		return false;
	}

	@Override
	public void generatetree(DefaultMutableTreeNode dmt) {
		// TODO Auto-generated method stub

	}

}
