package domain;

import java.util.ArrayList;
import java.util.List;

public class DomainTable {
    private static DomainTable dt=null;
    private Domain current=null;
    private static List<TypeTable> tt;
	private DomainTable() {
    }
	
	public static DomainTable instance() {
		if(dt==null) {
			dt=new DomainTable();
			tt=new ArrayList<TypeTable>();}
		return dt;
	}
	
	public void add(Domain d) throws DomainException {
		if(this.current==null)
			this.current=d;
		else {d.upper=this.current;
			this.current.add(d);
			this.current=d;}
		}
	
	public void addtype(String name,String method_arg) {
		Domain d=this.current,i;
		String method=null;
		for(i=this.current;i!=null&&!(i instanceof Class);d=i,i=i.upper) {
			if(i instanceof Method/*&&method_arg==null*/)
				method=i.name;}
		if(i==null)
			if(!(d instanceof Class))
				throw new DomainException(name+" is defined outside of a class");
		/*if(method_arg!=null) 
			method=method_arg;*/
		this.tt.add(new TypeTable(name,i.name,method));}
	
	public boolean typeexists(String name) {
		Domain d=this.current,i;
		String method=null;
		for(i=this.current;i!=null&&!(i instanceof Class);d=i,i=i.upper) {
			if(i instanceof Method)
				method=i.name;}
		if(i==null)
			if(!(d instanceof Class))
				throw new DomainException(name+" is used outside of a class");
		TypeTable tti =new TypeTable(name,i.name,method);
		for(TypeTable t:this.tt)
			if(tti.equals(t))
				return true;
		throw new DomainException(name+" was not defined previously");
		//return false;
		}
	
	public boolean vardefined(String name) {
		Domain cls=this.current;
		if(this.current instanceof Method) {
			cls=current.upper;
			if(((Method)current).searchvar(name))
			return true;}
		if(cls instanceof Class && ((Class)cls).searchvar(name))
			return true;
		throw new DomainException("Variable "+name+" was not defined");		
	}
	
	public boolean jumpup() {
		if(this.current.upper==null)
			return false;
		this.current=this.current.upper;
		return true;
	}
	
	public String toString() {
	Domain d=this.current;
	String s="";
	for(Domain i=this.current;i!=null;d=i,i=i.upper);
	for(TypeTable t:this.tt)
		s+=t.toString();
	return d.toString()+"\n"+s;
	}
	
}
