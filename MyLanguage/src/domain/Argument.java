package domain;

public class Argument extends Domain {
	protected String name,type;
	public Argument(String type,String name) {
		this.type=type;
		this.name=name;}

	@Override
	public boolean test(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(Domain d) {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		return this.type+" "+this.name;}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Argument) {
			Argument a=(Argument)o;
			return this.name.equals(a.name);}
		return false;
	}
	
	public boolean match(Object o) {
		if(o instanceof Argument) {
			Argument a=(Argument)o;
			return this.type.equals(a.type);}
		return false;
	}
}
