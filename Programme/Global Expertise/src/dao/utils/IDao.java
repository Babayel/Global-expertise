/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.utils;

import java.util.List;

/**
 *
 * @author DELL
 */
public interface IDao<t> {
    /*public String sql_update = "UPDATE ? SET ? = ? WHERE `id` = ?";
    public String sql_find_on = "SELECT * FROM `compte` WHERE `id` = ?";    
    public String sql_find_all = "SELECT * FROM `compte`";
    public String sql_remove = "DELETE FROM `compte` WHERE `id` = ?";*/

    public t save(t obj);    
    public List<t> findAll();
    public t findOneById(t obj);    
    public List<t> findAllByKey(int id);
    public t update(t obj);
    public t remove(t obj);

}
