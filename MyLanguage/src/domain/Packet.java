package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Packet extends Domain {
	List<Class> lc = new ArrayList<Class>();
	public Packet(String name) {
		this.name=name;
	}
		
	@Override
	public boolean test(Domain d) {
		if(d instanceof Class)
		{ Class c=(Class)d;
		if(Packet.listcontain(this.lc, c.name)==null)
			return false;
		if(Packet.listcontain(this.lc, c.extend)==null)
			return false;
		
		for(Class cl : lc) {
			Class auxc=cl;
			List<Class> aux=new LinkedList<Class>();
			while(auxc!=null) {
				if(Packet.listcontain(aux, auxc.extend)!=null) {
					String s="";
					for(Class cir:aux)
						s+="->"+cir.name;
					DomainException de= new DomainException(auxc.name+s+" contains a circular inheritance hierarchy");
					//return false;
					throw de;
					//return false;
					}
				auxc=Packet.listcontain(this.lc, auxc.extend);
				aux.add(auxc);
				if(auxc==null)
					break;
			}
		}
		}
			return true;
	}
	
	public static Class listcontain(List<Class> lc,Class c) {
		return Packet.listcontain(lc,c.name);}
	
	public static Class listcontain(List<Class> lc,String name) {
		for(Class cls:lc)
			if(cls.equals(name)) 
				return cls;
		return null;}
	
	public String toString() {
		String s =this.name+" ";
		for(Class c:lc)
			s+=c.toString()+"\n ";
		return s;}
	
	public boolean testclass(Class c_match) {
		if(Packet.listcontain(this.lc, c_match.extend)==null&&c_match.extend!=null) {
			/*for(Class cin:this.lc)
				if(cin.name.equals(c_current.extend)) {
					if(cin.name.equals(c_match.name)) {
						DomainException de= new DomainException(c_match+" contains a circular inheritance hierarchy");
						DomainTable.instance().addfinalanalysis(this, de,c_match);
						//return false;
						throw de;
					}
					this.testclass(c_match,cin);
					return true;}*/
			DomainException de= new DomainException("Superclass "+c_match.extend+" is not defined");
			DomainTable.instance().addfinalanalysis(this, de,c_match);
			//throw de;
		}
		return false;
		
	}
	
	@Override
	public boolean add(Domain d) {
		boolean ret=false;
		if(d instanceof Class) {
			ret=this.testclass((Class)d);
		for(Class c:this.lc)
			if(c.equals(d)) {
				DomainException de= new DomainException("Classes "+d+" and "+c+" have the same name");
				DomainTable.instance().addfinalanalysis(this, de,d);
				return false;
				//throw de;
			}
		this.lc.add((Class)d);}
		return ret;
	}
	@Override
	public void generatetree(DefaultMutableTreeNode dmt) {
		DefaultMutableTreeNode dmt1=new DefaultMutableTreeNode("Package: "+this.name);
		dmt.add(dmt1);
		for(Class c:this.lc)
			c.generatetree(dmt1);
		
	}
		
}
