package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Bank;
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
			
			try {
				Parent loader = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
				Scene scene = new Scene(loader);
				primaryStage.setTitle("Flight Organizer");
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
