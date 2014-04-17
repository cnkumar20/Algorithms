package kth_smallest_2d;

public class HeapNode {
	int val;
	int r;
	int c;
	
	HeapNode(int val,int r, int c) {
		this.val =val;
		this.r = r;
		this.c = c;
	}
	
	HeapNode() {
		r=0;
		val=0;
		c=0;
	}
}
