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
    		alert.setTitle("Missing data fields");
    		alert.setHeaderText("Error");
    		alert.setContentText("At least one fields is missing, please be sure all the fields are filled!");
    		alert.showAndWait();
    	}
    	else if(bornDate.getValue().isAfter(LocalDate.now())) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Unvalid date");
    		alert.setHeaderText("Error");
    		alert.setContentText("Are you a time traveller? please check your birth day!");
    		alert.showAndWait();
    	}
    	else {
    		boolean check = bank.addNewActiveClient(nameText.getText(), idText.getText(), bornDate.getValue(), LocalDate.now());
    	
    		if(check) {
    			Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Client added succesfully");
        		alert.setHeaderText("Information");
        		alert.setContentText("The given client has been added!");
        		alert.showAndWait();
    		}
    		else {
    			Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Client Already exists");
        		alert.setHeaderText("Error");
        		alert.setContentText("A client with the given id already exists!");
        		alert.showAndWait();
    		}
    	
    	}
    	
    }

	public void setBank(Bank bank) {
		this.bank = bank;		
	}
    
    //------------------------------------------------------------------------------------

}
