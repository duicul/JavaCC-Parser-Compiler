package domain;

import java.util.ArrayList;
import java.util.List;

public class Class extends Domain {
	public final List<ClassVar> lcv=new ArrayList<ClassVar>();
	public final List<Method> lm=new ArrayList<Method>();
	public final String extend;
	public Class(String name,String extend) {
		this.name=name;
		this.extend=extend;}

	@Override
	public boolean test(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public String toString() {
		String s =this.name+"->"+this.extend+"\n ";
		for(ClassVar cv:lcv)
			s+=cv.toString()+" ";
		s+="\n";
		for(Method m:lm)
			s+=m.toString()+" ";
		s+="\n";
		return s;}
	
	@Override
	public void add(Domain d) {
			if(d instanceof ClassVar) {
				ClassVar a=(ClassVar)d;
				for(ClassVar i:this.lcv)
					if(a.equals(i))
						throw new DomainException("Class attributes "+a+" and "+i+" have the same name");
				lcv.add((ClassVar) d);}
			if(d instanceof Method) {
				Method a=(Method)d;
				for(Method i:this.lm)
					if(a.equals(i))
						throw new DomainException("Methods "+a+" and "+i+" have the same signature");
				lm.add((Method) d);}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Class) {
			Class a=(Class)o;
			return this.name.equals(a.name);}
		return false;
	}
	
	public boolean searchvar(String name) {
		for(ClassVar cv:this.lcv) 
			if(cv.name.equals(name))
				return true;
		return false;
	}

}
