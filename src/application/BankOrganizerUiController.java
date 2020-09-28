package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class BankOrganizerUiController implements Initializable {
	
	@FXML
    private TableView<?> txBaseTV;

    @FXML
    private TableColumn<?, ?> tclName;

    @FXML
    private TableColumn<?, ?> tclID;

    @FXML
    private TableColumn<?, ?> tclBankAccount;

    @FXML
    private TableColumn<?, ?> tclIncDate;

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

    
    


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
