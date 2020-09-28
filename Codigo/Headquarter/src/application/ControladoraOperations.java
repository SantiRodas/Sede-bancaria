/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import model.ActiveClient;
import model.Bank;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ControladoraOperations {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	private ControladoraRetirar controladoraRetirar;
	
	private ControladoraConsignar controladoraConsignar;
	
	private ControladoraCancelar controladoraCancelar;
	
	private ControladoraPagar controladoraPagar;
	
	private ControladoraDeshacer controladoraDeshacer;
	
	private ControladoraCrear controladoraCrear;
		
	//------------------------------------------------------------------------------------
	
	//Attributes

    @FXML
    private Button searchButton;

    @FXML
    private TextField idText;

    @FXML
    private Label nameLabel;

    @FXML
    private ChoiceBox<String> cards;

    @FXML
    private RadioButton takeChoice;

    @FXML
    private ToggleGroup operaciones;

    @FXML
    private RadioButton recordChoice;

    @FXML
    private RadioButton cancelChoice;

    @FXML
    private RadioButton payChoice;

    @FXML
    private RadioButton breakChoice;

    @FXML
    private Pane secundaryPane;

    @FXML
    private BorderPane panelSecundario;
    
    @FXML
    private RadioButton createAccountButton;
    
    //------------------------------------------------------------------------------------
    
    //Constructor
    
    public ControladoraOperations() {
    	
		controladoraRetirar = new ControladoraRetirar();
		
		controladoraConsignar = new ControladoraConsignar();
		
		controladoraCancelar = new ControladoraCancelar();
		
		controladoraPagar = new ControladoraPagar();
		
		controladoraDeshacer = new ControladoraDeshacer();
		
		controladoraCrear = new ControladoraCrear();
		
	}
	
	//------------------------------------------------------------------------------------
    
    //Method set bank
    
    public void setBank(Bank b) {
    	
    	bank = b;
    	
    }
    
    //------------------------------------------------------------------------------------
    
    //Cancel method
	
    @FXML
    public void cancelar(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Cancelar.fxml"));
		
		fxmlLoader.setController(controladoraCancelar);    
		
		Parent addContactPane = fxmlLoader.load();
		
		controladoraCancelar.setBank(bank);
		
		controladoraCancelar.getId(idText.getText());
    	
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Give money method

    @FXML
    public void consignar(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Consignar.fxml"));
		
		fxmlLoader.setController(controladoraConsignar);    
		
		Parent addContactPane = fxmlLoader.load();
		
		controladoraConsignar.setBank(bank);
		
		if(cards.getValue().isEmpty() == false)
			controladoraConsignar.getData(cards.getValue());
		
		else{
			alert();
			
		}
    	
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Remove an action method

    @FXML
    public void deshacer(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Deshacer.fxml"));
		
		fxmlLoader.setController(controladoraDeshacer);    
		
		Parent addContactPane = fxmlLoader.load();
		
		controladoraDeshacer.setBank(bank);
    	
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Pay method

    @FXML
    public void pago(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pagar.fxml"));
		
		fxmlLoader.setController(controladoraPagar);    
		
		Parent addContactPane = fxmlLoader.load();
		
		controladoraPagar.setBank(bank);
		
		if(cards.getValue().isEmpty() == false)
			controladoraPagar.getData(cards.getValue());
		
		else {
			alert();
			
		}
    	
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Take money method

    @FXML
    public void retirar(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Retirar.fxml"));
		
		fxmlLoader.setController(controladoraRetirar);    
		
		Parent addContactPane = fxmlLoader.load();
		
		controladoraRetirar.setBank(bank);
		
		if(cards.getValue().isEmpty() == false)
			controladoraRetirar.getData(cards.getValue());
		
		else {
			alert();
			
		}
		
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Search method

    @FXML
    public void search(ActionEvent event) {
    	
    	if(!idText.getText().equals("")) {
    		
    		ActiveClient aux = bank.searchActiveClientById(idText.getText());
    		
    		nameLabel.setText(aux.getName());
    		
    		String[] cc = aux.getCreditCardNumbers();
    		String[] sa = aux.getSavingsAccountsNumbers();
    	
    		int i = 0;
    		
    		while(i<cc.length) {
    			
    			cards.getItems().add(cc[i]);
    			
    			i++;
    			
    		}	
    		
    		int j = 0;
    		
    		while(j<sa.length) {
    			
    			cards.getItems().add(sa[j]);
    			
    			j++;
    		}
    		
    	} else {
    		
    		alert();
    		
    	}
    	
    }
    
    //------------------------------------------------------------------------------------
    
    //Alert method
    
    public void alert() {
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Alerta");
    	alert.setHeaderText("Campo vacío");
    	alert.setContentText("Es necesario que llene todos los campos para poder realizar la operación");

    	alert.showAndWait();
    	
    }
    
    //------------------------------------------------------------------------------------
    
    //Create account method
    
    @FXML
    public void createAccount(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Crear.fxml"));
		
		fxmlLoader.setController(controladoraCrear);    
		
		Parent addContactPane = fxmlLoader.load();
		
		controladoraDeshacer.setBank(bank);
    	
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------

}
