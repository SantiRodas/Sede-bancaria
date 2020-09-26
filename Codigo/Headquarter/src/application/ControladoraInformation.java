/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    	nameLabel.setText(aux.getName());
    	idLabel.setText(aux.getId());
    	dateStartLabel.setText(aux.getStartDate().toString());
    	datePayLabel.setText(aux.getLastCreditCardPayDate().toString());
    	balanceLabel.setText(aux.toStringSavingsAccounts());
    	amountCreditCard.setText(aux.toStringCreditCards());
    }

	public void setBank(Bank bank) {
		this.bank = bank;
		
	}
	
	//------------------------------------------------------------------------------------

}
