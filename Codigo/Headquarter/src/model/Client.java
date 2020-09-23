/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import java.time.LocalDate;

public class Client {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the Client class
	
	private String name;
	private String id;
	private LocalDate birthday;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the Client class
	
	public Client(String name, String id, LocalDate birthday) {

		this.name = name;
		this.id = id;
		this.birthday = birthday;
	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the Client class

	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the Client class

	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	//------------------------------------------------------------------------------------	

}
