package domainvalue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Class extends Domain {
	public final List<ClassVar> lcv=new ArrayList<ClassVar>();
	public final List<Method> lm=new ArrayList<Method>();
	public final String extend;
	public Class(String name,String extend) {
		this.name=name;
		this.extend=extend;}

	@Override
	public boolean test(Domain d) {
		if(d instanceof ClassVar) {
			ClassVar a=(ClassVar)d;
			for(ClassVar i:this.lcv)
				if(a.equals(i)) 
					return false;}
		if(d instanceof Method) 
			if(this.check((Method)d))
			return true;
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
	public boolean add(Domain d) {
			if(d instanceof ClassVar) {
				ClassVar a=(ClassVar)d;
				if(!Packet.isprimitive(a.type)) {
					Domain dom=this;
					for(dom=this;dom.upper!=null&&!(dom instanceof Packet);dom=dom.upper);
					if((dom instanceof Packet)&&Packet.listcontain(((Packet)dom).lc,a.type)==null) {
							DomainException de=new DomainException("Class "+a.type+" is not defined");
						    DomainTable.instance().addfinalanalysis(a, de,null);
						    lcv.add((ClassVar) d);
						    return false;}
				}
					
				for(ClassVar i:this.lcv)
					if(a.equals(i)) {
						DomainException e=new DomainException("Class attributes "+a+" and "+i+" have the same name");
						DomainTable.instance().addfinalanalysis(this,e,d );
						lcv.add((ClassVar) d);
						return false;
						//throw e;
					}
				lcv.add((ClassVar) d);}
			if(d instanceof Method) {
				Method a=(Method)d;
				for(Method m:this.lm)
					if(m.equals(a))
						return false;
				lm.add((Method) d);
				return true;}
			return false;
	}
	
	public boolean check(Method a) {
		int cnt=0;
		Method q=null;
		for(Method i:this.lm)
			if(a.equals(i)) {
				cnt++;q=i;
			}
		if(cnt!=1) {
			DomainException de=new DomainException("Methods "+((Method)a).signature()+" and "+((Method)q).signature()+" have the same signature");
			DomainTable.instance().addfinalanalysis(this, de,a);
			return false;
			//throw de;
		}
	return true;
	}
	
	public void remove(Method m) {
		this.lm.remove(m);}
	
	@Override
	public boolean equals(Object o) {
		String nameaux;
		if(o instanceof String) {
			nameaux=(String)o;
			return this.name.equals(nameaux);}
		if(o instanceof Class) {
			nameaux=((Class)o).name;
			return this.name.equals(nameaux);}
		return false;
	}
	
	public boolean searchvar(String name) {
		for(ClassVar cv:this.lcv) 
			if(cv.name.equals(name))
				return true;
		return false;
	}

	@Override
	public void generatetree(DefaultMutableTreeNode dmt) {
		DefaultMutableTreeNode dmt1=new DefaultMutableTreeNode("Class "+ this.name+"->"+this.extend);
		dmt.add(dmt1);
		DefaultMutableTreeNode dmt2=new DefaultMutableTreeNode("Methods");
		DefaultMutableTreeNode dmt3=new DefaultMutableTreeNode("Class Variables");
		dmt1.add(dmt2);
		dmt1.add(dmt3);
		for(Method m:this.lm)
			m.generatetree(dmt2);
		for(ClassVar cv:this.lcv)
			cv.generatetree(dmt3);
		
	}

}
