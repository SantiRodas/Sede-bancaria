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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.ActiveClient;
import model.Bank;

public class ControladoraInformation {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
	@FXML
    private Button searchButton;

    @FXML
    private TextField searchText;

    @FXML
    private Label nameLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label dateStartLabel;

    @FXML
    private Label datePayLabel;

    @FXML
    private Label amountCreditCard;

    @FXML
    private Label balanceLabel;
	
	//------------------------------------------------------------------------------------
    
    //Search method
    
    @FXML
    public void search(ActionEvent event) {
    	ActiveClient aux = bank.searchActiveClientById(searchText.getText());
    	if(aux != null) {
	    	nameLabel.setText(aux.getName());
	    	idLabel.setText(aux.getId());
	    	dateStartLabel.setText(aux.getStartDate().toString());
	    	
	    	if(aux.getCreditCardNumbers() != null) {	    				    	
		    	amountCreditCard.setText(aux.toStringCreditCards());
	    	}
	    	else {
	    		amountCreditCard.setText("N/A");
	    	}
	    	
	    	if(aux.getLastCreditCardPayDate() != null) {
	    		datePayLabel.setText(aux.getLastCreditCardPayDate().toString());
	    	}
	    	else {
	    		datePayLabel.setText("N/A");
	    	}
	    	
	    	if(aux.getSavingsAccountsNumbers() != null) {
	    		balanceLabel.setText(aux.toStringSavingsAccounts());
	    	}
	    	else {
	    		balanceLabel.setText("N/A");
	    	}
	    	
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Client not found");
    		alert.setHeaderText("Error");
    		alert.setContentText("A client with the given id not found!");
    		alert.showAndWait();
    	}
    }

	public void setBank(Bank bank) {
		this.bank = bank;
		
	}
	
	//------------------------------------------------------------------------------------

}
