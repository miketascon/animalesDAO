/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.animales.dao;

/**
 *
 * @author dandres
 */
public class AnimalDAOFactory {
    public AnimalesDao createAnimalesDao(){
        return new AnimalDAOJDBCImpl();
    }
    
}
