/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dao.list.DepotDao;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Depot {
    private int id;
    private LocalDate date;
    private double montant;
    private int idCompte; 
    //private DepotDao manager = new DepotDao();

   

    public Depot(double montant) {
        this.date = LocalDate.now();
        this.montant = montant;
        //manager.add(this);
    }

    public Depot(int idCompte, double montant) {
        this.date = LocalDate.now();
        this.idCompte = idCompte;
        this.montant = montant;
        //manager.add(this);
    }

    public LocalDate getDate() {
        return date;
    }


    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    @Override
    public String toString() {
        return "Depot{" + "id=" + id + ", date=" + date + ", montant=" + montant + ", idCompte=" + idCompte + '}';
    }
    
    
}
