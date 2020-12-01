/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.utils;
    
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.Compte;
import models.Partenaire;
import services.Transaction;
import views.*;


/**
 *
 * @author DELL
 */
public class Utils {
    
    private static List<TextInputControl> filds;

    

    
    private Partenaire partenaire;
    private static Transaction transaction;
    //public ObservableList comptesObs;


    public Utils() {
        transaction = new Transaction();
    }
    

    
    //serch for All
    /*
    public Partenaire searchPartenaire(TextField txtNci, TextField txtNomComplet, TextField txtTelephone, TextArea txtAddress, TableView<?> tblView, TableColumn<?, ?> tblColNum, TableColumn<?, ?> tblColSolde)
    {
        
        
        this.filds = new ArrayList<>(
                Arrays.asList(
                        txtNomComplet,
                        txtTelephone,
                        txtAddress
                        )
        );
        //===========
        this.partenaire = new Transaction().getPartenaireByNci(txtNci.getText());
        if(partenaire!=null)
        {
            txtNomComplet.setText(partenaire.getNomComplet());
            txtTelephone.setText(partenaire.getTel());
            txtAddress.setText(partenaire.getAddress());
            this.disableFilds();
        }
        else
        {
            this.enableFilds();
            this.emptyFilds();
        }
        
        return partenaire;
    }
*/
    //serch for Create Partenair 
    public static ObservableList<Compte> searchPartenaire(Partenaire partenaire,Transaction ts,TextField nci, TextField nomComplet, TextField telephone, TextArea address, TextField login, TextField password, TextField txtSolde, TableView<Compte> tblView, TableColumn<Compte, String> tblColNum, TableColumn<Compte, String> tblColSolde,ObservableList<Compte> OblComptes)
    {

        if(OblComptes != null) OblComptes.clear();
            
        filds = new ArrayList<>(
                Arrays.asList(
                        nomComplet,
                        telephone,
                        address,
                        login,
                        password,
                        txtSolde
                        )
        );
        //===========
        
        if(partenaire!=null)
        {//part exist
            nomComplet.setText(partenaire.getFullName());
            telephone.setText(partenaire.getTelephone());
            address.setText(partenaire.getAddress());
            login.setText(partenaire.getLogin());
            password.setText(partenaire.getPassword());
            disableFilds();
            
           
            return  remplireComptes(partenaire,ts,tblView,tblColNum,tblColSolde,OblComptes);
            
                       
        }
        else
        {//parte not exist            
            //Transaction.comptesObl.clear();
            enableFilds();
            emptyFilds();
            return OblComptes;
        }
        
    }
    
    public static ObservableList<Compte> searchPartenaire(Partenaire partenaire, Transaction ts, TextField txtNci, TextField txtNomComplet, TextField txtTelephone, TextArea txtAddress, TextField txtMnt, TableView<Compte> tblViewCompte, TableColumn<Compte, String> tblColNum, TableColumn<Compte, String> tblColSolde, ObservableList<Compte> OblComptes) {
        if(OblComptes != null) OblComptes.clear();
            
        filds = new ArrayList<>(
                Arrays.asList(
                        txtNomComplet,
                        txtTelephone,
                        txtAddress
                        
                        )
        );
        //===========
        
        if(partenaire!=null)
        {
            txtNomComplet.setText(partenaire.getFullName());
            txtTelephone.setText(partenaire.getTelephone());
            txtAddress.setText(partenaire.getAddress());
            disableFilds();
            
           
            return  remplireComptes(partenaire,ts,tblViewCompte,tblColNum,tblColSolde,OblComptes);
            
                       
        }
        else
        {            
            //Transaction.comptesObl.clear();
            enableFilds();
            emptyFilds();
            return OblComptes;
        }
    }
    
    
    
    public static void disableFilds() {
        filds.forEach((fld) -> {
            fld.setDisable(true);
        });
    }
    public static void disableFilds(List<TextInputControl> fields) {
        fields.forEach((fld) -> {
            fld.setDisable(true);
        });
    }
    private static void enableFilds() {
        filds.forEach((fld) -> {
            fld.setDisable(false);
        });
    }
    private static void emptyFilds() {
        filds.forEach((fld) -> {
            fld.clear();
        });
    }

    private static ObservableList<Compte> remplireComptes(Partenaire part,Transaction ts,TableView<Compte> tblView, TableColumn<Compte, String> tblColNum, TableColumn<Compte, String> tblColSolde,ObservableList<Compte> OblComptes) {
        //List<Compte> comptes = this.transaction.getComptesByPartenaire(part);
        OblComptes = FXCollections.observableArrayList(ts.getComptesByPartenaire(part));
        tblColNum.setCellValueFactory(new PropertyValueFactory<>("numero"));
        tblColSolde.setCellValueFactory(new PropertyValueFactory<>("solde"));
        tblView.setItems(OblComptes);
        return OblComptes;
        //comptes.
    }
    
    public static ObservableList<models.Transaction> searchTransaction(Compte cpt,ObservableList<models.Transaction> OblTransaction) {
        OblTransaction = FXCollections.observableArrayList(transaction.getTransactionsByCompte(cpt));
        return OblTransaction;
    }
    //public addCompte()

    public void loadView(AnchorPane mainContainer, String view) throws IOException {
        mainContainer.getChildren().clear();
        mainContainer.getChildren().add(FXMLLoader.load(getClass().getResource("./../views/"+view+".fxml")));
    }
}
