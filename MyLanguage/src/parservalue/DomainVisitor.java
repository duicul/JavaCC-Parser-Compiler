package parservalue;

import java.awt.image.TileObserver;

import domainvalue.Argument;
import domainvalue.ClassVar;
import domainvalue.Domain;
import domainvalue.DomainTable;
import domainvalue.Method;
import domainvalue.Packet;
import domainvalue.Program;
import domainvalue.Var;
import domainvalue.DomainException;

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
		DomainTable.instance().add(new domainvalue.Class((String) node.value,null));
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, "Class");
		DomainTable.instance().jumpup();
		return data;
	}

	@Override
	public Object visit(ASTClassDecl node, Object data) {
		String [] s=(String[]) node.value;
		DomainTable.instance().add(new domainvalue.Class(s[0],s[1]));
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
		// TODO Removed Type check
		/*Token t=((Token[]) node.value)[0];
		Token t1=((Token[]) node.value)[1];
		if(t!=null) {
			if(node.children.length>0) {
			if(t.kind==IF)
				((String[])node.children[0].jjtAccept(this, t))[0].equals("boolean");
			else if(t.kind==WHILE)
				((String[])node.children[0].jjtAccept(this, t))[0].equals("boolean");
			else if(t.kind==PRINTLN)
			{}
			else if(t.kind==LACCOLADE)
			{}
			else if(t.kind==IDENTIFIER)
			{if(t1.image.equals("="))
			{String id=t.image;
			String exp_type=((String[])node.children[0].jjtAccept(this, t))[0];
			DomainTable.instance().getType(id).equals(exp_type);}
			else if(t1.image.equals("["))
			{String id_type=DomainTable.instance().getType(t.image);
			String ind_type=((String[])node.children[0].jjtAccept(this, t))[0];
			String exp_type=((String[])node.children[1].jjtAccept(this, t))[0];
			boolean ret=ind_type.equals("int")&&exp_type.equals("int")&&id_type.equals("");
				
			}
			}
			}}
        */
		return null;
	}

	@Override
	public Object visit(ASTExp node, Object data) {
		// TODO Removed Type check
		/*Token t=(Token)node.value;
		System.out.println("Token"+t);
		String [] type=(String [])node.children[0].jjtAccept(this,data);
		return type;
		switch(t.kind) {
		case PRINTLN : break;
		case IF:DomainTable.testExpression((String)node.children[0].jjtAccept(this,IF),"boolean"); break;
		}
		String name=(String) node.value;*/
		//if(name!=null)
		//	DomainTable.instance().typeexists(name);
		return null;
	}

	@Override
	public Object visit(ASTCondition node, Object data) {
		// TODO Removed Type check
		/*String[] type=(String []) node.children[0].jjtAccept(this,data);
		if(node.value!=null&&((Token)node.value).image=="!"&&!type.equals("boolean"))
			throw new DomainException("Line "+((Token)node.value).beginLine+": ! needs to be followed by a boolean expression");
		return type;*/
		return null;}

	@Override
	public Object visit(ASTExpLog node, Object data) {
		// TODO Removed Type check
		/*Token t=(Token) node.value;
		String s []=new String [2];
		String[] explog2_type=(String []) node.children[0].jjtAccept(this,data);
		if(explog2_type!=null&&!explog2_type.equals("boolean"))
			throw new DomainException("Line "+t.beginLine+": needs to contain a boolean expression");
		if(data!=null) {
		if(t==null)
		   return node.children[0].jjtAccept(this,data);
		else
		if(t.kind==TRUE) {
		   s[0]="boolean";
		   s[1]="true";}
		else if(t.kind==FALSE){
			   s[0]="boolean";
			   s[1]="true";}
		}
		return s;*/
		return null;}

	@Override
	public Object visit(ASTExpLog2 node, Object data) {
		// TODO Removed Type check
		/*if(node.children.length==0)
			return null;
		String[] exp_reltype=(String[]) node.children[1].jjtAccept(this,data);
		String[] exp_log2type=(String[]) node.children[2].jjtAccept(this,data);
		if(exp_reltype[0].equals("boolean")&&(exp_log2type[0].equals("boolean")||exp_log2type==null)) {
			String[] ret= {"boolean"};
			return ret;}
		throw new DomainException("Line "+((Token)node.value).beginLine+": needs to contain a boolean expression");*/
		return null;}

	@Override
	public Object visit(ASTOpLog node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpRel node, Object data) {
		// TODO Removed Type check
		/*Token t=(Token)node.value;
		if(t!=null&&t.image=="(")
			return node.children[0].jjtAccept(this,data);
		else if(node.children.length==1)
			return node.children[0].jjtAccept(this,data);
		else if(node.children.length==3) {
			String[] exparm1=(String[]) node.children[0].jjtAccept(this,data);
		    String[] exparm2=(String[]) node.children[2].jjtAccept(this,data);
		    if(exparm1[0].equals("int")&&exparm2[0].equals("int")) {
		    	String[] ret={"boolean"};
		    	return ret;}
		throw new DomainException("Line "+((Token)node.value).beginLine+": needs integer expressions");}
		
		throw new DomainException("Line "+((Token)node.value).beginLine+": unknows error");*/
		return null;}

	@Override
	public Object visit(ASTOpRel node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpArm node, Object data) {
		// TODO Removed Type check
		/*String[] exparm2=(String[]) node.children[1].jjtAccept(this,data);
		String[] rettype=(String[]) node.children[0].jjtAccept(this,data);
		if((exparm2!=null&&!exparm2[0].contentEquals("int"))||!rettype[0].equals("int"))
			throw new DomainException("Line "+((Token)node.value).beginLine+": needs integer expressions");
		return rettype;*/
		return null;}

	@Override
	public Object visit(ASTExpArm2 node, Object data) {
		// TODO Removed Type check
		/*if(node.children==null)
			return null;
		String[] expterm=(String[]) node.children[1].jjtAccept(this,data);
		String[] exparm2=(String[]) node.children[2].jjtAccept(this,data);
		if(!expterm[0].equals("int"))
			throw new DomainException("Line "+((Token)node.value).beginLine+": needs integer expressions");
		if(exparm2[0]!=null&&!exparm2[0].equals("int"))
			throw new DomainException("Line "+((Token)node.value).beginLine+": needs integer expressions");
		String[] ret= {"int"};
		return ret;*/
		return null;}

	@Override
	public Object visit(ASTOpAd node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpTerm node, Object data) {
		// TODO Removed Type check
		/*String[] term2=(String[]) node.children[1].jjtAccept(this,data);
		String[] fact=(String[]) node.children[0].jjtAccept(this,data);
		if((term2!=null&&!term2[0].contentEquals("int"))||!fact[0].equals("int"))
			throw new DomainException("Line "+((Token)node.value).beginLine+": needs integer expressions");
		return fact;*/
		return null;}

	@Override
	public Object visit(ASTExpTerm2 node, Object data) {
		// TODO Removed Type check
		/*if(node.children==null)
			return null;
		String[] fact=(String[]) node.children[1].jjtAccept(this,data);
		String[] term2=(String[]) node.children[2].jjtAccept(this,data);
		if(!fact[0].equals("int"))
			throw new DomainException("Line "+((Token)node.value).beginLine+": needs integer expressions");
		if(term2[0]!=null&&!term2[0].equals("int"))
			throw new DomainException("Line "+((Token)node.value).beginLine+": needs integer expressions");
		String[] ret= {"int"};
		return ret;*/
		return null;}

	@Override
	public Object visit(ASTOpMul node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTExpFact node, Object data) {
		// TODO Removed Type check
		/*Token t=(Token) node.value;
		if(t!=null&&t.kind==INTEGER) {
			String[] ret= {"int"};
			return ret;}
		if(t!=null&&t.image.equals("(")) {
			if(!((String[]) node.children[0].jjtAccept(this,data))[0].equals("int"))
               throw new DomainException("Line "+((Token)node.value).beginLine+": needs integer expressions");
			String[] ret= {"int"};
			return ret;}
		return node.children[0].jjtAccept(this,data);*/
		return null;}

	@Override
	public Object visit(ASTAccess node, Object data) {
		// TODO Removed Type check
		/*Token t=(Token) node.value;
		if(t.image.equals("[")) {
			String[] call=(String[]) node.children[0].jjtAccept(this,data);
			String[] arm=(String[]) node.children[1].jjtAccept(this,data);
			if(!call[0].equals("int[]"))
				throw new DomainException("Line "+((Token)node.value).beginLine+": needs an integer array");
			if(!arm[0].equals("int[]"))
				throw new DomainException("Line "+((Token)node.value).beginLine+": needs integer expressions");
			String[] ret= {"int"};
			return ret;}
		return node.children[0].jjtAccept(this,data);*/
		return null;}

	@Override
	public Object visit(ASTCall node, Object data) {
		// TODO Removed Type check
		/*String[] target=(String[]) node.children[0].jjtAccept(this,data);
		String[] call=(String[]) node.children[1].jjtAccept(this,target);
		if(call.length>1&&call[1].equals("length")&&!target[0].equals("int[]"))
			throw new DomainException("Line "+((Token)node.value).beginLine+": needs an integer array");
		if(node.children[1]==null)
			return target;
		else return call;*/
		return null;}

	@Override
	public Object visit(ASTCall2 node, Object data) {
		// TODO Removed Type check
		/*Token t=(Token) node.value;
		if(t.kind==LENGTH) {
		   String[] ret= {"int","length"};
		   return ret;}
		else if(t.kind==IDENTIFIER) {
			if(node.children!=null&&node.children.length==2) {
				String[] explist=(String[]) node.children[0].jjtAccept(this,data);
				String[] call2=(String[]) node.children[1].jjtAccept(this,data);
				if(call2!=null)
					return call2;
				else return null;
			}
			
			
		}*/			
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
		// TODO Removed Type check
		/*String name=(String) node.value;
		if(node.children!=null) {
			String type =  (String) node.children[0].jjtAccept(this, "Argument");
			DomainTable.instance().add(new Argument(type,name));
			DomainTable.instance().jumpup();
		}
		return data;*/
		return null;
	}
}
