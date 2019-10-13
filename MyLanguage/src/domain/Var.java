package domain;

public class Var extends Domain {
    protected String name,val,type;
	public Var(String type,String name,String val) {
		this.type=type;
		this.name=name;
		this.val=val;
	}

	@Override
	public boolean test(String name) {
		return true;
	}

	@Override
	public void add(Domain d) {
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

}
