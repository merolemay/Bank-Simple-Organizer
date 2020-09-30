package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Bank;
import model.Registry;
import ui.UsserGUI;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	
	private static BankOrganizerGUI bankGUI;
	private static Bank myBank;
	private Scene scene;
	
	
	public Main() {
		
		if (myBank == null) myBank = new Bank();
		bankGUI = new BankOrganizerGUI(myBank);
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
			Parent loader = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			
			
			((FXMLLoader) loader).setController(bankGui);
			Parent root = loader.load();

			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Project Bilet");
			usserGUI.loadUserWindow(null);
			stage.show();
			stage.sizeToScene();}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
