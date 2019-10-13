package lab4polish;

import javax.swing.tree.DefaultMutableTreeNode;

import lab4polish.Node;
import javax.swing.tree.DefaultMutableTreeNode;
public class TreeVisitor implements PolishVisitor {

	@Override
	public Object visit(SimpleNode node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTSimpleNode "+node.value);
		String s="";
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		System.out.println();
		((DefaultMutableTreeNode) data).add(dmt);
		return s;
	}

	@Override
	public Object visit(ASTStart node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTStart "+node.value);
		String s="";
		if(node.children!=null)
		for(Node n:node.children)
			n.jjtAccept(this, dmt);
		System.out.println();
		((DefaultMutableTreeNode) data).add(dmt);
		return s;
	}

	@Override
	public Object visit(ASTExp node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExp "+node.value);
		String s="";
		if(node.children!=null)
		for(Node n:node.children)
			s+=n.jjtAccept(this, dmt);
		System.out.println();
		((DefaultMutableTreeNode) data).add(dmt);
		return s;
	}

	@Override
	public Object visit(ASTExpp node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTExpp "+node.value);
		String s="";
		if(node.children!=null)
		{s+=node.children[0].jjtAccept(this, dmt);
		if(node.jjtGetValue()!=null)
		s+=node.jjtGetValue();
		for(int i=1;i<node.children.length;i++)
			s+=node.children[i].jjtAccept(this, dmt);
		}
		((DefaultMutableTreeNode) data).add(dmt);
				return data;
	}

	@Override
	public Object visit(ASTTerm node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTTerm "+node.value);
		String s = "";
		if(node.children!=null)
		for(Node n:node.children)
			s+=n.jjtAccept(this, dmt);
		((DefaultMutableTreeNode) data).add(dmt);
		return data;
	}

	@Override
	public Object visit(ASTTermp node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTTermp "+node.value);
		String s = "";
		if(node.children!=null)
		{s+=node.children[0].jjtAccept(this, dmt);
		if(node.jjtGetValue()!=null)
		s+=node.jjtGetValue();
		for(int i=1;i<node.children.length;i++)
			s+=node.children[i].jjtAccept(this, dmt);
		}
		((DefaultMutableTreeNode) data).add(dmt);
				return data;
	}

	@Override
	public Object visit(ASTFactor node, Object data) {
		DefaultMutableTreeNode dmt= new DefaultMutableTreeNode("ASTFactor ");
		String s = "";
		if(node.children!=null)
		{if(node.jjtGetValue()!=null&&((String [])node.jjtGetValue()).length>1)
		 ((DefaultMutableTreeNode) data).add(new DefaultMutableTreeNode(((String [])node.jjtGetValue())[0]));
			
		for(int i=0;i<node.children.length;i++)
			s+=node.children[i].jjtAccept(this, dmt);
		if(node.jjtGetValue()!=null&&((String [])node.jjtGetValue()).length>1)
			((DefaultMutableTreeNode) data).add(new DefaultMutableTreeNode(((String [])node.jjtGetValue())[1]));
		}else
		if(node.jjtGetValue()!=null&&((String [])node.jjtGetValue()).length==1)
			dmt.setUserObject(dmt.getUserObject().toString()+((String [])node.jjtGetValue())[0]);
		((DefaultMutableTreeNode) data).add(dmt);
				return data;
	}

}
