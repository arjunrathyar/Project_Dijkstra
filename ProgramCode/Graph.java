import java.util.*;

public class Graph {
	GraphNode[] node;
	int size;

	public Graph(int n) {
		size = n;
		node = new GraphNode[size];
		for(int i=0; i<n; i++) {
			node[i] = new GraphNode(i);
		}
	}
	
	public void addEdge(int from, int to, int w) {
		node[from].adjList.add(node[to]);
		node[to].adjList.add(node[from]);
		node[from].weights.add(w);
		node[to].weights.add(w);
		}
	
	public void print() {
		for(int i=0; i<this.size; i++) {
			System.out.print(i+": ");
			node[i].print();
			System.out.println();
		}
	}
	
	public void reset() {
		for(int i=0; i<size; i++) {
			node[i].visited = false;
			node[i].d = Integer.MAX_VALUE;
			node[i].reset();
		}
	}
	
	public void Dijkstra(int i) {
		reset();
		ArrayDeque<GraphNode> q = new ArrayDeque<GraphNode>();
		q.add(node[i]);
		node[i].visited = true;
		node[i].d = 0;		
		node[i].Dijkstra(q);
	}
	
	public void getCost(int s) {
		Dijkstra(s);
		if(node[size-1].d==Integer.MAX_VALUE) {
			System.out.println("NO PATH EXIST");
			}
		else {
			System.out.println();
			System.out.println("*****************************************************************************************************************************************");
			System.out.println("STATION CODE                  : "+(node[s].label+1));
			System.out.println();
			System.out.println("DESTINATION CODE              : "+(node[size-1].label+1));
			System.out.println();
			System.out.println("MOST EFFICIENT PATH WILL COST : "+(node[size-1].d));
			System.out.println("*****************************************************************************************************************************************");
			//System.out.println("Shortest path from "+(node[s].label+1)+" to "+node[size-1].label+1+": "+node[size-1].d);
			}
		}
	}