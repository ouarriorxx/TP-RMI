/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import services.MachineService;
import services.SalleService;
import util.HibernateUtil;

/**
 *
 * @author kawta
 */
public class Test {

    public static void main(String[] args) {
        try {
           IDao<Machine> dao1 = new MachineService();
           IDao<Salle> dao = new SalleService();
           dao.create(new Salle("code1"));
           dao1.create(new Machine("lenovo","lenovo", 5000, dao.findById(1)));
           
        
     for(Machine m: dao1.findAll()){
            System.out.println(m);
        }
        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
 

    }
}
