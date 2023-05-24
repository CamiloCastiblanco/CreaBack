/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author CamiloCastiblanco
 */

import static org.junit.Assert.* ;
import org.junit.AfterClass; 
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test; 
        
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.escuelaing.arsw.crea.model.User;
import co.edu.escuelaing.arsw.crea.services.exceptions.CreaServiceException;
import co.edu.escuelaing.arsw.crea.services.impl.CreaServiceImpl;
import co.edu.escuelaing.arsw.crea.services.impl.RoomServiceImpl;
public class RoomsTest {
    CreaServiceImpl CreaServiceImpl; 
    @Before
    public void init(){
        CreaServiceImpl = new CreaServiceImpl(); 
    }
    
    @Test
    public void deberiaCrearSala() throws CreaServiceException{
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala","En", false, 10 ));
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala1","En", true, 10));
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala2","En", false, 10));
        assertEquals(CreaServiceImpl.getRooms().size() , 3 ); 
    }
    
    @Test
    public void deberiaAssignarClaveAleatoria() throws CreaServiceException{
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala1","En", true, 10));
        assertNotSame(CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).getRoom().getPassword() , null );
    }
    
    @Test
    public void noDeberiaAssignarClaveAleatoria() throws CreaServiceException{
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 10));
        assertEquals(CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).getRoom().getPassword() , null );
    }
    
    @Test
    public void deberiaAñadirUsuarios() throws CreaServiceException{
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 10));
        CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).addUser(new User("juan", "skin1"));
        CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).addUser(new User("pedro", "skin1"));
        assertEquals(CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).getRoom().getUsers().size() ,2 );
    }
    @Test 
    public void deberiaEliminarUsuarios() throws CreaServiceException{
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 10));
        CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).addUser(new User("juan", "skin1"));
        CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).addUser(new User("pedro", "skin1"));
        CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).getRoom().getUsers().get(0).setId(700); 
        User toDelete = CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).searchUserById(700);
        CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).delUser(toDelete);
        assertEquals(CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).getRoom().getUsers().size() ,1 );
        assertEquals(CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).getRoom().getUsers().get(0).getNickname() ,"pedro" );
    }
    
    @Test
    public void noDeberiaPonerLimiteMayor() throws CreaServiceException{
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 70));
        assertEquals(CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).getRoom().getMaxUsers() ,CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).getRoom().getLimit()); 
    }
    
    @Test
    public void noDeberiaAgregarMasUsuariosQueLimite() throws CreaServiceException{
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 3));
        CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).addUser(new User("usuario1", "skin1"));
        CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).addUser(new User("usuario2", "skin1"));
        CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).addUser(new User("usuario3", "skin1"));
        try{
            CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).addUser(new User("usuario4", "skin1"));
        }catch(Exception e){
            
            assertEquals(e.getMessage() , "limite de usuariso alcanzado"); 
            assertEquals( CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).getRoom().getUsers().size() , 3 ); 
        }
    }
    
    @Test
    public void deberiaAñadirusuarioPorId() throws CreaServiceException{
         CreaServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 3));
         CreaServiceImpl.addUserToRoomById(new User("usuario1", "skin1"), 1);
         assertEquals( CreaServiceImpl.getRooms().get(0).getRoom().getUsers().size(), 1); 
         
    }
    @Test
    public void deberiaCrearPalabraAleatoria() throws CreaServiceException{
         CreaServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 3));
         System.out.println(CreaServiceImpl.getRooms().get(0).getRoom().getWord()); 
         assertNotSame(CreaServiceImpl.getRooms().get(0).getRoom().getWord() , null); 
    }
    @Test
    public void deberiaRegenerarLasPalabras() throws CreaServiceException{
         CreaServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 3));
         String p1 = CreaServiceImpl.getRooms().get(0).getRoom().getWord();
         CreaServiceImpl.getRooms().get(0).getRoom().changeWord(); 
         String p2 = CreaServiceImpl.getRooms().get(0).getRoom().getWord();
         System.out.println(p1 + " - " +  p2); 
         assertNotSame(p1 ,p2); 
    }
    
   
    
    
}
