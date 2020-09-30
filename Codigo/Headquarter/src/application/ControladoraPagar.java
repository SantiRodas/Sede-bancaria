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
import javafx.scene.control.ChoiceBox;
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
	
	private ControladoraOperations controladoraOperations;
	
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
    private Text numCuentTexto;
    
    @FXML
    private ChoiceBox<String> accountsChoiceBox;
        
    //------------------------------------------------------------------------------------
    
    //Method set bank
    
    public ControladoraPagar(ControladoraOperations cO, Bank b) {
		bank = b;
		controladoraOperations = cO;
	}
	
	//------------------------------------------------------------------------------------
    
    //Pay method
    
    @FXML
    public void pagar(ActionEvent event) {
    	
    	String creditCardNumber = controladoraOperations.getCurrentCardsSelection();
    	String amountText = cantidadText.getText();
    	
    	if(!amountText.isEmpty()) {
    		if(efectivoChoice.isSelected() || efectivoChoice.isSelected()) {
    			try {
    				
    				double amount = Double.parseDouble(amountText);
    				 
    				if(amount < 0) {
    					throw new NumberFormatException("Negative Number");
    				}
    				 
    				if(creditCardNumber != null && !creditCardNumber.isEmpty()) {
    					if(efectivoChoice.isSelected()) {
    						bank.saveAction(); 
    						boolean success = bank.payCreditCard(creditCardNumber, amount);
	    					 
    						if(success) {
    							Alert alert = new Alert(AlertType.INFORMATION);
    	                    	alert.setTitle("Alerta");
    	                    	alert.setHeaderText("La operacion que ha solicitado fue realizada exitosamente");
    	                    	alert.setContentText("El nuevo de credito disponible de su tarjeta es: $" + bank.getCurrentActiveClient().getBalanceFromCreditCard(creditCardNumber)
    	                    			+ " Debe un total de: $" + bank.getCurrentActiveClient().getAmountToPayFromCreditCard(creditCardNumber));
    	                    	alert.showAndWait();
    						}
    						else {
    							bank.undoLastAction();
    							Alert alert = new Alert(AlertType.ERROR);
    	                    	alert.setTitle("Alerta");
    	                    	alert.setHeaderText("La operacion que ha solicitado no fue realizada");
    	                    	alert.setContentText("Por favor verifique que la cantidad a pagar no supere la cantidad que debe de su tarjeta de credito!");

    	                    	alert.showAndWait();
    						}
			    				
    					} 
	    				else { //SI SE VA A PAGAR CON ALGUNA CUENTA
	    					String accountNumber = accountsChoiceBox.getValue();	
	    					
	    					if(!accountNumber.isEmpty()) {
	    						bank.saveAction();
	    						boolean success1 = bank.retrieveSavings(accountNumber, amount);
	    						
	    						if(success1) {
	    							
	    							boolean success2 = bank.payCreditCard(creditCardNumber, amount);
	    						
	    							if(success2) {	    								
	    								Alert alert = new Alert(AlertType.INFORMATION);
	        	                    	alert.setTitle("Alerta");
	        	                    	alert.setHeaderText("La operacion que ha solicitado fue realizada exitosamente");
	        	                    	alert.setContentText("El nuevo de credito disponible de su tarjeta es: $" + bank.getCurrentActiveClient().getBalanceFromCreditCard(creditCardNumber)
	        	                    			+ " Debe un total de: $" + bank.getCurrentActiveClient().getAmountToPayFromCreditCard(creditCardNumber));
	        	                    	alert.showAndWait();
	        	                    	
	        	                    	alert = new Alert(AlertType.INFORMATION);
	        	                    	alert.setTitle("Alerta");
	        	                    	alert.setHeaderText("La operacion que ha solicitado fue realizada exitosamente");
	        	                    	alert.setContentText("El nuevo de saldo de su cuenta de ahorros es de: $" + bank.getCurrentActiveClient().getBalanceFromSavingsAccount(accountNumber));
	        	                    	alert.showAndWait();
	    							}
	    							else {
	    								bank.undoLastAction();
	    								Alert alert = new Alert(AlertType.ERROR);
	        	                    	alert.setTitle("Alerta");
	        	                    	alert.setHeaderText("La operacion que ha solicitado no fue realizada");
	        	                    	alert.setContentText("Por favor verifique que la cantidad a pagar no supere la cantidad que debe de su tarjeta de credito!");
	        	                    	alert.showAndWait();
	    							}
	    						}
	    						else {
	    							bank.undoLastAction();	    							
	    							Alert alert = new Alert(AlertType.ERROR);
	    	                    	alert.setTitle("Alerta");
	    	                    	alert.setHeaderText("La operacion que ha solicitado no fue realizada");
	    	                    	alert.setContentText("Por favor verifique que el saldo de su cuenta de ahorros sea mayor a la cantidad a pagar!");
	    	                    	alert.showAndWait();
	    						}
			    		    	
	    					}    					
	    					else {			    		     		
	    						Alert alert = new Alert(AlertType.INFORMATION);
	    						alert.setTitle("Alerta");
			        	        alert.setHeaderText("Campo vacío");
			        	        alert.setContentText("Por favor digite el número de cuenta");
			     	        	alert.showAndWait();
			        	        	
	    					}
			    		    	
	    				}
    				}
    				else {
    					Alert alert = new Alert(AlertType.ERROR);
                    	alert.setTitle("Alerta");
                    	alert.setHeaderText("No hay una seleccion de tarjeta");
                    	alert.setContentText("Por favor verifique que ha seleccionado una tarjeta de credito a pagar!");

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
    		}
    		else {
    			
    			Alert alert = new Alert(AlertType.INFORMATION);
    	        alert.setTitle("Alerta");
    	        alert.setHeaderText("Campo vacío");
    	        alert.setContentText("Por favor seleccione alguna de las opciones de pago");

    	        alert.showAndWait();
    	        
    		}
    		 
    	}
    	else {
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Alerta");
        	alert.setHeaderText("Campo vacío");
        	alert.setContentText("Por favor digite el monto que desea pagar");

        	alert.showAndWait();
        	
    	}
    	
    }
	
	//------------------------------------------------------------------------------------
    
    public void fillAccountsChoiceBox() {
    	String[] accounts = bank.getCurrentActiveClient().getSavingsAccountsNumbers();
    	accountsChoiceBox.getItems().addAll(accounts);
    }
    

    @FXML
    void updateOptionToCash(ActionEvent event) {
    	pagarButton.setDisable(false);
    	accountsChoiceBox.setDisable(true);
    	cantidadText.setDisable(false);
    }

    @FXML
    void updateOptionsToSavings(ActionEvent event) {
    	pagarButton.setDisable(false);
    	accountsChoiceBox.setDisable(false);
    	cantidadText.setDisable(true);
    }

}
