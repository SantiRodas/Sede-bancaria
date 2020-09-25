/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import model.Bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ControladoraAdd {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
	@FXML
    private TextField nameText;

    @FXML
    private TextField idText;

    @FXML
    private Button addButton;

    @FXML
    private DatePicker bornDate;
    
    //------------------------------------------------------------------------------------
    
    //Add method

    @FXML
    public void addClient(ActionEvent event) {

    }

	public void setBank(Bank bank) {
		this.bank = bank;
		
	}
    
    //------------------------------------------------------------------------------------

}
