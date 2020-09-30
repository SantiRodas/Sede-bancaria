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
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import model.Bank;

public class ControladoraCancelar {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	private ControladoraOperations controladoraOpertions;
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private Button cancelButton;

    @FXML
    private TextArea cancelText;   
    
    //------------------------------------------------------------------------------------
    
    public ControladoraCancelar(ControladoraOperations cO, Bank b) {
		bank = b;
		controladoraOpertions = cO;
	}
	
	//------------------------------------------------------------------------------------
    
    //Cancel method

    @FXML
    public void cancel(ActionEvent event) {
    	
    	if(!cancelText.getText().isEmpty()) {
    		
    		boolean validation = bank.removeActiveClient(cancelText.getText());
    		
    		if(validation) {
    			
    			controladoraOpertions.updateToRemovedUser();
    			
    			Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("Alerta");
            	alert.setHeaderText("Su usuario ha sido removido exitosamente!");
            	
            	alert.showAndWait();
    			
    			
    		}
    		else {
    			Alert alert = new Alert(AlertType.ERROR);
            	alert.setTitle("Alerta");
            	alert.setHeaderText("Su usuario no ha sido removido");
            	alert.setContentText("Verifique que no tengo monto por pagar en sus tarjetas y sus cuentas de ahorros esten vacias!");

            	alert.showAndWait();
    		}
    		
    		
    	} else {
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Alerta");
        	alert.setHeaderText("Campo vacío");
        	alert.setContentText("Por favor escriba su causa de cancelación");

        	alert.showAndWait();
        	
    	}
    	
    }
	//------------------------------------------------------------------------------------

}
