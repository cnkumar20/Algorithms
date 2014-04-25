package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ListIterator;
import java.util.Stack;

public class Tree {
	Node rootNode;

	public Tree() {
	}

	public Tree(List<Queue<String>> path) {
		rootNode = insert(path);
	}

	// before inserting traversing through the available path is necessary so we
	// don;t create duplicate files
	// and traverse to the depth until the path is matching and once mismatch of
	// path the node is created at that point

	public Node search(Queue<String> inputpath) {
		Node cur = rootNode;
		String path = inputpath.remove();
		Node prev = cur;
		while (!inputpath.isEmpty() && cur != null) {
			if (cur.name.equals(path)) {
				prev = cur;
				// System.out.print(inputpath);
				cur = checkList(cur.childNodes, inputpath.peek()); // search in
																	// childnode
																	// List
			}
			if (cur == null) {
				return prev;
			}
			path = inputpath.remove();
		}

		if (inputpath.isEmpty()) {
			return cur;
		} else {
			return null;
		}

	}

	// In the childNode list the path term passed is compare to each child of
	// the particular node
	// if its found the reference of the child matched is passed so we can
	// create nodes from there(point).

	private Node checkList(List<Node> listNodes, String path) {
		ListIterator<Node> li = listNodes.listIterator();
		while (li.hasNext()) {
			Node cur = li.next();
			if (cur.name.equals(path)) {
				return cur;
			}
		}
		return null;
	}

	public Node createNode(Queue<String> inputpath) {
		// The if section when root node is null start creating directories from
		// root level

		if (rootNode == null) {
			rootNode = new Node(inputpath.remove());
			Node temp = rootNode;
			while (!inputpath.isEmpty()) {
				Node cur = new Node(inputpath.remove());
				temp.childNodes.add(cur);
				temp = cur;
			}

			return rootNode;
		}
		// when root node is not null, every term is searched level by level and
		// the directory are created only if its not
		// present othervice null is returned if any new path is created then
		// rootNode is returned.
		Node cur = search(inputpath);
		if (!inputpath.isEmpty()) {
			// System.out.println(cur.name);
			while (!inputpath.isEmpty()) {
				String s = inputpath.remove();
				Node prev = cur;
				cur = new Node(s);
				prev.childNodes.add(cur);
			}

		}
		return rootNode;

	}

	public Node insert(List<Queue<String>> paths) {
		Node node = null;
		for (Queue<String> path : paths) {
			node = createNode(path);

		}
		return node;
	}

	public List<Node> createNodeList(List<String> node_names) {
		List<Node> childNodeList = new ArrayList<Node>();
		for (String s : node_names) {
			childNodeList.add(new Node(s));
		}
		return childNodeList;

	}

	// To show print the tree : use BFS (Breadth first search Algorithm)

	public void bfs_print() {
		if (rootNode == null) {
			System.out.println("Null tree");
		}
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.add(rootNode);
		while (!nodeQueue.isEmpty()) {
			// System.out.println("Hello");
			Iterator<Node> i = nodeQueue.iterator();
			while (i.hasNext()) {
				System.out.print(i.next().name);
				System.out.print("	");
			}
			System.out.print("\n");
			int ind = 0;
			int l = nodeQueue.size();
			while (ind < l) {
				// System.out.println(nodeQueue.peek().childNodes.size());
				nodeQueue.addAll(nodeQueue.remove().childNodes);
				ind++;
			}
		}
	}

	// To show the collapsed structure we need to traverse the tree by DFS(Depth
	// First search tree) and compare
	// the nodes at each level from bottom up
	// collect the nodes at each level and compare their children if its same
	// collapse
	// and then print the nodes in the same level separated by |
	// we don't collapse two branch until the child nodes are same
	// if there is more than one branch star from root we check the combination
	// of them if present and above condition satisfies
	// we collapse other print normal structure

	public String collapse() {
		ArrayList<String> collapsed = new ArrayList<String>();
		int depth = 0;
		collapse(rootNode, depth, collapsed);
		StringBuilder builder = new StringBuilder();

		for (String string : collapsed) {
			builder.append(string);
		}
		return builder.toString();
	}

	public void collapse(Node cur, int depth, ArrayList<String> path) {
		Node temp = cur;
		if (temp == null) {
			return;
		}

		// System.out.println(temp.name);
		Iterator<Node> i = temp.childNodes.iterator();
		if (depth >= path.size()) {
			path.add("/" + temp.name.replace("-", "|"));
		} else if (path.get(depth).length() < temp.name.length()) {
			path.set(depth, "/" + temp.name.replace("-", "|"));
		}
		while (i.hasNext()) {

			collapse(i.next(), depth + 1, path);
		}

	}

	public ArrayList<String> similarityDetection(Queue<String> path) {
		Node node = search(path);
		ArrayList<String> leafs = new ArrayList<String>();
		Iterator<Node> itr = node.childNodes.iterator();
		while (itr.hasNext()) {
			leafs.add(itr.next().name);
		}
		ArrayList<String> synonympaths = new ArrayList<String>();
		// System.out.println(leafs);
		dfs(leafs, rootNode, synonympaths, "/");
		return synonympaths;
	}

	// to find synonym using dfs and returning Arraylist of string path
	// constructed:
	// for given path which has same childnodes

	public void dfs(ArrayList<String> leafs, Node initNode,
			ArrayList<String> synonympaths, String synonym) {

		if (initNode == null) {
			return;
		}
		synonym = synonym + initNode.name;
		// System.out.print(compare(initNode,leafs)+synonym+"xxxxx");
		if (compare(initNode, leafs) && !initNode.childNodes.isEmpty()) {
			// System.out.println(initNode.name+"hahahaha");
			synonympaths.add(synonym);
		}

		Iterator<Node> nodeitr = initNode.childNodes.iterator();

		while (nodeitr.hasNext()) {

			dfs(leafs, nodeitr.next(), synonympaths, synonym + "/");

		}
	}

	private boolean compare(Node curNode, ArrayList<String> leafs) {
		boolean found = true;
		Iterator<Node> it = curNode.childNodes.iterator();
		while (it.hasNext()) {
			if (!leafs.contains(it.next().name)
					|| curNode.childNodes.size() != leafs.size()) {
				found = false;
				// System.out.print("Hahahaha"+curNode.childNodes.size()+
				// curNode.childNodes.size()+"Muhahaha");

			}

		}

		return found;
	}

}
