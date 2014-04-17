package kth_smallest_2d;
import java.util.ArrayList;
import java.util.Collections;
public class Array2d {
	int[][] input;
	ArrayList<HeapNode> Hn= new ArrayList<HeapNode>();
	
	public void minheapify(int i , int heap_size) {
		int l = i*2+1;
		int r =i*2+2;
		int smallest = i;
	if(l< heap_size && Hn.get(l).val < Hn.get(i).val  ) {
		smallest = l;
		
	}
	if (r< heap_size && Hn.get(r).val < Hn.get(smallest).val  ) {
		smallest = r;
		
	}
	
	if(smallest != i) {
		Collections.swap(Hn, smallest, i);
		minheapify(smallest, heap_size);
	}
	
	}
	
	
	public void buildHeap(int n) {
		int i=(n-1)/2;
		while(i>0) {
			minheapify(i, n);
			i--;
		}
	}
	
	
	public int kthSmallest(int[][] a,int n, int k) {
		
		if(k<=0||k>n*n) {
			
			return Integer.MAX_VALUE;
		}
		
		for(int i=0;i<n;i++) {
			Hn.add(new HeapNode(a[0][i],0,i));
			
		}

		buildHeap(n);
		HeapNode thn = new HeapNode();	

		for(int i=0;i< k;i++) {
			thn=Hn.get(0);
			int nextval = (thn.r < (n-1))?a[thn.r+1][thn.c]: Integer.MAX_VALUE;
			Hn.set(0,new HeapNode(nextval,thn.r+1,thn.c));
			minheapify(0, n);
		}
		return thn.val;	
	}
}