package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
	
<<<<<<< HEAD
	BankGUIController bankGUI;
	Bank bank;
	Scene scene;
	
	public Main() {
		if(bank==null) {
		bank = new Bank();
		}
		bankGUI= new BankGUIController(bank);
	}
	
	@Override
	public void start(Stage stage)   {
		try {	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			
			loader.setController(bankGUI);
			Parent root = loader.load();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Bank Organizer");
			bankGUI.viewDataBase(null);
=======
	@Override
	public void start(Stage stage)   {
		try {	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ventanaPrincipal.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Bank Organizer");
>>>>>>> 9c401206f14677b390af3854e3bbfd4c4c6b5ebf
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
