/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Bank;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	//------------------------------------------------------------------------------------
	
	//Relation with a ControladoraPrincipal class
	
	private ControladoraPrincipal controladora;
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Method Main
	
	public Main() {
		
		bank = new Bank("Bancolombia");
		controladora = new ControladoraPrincipal(bank);
				
	}
	
	//------------------------------------------------------------------------------------
	
	//Principal method to application
	
	@Override
	public void start(Stage primaryStage) {

		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Principal.fxml"));

			fxmlLoader.setController(controladora);
			
			Parent root = fxmlLoader.load();
			
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			
			primaryStage.setTitle(bank.getBankName());
			
			primaryStage.show();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
			
	}
	
	//------------------------------------------------------------------------------------
	
	//Launch method
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//------------------------------------------------------------------------------------
	
}
