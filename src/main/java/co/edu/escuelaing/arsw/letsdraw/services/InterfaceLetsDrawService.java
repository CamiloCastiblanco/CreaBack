/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.services;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import co.edu.escuelaing.arsw.letsdraw.services.impl.RoomServiceImpl;
import java.util.ArrayList;



/**
 *
 * @author jgarc
 */
public interface InterfaceLetsDrawService {
    
    public ArrayList<RoomServiceImpl> getRooms(); 
    public void createRoom(RoomServiceImpl r); 
    public void addUserToRoomById(User u , int id ) throws LetsDrawServiceException ;
    public void delUser(String u , int id) throws LetsDrawServiceException ; 

    
}
