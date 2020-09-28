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
    	
    	if(consignarText.getText().isEmpty()==false) {
    		
    		bank.addSavings(cardNumber, Double.parseDouble(consignarText.getText()));
    		bank.saveAction();
    		
    	} else {
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Alerta");
        	alert.setHeaderText("Campo vacío");
        	alert.setContentText("Por favor digite el monto que desea consignar");

        	alert.showAndWait();
        	
    	}
    	
    }
    
	//------------------------------------------------------------------------------------
    
    //Method get data

	public void getData(String cardNumber) {
		this.cardNumber = cardNumber;
	}
    
	//------------------------------------------------------------------------------------

}
