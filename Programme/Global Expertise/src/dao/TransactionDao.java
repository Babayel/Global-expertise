/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.db;

import dao.list.*;
import dao.IDao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Transaction;

/**
 *
 * @author DELL
 */
public class TransactionDao implements IDao<Transaction> {
    
    private static int nbreTransaction;
    private List<Transaction> transactions;

    public TransactionDao() {
        this.transactions = new ArrayList<>(
                Arrays.asList(
                        new Transaction(6900,1),
                        new Transaction(556,1),
                        new Transaction(789,1),
                        new Transaction(75,1),
                        new Transaction(666,1)
                      )
        );
    }
    
    

    @Override
    public Transaction save(Transaction trc) {
        trc.setId(++nbreTransaction);
        this.transactions.add(trc);
        return trc;
    }

    @Override
    public List<Transaction> findAll() {
        return this.transactions;
    }

    

    @Override
    public Transaction update(Transaction obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction remove(Transaction obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaction> findAllByKey(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction findOneById(Transaction obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
