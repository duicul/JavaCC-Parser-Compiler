/* Generated By:JJTree: Do not edit this line. ASTOperation2.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

public
class ASTOperation2 extends SimpleNode {
  public ASTOperation2(int id) {
    super(id);
  }

  public ASTOperation2(MyMiniParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyMiniParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=555d3dc98fdddfe94853dc4fd39be2c6 (do not edit this line) */
