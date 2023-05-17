/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.services.impl;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.InterfaceLetsDrawService;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgarc
 */
@Service 
public class LetsDrawServiceImpl implements InterfaceLetsDrawService {
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
    public void addUserToRoomById(User u , int id) throws LetsDrawServiceException {
        
        ArrayList<RoomServiceImpl> rooms = getRooms();
        for(RoomServiceImpl i : rooms ){
            
            if (i.getRoom().getId() == id){
                i.addUser(u);
                break; 
            } 
        }
    }
    
    @Override
    public void delUser(String u, int id) throws LetsDrawServiceException {
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
