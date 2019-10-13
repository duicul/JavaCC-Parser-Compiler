package domain;

import java.util.ArrayList;
import java.util.List;

public class Method extends Domain {
	private String val,access;
	private List<Argument> lm=new ArrayList<Argument>();
	private List<Var> lv=new ArrayList<Var>();
	public Method(String name,String val,String access) {
		this.name=name;
		this.val=val;
		this.access=access==null?"package":access;
	}

	@Override
	public boolean test(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void add(Domain d) throws DomainException {
		if(d instanceof Argument) {
			Argument a=(Argument)d;
			for(Argument i:this.lm)
				if(a.equals(i))
					throw new DomainException("Arguments "+a+" and "+i+" have the same name");
			lm.add((Argument) d);}
		if(d instanceof Var) {
			Var a=(Var)d;
			for(Var i:this.lv)
				if(a.equals(i))
					throw new DomainException("Variables "+a+" and "+i+" have the same name");
			lv.add((Var) d);}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Method) {
			Method a=(Method)o;
			if(!a.name.equals(this.name))
				return false;
			int cnt=0;
			if(this.lm.size()!=a.lm.size())
				return false;
			for(Argument a1:this.lm)
				for(Argument a2:a.lm)
					if(a1.match(a2)) {
						cnt++;break;}
			if(cnt==this.lm.size())
				return true;
			}
		return false;
	}
	
	public String toString() {
		String s=this.access+" "+this.val+" "+this.name;
		for(Argument a:this.lm)
			s+=" "+a.toString();
		for(Var v:this.lv)
			s+=" "+v.toString();
		s+="\n";
		return s;}
	
	public boolean searchvar(String name) {
		for(Var v:this.lv)
			if(v.name.equals(name))
				return true;
		for(Argument a:this.lm)
			if(a.name.equals(name))
				return true;
		return false;
	}
}
