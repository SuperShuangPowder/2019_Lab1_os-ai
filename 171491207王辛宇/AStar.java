package a_star_search;
import java.util.*;
public class AStar {
	/** 
	   * ʹ��ArrayList������Ϊ�������б��͡��ر��б� 
	   * �����б�װ����һ����Ҫ�ߵĽ�㣬���ر��б�װ���Ѿ��������Ľ��
	   */
		ArrayList<Node> open = new ArrayList<Node>();
		ArrayList<Node> close = new ArrayList<Node>();
	
		
		
		public double getHValue(Node currentNode,Node endNode){
			return (Math.abs(currentNode.getX() - endNode.getX()) + 
					Math.abs(currentNode.getY() - endNode.getY()))*10;
		}

		public double getGValue(Node currentNode){
			if(currentNode.getPNode()!=null){//����ǰ�ڵ��и��ڵ���
				if(currentNode.getX()==currentNode.getPNode().getX()||
						currentNode.getY()==currentNode.getPNode().getY()){//ˮƽλ��
					//�жϵ�ǰ�ڵ����丸�ڵ�֮���λ�ù�ϵ��ˮƽ���Խ��ߣ� 
					return currentNode.getGValue()+10;//�Խ���λ��
				}
				return currentNode.getGValue()+14;
			}
			return currentNode.getGValue();
		}

		public double getFValue(Node currentNode){
			return currentNode.getGValue()+currentNode.getHValue();
		}
		//�������뿪���б�
		public void inOpen(Node node,Map map){
			int x = node.getX();
			int y = node.getY();
			for (int i = 0;i<3;i++){
				for (int j = 0;j<3;j++){
					//�ж�����Ϊ���ڵ�Ϊ�ɵ���ģ��������ϰ�����ڹر��б��У�
					//�����б��в�����������ѡ�нڵ� 
					if(map.getMap()[x-1+i][y-1+j].isReachable()&&
							 !open.contains(map.getMap()[x-1+i][y-1+j])&&!(x==(x-1+i)&&y==(y-1+j))){
						map.getMap()[x-1+i][y-1+j].setPNode(map.getMap()[x][y]);
						//��ѡ�нڵ���Ϊ���ڵ� 
						map.getMap()[x-1+i][y-1+j].setGValue(getGValue(map.getMap()[x-1+i][y-1+j]));
						map.getMap()[x-1+i][y-1+j].
						setHValue(getHValue(map.getMap()[x-1+i][y-1+j],map.getEndNode()));
						map.getMap()[x-1+i][y-1+j].setFValue(getFValue(map.getMap()[x-1+i][y-1+j]));
						open.add(map.getMap()[x-1+i][y-1+j]);//��úϸ���fghֵ���ѵ�����open�б�
					}
				}
			}
		}
		//����һ��������Ľ�����ð������
		public void sort(ArrayList<Node> arr){
			for (int i = 0;i<arr.size()-1;i++){
				for (int j = i+1;j<arr.size();j++){
					if(arr.get(i).getFValue() > arr.get(j).getFValue()){
						Node tmp = new Node();
						tmp = arr.get(i);
						arr.set(i, arr.get(j));
						arr.set(j, tmp);
					}
				}
			}
		}
		//��������ر��б�
		public void inClose(Node node,ArrayList<Node> open){
			if(open.contains(node)){//���open���к��иõ�
				node.setReachable(false);
				//����Ϊ���ɴ� 
				open.remove(node);
				close.add(node);
			}
		}
		public void search(Map map){
			//����㼰�����Χ�Ľڵ���в��� 
			inOpen(map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()],map);
			//��һ���������A
			close.add(map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()]);
			//�����A����close��
			map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()].setReachable(false);
			map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()].
			setPNode(map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()]);
			sort(open);
			//�ظ����� 
			do{
				inOpen(open.get(0), map);
				inClose(open.get(0), open);
				sort(open);
			}
			while(!open.contains(map.getMap()[map.getEndNode().getX()][map.getEndNode().getY()]));
			//֪�������б��а����յ�Bʱ���˳�ѭ��
			inClose(map.getMap()[map.getEndNode().getX()][map.getEndNode().getY()], open);
			//�����������close��
			showPath(close,map);
		}
		//��·����ʾ�����ĺ���
		public void showPath(ArrayList<Node> arr,Map map) {
			if(arr.size()>0){
				for(int i=0;i<arr.size();i++) {
					arr.get(i).setValue("x");
				}
			}
		}
}