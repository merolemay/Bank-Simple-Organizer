package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Bank;



public class Main extends Application {
	
	private BankOrganizerGUI bankGUI;
	private Scene scene;
	private Bank bank;
	public Main() {
		bankGUI = new BankOrganizerGUI(bank);
	}
	
	@Override
	public void start(Stage stage)   {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));

			Parent root = loader.load();

			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Bank Organizer");
			bankGUI.loadStartWindowFP(null);
			stage.show();
			stage.sizeToScene();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		
		launch(args);
	}
	
}
