package finalproject;

public class Driver {
	public static void main(String[] args) {
	
		Item gso = new Item("Poecilotheria Metallica");
		gso.setNote("This Old World tarantula is the only known blue species of the Poecilotheria genus.");
		
		System.out.println(gso.toString());
		
		gso.setType("Tarantula");
		
		System.out.println(gso.toString());
		
		gso.addTag(new Tag("Halloween"));
		gso.addTag(new Tag("Spider"));
		
		System.out.println(gso.toString());
		
	}
}
