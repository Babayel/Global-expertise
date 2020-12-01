/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Compte;
import models.Depot;
import models.Partenaire;
import services.Transaction;
import views.utils.Utils;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FaireDepotController implements Initializable {

    @FXML
    private TextField txtNci;
    @FXML
    private TextField txtNomComplet;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextArea txtAddress;
    @FXML
    private TableColumn<Compte, String> tblColNum;
    @FXML
    private TableColumn<Compte, String> tblColSolde;
    @FXML
    private TableView<Depot> tblViewDepot;
    @FXML
    private TableColumn<Depot, String> dpColDate;
    @FXML
    private TableColumn<Depot, String> dbColMnt;
    @FXML
    private TableView<Compte> tblViewCompte;
    
    private Partenaire partenaire;
    private Compte compte;
    private ObservableList<Compte> OblComptes;
    private ObservableList<Depot> OblDepots;
    private Transaction ts;
    @FXML
    private TextField txtMnt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.ts = new Transaction();

    }    

    @FXML
    private void hundleSearchPartenaire(ActionEvent event) {         
        this.partenaire = ts.getPartenaireByNci(txtNci.getText());      
        OblComptes = Utils.searchPartenaire(this.partenaire,this.ts,txtNci,txtNomComplet,txtTelephone,txtAddress,txtMnt,tblViewCompte,tblColNum,tblColSolde, OblComptes);
    }

    @FXML
    private void hundleAddDepotPartenaire(ActionEvent event) {
            Depot dp = new Depot(Double.parseDouble(txtMnt.getText()));
            //ts.setDepot(this.compte, dp);
            this.OblDepots.add(dp);
    }

    @FXML
    private void hundleCompteSelected(MouseEvent event) {
        this.compte = this.tblViewCompte.getSelectionModel().getSelectedItem();
        this.dbColMnt.setCellValueFactory(new PropertyValueFactory<>("montant"));
        this.dpColDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        this.OblDepots = FXCollections.observableArrayList(ts.getDepotsByCompte(this.compte));
        this.tblViewDepot.setItems(OblDepots);
    }
    
}
