package a_star_search;

public class MainTest {
	 public static void main(String[] args) { 
		    Map map = new Map(); 
		    AStar aStar = new AStar(); 
		    map.ShowMap(); 
		    aStar.search(map); 
		    aStar.showPath(aStar.close, map);
		    System.out.println("============================="); 
		    System.out.println("����A*�㷨�����"); 
		    System.out.println("============================="); 
		    map.ShowMap();  
	 } 
}
