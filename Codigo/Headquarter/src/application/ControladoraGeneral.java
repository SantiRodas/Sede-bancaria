/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import java.io.IOException;
import java.time.LocalDate;
import model.Bank;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	
	private ControladoraPrincipal controladoraPrincipal;
	
	private Bank bank;
	
	private ActiveClient[] ac;
	
	//------------------------------------------------------------------------------------
	
	//Constructor method
	
	public ControladoraGeneral(ControladoraPrincipal cP, Bank b, ActiveClient[] acArray) {
		
		controladoraPrincipal = cP;
		bank = b;
		ac = acArray;
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
    private TableColumn<ActiveClient, LocalDate> columnBirthday;

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
        
        controladoraPrincipal.updateOpenTableButton();
        
    }
    
    //------------------------------------------------------------------------------------
    
    //Method to initialize the table view
    
    public void initializeTableView() {
    	
    	ObservableList<ActiveClient> observableList = FXCollections.observableArrayList(ac);
    	
    	clientsTable.setItems(observableList);
    	
    	columnName.setCellValueFactory(new PropertyValueFactory<ActiveClient,String>("name"));
    	columnId.setCellValueFactory(new PropertyValueFactory<ActiveClient,String>("id")); 
    	columnDateStart.setCellValueFactory(new PropertyValueFactory<ActiveClient,LocalDate>("startDate"));
    	columnBirthday.setCellValueFactory(new PropertyValueFactory<ActiveClient,LocalDate>("birthday"));
    
    }
    
    //------------------------------------------------------------------------------------
    
    //Method to go
    
    @FXML
	public void go(ActionEvent event) throws IOException {
		
			if(choiceBoxSort.getValue() != null && choiceBoxSort.getValue().equals("")) {
				
					Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("Error");
				    alert.setHeaderText("La seleccion esta vacia");
				    alert.setContentText("Por favor selecciona un metodo de ordenamiento");
				
				    alert.showAndWait();
				    
			} else {
				
				if(choiceBoxSort.getValue().equals("Ordenar por nombre")) {
					
					ac = bank.getSortedClients(SortCriteria.NAME);
					
				} else if(choiceBoxSort.getValue().equals("Ordenar por fecha de inicio")) {
					
					ac = bank.getSortedClients(SortCriteria.START_DATE);
					
				} else if(choiceBoxSort.getValue().equals("Ordenar por id")) {
					
					ac = bank.getSortedClients(SortCriteria.ID);
					
				} else if(choiceBoxSort.getValue().equals("Ordenar por cumpleaños")) {
					
					ac = bank.getSortedClients(SortCriteria.BIRTHDAY);
					
				}
				
				initializeTableView();
				clientsTable.refresh();
				
			}
			
	}
    
    //------------------------------------------------------------------------------------
    
    //Method to search a user
    
    @FXML
	public void search() {
    	
		String s = textFieldSearch.getText();
		
			if(s.isEmpty()==true) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle("Error");
			    alert.setHeaderText("Algunos campos estan vacios");
			    alert.setContentText("Por favor llena los campos");
			
			    alert.showAndWait();
			    
			} else {
				ActiveClient aux = (ActiveClient)bank.searchActiveClientById(s);
					
				if(aux!=null) {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Usuario encontrado");
					alert.setContentText(aux.toString());
					
					alert.showAndWait();
					
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);		   
					alert.setTitle("Error");
					alert.setContentText("El usuario buscado no existe en el sistema");
						
					alert.showAndWait();
					
				}
				
			}
			
	}
    
    //------------------------------------------------------------------------------------
    
    //Method to initialize

    @FXML
    void initialize() {
		
    	choiceBoxSort.getItems().add("Ordenar por nombre");
    	choiceBoxSort.getItems().add("Ordenar por fecha de inicio");
    	choiceBoxSort.getItems().add("Ordenar por id");
    	choiceBoxSort.getItems().add("Ordenar por cumpleaños");
    	
    }
    
    //------------------------------------------------------------------------------------

}
