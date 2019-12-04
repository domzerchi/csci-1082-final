package finalproject;

public class Driver {
	public static void main(String[] args) {
	
		/**
		 * Launch the application.
		 */
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GuiSearch window = new GuiSearch();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		Item gso = new Item("Poecilotheria Metallica");
		gso.setNote("This Old World tarantula is the only known blue species of the Poecilotheria genus.");
		
		gso.setType("Tarantula");
		
		gso.addTag(new Tag("Old World"));
		gso.addTag(new Tag("Arachnid"));
		gso.addTag(new Tag("Ornamental"));
		gso.addTag(new Tag("Blue"));
		
		System.out.println(gso.toString());
		System.out.println("\n");
		
		Collection bugs = new Collection();
		bugs.addItem(gso);
		
		System.out.println(bugs.toString());
		
	}
}
