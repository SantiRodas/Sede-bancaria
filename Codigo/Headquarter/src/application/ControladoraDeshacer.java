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
import model.Bank;

public class ControladoraDeshacer {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private Button deshacerButton;

    @FXML
    private Label deshacerLabel;
	
	//------------------------------------------------------------------------------------
    
    public void setBank(Bank bank) {
    	this.bank = bank;
    }
    
    //------------------------------------------------------------------------------------
    
    //Remove last one action method
    
    @FXML
    public void deshacer(ActionEvent event) {
    	boolean aux = bank.undoLastAction();
    	if(aux==true)
    		deshacerLabel.setText("La operación se ha realizado con éxito");
    	else
    		deshacerLabel.setText("La operación no se ha podido realizar");
    }
	
	//------------------------------------------------------------------------------------

}
