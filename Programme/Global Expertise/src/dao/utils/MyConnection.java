/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author DELL
 */

public class MyConnection 
{
    private static String url = "jdbc:mysql://localhost:3306/global_expertise";
    private static String utilisateur = "root";
    private static String motDePasse = "";
    private static Connection connexion = null;

    private MyConnection() {
    try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = (Connection) DriverManager.getConnection(url, utilisateur,
            motDePasse );
        } catch ( Exception e ) {
            e.printStackTrace();
            }
        }

    public static Connection getConnection() {
        if (connexion == null) {
        new MyConnection();
    }
    return connexion;
    }

    public static void stop() 
    {
        if (connexion != null) 
        {
            try 
            {
                connexion.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }
        
}