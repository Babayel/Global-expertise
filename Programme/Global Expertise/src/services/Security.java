/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.db.PartenaireDao;
import dao.db.UserDao;
import java.util.List;
import models.Partenaire;
import models.User;

/**
 *
 * @author DELL
 */
public class Security {
    private User user;
    //private List<User> users;
    private UserDao userDao;
    //private List<Partenaire> partenaires;
    //private PartenaireDao partenaireDao;
   
    public Security() {
        this.userDao = new UserDao();
        //this.users = userDao.findAll();
        //this.PartenaireDao = new PartenaireDao();
        //this.partenaires = partenaireDao.findAll();
    }
    //public Partenaire addComptePartenaire(String login, String password, String nci, String nomComplet, String address, String tel){
       // Partenaire p = new Partenaire(login, password, nci, nomComplet, address, tel);
        //PartenaireDao.partenaires.save(p);
        //this.partenaires.save(p);
        
       // return p;
    //}
    /*
    public void addCompteConnexion(String login, String password){
        User usr = new User(login,password);
        this.userDao.save(usr);
        this.users.save(usr);
    }
    */
    public User logOn(String login, String password) 
    {
        return this.userDao.findOneById(new User(login,password));
    }
    
    
}