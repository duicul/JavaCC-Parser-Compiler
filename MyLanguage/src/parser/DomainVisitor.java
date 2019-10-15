package parser;

import domain.Argument;
import domain.ClassVar;
import domain.Domain;
import domain.DomainTable;
import domain.Method;
import domain.Packet;
import domain.Var;

public class DomainVisitor implements MyMiniParserVisitor {

	public DomainVisitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object visit(SimpleNode node, Object data) {
		return data;
	}

	@Override
	public Object visit(ASTProgram node, Object data) {
		DomainTable.instance().add(new Packet((String) node.value));
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		DomainTable.instance().jumpup();
		return data;
	}

	@Override
	public Object visit(ASTMainClass node, Object data) {
		DomainTable.instance().add(new domain.Class((String) node.value,null));
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, "Class");
		DomainTable.instance().jumpup();
		return data;
	}

	@Override
	public Object visit(ASTClassDecl node, Object data) {
		String [] s=(String[]) node.value;
		DomainTable.instance().add(new domain.Class(s[0],s[1]));
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, "Class");
		DomainTable.instance().jumpup();
		return data;
	}

	@Override
	public Object visit(ASTVarDecl node, Object data) {
		String name=(String) node.value;
		if(node.children!=null) {
			Object o= node.children[0].jjtAccept(this, data),o1 = null;
			if(node.children.length>1)
				o1= node.children[1].jjtAccept(this, data);
			Domain d=null;
			if("Class".equals((String)data))
				d=new ClassVar((String)o,name,(String)o1,"package");
			else if("Argument".equals((String)data))
				d=new Argument((String)o,name);
			else if("Method".equals((String)data))
				d=new Var(o.toString(),(String) node.value,(String)o1);
			if(d!=null) {
				DomainTable.instance().add(d);
				DomainTable.instance().jumpup();}
		}
		
		return data;
	}

	@Override
	public Object visit(ASTMethodDecl node, Object data) {
		String name=(String) node.value;
		if(node.children!=null) {
			String type =  (String) node.children[0].jjtAccept(this, "MethodReturn");
			DomainTable.instance().add(new Method(name,type,"public"));
			for(int i=1;i<node.children.length;i++)
				node.children[i].jjtAccept(this, "Method");
			DomainTable.instance().jumpup();
			
		}
		return data;
	}

	@Override
	public Object visit(ASTFormalList node, Object data) {
		String name=(String) node.value;
		if(node.children!=null) {
			String type =  (String) node.children[0].jjtAccept(this, data);
			DomainTable.instance().add(new Argument(type,name));
			DomainTable.instance().jumpup();
			for(int i=1;i<node.children.length;i++)
				node.children[i].jjtAccept(this, "Argument");
			
		}
		return data;
	}

	@Override
	public Object visit(ASTFormalRest node, Object data) {
		String name=(String) node.value;
		if(node.children!=null) {
			String type =  (String) node.children[0].jjtAccept(this, "Argument");
			DomainTable.instance().add(new Argument(type,name));
			DomainTable.instance().jumpup();
		}
		return data;
	}

	@Override
	public Object visit(ASTStatement node, Object data) {
		if(node.value!=null) {
			DomainTable.instance().vardefined((String) node.value,null);
		}
		return null;
	}

	@Override
	public Object visit(ASTExp node, Object data) {
		String name=(String) node.value;
		/*if(name!=null)
			DomainTable.instance().typeexists(name);*/
		return null;
	}

	@Override
	public Object visit(ASTExpp node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpList node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpRest node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTOperation node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTType node, Object data) {
			if("MethodReturn".equals((String)data))
				return node.value;
			if("Argument".equals((String)data)) {
				DomainTable.instance().addtype((String) node.value,null);
			}
			DomainTable.instance().addtype((String) node.value,null);
			return node.value;
	}

}
