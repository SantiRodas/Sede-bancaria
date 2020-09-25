/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ActiveClient;
import model.SortCriteria;

public class ControladoraGeneral {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private ControladoraPrincipal controladora;
	
	//------------------------------------------------------------------------------------
	
	public ControladoraGeneral() {
		
		controladora = new ControladoraPrincipal();
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
	@FXML
    private Pane panel1;

    @FXML
    private TableView<ActiveClient> clientsTable;

    @FXML
    private TableColumn<ActiveClient, String> columnName;

    @FXML
    private TableColumn<ActiveClient, String> columnId;

    @FXML
    private TableColumn<ActiveClient, LocalDate> columnDateStart;

    @FXML
    private TableColumn<ActiveClient, LocalDate> columnDatePay;

    @FXML
    private TableColumn<ActiveClient, ?> columnMonto;

    @FXML
    private TableColumn<ActiveClient, ?> columnSaldo;

    @FXML
    private TableColumn<ActiveClient, ?> columnsAccounts;

    @FXML
    private Button comeBackButton;
    
    @FXML
    private ChoiceBox<String> choiceBoxSort;

    @FXML
    private TextField textFieldSearch;

    @FXML
    private Button buttonSort;

    @FXML
    private Button buttonSearch;
    
    //------------------------------------------------------------------------------------
    
    //ComeBack method

    @FXML
    public void comeBack(ActionEvent event) throws IOException {
    	
    	Stage stage = (Stage) panel1.getScene().getWindow(); 
        
        stage.close();
        
        // ******************************************
    	
    	Stage primaryStage = new Stage();
    	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Principal.fxml"));

		fxmlLoader.setController(controladora);
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Sede bancaria");
		
		primaryStage.show();

    }
    
    //------------------------------------------------------------------------------------
    
    private void initializeTableView() {
    	ObservableList<ActiveClient> observableList = FXCollections.observableArrayList(eq.getAccounts());
    	
    	clientsTable.setItems(observableList);
    	
    	columnName.setCellValueFactory(new PropertyValueFactory<ActiveClient,String>("name"));
    	columnId.setCellValueFactory(new PropertyValueFactory<ActiveClient,String>("id")); 
    	columnDateStart.setCellValueFactory(new PropertyValueFactory<ActiveClient,LocalDate>("startDate"));
    	columnDatePay.setCellValueFactory(new PropertyValueFactory<ActiveClient,LocalDate>("lastCreditCardPayDate"));
     	column5.setCellValueFactory(new PropertyValueFactory<ActiveClient,String>("gender"));
     	column6.setCellValueFactory(new PropertyValueFactory<ActiveClient,Double>("height"));
     	column7.setCellValueFactory(new PropertyValueFactory<ActiveClient,Double>("weight"));
    }
    
  //------------------------------------------------------------------------------------
    
    @FXML
	public void go(ActionEvent event) throws IOException {
		
			if(choiceBoxSort.getValue().equals("")) {
					Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("Warning at sorting");
				    alert.setHeaderText("The choice box is empty");
				    alert.setContentText("Please select an option of the choice box if you want to sort the clients");
				
				    alert.showAndWait();
			}
			
			else {
				
				
				if(choiceBoxSort.getValue().equals("Sort by name")) {
					bank.sortCriteria(SortCriteria.NAME);
				}
				else if(choiceBoxSort.getValue().equals("Sort by start date")) {
					bank.sortCriteria(SortCriteria.START_DATE);
				}
				else if(choiceBoxSort.getValue().equals("Sort by id")) {
					bank.sortCriteria(SortCriteria.ID);
				}
				else if(choiceBoxSort.getValue().equals("Sort by birthdate")) {
					bank.sortCriteria(SortCriteria.BIRTHDAY);
				}
				
				initializeTableView();
			}
			
	//------------------------------------------------------------------------------------
		
	}
    
    @FXML
	public void search() {
		String s = textFieldSearch.getText();
		
			if(s.equals("")) {
				Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle("Warning");
			    alert.setHeaderText("Some fields are empty");
			    alert.setContentText("Please fill the fields if you want to search for a client");
			
			    alert.showAndWait();
			}
			
			else {
				ActiveClient aux = bank.searchClientById(s);
					
				if(aux!=null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("User found");
					alert.setContentText(aux.toString());
					
					alert.showAndWait();
				}
				else {
					Alert alert = new Alert(AlertType.INFORMATION);		   
					alert.setTitle("Error");
					alert.setContentText("The wanted user doesn't exist in the database");
						
					alert.showAndWait();
				}
			}
	}
    
  //------------------------------------------------------------------------------------

    
    @FXML
    void initialize() {
		
    	choiceBoxSort.getItems().add("Sort by name");
    	choiceBoxSort.getItems().add("Sort by start date");
    	choiceBoxSort.getItems().add("Sort by id");
    	choiceBoxSort.getItems().add("Sort by birthdate");
    	

    }
    
    //------------------------------------------------------------------------------------

}
