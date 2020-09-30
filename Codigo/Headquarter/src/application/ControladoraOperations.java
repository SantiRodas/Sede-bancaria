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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ControladoraOperations {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	private ControladoraPrincipal controladoraPrincipal;
	
	private ControladoraRetirar controladoraRetirar;
	
	private ControladoraConsignar controladoraConsignar;
	
	private ControladoraCancelar controladoraCancelar;
	
	private ControladoraPagar controladoraPagar;
	
	private ControladoraDeshacer controladoraDeshacer;
	
	private ControladoraCrear controladoraCrear;
		
	//------------------------------------------------------------------------------------
	
	//Attributes

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
    
    @FXML
    private ToggleGroup accounts;
    
    @FXML
    private RadioButton creditCardRButton;
    
    @FXML
    private RadioButton savingsAccountRButton;

    
    //------------------------------------------------------------------------------------
    
    //Constructor
    
    public ControladoraOperations(ControladoraPrincipal cP, Bank b) {
    	controladoraPrincipal = cP;
    	
    	bank = b;
    	
		controladoraRetirar = new ControladoraRetirar(this, b);
		
		controladoraConsignar = new ControladoraConsignar(this, b);
		
		controladoraCancelar = new ControladoraCancelar(this, b);
		
		controladoraPagar = new ControladoraPagar(this, b);
		
		controladoraDeshacer = new ControladoraDeshacer(b);
		
		controladoraCrear = new ControladoraCrear(this,b);
		
	}
    
    //------------------------------------------------------------------------------------
    
    //Cancel method
	
    @FXML
    public void cancelar(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Cancelar.fxml"));
		
		fxmlLoader.setController(controladoraCancelar);    
		
		Parent addContactPane = fxmlLoader.load();
				
		//controladoraCancelar.getId(idText.getText());
    	
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
		
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

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
		
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }

    
	public void setOperationsAvailability(boolean[] visibilities) {
		takeChoice.setDisable(!visibilities[0]);
		recordChoice.setDisable(!visibilities[1]);
		cancelChoice.setDisable(!visibilities[2]);
		payChoice.setDisable(!visibilities[3]);
		breakChoice.setDisable(!visibilities[4]);	
		createAccountButton.setDisable(!visibilities[5]);
		savingsAccountRButton.setDisable(!visibilities[6]);
		creditCardRButton.setDisable(!visibilities[7]);
		cards.setDisable(!visibilities[8]);
	}
	
	@FXML
	void loadCreditCards(ActionEvent event) {
		ActiveClient aux = bank.getCurrentActiveClient();
    	
    	if(aux != null) {    			
    		cards.getItems().clear();
    		
    		updateCurrentClient(aux.getName(),aux.getId());
    		
    		String[] cc = aux.getCreditCardNumbers();
    		
    		if(cc != null) {
	    		for(String number : cc) {
	    			if(number != null) {
	    				cards.getItems().add(number);
	    			}    			
	    		}
	    		
	    		boolean[] visibilities = {true, false, true, true, true, true, true, true , true};
	    		setOperationsAvailability(visibilities);
    		}
    		else {
    			boolean[] visibilities = {false, false, true, false, false, true, true, true , true};
        		
        		setOperationsAvailability(visibilities);
    		}    		
    	}   
    	else {
    		cards.getItems().clear();
    	}
	}

	@FXML
	void loadSavingsAccount(ActionEvent event) {
		ActiveClient aux = bank.getCurrentActiveClient();
    	
    	if(aux != null) {
    		cards.getItems().clear();		
    		
    		updateCurrentClient(aux.getName(),aux.getId());
    		
    		String[] sa = aux.getSavingsAccountsNumbers();
    		
    		if(sa != null) {
	    		for(String number : sa) {
	    			if(number != null) {
	    				cards.getItems().add(number);
	    			}    			
	    		}   
	    		boolean[] visibilities = {true, true, true, false, true, true, true, true , true};
	    		setOperationsAvailability(visibilities);
    		}
    		else {
    			boolean[] visibilities = {false, false, true, false, false, true, true, true , true};
        		
        		setOperationsAvailability(visibilities);
    		}
    	}   
    	else {
    		cards.getItems().clear();
    	}
	}
    
	public void clearCards() {
		cards.getItems().clear();
	}
	
	public String getCurrentCardsSelection() {
		return cards.getValue();
	}
	
	public boolean isCreditCardSelected() {
		return creditCardRButton.isSelected();
	}
	
	public boolean isSavingsAccountSelected() {
		return savingsAccountRButton.isSelected();
	}
    //------------------------------------------------------------------------------------

	public void updateCurrentClient(String name, String id) {
		if(name != null && id != null) {
			nameLabel.setText(name + " CC" + id);
		}	
		else {
			nameLabel.setText("Ninguno");
		}
	}

	public void refreshAvailability() {
		if(creditCardRButton.isSelected()) {
			loadCreditCards(new ActionEvent());
		}
		else if(savingsAccountRButton.isSelected()){
			loadSavingsAccount(new ActionEvent());
		}
		else {
			boolean[] visibilities = {false, false, true, false, false, true, true, true , true};
    		
    		setOperationsAvailability(visibilities);
		}
		
	}

	public void updateToRemovedUser() {
		boolean[] visibilities = {false, false, false, false, false, false, false, false , false};
		
		setOperationsAvailability(visibilities);
		
		nameLabel.setText("Ninguno");
		cancelChoice.setSelected(false);
		
		controladoraPrincipal.updateToRemovedUser();
		
	}
}
