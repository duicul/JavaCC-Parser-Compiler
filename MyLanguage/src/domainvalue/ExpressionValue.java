package domainvalue;

import javax.swing.tree.DefaultMutableTreeNode;

public class ExpressionValue extends Domain {
	public final Object value;
	public final String type;
	
	public ExpressionValue(String name,String type,Object value) {
		this.name=name;
		this.type=type;
		this.value=value;
	}
	
	@Override
	public boolean test(Domain d) {
		// TODO Auto-generated method stub
		return true;
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
