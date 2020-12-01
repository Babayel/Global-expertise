/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.db;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import dao.list.*;
import dao.IDao;
import dao.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Depot;

/**
 *
 * @author DELL
 */
public class DepotDao implements IDao<Depot>{
    
    private String sql_create = "INSERT INTO `depot`(`montant`, `date`, `idCompte`) VALUES (?,?,?)";
    public List<Depot>  depots;
    
    public DepotDao() {
        
    }
    

    @Override
    public Depot save(Depot depot) {
        Connection c = MyConnection.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement(sql_create,Statement.RETURN_GENERATED_KEYS);
                ps.setDouble(1, depot.getMontant());
                ps.setString(2, String.valueOf(depot.getDate()));
                ps.setInt(3, depot.getIdCompte());
                ps.executeUpdate();
                ResultSet resultat = ps.getGeneratedKeys();
                if (resultat.next()) {
                    depot.setId(resultat.getInt(1));
                    return depot;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }finally{
                MyConnection.stop();
            }
        }
        return null;
    }

    @Override
    public List<Depot> findAll() {
        return this.depots;
    }


    @Override
    public Depot update(Depot obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public Depot remove(Depot obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Depot> findAllByKey(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Depot findOneById(Depot obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
