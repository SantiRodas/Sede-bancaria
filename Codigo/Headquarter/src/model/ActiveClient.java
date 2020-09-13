package model;

import java.time.LocalDate;

public class ActiveClient extends Client {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the ActiveClient class
	
	private LocalDate startDate;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the ActiveClient class

	public ActiveClient(String name, String id, LocalDate startDate) {
		
		super(name, id);
		
		this.startDate = startDate;

	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the ActiveClient class

	public LocalDate getStartDate() {
		return startDate;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the ActiveClient class

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	//------------------------------------------------------------------------------------

}
