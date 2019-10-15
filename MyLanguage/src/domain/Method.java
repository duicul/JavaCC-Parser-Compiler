package domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

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
	public boolean test(Domain d) {
		if(d instanceof Argument) {
			Argument a=(Argument)d;
			for(Argument i:this.lm)
				if(a.equals(i)) {
					DomainException de=new DomainException("Arguments "+a+" and "+i+" have the same name");
					DomainTable.instance().addfinalanalysis(this, de,d);
					return false;
					//throw de;
					}
			return true;}
		if(d instanceof Var) {
			Var a=(Var)d;
			for(Var i:this.lv)
				if(a.equals(i)) {
					DomainException de=new DomainException("Variables "+a+" and "+i+" have the same name");
					DomainTable.instance().addfinalanalysis(this, de,d);
					return false;
					//throw de
					}
			return true;}
		return false;
	}
	
	@Override
	public boolean add(Domain d) throws DomainException {
		if(d instanceof Argument) {
			Argument a=(Argument)d;
			for(Argument i:this.lm)
				if(a.equals(i)) {
					DomainException de=new DomainException("Arguments "+a+" and "+i+" have the same name");
					DomainTable.instance().addfinalanalysis(this, de,d);
					return false;
					//throw de;
				}
				lm.add((Argument) d);
			return true;}
		if(d instanceof Var) {
			Var a=(Var)d;
			for(Var i:this.lv)
				if(a.equals(i)) {
					DomainException de=new DomainException("Variables "+a+" and "+i+" have the same name");
					DomainTable.instance().addfinalanalysis(this, de,d);
					return false;
					//throw de;
				}
			lv.add((Var) d);
			return true;}
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Method) {
			Method a=(Method)o;
			if(!a.name.equals(this.name))
				return false;
			int cnt=0;
			if(this.lm.size()!=a.lm.size()) {
				System.out.println("\n"+this.lm.size()+" "+a.lm.size());
				return false;}
			for(int i=0;i<this.lm.size();i++) 
				if(this.lm.get(i).match(a.lm.get(i))) 
					cnt++;
			if(cnt==this.lm.size())
				return true;
			}
		return false;
	}
	
	public String signature() {
		String s=this.access+" "+this.name;
		for(Argument a:this.lm)
			s+=" "+a.toString();
		return s;
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

	@Override
	public void generatetree(DefaultMutableTreeNode dmt) {
		DefaultMutableTreeNode dmt1=new DefaultMutableTreeNode("Method "+ this.name);
		dmt.add(dmt1);
		DefaultMutableTreeNode dmt2=new DefaultMutableTreeNode("Arguments");
		DefaultMutableTreeNode dmt3=new DefaultMutableTreeNode("Variables");
		dmt1.add(dmt2);
		dmt1.add(dmt3);
		for(Argument a:this.lm)
			a.generatetree(dmt2);
		for(Var v:this.lv)
			v.generatetree(dmt3);		
	}
}
