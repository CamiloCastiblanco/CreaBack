/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jgarc
 */

import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import co.edu.escuelaing.arsw.letsdraw.services.impl.LetsDrawServiceImpl;
import co.edu.escuelaing.arsw.letsdraw.services.impl.RoomServiceImpl;
import static org.junit.Assert.* ;
import org.junit.AfterClass; 
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test; 
        
import org.springframework.beans.factory.annotation.Autowired;
public class RoomsTest {
    LetsDrawServiceImpl letsDrawServiceImpl; 
    @Before
    public void init(){
        letsDrawServiceImpl = new LetsDrawServiceImpl(); 
    }
    
    @Test
    public void deberiaCrearSala() throws LetsDrawServiceException{
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala","En", false, 10 ));
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala1","En", true, 10));
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala2","En", false, 10));
        assertEquals(letsDrawServiceImpl.getRooms().size() , 3 ); 
    }
    
    @Test
    public void deberiaAssignarClaveAleatoria() throws LetsDrawServiceException{
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala1","En", true, 10));
        assertNotSame(letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).getRoom().getPassword() , null );
    }
    
    @Test
    public void noDeberiaAssignarClaveAleatoria() throws LetsDrawServiceException{
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 10));
        assertEquals(letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).getRoom().getPassword() , null );
    }
    
    @Test
    public void deberiaAñadirUsuarios() throws LetsDrawServiceException{
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 10));
        letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).addUser(new User("juan", "skin1"));
        letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).addUser(new User("pedro", "skin1"));
        assertEquals(letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).getRoom().getUsers().size() ,2 );
    }
    @Test 
    public void deberiaEliminarUsuarios() throws LetsDrawServiceException{
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 10));
        letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).addUser(new User("juan", "skin1"));
        letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).addUser(new User("pedro", "skin1"));
        letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).getRoom().getUsers().get(0).setId(700); 
        User toDelete = letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).searchUserById(700);
        letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).delUser(toDelete);
        assertEquals(letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).getRoom().getUsers().size() ,1 );
        assertEquals(letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).getRoom().getUsers().get(0).getNickname() ,"pedro" );
    }
    
    @Test
    public void noDeberiaPonerLimiteMayor() throws LetsDrawServiceException{
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 70));
        assertEquals(letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).getRoom().getMaxUsers() ,letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).getRoom().getLimit()); 
    }
    
    @Test
    public void noDeberiaAgregarMasUsuariosQueLimite() throws LetsDrawServiceException{
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 3));
        letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).addUser(new User("usuario1", "skin1"));
        letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).addUser(new User("usuario2", "skin1"));
        letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).addUser(new User("usuario3", "skin1"));
        try{
            letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).addUser(new User("usuario4", "skin1"));
        }catch(Exception e){
            
            assertEquals(e.getMessage() , "limite de usuariso alcanzado"); 
            assertEquals( letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).getRoom().getUsers().size() , 3 ); 
        }
    }
    
    @Test
    public void deberiaAñadirusuarioPorId() throws LetsDrawServiceException{
         letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 3));
         letsDrawServiceImpl.addUserToRoomById(new User("usuario1", "skin1"), 1);
         assertEquals( letsDrawServiceImpl.getRooms().get(0).getRoom().getUsers().size(), 1); 
         
    }
    @Test
    public void deberiaCrearPalabraAleatoria() throws LetsDrawServiceException{
         letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 3));
         System.out.println(letsDrawServiceImpl.getRooms().get(0).getRoom().getWord()); 
         assertNotSame(letsDrawServiceImpl.getRooms().get(0).getRoom().getWord() , null); 
    }
    @Test
    public void deberiaRegenerarLasPalabras() throws LetsDrawServiceException{
         letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala1","En", false, 3));
         String p1 = letsDrawServiceImpl.getRooms().get(0).getRoom().getWord();
         letsDrawServiceImpl.getRooms().get(0).getRoom().changeWord(); 
         String p2 = letsDrawServiceImpl.getRooms().get(0).getRoom().getWord();
         System.out.println(p1 + " - " +  p2); 
         assertNotSame(p1 ,p2); 
    }
    
   
    
    
}
