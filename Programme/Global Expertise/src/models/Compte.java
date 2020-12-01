/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dao.db.CompteDao;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Compte {
    
    private int id;
    private String numero;
    private double solde;    
    private int idPartenaire;

    //private CompteDao manager = new CompteDao();

    public void setIdPartenaire(int idPartenaire) {
        this.idPartenaire = idPartenaire;
    }

    public Compte() {
        //this.numero = "SN00"+this.id;
        //manager.add(this);
    }

    public Compte(int id, String numero, double solde, int idPartenaire) {
        this.id = id;
        this.numero = numero;
        this.solde = solde;
        this.idPartenaire = idPartenaire;
    }
    
    public Compte(int id, String numero, double solde) {
        this.id = id;
        this.numero = numero;
        this.solde = solde;
    }
    /*
    public Compte(Partenaire part, double solde) {
        this.id = ++nbreCompte;
        this.idPartenaire = part.getId();
        this.solde = solde;
        manager.add(this);
    }
*/
    public Compte(double solde) {
        this.solde = solde;
    }
    

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public int getIdPartenaire() {
        return this.idPartenaire;
    }

    public void affect(Partenaire partenaire) {
        this.idPartenaire = partenaire.getId();
    }

    public void getDepot(Depot depot) {
        this.solde += depot.getMontant();
    }

    public int getId() {
        return this.id;    
        }

    public Compte(String numero, double solde, int idPartenaire) {
        this.numero = numero;
        this.solde = solde;
        this.idPartenaire = idPartenaire;
    }

    public Compte(double solde, int idPartenaire) {
        //this.id = ++nbreCompte;
        //this.numero = "SN00"+this.id;
        this.solde = solde;
        this.idPartenaire = idPartenaire;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setRetrait(double montant) {
        this.solde += montant;
    }

    public void setDepot(double montant) {
        this.solde -= montant;
        
    }

    @Override
    public String toString() {
        return "Compte{" + "id=" + id + ", numero=" + numero + ", solde=" + solde + ", idPartenaire=" + idPartenaire + '}';
    }
    
    
}
