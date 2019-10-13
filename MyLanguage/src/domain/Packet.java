package domain;

import java.util.ArrayList;
import java.util.List;

public class Packet extends Domain {
	List<Class> lc = new ArrayList<Class>();
	public Packet(String name) {
		this.name=name;
	}
	@Override
	public boolean test(String name) {
		for(Class c : lc)
			if(c.equalname(name))
				return false;
		return true;
	}
	
	public String toString() {
		String s =this.name+" ";
		for(Class c:lc)
			s+=c.toString()+"\n ";
		return s;}
	
	public void testclass(Class c_match,Class c_current) {
		if(c_current.extend!=null) {
			for(Class cin:this.lc)
				if(cin.name.equals(c_current.extend)) {
					if(cin.name.equals(c_match.name))
						throw new DomainException(c_match+" contains a circular inheritance hierarchy");
					this.testclass(c_match,cin);
					return;}
			throw new DomainException("Superclass "+c_current.extend+" is not defined");
		}
		
	}
	
	@Override
	public void add(Domain d) {
		if(d instanceof Class) {
			this.testclass((Class)d,(Class)d);
		for(Class c:this.lc)
			if(c.equals(d))
				throw new DomainException("Classes "+d+" and "+c+" have the same name");
		this.lc.add((Class)d);}}

}
