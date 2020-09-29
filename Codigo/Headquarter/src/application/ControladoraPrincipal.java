/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.ActiveClient;
import model.Bank;

public class ControladoraPrincipal {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	private ControladoraAdd controladoraAdd;
	
	private ControladoraAssign controladoraAssign;
	
	private ControladoraInformation controladoraInformation;
	
	private ControladoraOperations controladoraOperations;
		
	//------------------------------------------------------------------------------------
	
	//Attributes of the ControladoraPrincipal class
	
	@FXML
    private Tab addTab;
	
	@FXML
    private Tab assignTab;
	
	@FXML
    private Tab informationTab;
	
    @FXML
    private Tab operationsTab;
	
	@FXML
	private Tab generalTab;
	
	@FXML
	private Pane panel;
	
	@FXML
    private TableView<ActiveClient> lineTable;

    @FXML
    private TableColumn<ActiveClient, String> line1;

    @FXML
    private TableView<ActiveClient> pLineTable;

    @FXML
    private TableColumn<ActiveClient, String> line2;
    
    @FXML
    private Button nextButton;
    
    @FXML
    private Button loadTabsButton;
    
    @FXML
    private AnchorPane addClientAPane;

    @FXML
    private AnchorPane assignQueueAPane;

    @FXML
    private AnchorPane clientInformationAPane;

    @FXML
    private AnchorPane operationsAPane;

    @FXML
    private AnchorPane generalInfAPane;
    
    @FXML
    private Button openTableButton;
    
    @FXML
    private Label currentClientLabel;

    //------------------------------------------------------------------------------------
    
    //Constructor
    
    public ControladoraPrincipal(Bank b) {
    	
    	bank = b;
		controladoraAdd = new ControladoraAdd(bank);
		controladoraAssign = new ControladoraAssign(this, bank);
		controladoraInformation = new ControladoraInformation(bank);
		controladoraOperations = new ControladoraOperations(bank);
		
	}
    
    //------------------------------------------------------------------------------------
    
    //Add method
    
    public void add() throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddClient.fxml"));
		
		fxmlLoader.setController(controladoraAdd);    
		
		Parent addContactPane = fxmlLoader.load();
		
		addClientAPane.getChildren().clear();
		
		addClientAPane.getChildren().setAll(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Assign method
   
    public void assign() throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AsignClient.fxml"));
		
		fxmlLoader.setController(controladoraAssign);    
		
		Parent addContactPane = fxmlLoader.load();
		    	
		assignQueueAPane.getChildren().clear();
		
		assignQueueAPane.getChildren().setAll(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //GeneralInformation method

    public void generalInformation() throws IOException {
    	
    	ControladoraGeneral controladoraGeneral = new ControladoraGeneral(this, bank);
    	    	
    	Stage primaryStage = new Stage();
    	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GeneralInformation.fxml"));

		fxmlLoader.setController(controladoraGeneral);
		
		Parent root = fxmlLoader.load();
				
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Sede bancaria");		
		
		controladoraGeneral.initializeTableView();
		
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
            public void handle(WindowEvent we) {
            	
                updateOpenTableButton(); 
                
            }
            
        }); 
		
		updateOpenTableButton();

    }
    
    //------------------------------------------------------------------------------------
    
    //Information method

    public void information() throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InformationClientWithTable.fxml"));
		
		fxmlLoader.setController(controladoraInformation);    
		
		Parent addContactPane = fxmlLoader.load();
		
		clientInformationAPane.getChildren().clear();
		
		clientInformationAPane.getChildren().setAll(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Operations method
    
    void operations() throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OperationsClient.fxml"));
		
		fxmlLoader.setController(controladoraOperations);  
		
		Parent addContactPane = fxmlLoader.load();	
    	
		operationsAPane.getChildren().clear();
		
		operationsAPane.getChildren().setAll(addContactPane);

    }
      
    //------------------------------------------------------------------------------------
	
	//Initialize table view

	public void initializeTableView() {
		
    	ObservableList<ActiveClient> observableList1 = FXCollections.observableArrayList(bank.getQueue());
    	   	
    	lineTable.setItems(observableList1);
    	
    	line1.setCellValueFactory(new PropertyValueFactory<ActiveClient,String>("id")); 
    	
    	ObservableList<ActiveClient> observableList2 = FXCollections.observableArrayList(bank.getPriorityQueue());
    	
    	pLineTable.setItems(observableList2);
    	
    	line2.setCellValueFactory(new PropertyValueFactory<ActiveClient,String>("id")); 
    	
    }
	
	//------------------------------------------------------------------------------------
	
	//Method to load tabs
	
	@FXML
    public void loadTabs(ActionEvent event) throws IOException {
		
		add();
		assign();
		information();
		operations();
		
		loadTabsButton.setVisible(false);
		addTab.setDisable(false);
		assignTab.setDisable(false);
		informationTab.setDisable(false);
		operationsTab.setDisable(false);
		generalTab.setDisable(false);
		
    }
	
	//------------------------------------------------------------------------------------
	
	//Method to open the table

	@FXML
    public void openTable(ActionEvent event) throws IOException {
		generalInformation();
    }
	
	//------------------------------------------------------------------------------------
	
	//Method next
	
    @FXML
    public void next(ActionEvent event) {
    	
    	boolean attend = bank.attendNextClient();
    	
    	ActiveClient currentClient = bank.getCurrentActiveClient();
    	
    	if(attend) {
    		
    		currentClientLabel.setText(currentClient.getId());
    		
    		initializeTableView();
    		
    		boolean[] visibilities = {false, false, true, false, false, true, true, true , true};
    		
    		controladoraOperations.setOperationsAvailability(visibilities);
    		
    		controladoraOperations.clearCards();
    		
    		controladoraOperations.updateCurrentClient(currentClient.getName(),currentClient.getId());
    	}
    	else {
    		
    		currentClientLabel.setText("Ninguno");
    		
    		boolean[] visibilities = {false, false, false, false, false, false, false, false , false};
    		
    		controladoraOperations.setOperationsAvailability(visibilities);
    		
    		controladoraOperations.clearCards();
    		
    		controladoraOperations.updateCurrentClient(null,null);
    	}
    	    	
    }
    
    //------------------------------------------------------------------------------------
    
    //Method to update
    
    public void updateOpenTableButton() {
    	
    	if(openTableButton.isDisable()) {
    		
    		openTableButton.setDisable(false);
    		
    	} else {
    		
    		openTableButton.setDisable(true);
    		
    	}
    	
    }
    
    //------------------------------------------------------------------------------------
    
}
