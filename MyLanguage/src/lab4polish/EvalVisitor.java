package lab4polish;

public class EvalVisitor implements PolishVisitor {

	@Override
	public Object visit(SimpleNode node, Object data) {
			return node.children[0].jjtAccept(this, data);
	}

	@Override
	public Object visit(ASTStart node, Object data) {
			return node.children[0].jjtAccept(this, data);
	}

	@Override
	public Object visit(ASTExp node, Object data) {
           Object o = node.children[0].jjtAccept(this, data);
		   return node.children[1].jjtAccept(this, o);
		  
	}

	@Override
	public Object visit(ASTExpp node, Object data) {
		if(node.jjtGetValue()!=null&&node.jjtGetValue()=="+")
		{if(node.children!=null)
		{ Object o = (Integer)data +(Integer) node.children[0].jjtAccept(this, data);
		  return node.children[1].jjtAccept(this, o);
		}
		}
				return data;
	}

	@Override
	public Object visit(ASTTerm node, Object data) {
		   Object o = node.children[0].jjtAccept(this, data);
		   return node.children[1].jjtAccept(this, o);
	}

	@Override
	public Object visit(ASTTermp node, Object data) {
		if(node.jjtGetValue()!=null&&node.jjtGetValue()=="*")
		{if(node.children!=null)
		{ Object o = (Integer)data * (Integer) node.children[0].jjtAccept(this, data);
		  return node.children[1].jjtAccept(this, o);
		}
		}
				return data;
	}

	@Override
	public Object visit(ASTFactor node, Object data) {
		if(node.children!=null&&((String [])node.jjtGetValue()).length>1)
		    return node.children[0].jjtAccept(this, data);
		else
			return Integer.parseInt(((String [])node.jjtGetValue())[0]);
	}
}
