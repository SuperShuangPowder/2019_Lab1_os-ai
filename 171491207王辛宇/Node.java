package a_star_search;


public class Node {
	  private int x; //x���� 
	  private int y; //y���� 
	  private String value;  //��ʾ�ڵ��ֵ 
	  private double FValue = 0; //Fֵ 
	  private double GValue = 0; //Gֵ 
	  private double HValue = 0; //Hֵ 
	  private boolean Reachable; //�Ƿ�ɵ����ΪҪ�ڵ�ͼ�����ñ߽����ϰ�� 
	  private Node PNode;   //���ڵ� 
	   
	  public Node(int x, int y, String value, boolean reachable) { 
	    super(); 
	    this.x = x; 
	    this.y = y; 
	    this.value = value; 
	    Reachable = reachable; 
	  } 
	   
		  public Node() {
			super(); 
			this.value="x";

		  }
	 
	  public int getX() { 
	    return x; 
	  } 
	  public void setX(int x) { 
	    this.x = x; 
	  } 
	  public int getY() { 
	    return y; 
	  } 
	  public void setY(int y) { 
	    this.y = y; 
	  } 
	  public String getValue() { 
	    return value; 
	  } 
	  public void setValue(String value) { 
	    this.value = value; 
	  } 
	  public double getFValue() { 
	    return FValue; 
	  } 
	  public void setFValue(double fValue) { 
	    FValue = fValue; 
	  } 
	  public double getGValue() { 
	    return GValue; 
	  } 
	  public void setGValue(double gValue) { 
	    GValue = gValue; 
	  } 
	  public double getHValue() { 
	    return HValue; 
	  } 
	  public void setHValue(double hValue) { 
	    HValue = hValue; 
	  } 
	  public boolean isReachable() { 
	    return Reachable; 
	  } 
	  public void setReachable(boolean reachable) { 
	    Reachable = reachable; 
	  } 
	  public Node getPNode() { 
	    return PNode; 
	  } 
	  public void setPNode(Node pNode) { 
	    PNode = pNode; 
	  }   
}
