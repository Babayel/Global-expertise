/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.list.CompteDao;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Compte;
import models.Transaction;
import views.utils.Utils;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class TransactionController implements Initializable {

    @FXML
    private VBox left;
    @FXML
    private Label labNumCompte;
    @FXML
    private RadioButton btnDepot;
    @FXML
    private TextField txtCode;
    @FXML
    private Button btnOk;
    @FXML
    private TextField fieldNciEnv;
    @FXML
    private TextField fieldFullnameEnv;
    @FXML
    private TextField fieldTelephoneEnv;
    @FXML
    private TextField fieldNciBen;
    @FXML
    private TextField fieldFullnameBen;
    @FXML
    private Label labSolde;
    @FXML
    private RadioButton btnRetrait;
    @FXML
    private TextField txtMnt;
    @FXML
    private Button btnValider;
    @FXML
    private TableView<Transaction> tableTransaction;
    @FXML
    private TableColumn<Transaction, String> colDate;
    @FXML
    private TableColumn<Transaction, String> colMnt;
    
    //TextInputControl[];
    
    
    //prop
    
    Compte compte;
    CompteDao compteDao;
    Transaction transaction;
    services.Transaction ts;
    private String typeTransaction;
    ObservableList<Transaction> Obltransactions;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.compteDao = new CompteDao();
        this.compte = compteDao.findAll().get(2);
        labNumCompte.setText(compte.getNumero());
        labSolde.setText(String.valueOf(compte.getSolde()));
        
        this.ts = new services.Transaction();
        this.colDate.setCellValueFactory(new PropertyValueFactory<>("date"));        
        this.colMnt.setCellValueFactory(new PropertyValueFactory<>("montant"));        
        Obltransactions = FXCollections.observableArrayList(ts.getTransactionsByCompte(this.compte));
        this.tableTransaction.setItems(Obltransactions);

    }    

    @FXML
    private void handleDepot(ActionEvent event) {
        this.typeTransaction = "Dépot";
        this.refector();
        
    }

    @FXML
    private void handleRetrait(ActionEvent event) {
        this.typeTransaction = "Retrait";
        this.refector();
    }

    @FXML
    private void handleCheckCode(ActionEvent event) {
        //this.btnOk.setDisable(false);
        if(this.txtCode.getText().equals("lampuFaalCash")){
            this.txtMnt.setText("2000");
            
        }
    }

    @FXML
    private void handleValidate(ActionEvent event) {
        //case Retrait
        if(this.typeTransaction.equals("Retrait")){
        this.compte.setRetrait(Double.parseDouble(this.txtMnt.getText()));
        }
        else
        //case Dépot
        {
            this.compte.setDepot(Double.parseDouble(this.txtMnt.getText()));
        }
        
        this.transaction = new Transaction(Integer.valueOf(this.txtMnt.getText()),this.typeTransaction,this.compte.getId());
        Obltransactions.add(transaction);
    }
    
    private void refector(){
        if(this.typeTransaction.equals("Retrait")){
        Utils.disableFilds(Arrays.asList(txtMnt,fieldNciEnv,fieldFullnameEnv,fieldTelephoneEnv));
        this.btnDepot.setSelected(false);        
        this.btnOk.setDisable(false);
        }
        else
        //case Dépot
        {
            this.btnOk.setDisable(true);
            this.btnRetrait.setSelected(false);
            this.txtMnt.setDisable(false);
        }
    }
    
    
    
}
