/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.crea.services.impl;

import ch.qos.logback.core.net.server.Client;
import co.edu.escuelaing.arsw.crea.model.User;
import co.edu.escuelaing.arsw.crea.services.InterfaceUserService;
import co.edu.escuelaing.arsw.crea.services.exceptions.CreaServiceException;

/**
 * @author CamiloCastiblanco
 */
public class UserServiceImpl implements InterfaceUserService {
    private User user ; 
    public UserServiceImpl(){}
    
    public UserServiceImpl(String nickname, String skin) throws CreaServiceException{
    
        user = new User(nickname, skin); 
    }
    @Override
    public void joinRoom(String id) {
        
    }
    @Override
    public void exitRoom(String id) {
        
    }
}
