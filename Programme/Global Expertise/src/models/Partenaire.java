/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dao.db.PartenaireDao;



/**
 *
 * @author DELL
 */
public class Partenaire extends User{

    //PartenaireDao manager = new PartenaireDao();
   
    public Partenaire() {
        this.profil = "partenaire";
    }

    public Partenaire(String nci, String nomComplet, String address, String tel, String login, String password) {
        super(login, password);
        this.profil = "partenaire";
       // manager.add(this);
    }
    //SERIALISATION
    public Partenaire(String nci, String nomComplet, String address, String tel) {
        
    }

    public Partenaire(int id, String login, String password, String nci, String nomComplet, String address, String tel) {
        super(id, login, password);
        this.profil = "partenaire";
        
    }

    
    
    
    
}
