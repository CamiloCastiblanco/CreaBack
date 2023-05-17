package co.edu.escuelaing.arsw.letsdraw.controllers;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import co.edu.escuelaing.arsw.letsdraw.services.impl.LetsDrawServiceImpl;
import co.edu.escuelaing.arsw.letsdraw.services.impl.RoomServiceImpl;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jgarc
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    LetsDrawServiceImpl letsDrawServiceImpl; 
    
    @RequestMapping(value = "/addUser/{name}/{skin}/{id}", method = RequestMethod.GET)
    public String createAndAddUser(@PathVariable("name") String name,@PathVariable("skin") String skin ,@PathVariable("id") int id ) throws LetsDrawServiceException {
        letsDrawServiceImpl.addUserToRoomById(new User(name, skin) , id);
        return name;    
    }
    
    
    @RequestMapping(value = "/delUser/{name}/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("name") String name ,@PathVariable("id") int id ) throws LetsDrawServiceException {
        letsDrawServiceImpl.delUser(name, id);
        return name;    
    }
    
    
    
    
    
}
