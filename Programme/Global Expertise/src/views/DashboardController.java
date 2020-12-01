/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class DashboardController implements Initializable {

    @FXML
    private Label labFullname;
    @FXML
    private Label labProfil;
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnCreation;
    @FXML
    private Button btnDepot;
    @FXML
    private Button btnTransaction;
    @FXML
    private Button btnCreateCompteSec;
    @FXML
    private Button btnBloquerCompte;
    @FXML
    private Button btnProfil;
    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.labFullname.setText(ConnexionController.user.getFullName());
        this.labProfil.setText(ConnexionController.user.getProfil());
    }    

    @FXML
    private void handleDeconnexion(ActionEvent event) {
    }

    @FXML
    private void handleCreationComptePartenaire(ActionEvent event) throws IOException {
        this.loadView(anchorPane, "addCompte");
    }

    @FXML
    private void handleFaireDepot(ActionEvent event) throws IOException {
        this.loadView(anchorPane, "FaireDepot");
    }

    @FXML
    private void handleTransaction(ActionEvent event) throws IOException {
        this.loadView(anchorPane, "Transaction");
    }

    @FXML
    private void handleCreationCompteUser(ActionEvent event) {
    }

    @FXML
    private void handleBloquerCompte(ActionEvent event) {
    }

    @FXML
    private void handleProfile(ActionEvent event) {
    }

    public void loadView(AnchorPane mainContainer, String view) throws IOException {
            mainContainer.getChildren().clear();
            mainContainer.getChildren().add(FXMLLoader.load(getClass().getResource(view+".fxml")));
    }
    
}
