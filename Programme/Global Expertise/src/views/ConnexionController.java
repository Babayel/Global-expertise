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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import models.User;
import services.Security;
import views.utils.Utils;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ConnexionController implements Initializable {

    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Text txtAnonce;
    
    public static User user;

    
    private Security connexion;
    @FXML
    private AnchorPane mainContainer;
    private Utils utils;
    /**
     * Initializes the controller class.
     * 
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.connexion = new Security();
        //this.utils = new Utils();
        
    }    

    @FXML
    public void hundleConnexion(ActionEvent event) throws IOException {
        this.user = connexion.logOn(txtLogin.getText(),txtPassword.getText());
        if(this.user==null){
            this.txtAnonce.setText("L'utilisateur ou le mot de passe est incorrect");
        }
        else
        {
            switch(user.getProfil()){
                case "adminSystem":
                this.loadView(mainContainer,"Dashboard");
                break;
                default:
                    this.loadView(mainContainer,"addCompte");
            }
            
        }
    }
    
    public User getUser() {
        return user;
    }
        
    public void loadView(AnchorPane mainContainer, String view) throws IOException {
            mainContainer.getChildren().clear();
            mainContainer.getChildren().add(FXMLLoader.load(getClass().getResource(view+".fxml")));
    }
}
