/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kawta
 */
public class ClientRMI {

    public static void main(String[] args) {
        try {
            IDao<Machine> dao = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao");
            IDao<Salle> dao2 = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/dao2");
            dao2.create(new Salle("A11"));
            dao2.create(new Salle("A10"));

            for (Salle s : dao2.findAll()) {
                System.out.println(s);
            }

            dao.create(new Machine("Hp", "Hp", 6000, dao2.findById(2)));
            dao.create(new Machine("lenovo", "Lenovo", 5000, dao2.findById(1)));
            dao.create(new Machine("Huawei", "Huawei", 12000, dao2.findById(1)));
            for (Machine m : dao.findAll()) {
                System.out.println(m);
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
