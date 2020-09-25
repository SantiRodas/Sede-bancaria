/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import model.Bank;

public class ControladoraCancelar {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private Button cancelButton;

    @FXML
    private TextArea cancelText;
    
    //------------------------------------------------------------------------------------
    
    public void setBank(Bank bank) {
    	this.bank = bank;
    }
	
	//------------------------------------------------------------------------------------
    
    //Cancel method

    @FXML
    public void cancel(ActionEvent event) {

    }
	
	//------------------------------------------------------------------------------------

}
