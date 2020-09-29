/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ActiveClient;
import model.Bank;
import model.CreditCard;
import model.SavingsAccount;

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
    private TableView<SavingsAccount> tableSavingsAccount;
    
    @FXML
    private TableColumn<SavingsAccount, String> columnSA;

    @FXML
    private TableColumn<SavingsAccount, Double> columnSaldo;

    @FXML
    private TableView<CreditCard> tableCredit;

    @FXML
    private TableColumn<CreditCard, String> columnCC;

    @FXML
    private TableColumn<CreditCard, Double> columnMonto;

    @FXML
    private TableColumn<CreditCard, Double> columnSaldoDisponible;
	
	//------------------------------------------------------------------------------------
    
    //Search method
    
    public ControladoraInformation(Bank b) {
		bank = b;
	}

	@FXML
    public void search(ActionEvent event) {
    	
    	if(searchText.getText().isEmpty()==false) {
    		
    		ActiveClient aux = bank.searchActiveClientById(searchText.getText());
    		
    		if(aux != null) {
    			
    			nameLabel.setText(aux.getName());
	    		idLabel.setText(aux.getId());
	    		dateStartLabel.setText(aux.getStartDate().toString());
	    	
	    		initializeTableViewSA();
	    	
	    		if(aux.getLastCreditCardPayDate() != null) {
	    			
	    			datePayLabel.setText(aux.getLastCreditCardPayDate().toString());
	    			
	    		} else {
	    			
	    			datePayLabel.setText("N/A");
	    			
	    		}
	    	
	    		initializeTableViewCC();
	    	
    		} else {
    			
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Cliente no encontrado");
    			alert.setHeaderText("Error");
    			alert.setContentText("La id no esta registrada en el sistema");
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

   //Method to initialize the table view of saving accounts
    
    public void initializeTableViewSA() {
    	
    	ObservableList<SavingsAccount> observableList = FXCollections.observableArrayList(bank.searchActiveClientById(idLabel.getText()).getsAccounts());
    	
    	tableSavingsAccount.setItems(observableList);
    	
    	columnSA.setCellValueFactory(new PropertyValueFactory<SavingsAccount,String>("number"));
    	columnSaldo.setCellValueFactory(new PropertyValueFactory<SavingsAccount,Double>("balance")); 
    
    }
    
    //------------------------------------------------------------------------------------

   //Method to initialize the table view of credit cards
    
    public void initializeTableViewCC() {
    	
    	ObservableList<CreditCard> observableList = FXCollections.observableArrayList(bank.searchActiveClientById(idLabel.getText()).getcCards());
    	
    	tableCredit.setItems(observableList);
    	
    	columnCC.setCellValueFactory(new PropertyValueFactory<CreditCard,String>("number"));
    	columnMonto.setCellValueFactory(new PropertyValueFactory<CreditCard,Double>("balanceToPay")); 
    	columnSaldoDisponible.setCellValueFactory(new PropertyValueFactory<CreditCard,Double>("availableCredit"));
    	
    }
    
    //------------------------------------------------------------------------------------

	
}
