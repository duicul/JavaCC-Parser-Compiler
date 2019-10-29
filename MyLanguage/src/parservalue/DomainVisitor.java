package parservalue;

import domain.Argument;
import domain.ClassVar;
import domain.Domain;
import domain.DomainTable;
import domain.Method;
import domain.Packet;
import domain.Program;
import domain.Var;

public class DomainVisitor implements MyMiniParserVisitor,MyMiniParserConstants {

	@Override
	public Object visit(SimpleNode node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTProgram node, Object data) {
		DomainTable.instance().add(new Program("Start"));
		DomainTable.instance().add(new Packet((String) node.value));
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		DomainTable.instance().jumpup();
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
	public Object visit(ASTType node, Object data) {
		if("MethodReturn".equals((String)data))
			return node.value;
		if("Argument".equals((String)data)) {
			DomainTable.instance().addtype((String) node.value,null);
		}
		DomainTable.instance().addtype((String) node.value,null);
		return node.value;
	}

	@Override
	public Object visit(ASTStatement node, Object data) {
		Token t=(Token) node.value;
		if(t!=null) {
			if(node.children.length>0) {
			if(t.kind==IF)
				((String[])node.children[0].jjtAccept(this, IF))[0].equals("boolean");
			if(t.kind==WHILE)
				((String[])node.children[0].jjtAccept(this, WHILE))[0].equals("boolean");
		}}
		/*if(node.value!=null) {
			DomainTable.instance().vardefined((String) node.value,null);
		}*/
		return null;
	}

	@Override
	public Object visit(ASTExp node, Object data) {
		Token t=(Token)node.value;
		System.out.println("Token"+t.image+"kind"+t.kind);
		switch(t.kind) {
		case PRINTLN : break;
		case IF:DomainTable.testExpression((String)node.children[0].jjtAccept(this,IF),"boolean"); break;
		}
		String name=(String) node.value;
		//if(name!=null)
		//	DomainTable.instance().typeexists(name);
		return null;
	}

	@Override
	public Object visit(ASTCondition node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpLog node, Object data) {
		Token t=(Token) node.value;
		String s []=new String [2];
		if(data!=null) {
		if(t.kind==TRUE) {
		   s[0]="boolean";
		   s[1]="true";}
		if(t.kind==FALSE){
			   s[0]="boolean";
			   s[1]="true";}
		} 
		else if(node.children!=null) {
			// TODO Implement for non-terminal
			/*String type =  (String) node.children[0].jjtAccept(this, "Argument");
			DomainTable.instance().add(new Argument(type,name));
			DomainTable.instance().jumpup();*/
		}
		return s;
	}

	@Override
	public Object visit(ASTExpLog2 node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTOpLog node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpRel node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTOpRel node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpArm node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpArm2 node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTOpAd node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpTerm node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpTerm2 node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTOpMul node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpFact node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTAccess node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTCall node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTCall2 node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTCallTarget node, Object data) {
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
		String name=(String) node.value;
		if(node.children!=null) {
			String type =  (String) node.children[0].jjtAccept(this, "Argument");
			DomainTable.instance().add(new Argument(type,name));
			DomainTable.instance().jumpup();
		}
		return data;
	}
}
