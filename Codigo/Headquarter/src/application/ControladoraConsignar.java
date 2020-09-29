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
	private ControladoraOperations controladoraOperations;
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private TextField consignarText;

    @FXML
    private Button consignarButton;
    
    //------------------------------------------------------------------------------------
    
    public ControladoraConsignar(ControladoraOperations cO, Bank b) {
		bank = b;
		controladoraOperations = cO;
	}
    
	//------------------------------------------------------------------------------------
    
    //Give money method
	
    @FXML
    public void consignar(ActionEvent event) {
    	
    	String amountText =  consignarText.getText();
    	String accountNumber = controladoraOperations.getCurrentCardsSelection();
    	
    	if(!amountText.isEmpty()) {
    		    		
    		try {
    			double amount =Double.parseDouble(consignarText.getText());
    			
    			if(amount < 0) {
    				throw new NumberFormatException("Negative Number");
    			}
    			if(accountNumber != null && !accountNumber.isEmpty()) {
	    			boolean success = bank.addSavings(accountNumber, amount );
	    			
	    			if(success) {
	    				bank.saveAction();
	    				bank.saveAction();
						Alert alert = new Alert(AlertType.INFORMATION);
	                	alert.setTitle("Alerta");
	                	alert.setHeaderText("La operacion que ha solicitado fue realizada exitosamente");
	                	alert.setContentText("El nuevo de saldo de su cuenta es de: $" + bank.getCurrentActiveClient().getBalanceFromSavingsAccount(accountNumber));
	
	                	alert.showAndWait();
	    			}       
	    			else {
	    				Alert alert = new Alert(AlertType.ERROR);
	                	alert.setTitle("Alerta");
	                	alert.setHeaderText("La operacion que ha solicitado no fue realizada");
	                	alert.setContentText("Por razones desconocidas su consignacion no fue proceda, por favor contacte al administrador de sistemas!");
	
	                	alert.showAndWait();
	    			}
    			}
    			else {
    				Alert alert = new Alert(AlertType.ERROR);
                	alert.setTitle("Alerta");
                	alert.setHeaderText("No hay una seleccion cuenta de ahorros");
                	alert.setContentText("Por favor verifique que ha seleccionado una cuenta de ahorros!");

                	alert.showAndWait(); 
    			}
        		
    		}
    		catch(NumberFormatException ex) {
    			Alert alert = new Alert(AlertType.ERROR);
            	alert.setTitle("Alerta");
            	alert.setHeaderText("La cantidad de dinero ingresada no es valida");
            	alert.setContentText("Por favor verifique que el valor indicado en el campo sea una cantidad de dinero valida!");

            	alert.showAndWait();
    		}
    		    		    		
    		
    		
    	} else {
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Alerta");
        	alert.setHeaderText("Campo vacío");
        	alert.setContentText("Por favor digite el monto que desea consignar");

        	alert.showAndWait();
        	
    	}
    	
    }
    
	//------------------------------------------------------------------------------------

}
