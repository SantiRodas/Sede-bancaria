/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import java.time.LocalDate;

public class RemovedClient extends Client {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the RemovedClient class
	
	private LocalDate removalDate;
	private String removalReason;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the RemovedClient class
	
	public RemovedClient(String name, String id, LocalDate removalDate, String removalReason) {
		
		super(name, id);
		
		this.removalDate = removalDate;
		
		this.removalReason = removalReason;

	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the RemovedClient class

	public LocalDate getRemovalDate() {
		return removalDate;
	}
	
	public String getRemovalReason() {
		return removalReason;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the RemovedClient class

	public void setRemovalDate(LocalDate removalDate) {
		this.removalDate = removalDate;
	}
	
	public void setRemovalReason(String removalReason) {
		this.removalReason = removalReason;
	}
	
	//------------------------------------------------------------------------------------

}
