package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	public void start(Stage stage) throws Exception {
			
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));

		loader.setController(bankGUI);
		Parent root = loader.load();

		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Bank Organizer");
		bankGUI.loadStartWindowFP(null);
		stage.show();
		stage.sizeToScene();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream entrada = null;
		try
		{
			entrada = new ObjectInputStream(new FileInputStream("data" + File.separator + "Registry.txt")); 
			myBank = (Bank)entrada.readObject(); 
			entrada.close();
		}
		catch(Exception e)
		{
			if(entrada != null) entrada.close();
		}
		
		launch(args);
		
		
		ObjectOutputStream salida = new ObjectOutputStream(
		new FileOutputStream("data" + File.separator + "Registry.txt"));
		salida.writeObject(myBank);
		salida.close();
	}
}
