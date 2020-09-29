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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import model.Bank;
import javafx.scene.control.Alert.AlertType;

public class ControladoraCrear {
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private Button newAccountButton;

    @FXML
    private RadioButton creditRB;

    @FXML
    private ToggleGroup creador;

    @FXML
    private RadioButton debitRB;
    
    @FXML
    private Label exitLabel;
    
    private Bank bank;
    
    private ControladoraOperations cO;
    
    public ControladoraCrear(ControladoraOperations cO, Bank b) {
    	this.cO = cO;
    	bank = b;
    }
    
    //------------------------------------------------------------------------------------
    
    //Bank method's
    
	public Bank getBank() {
		return bank;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method 1
    
    @FXML
    public void newAccount(ActionEvent event) {
    	
    	if(creditRB.isSelected()) {
    		    		
    		boolean validacion = bank.createCreditCard();
    		
    		if(validacion == true) {
    			
    			bank.createCreditCard();
    			
    			exitLabel.setText("La cuenta se creo correctamente");
    			    			
    			cO.refreshAvailability();
    			    			
    		} else {
    			
    			exitLabel.setText("La cuenta no fue creada");
    			
    		}
    		
    	} else if(debitRB.isSelected()) {
    		
    		boolean validacion = bank.createSavingsAccount();
    		
    		if(validacion== true) {
    			
    			bank.createSavingsAccount();
    			
    			exitLabel.setText("La cuenta se creo correctamente");
    			
    			cO.refreshAvailability();
    		} else {
    			
    			exitLabel.setText("La cuenta no fue creada");
    			
    		}
    		
    	} else {
    		
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Alerta");
	        alert.setHeaderText("Campo vacío");
	        alert.setContentText("Por favor seleccione alguna de las opciones de tarjeta");
	        alert.showAndWait();
    		
    	}

    }

	//------------------------------------------------------------------------------------

}
