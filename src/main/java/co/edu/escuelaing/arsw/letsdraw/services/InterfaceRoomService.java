/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.services;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;

/**
 *
 * @author jgarc
 */
public interface InterfaceRoomService{
    
    public void addUser(User u) throws LetsDrawServiceException; 
    public void delUser(User u )throws LetsDrawServiceException; 
    public void changeLenguaje(String lenguaje)throws LetsDrawServiceException; 
    public void startTimer()throws LetsDrawServiceException; 
    public void stopTimer()throws LetsDrawServiceException; 
    public void changeTurn()throws LetsDrawServiceException; 
    public void sendMessage(User u , String message)throws LetsDrawServiceException; 
    public void endRound()throws LetsDrawServiceException;
    public void startRound()throws LetsDrawServiceException;
    public String getWord()throws LetsDrawServiceException; 
    public Room getRoom()throws LetsDrawServiceException; 
    public void setroom(Room room)throws LetsDrawServiceException;
    public User searchUserById(int id)throws LetsDrawServiceException;
    
}
