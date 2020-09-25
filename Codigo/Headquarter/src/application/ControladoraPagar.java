/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import model.Bank;

public class ControladoraPagar {
	
	//------------------------------------------------------------------------------------
	
	//Relations

	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private Button pagarButton;

    @FXML
    private RadioButton efectivoChoice;

    @FXML
    private ToggleGroup pago;

    @FXML
    private RadioButton desdeCuentaChoicen;
    
    //------------------------------------------------------------------------------------
    
    public void setBank(Bank bank) {
    	this.bank = bank;
    }
	
	//------------------------------------------------------------------------------------
    
    //Pay method
    
    @FXML
    public void pagar(ActionEvent event) {

    }
	
	//------------------------------------------------------------------------------------

}
