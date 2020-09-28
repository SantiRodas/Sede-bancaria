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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import model.Bank;

public class ControladoraPagar {
	
	//------------------------------------------------------------------------------------
	
	//Relations

	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private Button pagarButton;

    @FXML
    private RadioButton efectivoChoice;

    @FXML
    private ToggleGroup pago;

    @FXML
    private RadioButton desdeCuentaChoicen;
    
    @FXML
    private TextField cantidadText;
    
    @FXML
    private TextField numCuenta;

    @FXML
    private Text numCuentTexto;
    
    private String cardNumber;
    
    //------------------------------------------------------------------------------------
    
    //Method set bank
    
    public void setBank(Bank bank) {
    	this.bank = bank;
    }
	
	//------------------------------------------------------------------------------------
    
    //Pay method
    
    @FXML
    public void pagar(ActionEvent event) {
    	
    	if(cantidadText.getText().isEmpty()==false) {
    		
    		 if(efectivoChoice.isSelected()==true || efectivoChoice.isSelected()==true) {
    			 
    			if(efectivoChoice.isSelected()==true) {
    				
    				bank.payCreditCard(cardNumber, Double.parseDouble(cantidadText.getText()));
    				
    			} else { //SI SE VA A PAGAR CON ALGUNA CUENTA
    				
    				numCuentTexto.setVisible(true);
    				
    		    	numCuenta.setVisible(true);
    		    	
    		    	if(numCuenta.getText().isEmpty()==false) {
    		    		
    		    		bank.retrieveSavings(numCuenta.getText(), Double.parseDouble(cantidadText.getText()));
    		    		
    		    		bank.payCreditCard(cardNumber, Double.parseDouble(cantidadText.getText()));
    		    	
    		    	} else {
    		    		
    		    		Alert alert = new Alert(AlertType.INFORMATION);
    		    		alert.setTitle("Alerta");
        	        	alert.setHeaderText("Campo vacío");
        	        	alert.setContentText("Por favor digite el número de cuenta");

        	        	alert.showAndWait();
        	        	
    		    	}
    		    	
    			}
    			
    			bank.saveAction();
    			
    		} else {
    			
    			Alert alert = new Alert(AlertType.INFORMATION);
    	        alert.setTitle("Alerta");
    	        alert.setHeaderText("Campo vacío");
    	        alert.setContentText("Por favor seleccione alguna de las opciones de pago");

    	        alert.showAndWait();
    	        
    		 }
    		 
    	} else {
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Alerta");
        	alert.setHeaderText("Campo vacío");
        	alert.setContentText("Por favor digite el monto que desea pagar");

        	alert.showAndWait();
        	
    	}
    	
    }
    
    //------------------------------------------------------------------------------------
    
    //Method to get data
    
    public void getData(String cardNumber) {
    	this.cardNumber = cardNumber;
    }
	
	//------------------------------------------------------------------------------------
    
    //Method to initialize
    
    @FXML
    void initialize() {
    	numCuentTexto.setVisible(false);
    	numCuenta.setVisible(false);
    }

    //------------------------------------------------------------------------------------

}
