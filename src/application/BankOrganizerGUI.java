package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Bank;
import model.Client;

public class BankOrganizerGUI{
	
	@FXML
    private TableView<?> txBaseTV;

    @FXML
    private TableColumn<Client, String> tclName;

    @FXML
    private TableColumn<?, ?> tclID;

    @FXML
    private TableColumn<?, ?> tclBankAccount;

    @FXML
    private TableColumn<?, ?> tclIncDate;
    
    private Bank myBank;
    
    public BankOrganizerGUI(Bank d) {
		myBank = d;
	}

    @FXML
    void loadSortByBankAcc(ActionEvent event) {

    }

    @FXML
    void loadSortByIncDate(ActionEvent event) {

    }

    @FXML
    void loadSortByName(ActionEvent event) {

    }

    @FXML
    void loadSortIByID(ActionEvent event) {

    }

    @FXML
    void loadStartWindow(ActionEvent event) {

    }
    
    @FXML
    private TextField txtNameCreation;

    @FXML
    private TextField txtIDcreation;

    @FXML
    private RadioButton creditCardRadio;

    @FXML
    private RadioButton debitCardRadio;

    @FXML
    private TextField txtInitialAmount;

    @FXML
    void loadBackCreat(ActionEvent event) {

    }

    @FXML
    void loadRegisterCreat(ActionEvent event) {

    }
    @FXML
    private TableColumn<?, ?> tclNombreFC;

    @FXML
    private TableColumn<?, ?> tclCedulaFC;

    @FXML
    void loadFirstClientInfo(ActionEvent event) {

    }

    @FXML
    void loadBackFC(ActionEvent event) {

    }
    @FXML
    private TableColumn<?, ?> tclNombreFP;

    @FXML
    private TableColumn<?, ?> tclCedulaFP;

    @FXML
    void loadFirstClientInfoFP(ActionEvent event) {

    }

    @FXML
    void loadStartWindowFP(ActionEvent event) {

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
    void loadClientCreat(ActionEvent event) {

    }

    @FXML
    void loadClientQueue(ActionEvent event) {

    }

    @FXML
    void loadPriorityQueue(ActionEvent event) {

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

    }

    @FXML
    void loadCancelAccount(ActionEvent event) {

    }

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
		
	}

}
