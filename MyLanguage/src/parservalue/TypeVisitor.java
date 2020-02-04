package parservalue;

import domainvalue.DomainTable;
import domainvalue.DomainException;

public class TypeVisitor implements MyMiniParserVisitor,MyMiniParserConstants {
	private String current_class=null;
	@Override
	public Object visit(SimpleNode node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ASTProgram node, Object data) {
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		return data;
	}

	@Override
	public Object visit(ASTMainClass node, Object data) {
		this.current_class=(String) node.value;
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, "Class");
		return data;
	}

	@Override
	public Object visit(ASTClassDecl node, Object data) {
		this.current_class=((String[]) node.value)[0];
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, "Class");
		return data;
	}

	@Override
	public Object visit(ASTVarDecl node, Object data) {
		if(node.children!=null) {
			node.children[0].jjtAccept(this, data);
			if(node.children.length>1)
				node.children[1].jjtAccept(this, data);}
		return data;}

	@Override
	public Object visit(ASTMethodDecl node, Object data) {
		if(node.children!=null) {
			node.children[0].jjtAccept(this, "MethodReturn");
			for(int i=1;i<node.children.length;i++)
				node.children[i].jjtAccept(this, "Method");}
		return data;}

	@Override
	public Object visit(ASTFormalList node, Object data) {
		if(node.children!=null) {
			node.children[0].jjtAccept(this, data);
			for(int i=1;i<node.children.length;i++)
				node.children[i].jjtAccept(this, "Argument");}
		return data;}

	@Override
	public Object visit(ASTFormalRest node, Object data) {
		if(node.children!=null) {
			node.children[0].jjtAccept(this, "Argument");}
		return data;}

	@Override
	public Object visit(ASTType node, Object data) {
		return node.value;}

	@Override
	public Object visit(ASTStatement node, Object data) {
		Token[] t=((Token[]) node.value);
		if(t!=null&&t[0]!=null) {
			if(node.children!=null&&node.children.length>0) {
				if(t[0].kind==IF) {
					if(!((String[])node.children[0].jjtAccept(this, t))[0].equals("boolean"))
						throw new DomainException("Line "+t[0].beginLine+": IF instruction needs a boolean expression");
					node.children[1].jjtAccept(this, t);}
				else if(t[0].kind==WHILE) {
					if(!((String[])node.children[0].jjtAccept(this, t))[0].equals("boolean"))
						throw new DomainException("Line "+t[0].beginLine+": WHILE instruction needs a boolean expression");
					node.children[1].jjtAccept(this, t);}
				else if(t[0].kind==PRINTLN){
					if(node.children.length>0) {
						String exp_type=((String[])node.children[0].jjtAccept(this, t))[0];
						if(!"String".equals(exp_type))
							throw new DomainException("Line "+t[0].beginLine+": an expression of type "+exp_type+" is used. A String expression is needed");
					}
				}
				else if(t[0].kind==LACCOLADE){
					if(node.children.length>0)
						node.children[0].jjtAccept(this, t);}
				else if(t[0].kind==IDENTIFIER){
					if(t[1].image.equals("=")){
						String id=t[0].image;
						String exp_type=((String[])node.children[0].jjtAccept(this, t))[0];
						DomainTable dt=DomainTable.instance();
						String id_type=dt.getType(id, this.current_class);
						if(!DomainTable.instance().issuperClass(id_type,exp_type))
							throw new DomainException("Line "+t[0].beginLine+": variable "+id_type+" "+id+" needs to be assigned a subclass of "+id_type+". It is assigned a variable of type: "+exp_type);
					}
					else if(t[1].image.equals("[")){
						String id_type=DomainTable.instance().getType(t[0].image,this.current_class);
						String ind_type=((String[])node.children[0].jjtAccept(this, t))[0];
						String exp_type=((String[])node.children[1].jjtAccept(this, t))[0];
						if(!id_type.equals("int[]"))
							throw new DomainException("Line "+t[0].beginLine+": needs an integer array ");
						if(!ind_type.equals("int"))
							throw new DomainException("Line "+t[0].beginLine+": index should be of type integer ");
						if(!exp_type.equals("int"))
							throw new DomainException("Line "+t[0].beginLine+": integer array has to assign an integer ");
					}
				}
			}
		}
		return null;
	}

	@Override
	public Object visit(ASTExp node, Object data) {
		Token t=(Token)node.value;
		System.out.println("Token"+t);
		String [] type=(String [])node.children[0].jjtAccept(this,data);
		return type;
	}

	@Override
	public Object visit(ASTCondition node, Object data) {
		String[] type=(String []) node.children[0].jjtAccept(this,data);
		if(node.value!=null&&((Token)node.value).image=="!"&&!type.equals("boolean"))
			throw new DomainException("Line "+node.firstToken.beginLine+": ! needs to be followed by a boolean expression");
		return type;
	}

	@Override
	public Object visit(ASTExpLog node, Object data) {
		Token t=(Token) node.value;
		String s []=new String [2];
		String[] explog2_type=(String []) node.children[node.children.length-1].jjtAccept(this,data);//last child
		if(explog2_type==null) {
				if(t!=null) {
						if(t.kind==TRUE) {
							s[0]="boolean";
							s[1]="true";
							return s;}
						else if(t.kind==FALSE){
							s[0]="boolean";
							s[1]="true";
							return s;}
				}
				else if(node.children!=null)
					return node.children[0].jjtAccept(this,data);
				else throw new DomainException("Line "+t.beginLine+": expression not given");
			}
		if(explog2_type!=null)
			if(!explog2_type[0].equals("boolean"))
				throw new DomainException("Needs to contain a boolean expression");
			else {String[] ret= {"boolean"};
				  return ret;}
		throw new DomainException("Line "+t.beginLine+": state unknown");
		}

	@Override
	public Object visit(ASTExpLog2 node, Object data) {
		if(node.children==null)
			return null;
		String[] exp_reltype=(String[]) node.children[1].jjtAccept(this,data);
		String[] exp_log2type=(String[]) node.children[2].jjtAccept(this,data);
		if(exp_reltype[0].equals("boolean")&&(exp_log2type[0].equals("boolean")||exp_log2type==null)) {
			String[] ret= {"boolean"};
			return ret;}
		throw new DomainException("Line "+node.firstToken.beginLine+": needs to contain a boolean expression");
	}

	@Override
	public Object visit(ASTOpLog node, Object data) {
		return null;
	}

	@Override
	public Object visit(ASTExpRel node, Object data) {
		Token t=(Token)node.value;
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
		throw new DomainException("Line "+node.firstToken.beginLine+": needs integer expressions");}
		throw new DomainException("Line "+node.firstToken.beginLine+": unknows error");
	}

	@Override
	public Object visit(ASTOpRel node, Object data) {
		return null;
	}

	@Override
	public Object visit(ASTExpArm node, Object data) {
		String[] exparm2=(String[]) node.children[1].jjtAccept(this,data);
		String[] rettype=(String[]) node.children[0].jjtAccept(this,data);
		if(exparm2!=null&&(!exparm2[0].contentEquals("int")||(rettype!=null&&!rettype[0].equals("int"))))
			throw new DomainException("Line "+node.firstToken.beginLine+": needs integer expressions");
		return rettype;
	}

	@Override
	public Object visit(ASTExpArm2 node, Object data) {
		if(node.children==null)
			return null;
		String[] expterm=(String[]) node.children[1].jjtAccept(this,data);
		String[] exparm2=(String[]) node.children[2].jjtAccept(this,data);
		if(!expterm[0].equals("int"))
			throw new DomainException("Line "+node.firstToken.beginLine+": needs integer expressions. Change the "+expterm[0]+" expression");
		if(exparm2!=null&&exparm2[0]!=null&&!exparm2[0].equals("int"))
			throw new DomainException("Line "+node.firstToken.beginLine+": needs integer expressions. Change the "+exparm2+" expression");
		String[] ret= {"int"};
		return ret;
	}

	@Override
	public Object visit(ASTOpAd node, Object data) {
		return null;
	}

	@Override
	public Object visit(ASTExpTerm node, Object data) {
		String[] term2=(String[]) node.children[1].jjtAccept(this,data);
		String[] fact=(String[]) node.children[0].jjtAccept(this,data);
		if(term2!=null&&(!term2[0].contentEquals("int")||(fact!=null&&!fact[0].equals("int"))))
			throw new DomainException("Line "+node.firstToken.beginLine+": needs integer expressions");
		return fact;
	}

	@Override
	public Object visit(ASTExpTerm2 node, Object data) {
		if(node.children==null)
			return null;
		String[] fact=(String[]) node.children[1].jjtAccept(this,data);
		String[] term2=(String[]) node.children[2].jjtAccept(this,data);
		if(!fact[0].equals("int"))
			throw new DomainException("Line "+node.firstToken.beginLine+": needs integer expressions");
		if(term2[0]!=null&&!term2[0].equals("int"))
			throw new DomainException("Line "+node.firstToken.beginLine+": needs integer expressions");
		String[] ret= {"int"};
		return ret;
	}

	@Override
	public Object visit(ASTOpMul node, Object data) {
		return null;
	}

	@Override
	public Object visit(ASTExpFact node, Object data) {
		Token t=(Token) node.value;
		if(t!=null&&t.kind==INTEGER) {
			String[] ret= {"int"};
			return ret;}
		if(t!=null&&t.kind==LITERAL) {
			String[] ret= {"String"};
			return ret;}
		if(t!=null&&t.image.equals("(")) {
			if(!((String[]) node.children[0].jjtAccept(this,data))[0].equals("int"))
               throw new DomainException("Line "+node.firstToken.beginLine+": needs integer expressions");
			String[] ret= {"int"};
			return ret;}
		return node.children[0].jjtAccept(this,data);
	}

	@Override
	public Object visit(ASTAccess node, Object data) {
		Token t=(Token) node.value;
		if(t!=null&&t.image.equals("[")) {
			String[] call=(String[]) node.children[0].jjtAccept(this,data);
			String[] arm=(String[]) node.children[1].jjtAccept(this,data);
			if(!call[0].equals("int[]"))
				throw new DomainException("Line "+node.firstToken.beginLine+": needs an integer array");
			if(arm!=null&&!arm[0].equals("int"))
				throw new DomainException("Line "+node.firstToken.beginLine+": needs integer expressions");
			String[] ret= {"int"};
			return ret;}
		return node.children[0].jjtAccept(this,data);
	}

	@Override
	public Object visit(ASTCall node, Object data) {
		String[] target=(String[]) node.children[0].jjtAccept(this,data);
		String[] call=(String[]) node.children[1].jjtAccept(this,target);
		if(call!=null&&call.length>1&&call[1].equals("length")&&!target[0].equals("int[]"))
			throw new DomainException("Line "+node.firstToken.beginLine+": needs an integer array");
		if(call==null)
			return target;
		else return call;}

	@Override
	public Object visit(ASTCall2 node, Object data) {
		Token t=(Token) node.value;
		String[] target=(String[]) data;
		if(t!=null)
		if(t.kind==LENGTH) {
		   String[] ret= {"int","length"};
		   return ret;}
		else if(t.kind==IDENTIFIER) {
			if(node.children!=null&&node.children.length==2) {
				String[] explist=(String[]) node.children[0].jjtAccept(this,data);
				String[] call2=(String[]) node.children[1].jjtAccept(this,data);
				if(call2!=null)
					return call2;
				else return DomainTable.instance().methodType(t.image,target[1]);
			}
		}
		return null;}

	@Override
	public Object visit(ASTCallTarget node, Object data) {
		Token tarray[]=(Token []) node.value;
		if(tarray[0].kind==NEW){
			if(tarray[1].kind==INT) {
				String [] s=(String[]) node.children[0].jjtAccept(this,data);
				if(s==null||!s[0].equals("int"))
					throw new DomainException("Line "+node.firstToken.beginLine+": needs an integer index");
				return s;
			}
			else if(tarray[1].kind==IDENTIFIER) {
				String [] ret= {tarray[1].image};
				return ret;}
			throw new DomainException("Line "+node.firstToken.beginLine+": Unknown");
		}
		else if(tarray[0].kind==IDENTIFIER) {
			String s[]= {DomainTable.instance().getType(tarray[0].image,this.current_class)};
			return s;}
		else if(tarray[0].kind==THIS) {
			if(this.current_class==null)
				new DomainException("Line "+node.firstToken.beginLine+": this used outside of a class");
			String s[]= {this.current_class};
			return s;//DomainTable.instance().getType(this.current_class,this.current_class);
			}
		throw new DomainException("Line "+node.firstToken.beginLine+": Unknown state");
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
		}
		return data;
	}

}
