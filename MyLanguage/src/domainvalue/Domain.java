package domainvalue;

import javax.swing.tree.DefaultMutableTreeNode;

public abstract class Domain {
protected String name;
protected Domain upper=null;
public abstract boolean test(Domain d);
public boolean equalname(String name) {
	return this.name==name;
}
public abstract boolean add(Domain d) throws DomainException;
public abstract void generatetree(DefaultMutableTreeNode dmt);
public static boolean isprimitive(String s) {
	return s.equals("int")||s.equals("float")||s.equals("long")||s.equals("double")||s.equals("String");
}
}
