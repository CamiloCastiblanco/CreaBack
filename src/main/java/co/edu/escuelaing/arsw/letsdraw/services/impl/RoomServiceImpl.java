/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.services.impl;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.InterfaceRoomService;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgarc
 */

@Service 
public class RoomServiceImpl implements InterfaceRoomService {
    
    private Room room; 
    public RoomServiceImpl(){
    }
    
    public RoomServiceImpl(String name , String lenguaje , boolean priv , int limit) throws LetsDrawServiceException {
        room = new Room (name ,lenguaje , priv, limit);  
    }

    @Override
    public void addUser(User u) throws LetsDrawServiceException {
        if(room.getLimit() > room.getUsers().size() ){
            ArrayList<User> users = room.getUsers();
            if(users.size() == 0 ){
                u.setPainter();
            }
            u.setId(room.getUsers().size() + 1 ) ;
            users.add(u); 
            room.setUsers(users);
        }else{
            throw new LetsDrawServiceException("limite de usuariso alcanzado");  
        }
    }

    @Override
    public void delUser(User u) {
        for(User i: room.getUsers()){
            if(i.getId() == u.getId()){
                ArrayList<User> a = room.getUsers();
                a.remove(i); 
                room.setUsers(a);
                break; 
            }
        }
    }

    @Override
    public void changeLenguaje(String lenguaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startTimer() {
        room.startTimer(); 
    }

    @Override
    public void stopTimer() {
        room.stopTimer(); 
    }

    @Override
    public void changeTurn() {
        System.out.println("entro a service");
        room.changeWord();
        room.changeTurn();
    }

    @Override
    public void sendMessage(User u, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endRound() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startRound() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWord() {
        return room.getWord(); 
    }

    @Override
    public Room getRoom() {
        return room;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setroom(Room room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User searchUserById(int id) throws LetsDrawServiceException{
        for(User i : room.getUsers()){
            if(i.getId() == id){
                return i; 
                 
            }
        }
        throw(new LetsDrawServiceException("usuario no encontrado"));  
    }
    
       
}
