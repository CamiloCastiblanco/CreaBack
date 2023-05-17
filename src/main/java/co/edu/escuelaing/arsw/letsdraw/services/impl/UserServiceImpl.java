/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.services.impl;

import ch.qos.logback.core.net.server.Client;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.InterfaceUserService;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;

/**
 *
 * @author jgarc
 */
public class UserServiceImpl implements InterfaceUserService {
    private User user ; 
    public UserServiceImpl(){}
    
    public UserServiceImpl(String nickname, String skin) throws LetsDrawServiceException{
    
        user = new User(nickname, skin); 
    }
    @Override
    public void joinRoom(String id) {
        
    }
    @Override
    public void exitRoom(String id) {
        
    }
}
