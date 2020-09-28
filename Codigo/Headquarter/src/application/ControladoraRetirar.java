/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    
    //Method set bank
	
  	public void setBank(Bank bank) {
  		this.bank = bank;
  	}
  	
	//------------------------------------------------------------------------------------
  	
  	//Method to get data
  	
  	public void getData(String cn) {
  		cardNumber = cn;
  	}
	
	//------------------------------------------------------------------------------------
    
    //Take money method
    
    @FXML
    public void retirar(ActionEvent event) {
    	
    	if(retirarText.getText().isEmpty()==false) {
    		
    		boolean x = bank.retrieveCredit(cardNumber, Double.parseDouble(retirarText.getText()));
    		
    		if(x==false) {
    			
    			bank.retrieveSavings(cardNumber, Double.parseDouble(retirarText.getText()));
    			
    		}
    		
    		bank.saveAction();
    		
    	} else {
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Alerta");
        	alert.setHeaderText("Campo vacío");
        	alert.setContentText("Por favor ingrese el monto que desea retirar");

        	alert.showAndWait();
        	
    	}
    	
    }
	
	//------------------------------------------------------------------------------------

}
