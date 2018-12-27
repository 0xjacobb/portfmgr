package portfmgr.view;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import portfmgr.portfmgrApplication;
import portfmgr.model.PortfolioRepository;

/**
 * This class represents one of the main controllers and manage the detail view about the portfolios.
 * 
 * @author Marc Steiner
 */

public class PortfolioDetailViewController {

	private portfmgrApplication mainApp;
	private Long Id;
	private String newPortfolioName;
	private String portfolioCurrency;
	
	@Autowired
	PortfolioRepository portRepo;
	
	@FXML
	private Button openDashboard;
	@FXML
	private Button submitButton;
	@FXML
	private TextField portfolioName;
	@FXML
	private ChoiceBox<String> currency;
	@FXML
	private void submitData(ActionEvent event){
		newPortfolioName = portfolioName.getText();
		portfolioCurrency = currency.getValue();
		
		updatePortfolioNameAndCurrency();
    }


	public void openDashboard() {
		try {
			// Loads the portfolioView
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(portfmgrApplication.class.getResource("view/PortfolioView.fxml"));
			AnchorPane overview = (AnchorPane) loader.load();

			PortfolioViewController controller = loader.getController();
			controller.setMainApp(mainApp);

			mainApp.getRootLayout().setCenter(overview);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	

	public void updatePortfolio() {
		/*
		 * TO DO:
		 * Neue Instanz von OnlineCourseQuery welches ein JSON Objekt zurück gibt
		 * Alle Daten  neu Berechnen und die Daten des Portoflio updaten
		 */
		
	}
	
	public void updatePortfolioNameAndCurrency() {
		/*
		 * TO DO: Updatet nur den Namen und die gewählte Currency. 
		 * Wird nach editPortfolio und dessen Aufruf von UpdateView (Action submit Button) aufgerufen  
		 */
        
        System.out.println(newPortfolioName);
        System.out.println(portfolioCurrency);
        System.out.println(Id);
        
		
		/*
		 * 	Portfolio portfolio = portRepo.findByPortfolioId(Id);
		 *  portfolio.setPortfolioCurrency(portfolioCurrency);
		 *  portfolio.setPortfolioName(portfolioName);
		 */
		
	}
	
	public void editPortfolio() {
		
		/*
		 * TO DO: Pop Up erstellen welches Input entgegen nimmt für Currency und Namen
		 */

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(portfmgrApplication.class.getResource("view/PortfolioUpdateView.fxml"));
			AnchorPane overview = (AnchorPane) loader.load();
			
			/*
			
			choiceBox.setValue("CHF");
			choiceBox.setItems(currencyOptions);
			
			
			/*
			Stage modalDialog = new Stage();
			Scene scene = new Scene(overview);
			
			modalDialog.setScene(scene);
		    modalDialog.setTitle("Modal Dialog");
		    modalDialog.initModality(Modality.WINDOW_MODAL);
		    modalDialog.initOwner(modalDialog);
	        modalDialog.showAndWait();
	        mainApp.getRootLayout().setCenter(modalDialog);
	        */
			
			/*
			 * WAIT von modalDialog.showAndWait() muss implementiert werden um nach dem updatePortfolioNameAndCurrency()
			 * eine neue Ansicht zu bekommen
			 */
			
			mainApp.getRootLayout().setCenter(overview);
	     
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void setMainApp(portfmgrApplication mainApp) {
		this.mainApp = mainApp;

	}
	
	public void setActualPortoflio(Long PortfolioId) {
		Id = PortfolioId;	
	}
	
	public Long getActualPortoflio() {
		return Id;	
	}

	

}
