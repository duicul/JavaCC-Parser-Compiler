package parser;
import javax.swing.tree.DefaultMutableTreeNode;
public class TreeVisitor implements MyMiniParserVisitor {

	@Override
	public Object visit(SimpleNode node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTProgram "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTProgram node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTProgram "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTMainClass node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTMainClass "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTClassDecl node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTClassDecl "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTVarDecl node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTVarDecl "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTMethodDecl node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTMethodDecl "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTFormalList node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTFormalList "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTFormalRest node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTFormalRest "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTStatement node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTStatement "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExp node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExp "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpp node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpp "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpList node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpList "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpRest node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpRest "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTOperation node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTOperation "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTType node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTType "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

}
