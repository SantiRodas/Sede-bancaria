package model;

public class Client {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the Client class
	
	private String name;
	private String id;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the Client class
	
	public Client(String name, String id) {

		this.name = name;
		this.id = id;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the Client class

	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the Client class

	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	//------------------------------------------------------------------------------------	

}
