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

public class ControladoraRetirar {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private TextField retirarText;

    @FXML
    private Button retirarButton;
    
    private String cardNumber;
    
    //------------------------------------------------------------------------------------
	
  	public void setBank(Bank bank) {
  		this.bank = bank;
  	}
  	
	//------------------------------------------------------------------------------------
  	
  	public void getData(String cn) {
  		cardNumber = cn;
  	}
	
	//------------------------------------------------------------------------------------
    
    //Take money method
    
    @FXML
    public void retirar(ActionEvent event) {
    	boolean x = bank.retrieveCredit(cardNumber, Double.parseDouble(retirarText.getText()));
    	if(x==false) {
    		bank.retrieveSavings(cardNumber, Double.parseDouble(retirarText.getText()));
    	}
    	bank.saveAction();
    }
	
	//------------------------------------------------------------------------------------

}
