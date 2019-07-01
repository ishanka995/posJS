/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import obsever.Subject;

/**
 *
 * @author ishanka
 */
public interface Service extends Remote,Subject{
    public String check(String message) throws Exception;
}
