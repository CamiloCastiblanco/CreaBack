/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.crea.services.impl;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.arsw.crea.model.Room;
import co.edu.escuelaing.arsw.crea.model.User;
import co.edu.escuelaing.arsw.crea.services.InterfaceCreaService;
import co.edu.escuelaing.arsw.crea.services.exceptions.CreaServiceException;

/**
 * @author CamiloCastiblanco
 */
@Service 
public class CreaServiceImpl implements InterfaceCreaService {
    private ArrayList<RoomServiceImpl> rooms = new ArrayList<RoomServiceImpl>(); 
    
    @Override
    public ArrayList<RoomServiceImpl> getRooms() {
        return rooms; 
    }
    
    @Override
    public void createRoom(RoomServiceImpl r) {
        r.getRoom().setId(rooms.size() +1 );
        rooms.add(r);
    }

    @Override
    public void addUserToRoomById(User u , int id) throws CreaServiceException {
        
        ArrayList<RoomServiceImpl> rooms = getRooms();
        for(RoomServiceImpl i : rooms ){
            
            if (i.getRoom().getId() == id){
                i.addUser(u);
                break; 
            } 
        }
    }
    
    @Override
    public void delUser(String u, int id) throws CreaServiceException {
        ArrayList<RoomServiceImpl> rooms = getRooms();
        for(RoomServiceImpl i : rooms ){
            User n = null; 
            if (i.getRoom().getId() == id){
                for(User j: i.getRoom().getUsers()){
                    if(j.getNickname().equals(u)){
                        n = j;  
                    } 
                }
                i.delUser(n);
                break; 
            } 
        }
    }
}
