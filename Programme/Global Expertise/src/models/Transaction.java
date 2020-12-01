/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Transaction {
    
    private int id;
    private double montant;
    private LocalDate date;
    private String type;
    private int idCompte;

    public Transaction() {
    }

    public Transaction(double montant, LocalDate date, String type, int idCompte) {
        this.montant = montant;
        this.date = date;
        this.type = type;
        this.idCompte = idCompte;
    }

    public Transaction(double montant, String type, int idCompte) {
        this.montant = montant;
        this.type = type;
        this.idCompte = idCompte;
        this.date = LocalDate.now();
    }
    public Transaction(double montant, int idCompte) {
        this.montant = montant;
        this.idCompte = idCompte;
        this.date = LocalDate.now();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }
    
    
    
    
    
}
