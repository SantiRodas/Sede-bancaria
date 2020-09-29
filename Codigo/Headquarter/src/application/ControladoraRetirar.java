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
	
	private ControladoraOperations controladoraOperations;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private TextField retirarText;

    @FXML
    private Button retirarButton;
    
    public ControladoraRetirar(ControladoraOperations cO, Bank b) {
    	controladoraOperations = cO;
    	bank = b;
    }
  		
	//------------------------------------------------------------------------------------
    
    //Take money method
    
    @FXML
    public void retirar(ActionEvent event) {
    	
    	if(!retirarText.getText().isEmpty()) {
    		
    		try {
    			
    			double amount = Double.parseDouble(retirarText.getText());    		
    			String selectedAccount = controladoraOperations.getCurrentCardsSelection();
    			
    			if(amount < 0) {
    				throw new NumberFormatException("Negative Number");
    			}
    			
    			
    			if(selectedAccount != null && !selectedAccount.isEmpty()) {
	    			
    				boolean success = false;
    				
    				if(controladoraOperations.isCreditCardSelected()) {
	    				success = bank.retrieveCredit(selectedAccount,amount);
	    			
	    				if(success) {
	    					bank.saveAction();
	    					Alert alert = new Alert(AlertType.INFORMATION);
	                    	alert.setTitle("Alerta");
	                    	alert.setHeaderText("La operacion que ha solicitado fue realizada exitosamente");
	                    	alert.setContentText("El nuevo de credito disponible de su tarjeta es: $" + bank.getCurrentActiveClient().getBalanceFromCreditCard(selectedAccount)
	                    			+ " Debe un total de: $" + bank.getCurrentActiveClient().getAmountToPayFromCreditCard(selectedAccount));

	                    	alert.showAndWait();
	    				}
	    				else {
	    					Alert alert = new Alert(AlertType.ERROR);
	                    	alert.setTitle("Alerta");
	                    	alert.setHeaderText("La operacion que ha solicitado no fue realizada");
	                    	alert.setContentText("Por favor verifique que la cantidad a retirar no supera el monto de su tarjeta de credito o el saldo de su cuenta de ahorros!");

	                    	alert.showAndWait();
	    				}
    				}
	    			else {
	    				success = bank.retrieveSavings(selectedAccount,amount);
	    			
	    				if(success) {
	    					bank.saveAction();
	    					Alert alert = new Alert(AlertType.INFORMATION);
	                    	alert.setTitle("Alerta");
	                    	alert.setHeaderText("La operacion que ha solicitado fue realizada exitosamente");
	                    	alert.setContentText("El nuevo de saldo de su cuenta es de: $" + bank.getCurrentActiveClient().getBalanceFromSavingsAccount(selectedAccount));

	                    	alert.showAndWait();
	    				}
	    				else {
	    					Alert alert = new Alert(AlertType.ERROR);
	                    	alert.setTitle("Alerta");
	                    	alert.setHeaderText("La operacion que ha solicitado no fue realizada");
	                    	alert.setContentText("Por favor verifique que la cantidad a retirar no supera el monto de su tarjeta de credito o el saldo de su cuenta de ahorros!");

	                    	alert.showAndWait();
	    				}
	    			}	    			
    			}
    			else {
    				Alert alert = new Alert(AlertType.ERROR);
                	alert.setTitle("Alerta");
                	alert.setHeaderText("No hay una seleccion de cuenta o tarjeta");
                	alert.setContentText("Por favor verifique que ha seleccionado una tarjeta de credito o cuenta de ahorros!");

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
        	alert.setContentText("Por favor ingrese el monto que desea retirar");

        	alert.showAndWait();
        	
    	}
    	
    }
	
	//------------------------------------------------------------------------------------

}
