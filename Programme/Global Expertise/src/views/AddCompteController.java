/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Compte;
import models.Depot;
import models.Partenaire;
import models.User;
import services.Security;
import services.Transaction;
import views.utils.Utils;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AddCompteController implements Initializable {

    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtNci;
    @FXML
    private TextField txtNomComplet;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextArea txtAddress;
    @FXML
    private TextField txtSolde;
    @FXML
    private TableView<Compte> tblView;
    @FXML
    private TableColumn<Compte, String> tblColNum;
    @FXML
    private TableColumn<Compte, String> tblColSolde;
    
    //private Utils utils;    
    private Partenaire partenaire;
    private Transaction ts;
    //private Security sec;
    private ObservableList<Compte> OblComptes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //this.utils = new Utils();
        this.ts = new Transaction();          
        //sec = new Security();
        
    }    

    @FXML
    private void hundleSearchPartenaire(ActionEvent event) {
        // Check if Part exit
         this.partenaire = ts.getPartenaireByNci(txtNci.getText());
         OblComptes = Utils.searchPartenaire(this.partenaire,this.ts,txtNci,txtNomComplet,txtTelephone,txtAddress,txtLogin,txtPassword,txtSolde,tblView,tblColNum,tblColSolde, OblComptes);
    }

    @FXML
    private void hundleAddComptePartenaire(ActionEvent event) {
       
        
        if(this.partenaire == null)
        {//Part not exist
            
            OblComptes.add(ts.addCompteTransactionion(txtNci.getText(),txtNomComplet.getText(),txtTelephone
                    .getText(),txtAddress.getText(),txtLogin.getText(),txtPassword.getText()
                    ,Double.parseDouble(txtSolde.getText())));
        }   
        else
        {//Part exist
            
           OblComptes.add(ts.addCompteTransactionion(this.partenaire,Double.parseDouble(txtSolde.getText())));
            
        }
        //this.utils.searchPartenaire();
    }
    
}
