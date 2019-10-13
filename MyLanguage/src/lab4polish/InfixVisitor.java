package lab4polish;

public class InfixVisitor implements PolishVisitor {

	@Override
	public Object visit(SimpleNode node, Object data) {
		String s = "";
		if(node.children!=null)
		for(Node n:node.children)
			s+=n.jjtAccept(this, data);
		return s;
	}

	@Override
	public Object visit(ASTStart node, Object data) {
		String s = "";
		if(node.children!=null)
		for(Node n:node.children)
			s+=n.jjtAccept(this, data);
		return s;
	}

	@Override
	public Object visit(ASTExp node, Object data) {
		String s = "";
		if(node.children!=null)
		for(Node n:node.children)
			s+=n.jjtAccept(this, data);
		return s;
	}

	@Override
	public Object visit(ASTExpp node, Object data) {
		String s = "";
		if(node.children!=null)
		{if(node.jjtGetValue()!=null)
		s+=node.jjtGetValue();
		for(int i=0;i<node.children.length;i++)
			s+=node.children[i].jjtAccept(this, data);
		}
				return s;
	}

	@Override
	public Object visit(ASTTerm node, Object data) {
		String s = "";
		if(node.children!=null)
		for(Node n:node.children)
			s+=n.jjtAccept(this, data);
		return s;
	}

	@Override
	public Object visit(ASTTermp node, Object data) {
		String s = "";
		if(node.children!=null)
		{if(node.jjtGetValue()!=null)
		s+=node.jjtGetValue();
		for(int i=0;i<node.children.length;i++)
			s+=node.children[i].jjtAccept(this, data);
		}
				return s;
	}

	@Override
	public Object visit(ASTFactor node, Object data) {
		String s = "";
		if(node.jjtGetValue()!=null&&((String [])node.jjtGetValue()).length>1)
	     return node.children[0].jjtAccept(this, data);
		else
		 return Integer.parseInt(((String [])node.jjtGetValue())[0]);
		
		}

}
