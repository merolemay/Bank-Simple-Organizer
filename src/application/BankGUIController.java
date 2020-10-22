package application;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Bank;
import model.Client;
import model.CreditCard;
import model.DebitCard;

public class BankGUIController implements Initializable {
	
	Bank bank;
	
	BankGUIController main;
	
	public BankGUIController(){
		bank = new Bank();
	}
	
    @FXML
    private BorderPane mainPane;
    
    @FXML
    private TableView<Client> tablaBaseDeDatos;

    @FXML
    private TableView<Client> tablaPrioridad;
    
    @FXML
    private TableView<Client> tablaCola;

    @FXML
    private TextField registerName;

    @FXML
    private TextField registerTc;

    @FXML
    private TextField registerAmount;

    @FXML
    private TextField registerCc;

    @FXML
    private TextField registerDcard;
	
    
    
    private void loadMainWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ventanaPrincipal.fxml"));
			fxmlLoader.setController(this);
			Parent registry = null;
			registry = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(registry);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void loadQueueWindow() {
 		try {
 			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tablaQueue.fxml"));
 			fxmlLoader.setController(this);
 			Parent registry = null;
 			registry = fxmlLoader.load();
 			mainPane.getChildren().clear();
 			mainPane.setCenter(registry);	
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     }
    
    private void loadPriorityQueueWindow() {
 		try {
 			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tablaPriorityQueue.fxml"));
 			fxmlLoader.setController(this);
 			Parent registry = null;
 			registry = fxmlLoader.load();
 			mainPane.getChildren().clear();
 			mainPane.setCenter(registry);	
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     }
    
    private void loadRegisterWindow() {
 		try {
 			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ventanaRegistrar.fxml"));
 			fxmlLoader.setController(this);
 			Parent registry = null;
 			registry = fxmlLoader.load();
 			mainPane.getChildren().clear();
 			mainPane.setCenter(registry);	
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     }
	
    @SuppressWarnings("unchecked")
	private void loadTableDataBase() {
    	tablaBaseDeDatos.getColumns().clear();
 
		ObservableList<Client> data = FXCollections.observableArrayList(bank.getBank().toArrayList());

		TableColumn<Client, String> nameCol = new TableColumn<Client, String>("Nombre");
		nameCol.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		nameCol.setMinWidth(120);
		
		TableColumn<Client, Integer> ccCol = new TableColumn<Client, Integer>("Numero CC");
		ccCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("cc"));
		ccCol.setMinWidth(120);
		    
		TableColumn<Client, Double> amountCol = new TableColumn<Client, Double>("Saldo");
		amountCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		amountCol.setMinWidth(100);
		
		TableColumn<Client, String> dateCol = new TableColumn<Client, String>("Fecha Vinculacion");
  		dateCol.setCellValueFactory(new PropertyValueFactory<Client, String>("registerDateString"));
  		dateCol.setMinWidth(140);

		
		tablaBaseDeDatos.setItems(data);
		tablaBaseDeDatos.getColumns().addAll(nameCol,ccCol ,amountCol,dateCol);
	}
	
    @SuppressWarnings("unchecked")
  	private void loadTableQueue() {
    	tablaCola.getColumns().clear();
    	 
		ObservableList<Client> data = FXCollections.observableArrayList(bank.getClientQueueList());

		TableColumn<Client, String> nameCol = new TableColumn<Client, String>("Nombre");
		nameCol.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		nameCol.setMinWidth(120);
		
		TableColumn<Client, Integer> ccCol = new TableColumn<Client, Integer>("Numero CC");
		ccCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("cc"));
		ccCol.setMinWidth(120);
		    
		TableColumn<Client, Integer> amountCol = new TableColumn<Client, Integer>("Saldo");
		amountCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("amount"));
		amountCol.setMinWidth(100);
		
		TableColumn<Client, String> dateCol = new TableColumn<Client, String>("Fecha Vinculacion");
  		dateCol.setCellValueFactory(new PropertyValueFactory<Client, String>("registerDateString"));
  		dateCol.setMinWidth(140);

		
		tablaCola.setItems(data);
		tablaCola.getColumns().addAll(nameCol,ccCol ,amountCol,dateCol);
  	}
  	
    @SuppressWarnings("unchecked")
   	public void loadTablePriorityQueue() {
    	tablaPrioridad.getColumns().clear();
    	
   		ObservableList<Client> data = FXCollections.observableArrayList(bank.getPrioriQueueList());

   		

   		TableColumn<Client, String> nameCol = new TableColumn<Client, String>("Nombre");
   		nameCol.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
   		nameCol.setMinWidth(140);
   		
   		TableColumn<Client, Integer> ccCol = new TableColumn<Client, Integer>("Numero CC");
   		ccCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("cc"));
   		ccCol.setMinWidth(140);
   		
   		TableColumn<Client, Integer> amountCol = new TableColumn<Client, Integer>("Saldo");
   		amountCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("amount"));
   		amountCol.setMinWidth(100);
   		
   		TableColumn<Client, Date> dateCol = new TableColumn<Client, Date>("Fecha Vinculacion");
   		dateCol.setCellValueFactory(new PropertyValueFactory<Client, Date>("registerDate"));
   		dateCol.setMinWidth(100);

   		
   		tablaPrioridad.setItems(data);
   		tablaPrioridad.getColumns().addAll(nameCol,ccCol ,amountCol ,dateCol,dateCol);
   	}
   	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		main = new BankGUIController();
		loadTableDataBase();
	}
	
	public void viewDataBase() {
		loadTableDataBase();
		loadMainWindow();
	}
	
	public void viewRegisterWindow() {
		loadRegisterWindow();
	}
	
	public void registerClient() {
		Client c = new Client(this.registerName.getText(), Integer.parseInt(this.registerCc.getText()),Integer.parseInt(this.registerAmount.getText()));
		if(this.registerDcard.getText()!=null) {
			c.setDebitCard(new DebitCard(Integer.parseInt(this.registerDcard.getText()),new Date(System.currentTimeMillis()),0,false));
		}	else if(this.registerTc.getText()!=null) {
			c.setCrediCard(new CreditCard(Integer.parseInt(this.registerTc.getText()),new Date(System.currentTimeMillis()),0,false));
		}
		this.bank.addClientToQueue(c);
	}
	
	public void viewPriorityQueue() {
		loadTablePriorityQueue();
		loadPriorityQueueWindow();
	}
	
	public void viewQueue() {
		loadTableQueue();
		loadQueueWindow();
	}
}
