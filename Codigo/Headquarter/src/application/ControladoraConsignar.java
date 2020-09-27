/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Bank;

public class ControladoraConsignar {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private TextField consignarText;

    @FXML
    private Button consignarButton;
    
    private String cardNumber;
    
  //------------------------------------------------------------------------------------
    
    public void setBank(Bank bank) {
    	this.bank = bank;
    }
    
	//------------------------------------------------------------------------------------
    
    //Give money method
	
    @FXML
    public void consignar(ActionEvent event) {
    	bank.addSavings(cardNumber, Double.parseDouble(consignarText.getText()));
    	bank.saveAction();
    }

	public void getData(String cardNumber) {
		this.cardNumber = cardNumber;
	}
    
	//------------------------------------------------------------------------------------

}
