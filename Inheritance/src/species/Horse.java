package species;

public class Horse extends Animal {
	String name;
	String color;
	Horse(String name,String color) {
		super(name,"Horse");
		this.name = name;
		this.color = color;
	}
	
	public void printDetails() {
		System.out.println("Horse Class"+" Name : "+name+" Color: "+color);
	}
}
