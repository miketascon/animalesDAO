/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.animales.dao;

import com.animales.model.AnimalesModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dandres
 */
public interface AnimalesDao extends AutoCloseable{
    
    public void add(AnimalesModel animal);
    
    public void update(AnimalesModel animal) throws SQLException;
    
    public void delete(int id) throws SQLException;
    
    public AnimalesModel findById(int id) throws  SQLException;
    
    public List<AnimalesModel> getAllAnimal() throws SQLException;   
    
}
