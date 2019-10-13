package lab4polish;

public class PrefixVisitor implements PolishVisitor {

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
		{ Object o = node.children[0].jjtAccept(this, data);
		  s += node.children[1].jjtAccept(this, o);
		}
			return s;
	}

	@Override
	public Object visit(ASTExpp node, Object data) {
		String s = "";
		
		if(node.jjtGetValue()!=null)
		{s+=node.jjtGetValue();
		s+=data;
		if(node.children!=null)
		{ Object o = node.children[0].jjtAccept(this, data);
		  s += node.children[1].jjtAccept(this, o);
		}
		}
				return s;
	}

	@Override
	public Object visit(ASTTerm node, Object data) {
		String s = "";
		if(node.children!=null)
		{ Object o = node.children[0].jjtAccept(this, data);
		  s += node.children[1].jjtAccept(this, o);
		}
			return s;
	}

	@Override
	public Object visit(ASTTermp node, Object data) {
		String s = "";
		
		
		if(node.jjtGetValue()!=null)
		{s+=node.jjtGetValue();
		s+=data;
		if(node.children!=null)
		{ Object o = node.children[0].jjtAccept(this, data);
		  s += node.children[1].jjtAccept(this, o);
		}
		}
				return s;
	}

	@Override
	public Object visit(ASTFactor node, Object data) {
		String s = "";
		if(node.children!=null)
		{if(node.jjtGetValue()!=null&&((String [])node.jjtGetValue()).length>1)
		s+=((String [])node.jjtGetValue())[0];
		s+=node.children[0].jjtAccept(this, data);
		for(int i=1;i<node.children.length;i++)
			s+=node.children[i].jjtAccept(this, data);
		if(node.jjtGetValue()!=null&&((String [])node.jjtGetValue()).length>1)
			s+=((String [])node.jjtGetValue())[1];
		}else
		if(node.jjtGetValue()!=null&&((String [])node.jjtGetValue()).length==1)
			s+=((String [])node.jjtGetValue())[0];
				return s;
	}

}
