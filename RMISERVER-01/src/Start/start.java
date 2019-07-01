/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.impl.ServiceImpl;

/**
 *
 * @author ishanka
 */
public class start {
    public static void main(String[] args) {
        try {
            Registry reg =  LocateRegistry.createRegistry(5050);
            reg.rebind("ijse", new ServiceImpl());
            System.out.println("Server Started");
        } catch (RemoteException ex) {
            Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}
