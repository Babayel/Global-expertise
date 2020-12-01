/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author DELL
 */
public class AdminSystem extends User {
    private String fonction;

    public AdminSystem() {
        this.profil = "adminSystem";
    }

    public AdminSystem(String login, String password, String fonction) {
        super(login, password);
        this.fonction = fonction;
        this.profil = "adminSystem";
    }


    public AdminSystem(String login, String password) {
        super(login, password);
        this.profil = "adminSystem";
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    
    
    
    
}
