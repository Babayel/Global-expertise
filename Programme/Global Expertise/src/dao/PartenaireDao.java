/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.db;

import dao.IDao;
import dao.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Partenaire;

/**
 *
 * @author DELL
 */
public class PartenaireDao implements IDao<Partenaire>{
    public List<Partenaire> partenaires;
    //private UserDao ud ;

    private String sql_create = "INSERT INTO `user` (`login`, `password`, `nci`, `fullName`, `address`, `telephone`) VALUES (?, ?, ?, ?, ?, ?)";
    //private String sql_update = "UPDATE `user` SET `solde` = `solde` + ? WHERE id = ?";
    private String sql_find_one_by_id = "SELECT * FROM `user` WHERE `id` = ?";  
    private String sql_find_one_by_nci = "SELECT * FROM `user` WHERE `nci` = ?";
    //private String sql_find_all_by_id = "SELECT * FROM `user` WHERE `type` = ?";    
    private String sql_find_all = "SELECT * FROM `user` WHERE `type` = partenaire ";
    private String sql_remove = "DELETE FROM `user` WHERE `id` = ?";
    public PartenaireDao() 
    {
    }
    

    @Override
    public List<Partenaire> findAll() {
        Connection c = MyConnection.getConnection();
        this.partenaires = new ArrayList<>();
        if (c != null) {
            try {
                Statement stat = c.createStatement();
                ResultSet r = stat.executeQuery(sql_find_all);
                while (r.next()){
                    
                    this.partenaires.add(new Partenaire(r.getInt("id"),r.getString("login"),r.getString("password"),r.getString("nci"),r.getString("fullName"),r.getString("address"),r.getString("telephone")));
                    
                }
            } catch (SQLException e) {
            }finally{
                MyConnection.stop();
            }
        }

        return this.partenaires;
    }

    @Override
    public Partenaire save(Partenaire partenaire) {
        Connection c = MyConnection.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement(sql_create,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, partenaire.getLogin());
                ps.setString(2, partenaire.getPassword());
                ps.setString(3, partenaire.getNci());
                ps.setString(4, partenaire.getFullName());
                ps.setString(5, partenaire.getAddress());
                ps.setString(6, partenaire.getTelephone());
                
                ps.executeUpdate();
                ResultSet resultat = ps.getGeneratedKeys();
                if (resultat.next()) {
                    partenaire.setId(resultat.getInt(1));
                    return partenaire;
                }
            } catch (SQLException e) {
            }finally{
                MyConnection.stop();
            }
        }
        return null;
    }


    @Override
    public Partenaire findOneById(Partenaire part) {
        Partenaire partenaire = null;
        Connection c = MyConnection.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement(sql_find_one_by_id);
                ps.setInt(1, part.getId());
                ResultSet r = ps.executeQuery();
                if (r.next())
                    partenaire = new Partenaire(r.getInt("id"),r.getString("login"),r.getString("password"),r.getString("nci"),r.getString("fullName"),r.getString("address"),r.getString("telephone"));
            } catch (SQLException e) {
            }finally{
                MyConnection.stop();
            }
        }

        return partenaire;
    }

    public Partenaire findOneById(String nci) {
        Partenaire partenaire = null;
        Connection c = MyConnection.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement(sql_find_one_by_nci);
                ps.setString(1, nci);
                ResultSet r = ps.executeQuery();
                if (r.next())
                    partenaire = new Partenaire(r.getInt("id"),r.getString("login"),r.getString("password"),r.getString("nci"),r.getString("fullName"),r.getString("address"),r.getString("telephone"));
            } catch (SQLException e) {
            }finally{
                MyConnection.stop();
            }
        }

        return partenaire;
    }

    @Override
    public Partenaire update(Partenaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Partenaire remove(Partenaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Partenaire> findAllByKey(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //     Connection c = MyConnection.getConnection();
    //     this.partenaires = new ArrayList<>();
    //     if (c != null) {
    //         try {
    //             PreparedStatement ps = c.prepareStatement(sql_find_all_by_id);
    //             ps.setInt(1, id);
    //             ResultSet r = ps.executeQuery();
    //             while (r.next()){
    //                 this.partenaires.add(new Partenaire(r.getInt("id"),r.getString("numero"),r.getDouble("solde"),r.getInt("idPartenaire")));
    //             }
    //         } catch (SQLException e) {
    //         }finally{
    //             MyConnection.stop();
    //         }
    //     }

    //     return this.partenaires;
    // }
    
}
}