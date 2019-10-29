package parservalue;
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
	public Object visit(ASTType node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTType "+node.value);
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
	public Object visit(ASTCondition node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTCondition "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpLog node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpLog "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpLog2 node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpLog2 "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTOpLog node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTOpLog "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpRel node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpRel "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTOpRel node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTOpRel "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpArm node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpArm "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpArm2 node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpArm2 "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTOpAd node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTOpAd "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpTerm node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpTerm "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpTerm2 node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpTerm2 "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTOpMul node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTOpMul "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTExpFact node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpFact "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTAccess node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTAccess "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTCall node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTCall "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTCall2 node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTCall2 "+node.value);
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTCallTarget node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTCallTarget "+node.value);
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
}
