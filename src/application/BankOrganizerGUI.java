package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import Queue.Queue;
import customExceptions.NoFoundException;
import customExceptions.RepeatUserException;
import customExceptions.invalidInformationException;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import model.Bank;
import model.Client;
import model.DebitCard;


public class BankOrganizerGUI implements Initializable{

	@FXML
	private TableView<Client> txBaseTV;

	@FXML
	private TableColumn<Client, String> tclName;

	@FXML
	private TableColumn<Client, Integer> tclID;

	@FXML
	private TableColumn<Client, Double> tclAmount;

	@FXML
	private TableColumn<Client,String> tclIncDate;

	@FXML
	private BorderPane mainPane;

	private Bank myBank;

	public BankOrganizerGUI(Bank d) {
		myBank = d;
	}
	@FXML
	void loadStartWindowBD(ActionEvent event) throws Exception {

		loadStartWindow(null);

	}

	@FXML
	void loadSortByAmount(ActionEvent event) throws Exception {
		loadDatabase( event);

	}

	@FXML
	void loadSortByIncDate(ActionEvent event) throws Exception {

		loadDatabase( event);
	}

	@FXML
	void loadSortByName(ActionEvent event) throws Exception {

		loadDatabase( event);
	}

	@FXML
	void loadSortIByID(ActionEvent event)throws Exception {

		loadDatabase( event);

	}

	@FXML
	void loadStartWindow(ActionEvent event) throws Exception {

		loadStartWindowFP(null);


	}

	

	@FXML
	void loadBackCreat(ActionEvent event) throws Exception {

		loadStartWindow(null);

	}

	@FXML
	void loadRegisterCreat(ActionEvent event) {

		try {
			if (txtNameCreation.getText() == null && (txtIDcreation.getText() == null) ){


				throw new invalidInformationException();


			}
			else {

				String name = txtNameCreation.getText();

				String id = txtIDcreation.getText();

				String amountS = txtInitialAmount.getText();
				

				double amount =0;
				int limit =0;
				double deuda=0;
				int i =0;
				try {

				
					 if(amountS.isEmpty()) {
						 amount=0;
					 }else {
						 
					 
				 amount = Double.parseDouble(amountS);
				
					 }

				 i = Integer.parseInt(id);
				}catch(NumberFormatException ne) {
					
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle(null);
					alert.setContentText("Debes rellenar los campos con numeros");
					alert.showAndWait();
				}




				if(myBank.getBank().get(i) != null) {

					throw new RepeatUserException();



				}

				if(creditCardOption.isSelected()) {
					
					String limitS = txtLimit.getText();
					
					String deudaS = txtMoneyToPay.getText();
					
					 limit = Integer.parseInt(limitS);
					 deuda = Double.parseDouble(deudaS);
					
					myBank.registerClient(name,i,amount,deuda,limit);
					
				}
				else {

					myBank.registerClient(name,i,amount);

				}







			}

		}
		catch(invalidInformationException iE) {


			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(null);
			alert.setContentText(iE.getMessage());
			alert.showAndWait();



		}catch (NumberFormatException nE) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(null);
			alert.setContentText("La cedula deben ser solo numeros");
			alert.showAndWait();


		}catch (RepeatUserException rE) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(null);
			alert.setContentText(rE.getMessage());
			alert.showAndWait();


		}



	}
	@FXML
	private TableColumn<Client, String> tclNombreFC;

	@FXML
	private TableColumn<Client, Integer> tclCedulaFC;

	private TableView<Client> tvFilaCliente;

	@FXML
	void loadFirstClientInfoFC(ActionEvent event) {
		
		
		

	}

	@FXML
	void loadBackFC(ActionEvent event) throws Exception{

		loadStartWindow(null);


	}
	@FXML
	private TableColumn<Client, String> tclNombreFP;

	@FXML
	private TableColumn<Client, String> tclCedulaFP;

	private TableView<Client> tvFilaPrioridad;

	@FXML
	void loadFirstClientInfoFP(ActionEvent event) {

	}

	@FXML
	void loadStartWindowFP(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TurnoCliente.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.setCenter(registry);

	}
	@FXML
	private TextField txtNameTurn;

	@FXML
	private TextField txtIDturn;

	@FXML
	private RadioButton normalQueueRadio;

	@FXML
	private RadioButton priorityQueueRadio;

	@FXML
	private RadioButton firstPriority;

	@FXML
	private ToggleGroup Prioridad;

	@FXML
	private RadioButton secondPriority;

	@FXML
	private RadioButton thirdPriority;
	
    @FXML
    private ToggleGroup Fila;





	@FXML
	void loadDatabase(ActionEvent event) throws IOException {
		if(!myBank.getArrayListClients().isEmpty()) {
			inicializeTVClientsDataBase();
		}

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("baseDeDatos.fxml"));
		fxmlLoader.setController(this);
		Parent registry = null;

		registry = fxmlLoader.load();


		mainPane.getChildren().clear();
		mainPane.setCenter(registry);
		
		
	}

	
	public void inicializeTVClientsDataBase() {
		
		

		ObservableList<Client> observableList = FXCollections.observableArrayList(myBank.getArrayListClients());
		txBaseTV.setItems(observableList);
		tclName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		tclID.setCellValueFactory(new PropertyValueFactory<Client, Integer>("cc"));
		tclAmount.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		tclIncDate.setCellValueFactory(new PropertyValueFactory<Client,String>("registerDate"));


	}


	@FXML
	void loadRegisTurn(ActionEvent event) {


		String idTurn = txtIDturn.getText();
		
		

		try {

			if(idTurn == "") {
				throw new invalidInformationException();
				
				
				
			}
			
			
			
			
			
			
			




		}catch(invalidInformationException iF) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(null);
			alert.setContentText(iF.getMessage());
			alert.showAndWait();

		}















	}
	@FXML
	private TextField txtNameCreation;

	@FXML
	private TextField txtIDcreation;
	@FXML
	private CheckBox creditCardOption;

    @FXML
    private TextField txtInitialAmount;

    @FXML
    private TextField txtMoneyToPay;

    @FXML
    private TextField txtLimit;

	@FXML
	void loadClientCreat(ActionEvent event) {


		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClientCreation.fxml"));
		fxmlLoader.setController(this);
		Parent registry = null;
		
		try {
			registry = fxmlLoader.load();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException np) {
			np.printStackTrace();
		}

		mainPane.getChildren().clear();
		mainPane.setCenter(registry);


	}

	@FXML
	void loadClientQueue(ActionEvent event) {
		if(!myBank.getArrayListClientQueue().isEmpty()) {

			inicializeTVClientQueue();
		}

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("filaCliente.fxml"));
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




	}

	public void inicializeTVClientQueue() {

		
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(myBank.getArrayListClientQueue());

		tvFilaCliente.setItems(observableList);
		tclNombreFC.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		tclCedulaFC.setCellValueFactory(new PropertyValueFactory<Client, Integer>("cc"));


	}

	@FXML
	void loadPriorityQueue(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("filaPrioridad.fxml"));
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

	}

	@FXML
	private Label clientNameInfo;

	@FXML
	private Label clientIDInfo;

	@FXML
	private Label accountNumber;

	@FXML
	private Label cardDate;

	@FXML
	private Label cardDate1;

	@FXML
	private TextField amountToPay;

	@FXML
	private Label deudaSpace;

	@FXML
	void loadBackInfoClient(ActionEvent event) {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TurnoCliente.fxml"));
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
	}

	@FXML
	void loadCancelAccount(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("baseCancelados.fxml"));
		fxmlLoader.setController(this);
		Parent registry = null;
		try {
			registry = fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mainPane.getChildren().clear();
		mainPane.setCenter(registry);}

	@FXML
	void loadConsign(ActionEvent event) {

	}

	@FXML
	void loadPayCard(ActionEvent event) {

	}

	@FXML
	void loadRetire(ActionEvent event) {

	}

	@FXML
	void loadUndo(ActionEvent event) {

	}





	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myBank = new Bank();
		/*
		try {
			myBank.loadBankData();
			myBank.loadClients();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

}
