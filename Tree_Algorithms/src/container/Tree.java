package container;

import sort.objcompare;

public class Tree<T>{
	Node<T>  hnode;
    public Tree() {
		hnode=null;
	}

	public Tree(T d) {
		hnode = new Node<T>(d);
	}

	public boolean addNode(T idata) {
		objcompare<T> cmp = new objcompare<T>();	
		if(hnode==null) {
			hnode = new Node<T>(idata);
			return true;
		}
		Node<T> temp = hnode;
		Node<T> prev = temp;
		while(temp !=null) {
			if(cmp.compare(temp.data,idata)==-1) {
				prev = temp;
				temp = temp.right;
			}
			else {
				prev = temp;
				temp = temp.left;
			}
		} 
		
		if(cmp.compare(prev.data,idata)==-1) {
			prev.right = new Node<T>(idata);
		}
		else {
			prev.left = new Node<T>(idata);	
		}
		
		return true;
		
	}
	
	public void print(String ord) {
		if(ord.equals("inorder")) {
		print_tree_inorder(hnode);
		}
		else if(ord.equals("preorder")) {
			print_tree_preorder(hnode);
		}
		else {
			print_tree_postorder(hnode);
		}
	}
	
	private void print_tree_preorder(Node<T> t) {
		if(t==null) {
			return;
		}
		System.out.println(t.data);	
		print_tree_preorder(t.left);
		print_tree_preorder(t.right);
	}
	
	private void print_tree_inorder(Node<T> t) {
		if(t==null) {
			return;
		}
		print_tree_inorder(t.left);
		System.out.println(t.data);	
		print_tree_inorder(t.right);
	}
	
	private void print_tree_postorder(Node<T> t) {
		if(t==null) {
			return;
		}

		print_tree_postorder(t.left);
		print_tree_postorder(t.right);
		System.out.println(t.data);	
		
	}
	
}
