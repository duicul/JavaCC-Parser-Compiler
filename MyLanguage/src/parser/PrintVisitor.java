package parser;

public class PrintVisitor implements MyMiniParserVisitor{
	@Override
	public Object visit(ASTProgram node, Object data) {
		System.out.println("ASTProgram "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(SimpleNode node, Object data) {
		System.out.println("SimpleNode "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTMainClass node, Object data) {
		System.out.println("ASTMainClass "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTClassDecl node, Object data) {
		System.out.println("ASTClassDecl "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTVarDecl node, Object data) {
		System.out.println("ASTVarDecl "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTMethodDecl node, Object data) {
		System.out.println("ASTMethodDecl "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTFormalList node, Object data) {
		System.out.println("ASTFormalList "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTFormalRest node, Object data) {
		System.out.println("ASTFormalRest "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTStatement node, Object data) {
		System.out.println("ASTStatement "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTExp node, Object data) {
		System.out.println("ASTExp "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTExpList node, Object data) {
		System.out.println("ASTExpList "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTExpRest node, Object data) {
		System.out.println("ASTExpRest "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTOperation node, Object data) {
		System.out.println("ASTOperation "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTType node, Object data) {
		System.out.println("ASTType "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

	@Override
	public Object visit(ASTExpp node, Object data) {
		System.out.println("ASTExpp "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, data);
		System.out.println();
		return data;
	}

}
