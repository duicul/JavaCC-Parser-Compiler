package domainvalue;

public class TypeTable {
	private String name,class_parent,method;
	public TypeTable(String name,String class_parent,String method) {
		this.name=name;
		this.class_parent=class_parent;
		this.method=method;
	}
	
	public boolean equals(Object o) {
		if(o instanceof TypeTable)
			if(this.method!=null&&this.method.equals(((TypeTable)o).method))
			return ((TypeTable)o).name.equals(this.name)&&((TypeTable)o).class_parent.equals(this.class_parent);
		return false;}
	
	public String toString() {
		return this.class_parent+" "+this.method+" "+this.name+"\n";
	}
}
