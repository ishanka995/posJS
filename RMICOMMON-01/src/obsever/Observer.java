/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obsever;

import java.rmi.Remote;

/**
 *
 * @author ishanka
 */
public interface Observer extends Remote{
    public void update(String message) throws Exception;
    
}
