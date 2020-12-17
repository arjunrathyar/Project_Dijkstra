import java.util.*;

public class GraphNode {
	
	int label;
	ArrayList<GraphNode> adjList;
	ArrayList<Integer> weights;
	boolean visited;
	public int d;
	
	GraphNode(int l){
		label = l;
		adjList = new ArrayList<GraphNode>();
		weights = new ArrayList<Integer>();
		d = Integer.MAX_VALUE;
	}
	
	public void print() {
		for(int j=0; j<adjList.size(); j++) {
			System.out.print(adjList.get(j).label+"-->");
		}
		System.out.print("null");
	}
	
	public void reset() {
		
		for(int j = 0; j<adjList.size(); j++){
				adjList.get(j).visited = false;
				adjList.get(j).d = Integer.MAX_VALUE;
		}
	}
	
	public void Dijkstra(ArrayDeque<GraphNode> q) {
		while(!q.isEmpty()) {
			GraphNode x = q.remove();
			for(int j=0; j<x.adjList.size(); j++) {
				GraphNode y = x.adjList.get(j);
				int weight = x.weights.get(j);
				if(!y.visited) {
					y.visited = true;
					q.add(y);
					int w = 0;
					if(weight-x.d<0)
						w = 0;
					else
						w = weight-x.d;
					y.d = w+x.d;
					}
				else if (y.visited) {
					int w = 0;
					if(weight-x.d<0) 
						w = 0;
					else
						w = weight-x.d;
					if(y.d>(w+x.d))
						y.d = w+x.d;
					}
				}
			}
		}
	}