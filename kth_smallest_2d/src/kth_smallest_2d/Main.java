package kth_smallest_2d;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { {10, 20, 30, 40},
                 {15, 25, 35, 45},
                 {25, 29, 37, 48},
                 {32, 33, 39, 50},
               };
		//System.out.print(mat[1][1]);
		//System.exit(0);
		Array2d operation = new Array2d();
		System.out.println(operation.kthSmallest(mat, 4,7));
	}

}
