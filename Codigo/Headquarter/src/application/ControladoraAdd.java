/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import model.Bank;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ControladoraAdd {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
	@FXML
    private TextField nameText;

    @FXML
    private TextField idText;

    @FXML
    private Button addButton;

    @FXML
    private DatePicker bornDate;
    
    //------------------------------------------------------------------------------------
    
    //Add method

    @FXML
    public void addClient(ActionEvent event) {
    	
    	if(nameText.getText().equals("") || idText.getText().equals("") || bornDate.getValue() == null) {
    		
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Faltan campos por llenar");
    		alert.setHeaderText("Error");
    		alert.setContentText("Asegurese de que todos los campos esten llenos");
    		alert.showAndWait();
    		
    	} else if(bornDate.getValue().isAfter(LocalDate.now())) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Fecha incorrecta");
    		alert.setHeaderText("Error");
    		alert.setContentText("Por favor analiza el tiempo digitado");
    		alert.showAndWait();
    		
    	} else {
    		
    		boolean check = bank.addNewActiveClient(nameText.getText(), idText.getText(), bornDate.getValue(), LocalDate.now());
    	
    		if(check) {
    			
    			Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle("Cliente agregado correctamente");
        		alert.setHeaderText("Informacion");
        		alert.setContentText("Operacion resuelta");
        		alert.showAndWait();
        		nameText.clear();
            	idText.clear();
            	bornDate.setValue(null);
            	
    		} else {
    			
    			Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("El cliente existe");
        		alert.setHeaderText("Error");
        		alert.setContentText("El cliente con esta informacion ya existe");
        		alert.showAndWait();
        		
    		}
    	
    	}
    	
    }
    
    //------------------------------------------------------------------------------------
    
    //Method set bank

	public void setBank(Bank bank) {
		this.bank = bank;		
	}
    
    //------------------------------------------------------------------------------------

}
