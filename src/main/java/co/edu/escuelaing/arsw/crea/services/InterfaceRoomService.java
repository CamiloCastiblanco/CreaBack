/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.crea.services;

import co.edu.escuelaing.arsw.crea.model.Room;
import co.edu.escuelaing.arsw.crea.model.User;
import co.edu.escuelaing.arsw.crea.services.exceptions.CreaServiceException;

/**
 * @author CamiloCastiblanco
 */
public interface InterfaceRoomService{
    
    public void addUser(User u) throws CreaServiceException; 
    public void delUser(User u )throws CreaServiceException; 
    public void changeLenguaje(String lenguaje)throws CreaServiceException; 
    public void startTimer()throws CreaServiceException; 
    public void stopTimer()throws CreaServiceException; 
    public void changeTurn()throws CreaServiceException; 
    public void sendMessage(User u , String message)throws CreaServiceException; 
    public void endRound()throws CreaServiceException;
    public void startRound()throws CreaServiceException;
    public String getWord()throws CreaServiceException; 
    public Room getRoom()throws CreaServiceException; 
    public void setroom(Room room)throws CreaServiceException;
    public User searchUserById(int id)throws CreaServiceException;
    
}
