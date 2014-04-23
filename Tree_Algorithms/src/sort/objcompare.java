package sort;
import java.util.Comparator;
public class objcompare<T> implements Comparator<T>{
	int a;
	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		if(o1 instanceof Integer) {
			int a = (Integer)o1;
			int b = (Integer)o2;
			return intCompare(a,b);
		}
		if(o1 instanceof String) {
			String a = (String)o1;
			String b = (String)o2;
			return intCompare(a,b);
		}
		
		return 0;
	}
	
	private int intCompare(int a,int b) {
		if(a<b) {
			return -1;
		}
		else if(a>b){
			return 1;
		}
		else {
			return 0;
		}
	}
	
	private int intCompare(String a,String b) {
		return a.compareToIgnoreCase(b);
		
	}

}
