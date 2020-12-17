import java.io.*;
import java.util.*;

public class Data {
	private static Scanner mva;
	private static Scanner mea;
	private static Scanner mwa;

	public static void main(String[]args) throws IOException {
		
		mva = new Scanner(System.in);
		mea = new Scanner(System.in);
		mwa = new Scanner(System.in);
		
		int max_vertex,max_edges,max_weight;
		
		System.out.print("Enter the max no. of Vertices: ");
		max_vertex=mva.nextInt();
		System.out.print("Enter the max no. of Edges   : ");
		max_edges=mea.nextInt();
		System.out.print("Enter the max Weight         : ");
		max_weight=mwa.nextInt();
		

		Random rand = new Random(); 
		
		Set<Pair> container  = new HashSet<Pair>();
		int num = 1+ rand.nextInt(max_vertex); 
		int num_edge = 1+rand.nextInt(max_edges); 
		
		while(num_edge> (num*(num-1))/2) 			
			num_edge = 1+rand.nextInt(max_edges); 
		
		for (int j=1; j<=num_edge; j++) {
			int a = 1+ rand.nextInt(num); 
			int b = 1+ rand.nextInt(num); 
			Pair p = new Pair(a,b);
			Pair reverse_p = new Pair(b,a);
			
			while (container.contains(p) || container.contains(reverse_p)){
				a = 1+ rand.nextInt(num); 
				b = 1+ rand.nextInt(num); 
				p = new Pair(a,b);
				reverse_p = new Pair(b,a);
			}
			container.add(p);	
		}
		
		FileWriter file = new FileWriter("dataset.txt"); 
		BufferedWriter output = new BufferedWriter(file);
		
		output.write(Integer.toString(num));
		output.append(" ");
		output.append(Integer.toString(num_edge));
		output.append("\n");
		
		for (Pair value : container) {
			int wt = 1+ rand.nextInt(max_weight);
			//System.out.format("%d %d %d\n", value.get_first(), value.get_second(), wt);
			output.append(Integer.toString(value.get_first()));
			output.append(" ");
			output.append(Integer.toString(value.get_second()));
			output.append(" ");
			output.append(Integer.toString(wt));
			output.append("\n");
		    }
		output.close();
		
		System.out.println();
		System.out.println("**************************************************");
		System.out.println("	File Created Successfully!!!");
		System.out.println("**************************************************");
		
	}

}