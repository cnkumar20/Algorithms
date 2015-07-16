package species;

public class Animal {
	String name;
	String type;
	
	Animal(String n, String t) {
		name =n;
		type = t;
	}
	
	public void printDetails() {
		System.out.println("Animal Class"+ " Name : "+ name + " Type : " + type);
	}

}