package tree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ListIterator;

public class Tree {
	Node rootNode;
	public Tree() {}
	public Tree(List<Queue<String>> path) {
		rootNode = insert(path);
	}
	
	
	//before inserting traversing through the available path is necessary so we don;t create duplicate files
	// and traverse to the depth until the path is matching and once mismatch of path the node is created at that point
	
	public Node search(Queue<String> inputpath) {
		Node cur= rootNode;
		String path = inputpath.remove();
		Node prev = cur;
		while(!inputpath.isEmpty() && cur != null) {
			if(cur.name.equals(path)) {
				prev=cur;	
				cur = checkList(cur.childNodes,inputpath.peek());    //search in childnode List
			}
			if(cur==null) {
				return prev;
			}
			path = inputpath.remove();
		}	

		if(inputpath.isEmpty()) {
			return cur;
		}
		else {
			return null;
		}
		
	}
	//In the childNode list the path term passed is compare to each child of the particular node
	//if its found the reference of the child matched is passed so we can create nodes from there(point).
	
	private Node checkList(List<Node> listNodes, String path) {
		ListIterator<Node> li = listNodes.listIterator();
		while(li.hasNext()) {
			Node cur = li.next();
			if(cur.name.equals(path)) {
				return cur;
			}
		}
		return null;
	}
	
	
	public Node createNode(Queue<String> inputpath) {
		//The if section when root node is null start creating directories from root level
		
		if(rootNode== null) {
			rootNode = new Node(inputpath.remove());
			Node temp = rootNode;
			while(!inputpath.isEmpty()) {
				Node cur = new Node(inputpath.remove());
				temp.childNodes.add(cur);
				temp = cur;
			}
			
			return rootNode;
		}
		//when root node is not null, every term is searched level by level and the directory are created only if its not 
		//present othervice null is returned if any new path is created then rootNode is returned. 
		Node cur = search(inputpath);
		if(!inputpath.isEmpty()) {
			while(!inputpath.isEmpty()) {
			String s = inputpath.remove();
			cur.childNodes.add(new Node(s));
			}
			
		}
		return rootNode;
		
	}
	

	public Node insert(List<Queue<String>> paths) {
		Node node = null;
		for(Queue<String> path: paths) {
			node=createNode(path);
		}
		return node;
	}
	
	public List<Node> createNodeList(List<String>node_names) {
		List<Node> childNodeList = new ArrayList<Node>();
		for(String s: node_names) {
			childNodeList.add(new Node(s));
		}
		return childNodeList;
		
	}
	
	//To show print the tree : use BFS (Breadth first search Algorithm)
	
	public void bfs_print() {
		if(rootNode==null) {
			System.out.println("Null tree");
		}
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.add(rootNode);
		while(!nodeQueue.isEmpty()) {
			//System.out.println("Hello");
			Iterator<Node> i = nodeQueue.iterator();
				while(i.hasNext()) {
					System.out.print(i.next().name);
					System.out.print("	");
			}
				System.out.print("\n");
			int ind=0;	
			int l = nodeQueue.size();
			while(ind<l) {	
				nodeQueue.addAll(nodeQueue.remove().childNodes);
				ind++;
			}
		}	
	}
	
	//To show the collapsed structute we need to travers the tree by DFS(Depth First search tree)
	//and then print the nodes in the same level seperated by |
	
	public void collapse() {
	}
	public void similarityDetection() {
		// TODO Auto-generated method stub
		
	}

	
	
}
