/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.crea.services;

import java.util.ArrayList;

import co.edu.escuelaing.arsw.crea.model.Room;
import co.edu.escuelaing.arsw.crea.model.User;
import co.edu.escuelaing.arsw.crea.services.exceptions.CreaServiceException;
import co.edu.escuelaing.arsw.crea.services.impl.RoomServiceImpl;



/**
 * @author CamiloCastiblanco
 */
public interface InterfaceCreaService {
    
    public ArrayList<RoomServiceImpl> getRooms(); 
    public void createRoom(RoomServiceImpl r); 
    public void addUserToRoomById(User u , int id ) throws CreaServiceException ;
    public void delUser(String u , int id) throws CreaServiceException ; 

    
}
