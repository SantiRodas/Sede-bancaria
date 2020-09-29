/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import model.Bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladoraAssign {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	private ControladoraPrincipal controladoraPrincipal;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
	@FXML
    private TextField idText;

    @FXML
    private Button asignButton;

    @FXML
    private Label lineLabel;
    //------------------------------------------------------------------------------------
    
    //Constructor
    
    public ControladoraAssign(ControladoraPrincipal cP, Bank b) {
    	controladoraPrincipal = cP;
    	bank = b;
    }
    
    //------------------------------------------------------------------------------------
    
    //Method assign

    @FXML
    public void asignClient(ActionEvent event) {
    	
    	if(idText.getText().isEmpty()==false) {
    		
    		int q = bank.assignClientToQueue(idText.getText());
    		
    		if(q!=0) {
    			lineLabel.setText(q+"");
    		
    			controladoraPrincipal.initializeTableView();
    			
    		} else {
    			
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Error");
		    	alert.setHeaderText("Cliente no encontrado");
		    	alert.setContentText("El cliente con el id '" + idText.getText() + "' no esta registrado");
		
		    	alert.showAndWait();
    		}
    		
    	} else {
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Alerta");
        	alert.setHeaderText("Campo vacío");
        	alert.setContentText("Por favor llene todos los campos");

        	alert.showAndWait();
        	
    	}
    	
    }
    
	//------------------------------------------------------------------------------------

}
