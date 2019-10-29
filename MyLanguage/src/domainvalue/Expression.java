package domainvalue;

import javax.swing.tree.DefaultMutableTreeNode;

public class Expression extends Domain{
	public final Expression l,r;
	public final ExpressionValue val;
	public final String operation;
	
	public Expression(String name,Expression l,Expression r,String op) {
		this.name=name;
		this.l=l;
		this.r=r;
		this.val=null;
		this.operation=op;
	}
	
	public Expression(String name,ExpressionValue val) {
		this.name=name;
		this.l=null;
		this.r=null;
		this.val=val;
		this.operation=null;
	}
	
	@Override
	public boolean test(Domain d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Domain d) throws DomainException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void generatetree(DefaultMutableTreeNode dmt) {
		// TODO Auto-generated method stub
		
	}

}
