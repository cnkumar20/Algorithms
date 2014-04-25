package tree;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Path {
	String p;
	public Path() {
		p=null;
	}
	public Path(String ip) {
		p=ip;
	}
	
	public void add(String ip){
		p=ip;
	}

	public List<Queue<String>> processPath() {
		// TODO Auto-generated method stub
		String[] nodes;
		nodes = p.replaceFirst("^/","").split("/");
		List<Queue<String>> pathnodes = new ArrayList<Queue<String>>();
		Queue<String> first = new LinkedList<String>();
		pathnodes.add(first);
		for(String s: nodes) {
			String[] term = s.split("\\|");
			ArrayList<String> t = combination(term);
				int l = pathnodes.size();
					for(int j=0;j<l;j++) {
						int i=0;
						for(i=0;i<t.size()-1;i++) {
							pathnodes.add(clone(pathnodes.get(j),t.get(i)));
						}
						pathnodes.get(j).add(t.get(i));
				}	

				
		}
	//	System.out.println(pathnodes);
	//	System.exit(0);
		return pathnodes;
	}
	
	
	public Queue<String> clone(Queue<String> iq,String st) {
		Queue<String> q = new LinkedList<String>();
		for(String s: iq) {
			q.add(s);
		}
		q.add(st);
		return q;
	}
	
	static ArrayList<String>combination(String[] s) {
		ArrayList<String> input = new ArrayList<String>();
		for(int i=0;i<s.length;i++) {
			String temp = s[i];
			for(int j=i;j<s.length;j++) {
				if(i==j) {
					input.add(temp);
				}
				else {
					temp = temp+"-"+s[j];
					input.add(temp);
				}
			}
		}
		return input;
	}
}
