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

public class ControladoraInformation {
	
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

    }
	
	//------------------------------------------------------------------------------------

}
