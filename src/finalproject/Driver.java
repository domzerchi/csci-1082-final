package finalproject;

public class Driver {
	public static void main(String[] args) {
	
		Item gso = new Item("Poecilotheria Metallica");
		gso.setNote("This Old World tarantula is the only known blue species of the Poecilotheria genus.");
		
		System.out.println(gso.toString());
		
		gso.setType("Tarantula");
		
		System.out.println(gso.toString());
		
		gso.addTag(new Tag("Old World"));
		gso.addTag(new Tag("Arachnid"));
		gso.addTag(new Tag("Ornamental"));
		gso.addTag(new Tag("Blue"));
		
		System.out.println(gso.toString());
		
	}
}
