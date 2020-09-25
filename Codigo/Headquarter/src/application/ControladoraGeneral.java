/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private TableView<?> clientsTable;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnDateSatart;

    @FXML
    private TableColumn<?, ?> columnDatePay;

    @FXML
    private TableColumn<?, ?> columnMonto;

    @FXML
    private TableColumn<?, ?> columnSaldo;

    @FXML
    private TableColumn<?, ?> columnsAccounts;

    @FXML
    private Button comeBackButton;
    
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

}
