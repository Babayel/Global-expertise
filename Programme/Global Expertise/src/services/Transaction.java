/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.db.DepotDao;
import dao.db.CompteDao;
import dao.db.PartenaireDao;
import dao.db.TransactionDao;
import dao.db.UserDao;
import java.util.ArrayList;
import java.util.List;
import models.Compte;
import models.Depot;
import models.Partenaire;
import models.User;

/**
 *
 * @author DELL
 */
public class Transaction {
    private PartenaireDao partenaireDao;
    private CompteDao compteDao;
    private DepotDao depotDao;    
    private UserDao userDao;
    private TransactionDao transactionDao;
    //public static ObservableList<Compte> comptesObl;
    
    //private List<Partenaire> partenaires;
    private List<Compte> comptes;
    //private List<Depot> depots;
    private List<Depot> depots;
    private List<models.Transaction> transactions;
    

    public Transaction() {
        this.partenaireDao = new PartenaireDao();
        this.compteDao = new CompteDao();
        this.depotDao = new DepotDao();
        this.userDao = new UserDao();
        this.transactionDao = new TransactionDao();
        //Transaction.comptesObl = FXCollections.observableArrayList();
        
       // this.partenaires = this.partenaireDao.findAll();
        //this.comptes = this.compteDao.findAll();
        //this.depots = this.depotDao.findAll();
                
    }
    
    
    public Compte addCompteTransactionion(Partenaire part,Double solde){
        
        Compte compte = this.compteDao.save(new Compte(solde,part.getId()));
        this.setDepot(compte, solde);
        
        return compte;
    }
    
    public Compte addCompteTransactionion(String nci, String nomComplet, String address, String tel, String login, String password,Double solde){
        
        return this.addCompteTransactionion(this.partenaireDao.save(new Partenaire(nci, nomComplet, address, tel, login, password)), solde);
    }
    
    public Depot setDepot(Compte compte,Double montant){
        
        Depot depot = new Depot(compte.getId(),montant);
        this.depotDao.save(depot);
        
        return depot;
    }
    
    public Partenaire getPartenaireByNci(String nci){
        return this.partenaireDao.findOneById(nci);
    }
    
    public List<Compte>  getComptesByPartenaire(Partenaire part){
        
        return this.compteDao.findAllByKey(part.getId());
    }
    
    public List<Depot>  getDepotsByCompte(Compte cpt){
        //Transaction.comptesObl = FXCollections.observableArrayList();
        //this.comptes.addAll(this.compteDao.findAll());
        this.depots = new ArrayList();
        //ObservableList<Compte> comptesPart = FXCollections.observableArrayList();
        this.depotDao.findAll().stream().filter((d) -> (d.getIdCompte() == cpt.getId())).forEachOrdered((c) -> {
            this.depots.add(c);
        });
        //Alert a = new Alert(Alert.AlertType.INFORMATION,"After save: "+String.valueOf(this.comptes.size()));
        //a.showAndWait();
        return this.depots;//comptes.Stream cpt.getPartenaire().getId()==part.getId().collect(Collectors);
    }
    
    public List<models.Transaction>  getTransactionsByCompte(Compte cpt){
        this.transactions = new ArrayList();
        this.transactionDao.findAll().stream().filter((t) -> (t.getIdCompte() == cpt.getId())).forEachOrdered((t) -> {
            this.transactions.add(t);
        });
        //Alert a = new Alert(Alert.AlertType.INFORMATION,"After save: "+String.valueOf(this.comptes.size()));
        //a.showAndWait();
        return this.transactions;//comptes.Stream cpt.getPartenaire().getId()==part.getId().collect(Collectors);
    }
    
}