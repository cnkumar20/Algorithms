import container.Tree;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Tree<Integer> tr = new Tree<Integer>(1);
		 tr.addNode(3);
		 tr.addNode(2);
		 tr.addNode(4);
		 tr.addNode(5);
		 //tr.addNode(8);
		 tr.print("postorder");
	}

}
