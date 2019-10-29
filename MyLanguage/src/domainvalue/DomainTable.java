package domainvalue;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;


import parser.TreeVisitor;

public class DomainTable {
    private static DomainTable dt=null;
    private Domain current=null;
    private static List<TypeTable> tt;
    private static List<Truple<Domain,DomainException,Domain>> finaltest=new ArrayList<Truple<Domain,DomainException,Domain>>();
 
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
	
	public boolean vardefined(String name,Domain node) {
		Domain cls=node==null?this.current:node;
		if(this.current instanceof Method) {
			cls=current.upper;
			if(((Method)current).searchvar(name))
			return true;}
		if(cls instanceof Class && ((Class)cls).searchvar(name))
			return true;
		throw new DomainException("Variable "+name+" was not defined");		
	}
	
	public boolean jumpup() {
		if(this.current instanceof Packet) {
		 for(Truple<Domain,DomainException,Domain> pdde:DomainTable.finaltest)
			 if(!pdde.t1.test(pdde.t3))
				 throw pdde.t2;}
		if(this.current instanceof Method) {
			Method a=(Method)this.current;
			((Class)this.current.upper).check(a);}
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
	
	public void generatetree() {
		TreeVisitor tv= new TreeVisitor();
		Domain d;
		for(d=this.current;d.upper!=null;d=d.upper);
		DefaultMutableTreeNode dmt = new DefaultMutableTreeNode("Start");
		d.generatetree(dmt);
		JFrame f=new JFrame(); 
		f.add(new JTree(dmt));  
		f.setSize(500,500);  
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void addfinalanalysis(Domain parent,DomainException de,Domain child) {
		this.finaltest.add(new Truple(parent,de,child));
	}
	
}
