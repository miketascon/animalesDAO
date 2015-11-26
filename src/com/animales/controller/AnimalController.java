/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animales.controller;

import com.animales.dao.AnimalDAOFactory;
import com.animales.dao.AnimalesDao;
import com.animales.model.AnimalesModel;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class AnimalController {

    private static final AnimalController controller = new AnimalController();
    private int id;
    private AnimalesModel animalActual;
    private List<AnimalesModel> listaAnimales;
    private AnimalDAOFactory fabrica;

    public AnimalController() {
        fabrica = new AnimalDAOFactory();
        
    }
    
    public static AnimalController getController() {
        return controller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AnimalesModel getAnimalActual() {
        return animalActual;
    }

    public void setAnimalActual(AnimalesModel animalActual) {
        this.animalActual = animalActual;
    }

    public List<AnimalesModel> getListaAnimales() {
        if (listaAnimales == null) {
            try (AnimalesDao dao = fabrica.createAnimalesDao();) {
                listaAnimales = dao.getAllAnimal();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error" + e.getClass().getName()
                        + ",quiting", JOptionPane.ERROR_MESSAGE
                );
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error closing resource" + e.getClass().getName()
                        + ",quiting", JOptionPane.ERROR_MESSAGE
                );
            }

        }
        return listaAnimales;
    }

    public void setListaAnimales(List<AnimalesModel> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }

    public AnimalDAOFactory getFabrica() {
        return fabrica;
    }

    public void setFabrica(AnimalDAOFactory fabrica) {
        this.fabrica = fabrica;
    }

    public void recargarListaAnimales() {
        listaAnimales = null;
    }
    
     public boolean addAnimal() {
        try (AnimalesDao dao = fabrica.createAnimalesDao();) {
            dao.add(animalActual);
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error" + e.getClass().getName()
                    + ",quiting", JOptionPane.ERROR_MESSAGE
            );
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error closing resource" + e.getClass().getName()
                    + ",quiting", JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

    }
       
        public boolean updateAnimal() {
        try (AnimalesDao dao = fabrica.createAnimalesDao();) {
            dao.update(animalActual);
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error" + e.getClass().getName()
                    + ",quiting", JOptionPane.ERROR_MESSAGE
            );
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error closing resource" + e.getClass().getName()
                    + ",quiting", JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

    }
    
        public boolean deleteAnimal(int id) {
        this.id = id;
        try (AnimalesDao dao = fabrica.createAnimalesDao();) {
            dao.delete(id);
            return true;
        } catch (IOException e) {
            System.out.println("Error " + e.getClass().getName() + " , quiting.");
            System.out.println("Message: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error closing resource " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
            return false;
        }

    }
}
