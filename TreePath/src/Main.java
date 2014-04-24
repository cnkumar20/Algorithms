import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tree.Path;
import tree.Tree;



public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			Tree tree = new Tree();
			System.out.println("Enter the Path");
			int i=0;
			while(i!=4) {
				read();
				i = Integer.parseInt(enterOptions());
				if(i==1) {
					String path = readPath();
					Path ip = new Path(path);
					//System.out.print(ip.processPath());
					tree.insert(ip.processPath());
					tree.bfs_print();   //prints by breadth first search in the tree
				}
				else if(i==2) {
					tree.collapse();    // print by dfs , the ones in the same level are separated by | while printing
				}
				else if(i==3) {
					tree.similarityDetection(); 
					
				}
				else {
					System.exit(0);
				}
			}
	}
	
	public static String readPath() throws IOException {
		System.out.println("Enter Path");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
	public static String enterOptions() throws IOException {
		System.out.println("Enter Option by the number given");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
	public static void read() {
		System.out.println("1: Give Path to insert");
		System.out.println("2: Collapse");
		System.out.println("3: Subtree Detection");
		System.out.println("4: Exit");
	}

}
