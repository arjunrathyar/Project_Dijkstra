import java.util.*;
import java.io.*;

public class Test {
	private static Scanner in;
	public static void main(String[]args) throws IOException{
		System.out.println("*****************************************************************************************************************************************");
		System.out.println();
		System.out.println("					HELPING VIVEK FIND THE MOST COST EFFICIENT WAY					");
		System.out.println("*****************************************************************************************************************************************");
		in = new Scanner(System.in);
		System.out.println();
		System.out.print("PLEASE ENTER THE PUBLIC TRANSPORT SYSTEM FARE DATASET:           ");
		String s = in.nextLine();
		
		File file = new File(s); 
		
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String line1 = br.readLine();
		String[] str = line1.trim().split(" ");
		int n = Integer.parseInt(str[0]);
		Graph g = new Graph(n);		
		
		 String st; 
		 while ((st = br.readLine())!= null) {
			 String[] a = st.split(" "); 
			 g.addEdge(Integer.parseInt(a[0])-1,Integer.parseInt(a[1])-1,Integer.parseInt(a[2]));
			 }
		 
		 //		g.print();
		 
		 System.out.println();
		 g.getCost(0);
		 }
	}