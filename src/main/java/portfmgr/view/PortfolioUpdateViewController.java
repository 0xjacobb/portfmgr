package portfmgr.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import portfmgr.portfmgrApplication;
import portfmgr.model.Portfolio;
import portfmgr.model.PortfolioRepository;

/**
 * This class represents the controller for the update view which is used to set name and currency of the actual portfolio.
 * 
 * @author Marc Steiner
 */

@Controller
public class PortfolioUpdateViewController implements Initializable {
	
	@SuppressWarnings("unused")
	private portfmgrApplication mainApp;
	
	private String portfolioName;
	private String portfolioFiatCurrency;
	private Portfolio portfolio;
	private Stage dialogStage;
	
	@Autowired
	PortfolioRepository portRepo;
	
	@FXML
	private ComboBox<String> currencyBox;
	@FXML
	private TextField newPortfolioName;
	@FXML
	private Button submit;
	
	@FXML
	public void handleKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			newPortfolioName.setText(newPortfolioName.getText());
			submit.requestFocus();
		}
	}
	
	@FXML
	public void handleKeyPressedSubmit(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			handleSubmit();
		}
	}
      
    /**
     * Called when the user clicks submit button. It writes the new portfolio name and currency direct into the database
     */
    @FXML
    private void handleSubmit() {
    	    	
        if (isInputValid()) {
        	
        	portfolio.setPortfolioName(newPortfolioName.getText());
        	portfolio.setPortfolioFiatCurrency(currencyBox.getValue());        	
        	portRepo.save(portfolio);
        	dialogStage.close();
        } else newPortfolioName.requestFocus();
    }
    
    
    /**
     * Checks if the input for name and cryptoCurrency is correct, otherwise prompt alert
     */
    private boolean isInputValid() {
    	
    	if (newPortfolioName.getText() == null || newPortfolioName.getText().trim().isEmpty() || currencyBox.getValue() == null) {
 
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Eingabefehler");
            alert.setHeaderText("Portfolioname und W�hrung darf nicht leer sein");
            alert.showAndWait();
    
    		return false;
    	}
    	
    	return true;
    }
    
    /**
     * Set the possible currency list for the choiceBox and displays the actual name and currency from the portfolio.
     * @param currencyList: Is the possible selection of currencies (CHF, EUR...)
     * @param portfolio: the actual portfolio
     */
    public void init (Portfolio portfolio, List<String> currencyList) {

    	this.portfolio = portfolio;
    	
    	currencyBox.setItems(FXCollections.observableArrayList(currencyList));
    	currencyBox.setValue(portfolio.getPortfolioFiatCurrency());
    	newPortfolioName.setPromptText(portfolio.getPortfolioName());
    	newPortfolioName.requestFocus();
    	
    }
    
    public String getPortfolioName() {
    	return portfolioName;
    }
    
    public String getPortfolioFiatCurrency() {
    	return portfolioFiatCurrency;
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
	public void setMainApp(portfmgrApplication mainApp) {
		this.mainApp = mainApp;
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
