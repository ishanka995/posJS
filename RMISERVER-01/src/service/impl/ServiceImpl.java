/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import obsever.Observer;
import service.Service;


/**
 *
 * @author ishanka
 */
public class ServiceImpl extends UnicastRemoteObject implements Service{
    
    private static ArrayList<Observer> allobservers = new ArrayList<>();
    public ServiceImpl () throws Exception{
    
    }

    @Override
    public String check(String message) throws Exception {
        System.out.println(message);
        NotifyallObservers(message);
        return message;
    }

    @Override
    public void register(Observer ob) throws Exception {
        allobservers.add(ob);
    }

    @Override
    public void unregister(Observer ob) throws Exception {
        allobservers.remove(ob);
    }

    @Override
    public void NotifyallObservers(String message) throws Exception {
        for (Observer observer : allobservers) {
            new Thread(
            
            new Runnable() {
                @Override
                public void run() {
                    try {
                        observer.update(message);
                    } catch (Exception ex) {
                        Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            ).start();
        }
        
    }
    
}
