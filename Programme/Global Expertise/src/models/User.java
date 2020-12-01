/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dao.list.UserDao;

/**
 *
 * @author DELL
 */
public class User {
    protected int id;
    protected String login;
    protected String password;
    protected Boolean state;
    protected String profil;
    protected String address;
    protected String fullName;
    protected String nci;
    protected String telephone;

    
    
    public User() {
           // UserDao manager = new UserDao();
           this.state = true;
        //manager.add(this);
    }

    public User(String login, String password) {

        this.login = login;
        this.password = password;
        this.state = true;
    }

    public User(int id, String login, String password) {
            //UserDao manager = new UserDao();

        this.id = id;
        this.login = login;
        this.password = password;
        this.state = true;
        //manager.add(this);
    }

    public User(int id, String login, String password, String profil) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.profil = profil;
        this.state = true;
    }

    public User(int id, String login, String password, String nci, String fullName, String address, String telephone) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.address = address;
        this.fullName = fullName;
        this.nci = nci;
        this.telephone = telephone;
        this.state = true;
    }

    //connxion

    public User(int id, String fullName, String profil, Boolean state) {
        this.id = id;
        this.state = state;
        this.profil = profil;
        this.fullName = fullName;
    }
    

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
     public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNci() {
        return nci;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}
