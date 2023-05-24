package co.edu.escuelaing.arsw.crea.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.escuelaing.arsw.crea.model.Room;
import co.edu.escuelaing.arsw.crea.model.User;
import co.edu.escuelaing.arsw.crea.services.exceptions.CreaServiceException;
import co.edu.escuelaing.arsw.crea.services.impl.CreaServiceImpl;
import co.edu.escuelaing.arsw.crea.services.impl.RoomServiceImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author CamiloCastiblanco
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    CreaServiceImpl letsDrawServiceImpl; 
    
    @RequestMapping(value = "/addUser/{name}/{skin}/{id}", method = RequestMethod.GET)
    public String createAndAddUser(@PathVariable("name") String name,@PathVariable("skin") String skin ,@PathVariable("id") int id ) throws CreaServiceException {
        letsDrawServiceImpl.addUserToRoomById(new User(name, skin) , id);
        return name;    
    }
    
    
    @RequestMapping(value = "/delUser/{name}/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("name") String name ,@PathVariable("id") int id ) throws CreaServiceException {
        letsDrawServiceImpl.delUser(name, id);
        return name;    
    }
    
    
    
    
    
}
