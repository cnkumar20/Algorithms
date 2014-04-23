package container;
public class Node<T>{
	T data;
	Node<T> left;
	Node<T> right;
	Node(T d) {
		data =d;
		left=null;
		right=null;
	}
}
