package application;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import customExceptions.invalidInformationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Bank;
import model.Client;


public class BankGUIController implements Initializable {

	private static Bank bank;

	BankGUIController main;

	public BankGUIController(Bank b){
		bank = b;
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


	private void loadMainWindow() throws Exception{
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ventanaPrincipal.fxml"));
			fxmlLoader.setController(this);
			Parent registry = fxmlLoader.load()	;	

			mainPane.getChildren().clear();
			mainPane.setCenter(registry);	

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadQueueWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tablaQueue.fxml"));
			fxmlLoader.setController(this);
			Parent registry =null;
			registry = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(registry);	

		} catch (IOException e) {
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
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void loadTableDataBase() {

		ObservableList<Client> data = FXCollections.observableArrayList(bank.getArrayClients());

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
		tablaBaseDeDatos.getColumns().clear();
		tablaBaseDeDatos.getColumns().addAll(nameCol,ccCol ,amountCol,dateCol);
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private void loadTableQueue() {


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
		tablaCola.getColumns().clear();
		tablaCola.getColumns().addAll(nameCol,ccCol ,amountCol,dateCol);
	}

	@SuppressWarnings("unchecked")
	public void loadTablePriorityQueue() {

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
		tablaPrioridad.getColumns().clear();
		tablaPrioridad.getColumns().addAll(nameCol,ccCol ,amountCol,dateCol);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}
	@FXML
	public void viewDataBase(ActionEvent o) throws Exception {

		loadMainWindow();
		if(!bank.getBank().isEmpty()) {
			loadTableDataBase();
		}
		refreshMainTable();
	}

	public void viewRegisterWindow() {
		loadRegisterWindow();

	}
	@FXML
	private TextField registerlimitCC;

	@FXML
	private TextField registerDebtCC;

	public void registerClient() {

		try {

			if (registerName.getText().isEmpty()||registerCc.getText().isEmpty()) {

				throw new invalidInformationException();

			}
			String name = registerName.getText();
			String cc = registerCc.getText();
			double amount = 0;

			int id = Integer.parseInt(cc);

			String amou = registerAmount.getText();
			if(!amou.equals("")) {
				amount = Double.parseDouble(amou);
			}

			String limitt = registerlimitCC.getText();
			String balancee = registerDebtCC.getText();

			if(!limitt.equals("") && !balancee.equals("")) {
				int limit = Integer.parseInt(limitt);
				int balance = Integer.parseInt(balancee);
				bank.registerClient(name, id, amount, balance, limit);
			}else{
				bank.registerClient(name, id, amount);
			}

			registerName.clear();
			registerCc.clear();
			registerlimitCC.clear();
			registerDebtCC.clear();
			registerAmount.clear();


			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Cliente registrado satisfactoriamente");
			alert.setContentText(":D");
			alert.showAndWait();


		}

		catch (NumberFormatException nE) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos llenados de forma incorrecta");
			alert.setContentText("Los campos pueden estar vacios o con valores no correspondientes.");
			alert.showAndWait();

		}

		catch(invalidInformationException iie) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos llenados de forma incorrecta,registro no exitoso");
			alert.setContentText(iie.getMessage());	
			alert.showAndWait();



		}

		catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}



	public void viewPriorityQueue() {
		loadPriorityQueueWindow();
		if(!bank.getBank().isEmpty()) {
			loadTablePriorityQueue();
		}
		refreshPriorityQueueTable();

	}
	
	@FXML
	void atenderClientPQ() {
		
	}

	@FXML
	private TextField atendedCc;

	@FXML
	private TextField atendedName;

	@FXML
	private TextField atendedDate;

	@FXML
	private TextField atendedAmount;

	@FXML
	private TextField atendedTCAmount;

	@FXML
	private TextField atendedWithdrawAmount;

	@FXML
	private TextField atendedDepositInAmount;

	@FXML
	private TextField atendedDCAmount;

	@FXML
	private TextField atendedDCPaidment;
	@FXML
	void atenderClientNQ(ActionEvent Event) {
		
		
		if(!bank.getClientQueue().isEmpty()) {
		
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("atenderCliente.fxml"));
		fxmlLoader.setController(this);
		Parent registry = null;
		try {
			registry = fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainPane.getChildren().clear();
		mainPane.setCenter(registry);
		
		
	

		Client c = bank.getClientQueue().dequeue();
		atendedName.setText(c.getName());
		atendedCc.setText(""+c.getCc());
		atendedTCAmount.setText(""+c.getCrediCard().getBalance());
		atendedDCAmount.setText(""+c.getDebitCard().getAmount());
		}

	}

	@FXML
	void depositarClienteNQ(ActionEvent event) {
		bank.searchClient(Integer.parseInt(atendedCc.getText())).setAmount(Integer.parseInt(atendedAmount.getText())
				+Integer.parseInt(atendedDepositInAmount.getText()));
	}

	@FXML
	void retirarClienteNQCA(ActionEvent event) {
		bank.searchClient(Integer.parseInt(atendedCc.getText())).getDebitCard().setAmount(Integer.parseInt(atendedDCAmount.getText())
				-Integer.parseInt(atendedDCPaidment.getText()));
	}

	@FXML
	void pagarClienteNQCA(ActionEvent event) {
		bank.searchClient(Integer.parseInt(atendedCc.getText())).setAmount(Integer.parseInt(atendedAmount.getText())
				+Integer.parseInt(atendedWithdrawAmount.getText()));
	}

	@FXML
	void cancelAcountNQ(ActionEvent event) {
		bank.cancelAcount(Integer.parseInt(atendedCc.getText()));
	}


	@FXML
	void añadirClienteNQ(ActionEvent event) {
		
			
			
		

	}

	@FXML
	void eliminarClientNQ(ActionEvent event) {

	}
	public void viewQueue() {	
		loadQueueWindow();
		if(!bank.getBank().isEmpty()) {
			loadTableQueue();
		}
		refreshQueueTable();
		
	}

	public void refreshMainTable() {
		tablaBaseDeDatos.getItems().clear();
		ObservableList<Client> data = FXCollections.observableArrayList(bank.getArrayClients());
		tablaBaseDeDatos.setItems(data);
	}

	public void refreshPriorityQueueTable() {
		tablaPrioridad.getItems().clear();
		ObservableList<Client> data = FXCollections.observableArrayList(bank.getPrioriQueueList());
		tablaPrioridad.setItems(data);
	}
	public void refreshQueueTable() {
		tablaCola.getItems().clear();
		ObservableList<Client> data = FXCollections.observableArrayList(bank.getClientQueue().toArrayList());
		tablaCola.setItems(data);
	}

	@FXML
	private ToggleGroup usuario;

	@FXML
	private TextField idToSearch;

	@FXML
	private RadioButton oldMan;

	@FXML
	private RadioButton handicapped;

	@FXML
	private RadioButton pregnatWomen;

	@FXML
	void createTurn(ActionEvent event) {
		try {
			String id = idToSearch.getText();
			int cc = 0;
			if(!id.equals("")) {
				cc = Integer.parseInt(id);
				if(bank.searchClient(cc)!=null) {
					if(oldMan.isSelected()) {
						bank.addToPriorityQueue(bank.searchClient(cc), 1);
					}else if(handicapped.isSelected()) {
						bank.addToPriorityQueue(bank.searchClient(cc), 2);
					}else if(pregnatWomen.isSelected()) {
						bank.addToPriorityQueue(bank.searchClient(cc), 3);
					}else {
						bank.addClientToQueue(bank.searchClient(cc));
					}

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Turno registrado satisfactoriamente");
					alert.setContentText(":D");
					alert.showAndWait();
					idToSearch.clear();

				}else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Numero de cedula no registrado en el sistema");
					alert.setContentText("Por favor registrarse en el boton registrar.");
					alert.showAndWait();
					
				}
			}else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Campos llenados de forma incorrecta");
				alert.setContentText("Por favor llenar los campos requeridos.");
				alert.showAndWait();
				
				
			}
		}catch (NumberFormatException nE) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos llenados de forma incorrecta");
			alert.setContentText("Los campos pueden estar vacios o con valores no correspondientes.");
			alert.showAndWait();
		}
	}
	
	@FXML
	void addToQueuePQ(ActionEvent event) {
		
	}

	@FXML
	void loadBack(ActionEvent event) {
		try {
			viewDataBase(event);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@FXML
	void registryUser(ActionEvent event) {

		viewRegisterWindow();

	}

	@FXML
	void registryTurnPrincipalWindow(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registroTurno.fxml"));
			fxmlLoader.setController(this);
			Parent registry = null;
			registry = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(registry);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void sortByAmount(ActionEvent event) {
		bank.setArrayList(bank.bstSort().toArray(new Client[bank.bstSort().size()]));

		try {
			loadMainWindow();
			if(!bank.getBank().isEmpty()) {
				loadTableDataBase();
			}
			refreshMainTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


	@FXML
	void sortByCc(ActionEvent event) {

		bank.setArrayList(bank.heapSortId());

		try {
			loadMainWindow();
			if(!bank.getBank().isEmpty()) {
				loadTableDataBase();
			}
			refreshMainTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void sortByDate(ActionEvent event) {

		bank.setArrayList(bank.mergeSortMethod());

		try {
			loadMainWindow();
			if(!bank.getBank().isEmpty()) {
				loadTableDataBase();
			}
			refreshMainTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@FXML
	void sortByName(ActionEvent event) {

		bank.setArrayList(bank.selectionSortName());;

		try {
			loadMainWindow();
			if(!bank.getBank().isEmpty()) {
				loadTableDataBase();
			}
			refreshMainTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}

