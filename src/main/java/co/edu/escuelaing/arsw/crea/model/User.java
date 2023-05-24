/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.crea.model;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.escuelaing.arsw.crea.services.exceptions.CreaServiceException;
import co.edu.escuelaing.arsw.crea.services.impl.CreaServiceImpl;

/**
 * @author CamiloCastiblanco
 */
public class User {
    @Autowired
    CreaServiceImpl CreaService;  
    
    private String nickname; 
    private int points; 
    private int id ; 
    private String skin; 
    private boolean isDrawing; 
    
    
    public User(String nickname, String skin) throws CreaServiceException{
        this.nickname = nickname; 
        points = 0 ; 
        this.skin = skin; 
        isDrawing = false; 
    }
    public int getId(){
        return id; 
    }
    public void setId(int id ){
        this.id = id; 
    }
    public int getPoints(){
        return points; 
    }
    
    public void setPoints(int points){
        this.points = points; 
    }
    
    public String getNickname(){
        return nickname; 
    }
    
    public void setNickname(String nickname){
        this.nickname = nickname; 
    } 
    
    public String getSkin(){
        return skin; 
    }
    
    public void setSkin(String skin){
        this.skin = skin; 
    }
    
    public void setPainter(){
        isDrawing = true; 
    }
    
    public void stopPainting(){
        isDrawing = false; 
    }
    
    public boolean getIsDrawing(){
        return isDrawing; 
    }
    
    
    
    
  
}
