/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animales.dao;

import com.animales.model.AnimalesModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dandres
 */
public class AnimalDAOJDBCImpl implements AnimalesDao {

    private Connection conexion = null;

    public AnimalDAOJDBCImpl() {
        String url = "jdbc:mysql://localhost:3306/animales?zeroDateTimeBehavior=convertToNull";
        String userName = "root";
        String password = "Persefone2014";
        try {
            conexion = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se pudo establecer conexion: " + e, "Conection lost", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void add(AnimalesModel animal) {
        try (Statement stmt = conexion.createStatement()) {
            String query = "INSERT INTO animal VALUES (" + animal.getIdAnimal()
                    + ",'" + animal.getRaza() + "','" + animal.getNombre() + "'," + animal.getEdad()
                    + ",'" + animal.getGenero() + "','" + animal.getAlimentacion() + "')";
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado el animal" + e,
                    "Error al agregar un Animal", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void update(AnimalesModel animal) throws SQLException {
        try (Statement stmt = conexion.createStatement()) {
            String query = "UPDATE animal SET raza='" + animal.getRaza() + "',"
                    + "nombre='" + animal.getNombre() + "',"
                    + "edad=" + animal.getEdad() + ",genero='"
                    + animal.getGenero() + "',alimentacion='"
                    + animal.getAlimentacion() + "' WHERE id_animal="
                    + animal.getIdAnimal();
            if (stmt.executeUpdate(query) != 1) {
                throw new SQLException("Error updating registro");
            }

        } catch (SQLException se) {
            throw new SQLException("Error updating procesador in DAO", se);
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        AnimalesModel animal = findById(id);
        if (animal == null) {
            throw new SQLException("Procesador id: " + id + " does not exist to delete.");
        }
        try (Statement stmt = conexion.createStatement()) {
            String query = "DELETE FROM animal WHERE id_animal=" + id;

            if (stmt.executeUpdate(query) != 1) {
                throw new SQLException("Error deleting registro");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new SQLException("Error deleting animal in DAO", se);
        }

    }

    @Override
    public AnimalesModel findById(int id) throws SQLException {
        try (Statement stmt = conexion.createStatement()) {
            String query = "SELECT * FROM animal WHERE id_animal=" + id;
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return new AnimalesModel(rs.getInt("id_animal"),
                        rs.getString("raza"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("genero"),
                        rs.getString("alimentacion"));
            } else {
                JOptionPane.showMessageDialog(null, "No encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                return null;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha creado registro" + e, "Invalid Add", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public List<AnimalesModel> getAllAnimal() throws SQLException {
        try (Statement stmt=conexion.createStatement()){
            String query="select * from animal";
            ResultSet rs=stmt.executeQuery(query);
            List<AnimalesModel> lista= new ArrayList<>();
            while (rs.next()) { 
                lista.add(new AnimalesModel(rs.getInt("id_animal"),
                        rs.getString("raza"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("genero"),
                        rs.getString("alimentacion")
                       
                ));
            }
            return lista;
            
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha creado registro" + e, "Invalid Add", JOptionPane.ERROR_MESSAGE);
                return null;
        }
    }

    @Override
    public void close() throws Exception {
         try {
            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se esta cerrando la conexión"
                    + e, "title", JOptionPane.ERROR_MESSAGE);
        } 
    }
        
    }


