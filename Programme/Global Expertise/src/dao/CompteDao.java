/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.db;

import com.mysql.jdbc.Connection;
import dao.IDao;
import dao.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Compte;

/**
 *
 * @author DELL
 */
public class CompteDao implements IDao<Compte>
{
    
    public List<Compte> comptes;
    
    private String sql_create = "INSERT INTO `compte` (`solde`, `idPartenaire`) VALUES (?, ?)";
    private String sql_update = "UPDATE `compte` SET `solde` = `solde` + ? WHERE id = ?";
    private String sql_update_numero = "UPDATE `compte` SET `numero` = ? WHERE `compte`.`id` = ?";
    private String sql_find_one_by_id = "SELECT * FROM `compte` WHERE `id` = ?";    
    private String sql_find_all_by_id = "SELECT * FROM `compte` WHERE `idPartenaire` = ?";    
    private String sql_find_all = "SELECT * FROM `compte`";
    private String sql_remove = "DELETE FROM `compte` WHERE `id` = ?";
    public CompteDao() 
    {
    }
    

    @Override
    public List<Compte> findAll() {
        Connection c = MyConnection.getConnection();
        this.comptes = new ArrayList<>();
        if (c != null) {
            try {
                Statement stat = c.createStatement();
                ResultSet r = stat.executeQuery(sql_find_all);
                while (r.next()){
                    
                    this.comptes.add(new Compte(r.getInt("id"),r.getString("numero"),r.getDouble("solde"),r.getInt("idPartenaire")));
                    
                }
            } catch (SQLException e) {
            }finally{
                MyConnection.stop();
            }
        }

        return this.comptes;
    }

    @Override
    public Compte save(Compte compte) {
        Connection c = MyConnection.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement(sql_create,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setDouble(1, compte.getSolde());
                ps.setDouble(2, compte.getIdPartenaire());
                ps.executeUpdate();
                ResultSet resultat = ps.getGeneratedKeys();
                if (resultat.next()) {
                    return this.hydrate(compte, resultat.getInt(1));
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
    public Compte findOneById(Compte cpt) {
        Compte compte = null;
        Connection c = MyConnection.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement(sql_find_one_by_id);
                ps.setInt(1, cpt.getId());
                ResultSet r = ps.executeQuery();
                if (r.next())
                    compte = new Compte(r.getInt("id"),r.getString("numero"),r.getDouble("solde"),r.getInt("idPartenaire"));
            } catch (SQLException e) {
               // System.out.println(e.getMessage());
            }finally{
                MyConnection.stop();
            }
        }

        return compte;
    }


    @Override
    public Compte update(Compte obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compte remove(Compte obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Compte> findAllByKey(int id) {
        Connection c = MyConnection.getConnection();
        this.comptes = new ArrayList<>();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement(sql_find_all_by_id);
                ps.setInt(1, id);
                ResultSet r = ps.executeQuery();
                while (r.next()){
                    this.comptes.add(new Compte(r.getInt("id"),r.getString("numero"),r.getDouble("solde")));
                }
            } catch (SQLException e) {
            }finally{
                MyConnection.stop();
            }
        }

        return this.comptes;
    }
    private Compte hydrate(Compte compte, int id){
        compte.setId(id);
        compte.setNumero("SN00"+id);
        this.updatNumero(compte);
        return compte;
    }

    private void updatNumero(Compte compte) {
        Connection c = MyConnection.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement(sql_update_numero);
                ps.setString(1, compte.getNumero());
                ps.setInt(2, compte.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }finally{
                MyConnection.stop();
            }
        }
    }
}