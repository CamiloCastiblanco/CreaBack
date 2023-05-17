/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.model;

import co.edu.escuelaing.arsw.letsdraw.services.impl.LetsDrawServiceImpl;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.Timer;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jgarc
 */
public class Room {
    @Autowired
    LetsDrawServiceImpl letsDrawServiceImpl; 
    
    private int id; 
    private String name; 
    private String lenguaje; 
    private boolean priv; 
    private int limit; 
    private String password;
    private ArrayList<User> users = new ArrayList<User>(); 
    private ArrayList<String[]> messages = new ArrayList<String[]>(); 
    private Timer tt; 
    private int timer; 
    private String board;
    private String word; 
    private final int maxUsers = 10 ;
    private String[] palabrasEs = {"caballo", "zanahoria", "pollo","carro" , "celular", "cabello", "lapiz","zapato", 
                                   "sol" , "flor" , "arcoiris" , "agua" , "plato" , "cubiertos",  "cuchillo", "cuchara", 
                                   "sarten", "piso" , "vela", "lavamanos", "arbol", "cebra" , "jirafa" , "elefante" , "caballo", 
                                   "almohada", "matera" , "escoba", "tijeras" }; 
    
    private String[] palabrasIn = {"horse", "carrot", "chicken", "car", "phone", "hair", "pencil" , "shoe", "sun", "flower", 
                                    "rainbow", "water", "plate", "cutlery", "knife", "spoon", "pan", "floor", "candle", "sink", 
                                    "tree", "zebra", "giraffe", "elephant", "horse "," pillow "," pot "," broom "," scissors " }; 
    private int actualPainter; 
    
    public Room(String name , String lenguaje , boolean priv , int limit ) throws LetsDrawServiceException{
        this.name = name ;
        this.lenguaje = lenguaje; 
        this.limit = limit; 
        validLimit(); 
        board = "iVBORw0KGgoAAAANSUhEUgAAAu4AAAH0CAQAAADIsWAhAAAFa0lEQVR42u3UQRE"
                + "AAAjDMOZf9FCAAS6R0EfTDgDPxNwBzB0AcwfA3AEwdwDMHcDcATB3AMwdAHMH"
                + "wNwBzN3cAcwdAHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcAcxdBABzB8DcATB3A"
                + "MwdAHMHMHcAzB0AcwfA3AEwdwBzB8DcATB3AMwdAHMHwNwBzB0AcwfA3AEwdw"
                + "DMHcDcATB3AMwdAHMHwNwBMHcAcwfA3AEwdwDMHQBzBzB3AMwdAHMHwNwBMHc"
                + "AzB3A3AEwdwDMHQBzB8DcAcwdAHMHwNwBMHcAzB0AcwcwdwDMHQBzB8DcATB3"
                + "AHMHwNwBMHcAzB0AcwfA3AHMHQBzB8DcATB3AMwdwNwBMHcAzB0AcwfA3AEwd"
                + "wBzB8DcATB3AMwdAHMHMHcAzB0AcwfA3AEwdwDMHcDcATB3AMwdAHMHwNwBzB"
                + "0AcwfA3AEwdwDMHQBzBzB3AMwdAHMHwNwBMHcAcwfA3AEwdwDMHQBzB8DcAcw"
                + "dAHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcATB3AHMHwNwBMHcAzB0AcwcwdwDM"
                + "HQBzB8DcATB3AMwdwNwBMHcAzB0AcwfA3AHMHQBzB8DcATB3AMwdAHMHMHcAz"
                + "B0AcwfA3AEwdwBzB8DcATB3AMwdAHMHwNwBzB0AcwfA3AEwdwDMHcDcATB3AM"
                + "wdAHMHwNwBMHcAcwfA3AEwdwDMHQBzBzB3AMwdAHMHwNwBMHcAzB3A3AEwdwD"
                + "MHQBzB8DcAcwdAHMHwNwBMHcAzB0AcwcwdwDMHQBzB8DcATB3AHMHwNwBMHcA"
                + "zB0AcwfA3AHMHQBzB8DcATB3AMwdwNwBMHcAzB0AcwfA3AEwdwBzB8DcATB3A"
                + "MwdAHMHMHcAzB0AcwfA3AEwdwDMHcDcATB3AMwdAHMHwNwBzB0AcwfA3AEwdw"
                + "DMHQBzBzB3AMwdAHMHwNwBMHcAcwfA3AEwdwDMHQBzBzB3cwcwdwDMHQBzB8D"
                + "cATB3AHMHwNwBMHcAzB0Acwcwd3MHMHcAzB0AcwfA3AEwdwBzB8DcATB3AMwd"
                + "AHMHMHcRAMwdAHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcAcwdAHMHwNwBMHcAz"
                + "B0AcwcwdwDMHQBzB8DcATB3AHMHwNwBMHcAzB0AcwfA3AHMHQBzB8DcATB3AM"
                + "wdwNwBMHcAzB0AcwfA3AEwdwBzB8DcATB3AMwdAHMHMHcAzB0AcwfA3AEwdwD"
                + "MHcDcATB3AMwdAHMHwNwBzB0AcwfA3AEwdwDMHQBzBzB3AMwdAHMHwNwBMHcA"
                + "cwfA3AEwdwDMHQBzB8DcAcwdAHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcATB3A"
                + "HMHwNwBMHcAzB0AcwcwdwDMHQBzB8DcATB3AMwdwNwBMHcAzB0AcwfA3AHMHQ"
                + "BzB8DcATB3AMwdAHMHMHcAzB0AcwfA3AEwdwBzB8DcATB3AMwdAHMHwNwBzB0"
                + "AcwfA3AEwdwDMHcDcATB3AMwdAHMHwNwBMHcAcwfA3AEwdwDMHQBzBzB3AMwd"
                + "AHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcAcwdAHMHwNwBMHcAzB0AcwcwdwDMH"
                + "QBzB8DcATB3AHMHwNwBMHcAzB0AcwfA3AHMHQBzB8DcATB3AMwdwNwBMHcAzB"
                + "0AcwfA3AEwdwBzB8DcATB3AMwdAHMHMHcAzB0AcwfA3AEwdwDMHcDcATB3AMw"
                + "dAHMHwNwBzB0AcwfA3AEwdwDMHQBzBzB3AMwdAHMHwNwBMHcAcwfA3AEwdwDM"
                + "HQBzB8DcAcwdAHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcATB3AHMHwNwBMHcAz"
                + "B2AywKBFuY6V8dc6QAAAABJRU5ErkJggg=="; 
        this.priv = priv;
        word = randomWord(); 
        randomPassword(); 
        actualPainter = 0; 
        iniciarTimer(); 
        startTimer(); 
    }
    
    private void iniciarTimer(){
        tt = new Timer (1000, new ActionListener ()
{
        public void actionPerformed(ActionEvent e)
        {
            if(timer - 1 <= 0 ){
                timer = 30; 
                changeWord(); 
                changeTurn();
                board = "iVBORw0KGgoAAAANSUhEUgAAAu4AAAH0CAQAAADIsWAhAAAFa0lEQVR42u3UQRE"
                + "AAAjDMOZf9FCAAS6R0EfTDgDPxNwBzB0AcwfA3AEwdwDMHcDcATB3AMwdAHMH"
                + "wNwBzN3cAcwdAHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcAcxdBABzB8DcATB3A"
                + "MwdAHMHMHcAzB0AcwfA3AEwdwBzB8DcATB3AMwdAHMHwNwBzB0AcwfA3AEwdw"
                + "DMHcDcATB3AMwdAHMHwNwBMHcAcwfA3AEwdwDMHQBzBzB3AMwdAHMHwNwBMHc"
                + "AzB3A3AEwdwDMHQBzB8DcAcwdAHMHwNwBMHcAzB0AcwcwdwDMHQBzB8DcATB3"
                + "AHMHwNwBMHcAzB0AcwfA3AHMHQBzB8DcATB3AMwdwNwBMHcAzB0AcwfA3AEwd"
                + "wBzB8DcATB3AMwdAHMHMHcAzB0AcwfA3AEwdwDMHcDcATB3AMwdAHMHwNwBzB"
                + "0AcwfA3AEwdwDMHQBzBzB3AMwdAHMHwNwBMHcAcwfA3AEwdwDMHQBzB8DcAcw"
                + "dAHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcATB3AHMHwNwBMHcAzB0AcwcwdwDM"
                + "HQBzB8DcATB3AMwdwNwBMHcAzB0AcwfA3AHMHQBzB8DcATB3AMwdAHMHMHcAz"
                + "B0AcwfA3AEwdwBzB8DcATB3AMwdAHMHwNwBzB0AcwfA3AEwdwDMHcDcATB3AM"
                + "wdAHMHwNwBMHcAcwfA3AEwdwDMHQBzBzB3AMwdAHMHwNwBMHcAzB3A3AEwdwD"
                + "MHQBzB8DcAcwdAHMHwNwBMHcAzB0AcwcwdwDMHQBzB8DcATB3AHMHwNwBMHcA"
                + "zB0AcwfA3AHMHQBzB8DcATB3AMwdwNwBMHcAzB0AcwfA3AEwdwBzB8DcATB3A"
                + "MwdAHMHMHcAzB0AcwfA3AEwdwDMHcDcATB3AMwdAHMHwNwBzB0AcwfA3AEwdw"
                + "DMHQBzBzB3AMwdAHMHwNwBMHcAcwfA3AEwdwDMHQBzBzB3cwcwdwDMHQBzB8D"
                + "cATB3AHMHwNwBMHcAzB0Acwcwd3MHMHcAzB0AcwfA3AEwdwBzB8DcATB3AMwd"
                + "AHMHMHcRAMwdAHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcAcwdAHMHwNwBMHcAz"
                + "B0AcwcwdwDMHQBzB8DcATB3AHMHwNwBMHcAzB0AcwfA3AHMHQBzB8DcATB3AM"
                + "wdwNwBMHcAzB0AcwfA3AEwdwBzB8DcATB3AMwdAHMHMHcAzB0AcwfA3AEwdwD"
                + "MHcDcATB3AMwdAHMHwNwBzB0AcwfA3AEwdwDMHQBzBzB3AMwdAHMHwNwBMHcA"
                + "cwfA3AEwdwDMHQBzB8DcAcwdAHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcATB3A"
                + "HMHwNwBMHcAzB0AcwcwdwDMHQBzB8DcATB3AMwdwNwBMHcAzB0AcwfA3AHMHQ"
                + "BzB8DcATB3AMwdAHMHMHcAzB0AcwfA3AEwdwBzB8DcATB3AMwdAHMHwNwBzB0"
                + "AcwfA3AEwdwDMHcDcATB3AMwdAHMHwNwBMHcAcwfA3AEwdwDMHQBzBzB3AMwd"
                + "AHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcAcwdAHMHwNwBMHcAzB0AcwcwdwDMH"
                + "QBzB8DcATB3AHMHwNwBMHcAzB0AcwfA3AHMHQBzB8DcATB3AMwdwNwBMHcAzB"
                + "0AcwfA3AEwdwBzB8DcATB3AMwdAHMHMHcAzB0AcwfA3AEwdwDMHcDcATB3AMw"
                + "dAHMHwNwBzB0AcwfA3AEwdwDMHQBzBzB3AMwdAHMHwNwBMHcAcwfA3AEwdwDM"
                + "HQBzB8DcAcwdAHMHwNwBMHcAzB3A3AEwdwDMHQBzB8DcATB3AHMHwNwBMHcAz"
                + "B2AywKBFuY6V8dc6QAAAABJRU5ErkJggg=="; 
            }else{
                timer -- ; 
            }
        }
    });
    }
    private String randomWord(){
        String w = ""; 
        SecureRandom random = new SecureRandom();
        if(lenguaje.equals("Español")){
            int randomIndex = random.nextInt(palabrasEs.length);
            w = palabrasEs[randomIndex];
        }else{
            int randomIndex = random.nextInt(palabrasIn.length);
            w = palabrasIn[randomIndex]; 
        }
        return w; 
    }
    
    public void changeWord(){
        String nword = randomWord(); 
        while(nword.equals(word)){
            nword = randomWord(); 
        }
        word = nword; 
    }
    
    private void randomPassword(){
        if(priv){
                // ASCII range – alphanumeric (0-9, a-z, A-Z)
            final String chars = "abcdefghijklmnopqrstuvwxyz0123456789";

            SecureRandom random = new SecureRandom();
            StringBuilder sb = new StringBuilder();

            // each iteration of the loop randomly chooses a character from the given
            // ASCII range and appends it to the `StringBuilder` instance


            for (int i = 0; i < 5; i++)
            {
                int randomIndex = random.nextInt(chars.length());
                sb.append(chars.charAt(randomIndex));
            }
        
            password =  sb.toString();
        }else{
            password = null; 
        }
       
    }
    private void validLimit(){
        if(limit > maxUsers){
            limit = maxUsers; 
        } 
    }
    
    public void setWord(String word ){
        this.word = word; 
    } 
    
    public String getWord(){
        return word; 
    }
    
    public void setId(int id){
        this . id = id; 
    }
    
    public int getMaxUsers(){
        return maxUsers; 
    }
    
    public int getId(){
        return id; 
    }
    
    public void setMessages(ArrayList<String[]> messages){
        this.messages = messages; 
    }
    
    public ArrayList<String[]> getMessages(){
        return messages;  
    }
    
    public int getTimer(){
        return timer; 
    }
    

    
    public void setUsers(ArrayList<User> users){
        this.users = users; 
    }
    
    public ArrayList<User> getUsers (){
        return users;  
    } 
    
    public String getName(){
        return name; 
    }
    public void setName(String name){
        this.name = name; 
    }
    
    public String getLenguaje(){
        return lenguaje; 
    }
    
    public void setLenguaje(String lenguaje){
        this.lenguaje = lenguaje; 
    }
    
    public int getLimit(){
        return limit;  
    }
    
    public boolean getPriv(){
        return priv; 
    }
    
    public void setPriv(boolean priv){
        this.priv = priv; 
    }
    
    public String getBoard(){
        return board; 
    }
    
    public void setBoard(String board){
        this.board = board; 
    } 

    public String getPassword(){
        return password; 
    }
    
    public void sendMessage(String user, String message){
           messages.add( new String[] {user , message} ); 
    }
    
    public void changeTurn(){
        
        System.out.println(actualPainter); 
        for(User u : users){
            u.stopPainting();
        }
        if((actualPainter + 1) < users.size()){ 
            
            actualPainter ++ ; 
        }else{
            actualPainter = 0; 
        }   
        System.out.println(actualPainter); 
        users.get(actualPainter).setPainter();
    }
    
   
    
    public void stopTimer(){
        tt.stop(); 
        
    }
     public void startTimer(){
        tt.start(); 
    }
     
     public void cleanBoard(){
         board = ""; 
     }
    
    
}
    
    
 
