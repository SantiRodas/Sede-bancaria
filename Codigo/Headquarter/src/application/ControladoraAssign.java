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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladoraAssign {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
	@FXML
    private TextField idText;

    @FXML
    private Button asignButton;

    @FXML
    private Label lineLabel;
    
    //------------------------------------------------------------------------------------
    
    //Method assign

    @FXML
    public void asignClient(ActionEvent event) {

    }

	public void setBank(Bank bank) {
		this.bank = bank;
		
	}
    
  //------------------------------------------------------------------------------------

}
