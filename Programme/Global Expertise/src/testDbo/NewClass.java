/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDbo;

import dao.db.DepotDao;
import models.Depot;


/**
 *
 * @author DELL
 */
public class NewClass {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Depot cpt = new Depot(1,400000);
        DepotDao cp = new DepotDao();
        System.out.println(cp.save(cpt));        

    }
    
}
