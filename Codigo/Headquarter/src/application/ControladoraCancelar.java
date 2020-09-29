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
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private Button cancelButton;

    @FXML
    private TextArea cancelText;
    
    private String id;
    
    //------------------------------------------------------------------------------------
    
    public ControladoraCancelar(Bank b) {
		bank = b;
	}
	
	//------------------------------------------------------------------------------------
    
    //Cancel method

    @FXML
    public void cancel(ActionEvent event) {
    	
    	if(cancelText.getText().isEmpty()==false) {
    		
    		bank.removeActiveClient(id, cancelText.getText());
    		bank.saveAction();
    		
    	} else {
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Alerta");
        	alert.setHeaderText("Campo vacío");
        	alert.setContentText("Por favor escriba su causa de cancelación");

        	alert.showAndWait();
        	
    	}
    	
    }
    
    //------------------------------------------------------------------------------------
    
    //Method set bank

	public void getId(String id) {
		this.id = id;
	}
	
	//------------------------------------------------------------------------------------

}
