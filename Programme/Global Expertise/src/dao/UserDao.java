/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.utils.IDao;
import dao.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.User;

/**
 *
 * @author DELL
 */
public class UserDao implements IDao<User> {
    
    private String sql_find_login_and_pwd = "SELECT * FROM `user` WHERE `login` LIKE ? AND `password` LIKE ?";

    @Override
    public User save(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findOneById(User usr) {
        Connection c = MyConnection.getConnection();
        if (c != null) {
            try {     
                //System.out.println("Sante Cheikh Ibra");
                PreparedStatement ps = c.prepareStatement(sql_find_login_and_pwd);
                ps.setString(1, usr.getLogin());
                ps.setString(2, usr.getPassword());                                    
                ResultSet r = ps.executeQuery();
                if (r.next()){
                    return new User(r.getInt("id"),r.getString("fullName"),r.getString("profil"),r.getBoolean("state"));
                }
                //MyConnection.stop();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        //
        return null;
    }

    @Override
    public List<User> findAllByKey(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User update(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User remove(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
