package tree;
import java.util.List;
import java.util.ArrayList;

public class Node {
	String name;
	List<Node> childNodes = new ArrayList<Node>(); 
	Node(String s) {
		name =s;
	}
}
