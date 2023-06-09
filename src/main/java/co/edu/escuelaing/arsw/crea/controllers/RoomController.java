package co.edu.escuelaing.arsw.crea.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.escuelaing.arsw.crea.model.Room;
import co.edu.escuelaing.arsw.crea.model.User;
import co.edu.escuelaing.arsw.crea.services.exceptions.CreaServiceException;
import co.edu.escuelaing.arsw.crea.services.impl.CreaServiceImpl;
import co.edu.escuelaing.arsw.crea.services.impl.RoomServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.json.*;

/**
 * @author CamiloCastiblanco
 */

@RestController
public class RoomController {

    @Autowired
    CreaServiceImpl CreaServiceImpl;
    
    @CrossOrigin (origins = "*")
    @RequestMapping("/")
    private String testing() throws CreaServiceException {
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala", "En", false, 10));
        CreaServiceImpl.addUserToRoomById(new User("pepe" , "pepe") , 1);
        CreaServiceImpl.addUserToRoomById(new User("ana" , "ana") , 1);
        return "Hello World ARSW";
    }
    
    // retornar la palabra con  _ _ _ solo si el usuario no esta dibujando
    /*
    @CrossOrigin
    @RequestMapping(value = "/getWord2/{id}/{user}/", method = RequestMethod.GET)
    
    public String getWord2(@PathVariable("id") int id , @PathVariable("user") String user  ) throws CreaServiceException {
        
        CreaServiceImpl.createRoom(new RoomServiceImpl("sala", "En", false, 10));
        CreaServiceImpl.addUserToRoomById(new User("pepe" , "pepe") , 1);
        CreaServiceImpl.addUserToRoomById(new User("ana" , "ana") , 1);
        CreaServiceImpl.getRooms().get(id - 1 ).getRoom().getUsers().get(0).setPainter();
        
        String word = "N O N E";
        for(RoomServiceImpl i : CreaServiceImpl.getRooms()){
            if (i.getRoom().getId() == id) {
                word = i.getRoom().getWord(); 
            }
        }
        
        String word2 = ""; 
        for(User i : CreaServiceImpl.getRooms().get(id- 1 ).getRoom().getUsers()){
            if(i.getNickname().equals(user )){
                if(i.getIsDrawing()){
                    word2 = word; 
                }else{
                    for(char j : word.toCharArray()){
                        System.out.println(j);
                        word2 += "_ " ;
                    }
                }
                break; 
            }
        }
        return "{\n"
                + "    \"name\": " + "\"" + word2 +"\"\n"
                + "}";
    }
    */

    @CrossOrigin (origins = "*")
    @RequestMapping(value = "/getWord/{id}/", method = RequestMethod.GET)
    public String getWord(@PathVariable("id") int id) throws CreaServiceException {
        String word = "N O N E";
        for(RoomServiceImpl i : CreaServiceImpl.getRooms()){
            if (i.getRoom().getId() == id) {
                word = i.getRoom().getWord(); 
            }
        }
        return "{\n"
                + "    \"name\": " + "\"" + word +"\"\n"
                + "}";
    }

    @CrossOrigin (origins = "*")
    @RequestMapping(value = "/getTimer/{id}/", method = RequestMethod.GET)
    public String getTimer(@PathVariable("id") int id) throws CreaServiceException {
        int timer = 0; 
        for(RoomServiceImpl i : CreaServiceImpl.getRooms()){
            if (i.getRoom().getId() == id) {
                timer = i.getRoom().getTimer(); 
            }
        }
        return "{\n"
                + "    \"timer\": " + "\"" + timer +"\"\n"
                + "}";
    }



    @CrossOrigin (origins = "*")
    @RequestMapping(value = "/addRoom/{name}/{lenguaje}/{priv}/{limit}/", method = RequestMethod.GET)
    public int addRoom(@PathVariable("name") String name, @PathVariable("lenguaje") String lenguaje,
            @PathVariable("priv") boolean priv, @PathVariable("limit") int limit) throws CreaServiceException{

        /**
         *
         * System.out.println("name : " + name); System.out.println("lenguaje :
         * " + lenguaje); System.out.println("priv : " + priv );
         * System.out.println("limit : " + limit );          *
         *
         */
        CreaServiceImpl.createRoom(new RoomServiceImpl(name, lenguaje, priv, limit));

        return CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size() - 1).getRoom().getId();
    }

    @CrossOrigin (origins = "*")
    @RequestMapping(value = "/sendMessage/{id}/{name}/{message}/", method = RequestMethod.GET)
    public void sendMessage(@PathVariable("id") int id , @PathVariable("name") String name, @PathVariable("message") String message) throws CreaServiceException{
        System.out.println("entro el mensaje");
        System.out.println(id + " - " + name + " - " + message ); 
        boolean valid = false ; 
        for(RoomServiceImpl i : CreaServiceImpl.getRooms()){
            if (i.getRoom().getId() == id) {
                valid = ((i.getRoom().getWord()).equals(message)); 
                System.out.println(valid);
                if(valid){
                    for(User j : i.getRoom().getUsers()){
                        if(j.getNickname().equals(name) && !j.getIsDrawing() ){
                            int points = j.getPoints();
                            System.out.println("entro a sumar"); 
                            j.setPoints(points += (i.getRoom().getTimer()));
                            break; 
                        }
                        
                    }
                }else{
                    i.getRoom().sendMessage(name, message);
                }
                break; 
            }
        }
    }

    @CrossOrigin (origins = "*")
    @RequestMapping(value = "/getMessages/{id}/", method = RequestMethod.GET)
    public String getMessages(@PathVariable("id") int id ) throws CreaServiceException{
        String json = "";  
        for(RoomServiceImpl i : CreaServiceImpl.getRooms()){
            if (i.getRoom().getId() == id) {
                
                ArrayList<String[]> mensajes = i.getRoom().getMessages() ;  
                for(String[] j : mensajes ){
                    System.out.println(mensajes.indexOf(j)); 
                    if(mensajes.indexOf(j) == mensajes.size() - 1){
                        json += "{\n"
                        + "           \"user\": \"" + j[0] + "\",\n"
                        + "           \"message\": \"" + j[1] + "\"\n"
                        + "           }\n";
                    }else{
                        json += "{\n"
                        + "           \"user\": \"" + j[0] + "\",\n"
                        + "           \"message\": \"" + j[1] + "\"\n"
                        + "           },\n";
                    }  
                } 
            }
        }
        return "{ \"messages\" : [ " + json + "]} "; 
    }

    /**
     *
     * @param id
     * @return
     */
    @CrossOrigin (origins = "*")
    @RequestMapping(value = "/stopTimer/{id}", method = RequestMethod.GET)
    public void stopTimer(@PathVariable("id") int id ){
         for (RoomServiceImpl i : CreaServiceImpl.getRooms()) {
            if (i.getRoom().getId() == id) {
                i.stopTimer();
            }
         }
    }

    @CrossOrigin (origins = "*")
    @RequestMapping(value = "/startTimer/{id}", method = RequestMethod.GET)
    public void startTimer(@PathVariable("id") int id ){
         for (RoomServiceImpl i : CreaServiceImpl.getRooms()) {
            if (i.getRoom().getId() == id) {
                i.startTimer();
            }
         }
    }

    @CrossOrigin (origins = "*")
    @RequestMapping(value = "/setBoard", method = {RequestMethod.GET, RequestMethod.PUT , RequestMethod.POST } )
    public void setBoard(@RequestBody String board){
        JSONObject boardj = new JSONObject(board);  
        System.out.println(boardj.get("id")); 
        System.out.println(boardj.get("board"));
        int id = (int) boardj.get("id"); 
        String bo = (String) boardj.get("board");
        for (RoomServiceImpl i : CreaServiceImpl.getRooms()) {
            if (i.getRoom().getId() == id) {
                i.getRoom().setBoard(bo); 
            }
        }
    }

    @CrossOrigin (origins = "*")
    @RequestMapping(value = "/getBoard/{id}", method = RequestMethod.GET)
    public String setBoard(@PathVariable("id") int id  ){
        String finalBoard = ""; 
        for (RoomServiceImpl i : CreaServiceImpl.getRooms()) {
            if (i.getRoom().getId() == id) {
                finalBoard = i.getRoom().getBoard(); 
            }
         }
        return "{\n"
                + "    \"board\": " + "\"" + finalBoard +"\"\n"
                + "}";
    }




    @CrossOrigin (origins = "*")
    @RequestMapping(value = "/getRoomInfo/{id}", method = RequestMethod.GET)
    public String getRoomInfo(@PathVariable("id") int id) throws CreaServiceException {
        //CreaServiceImpl.createRoom(new RoomServiceImpl("sala", "En", false, 10));
        //CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).addUser(new User("juan", "skin1"));
        //CreaServiceImpl.getRooms().get(CreaServiceImpl.getRooms().size()-1).addUser(new User("pedro", "skin1"));
        
        ArrayList<User> users = null;
        String sala = "";
        for (RoomServiceImpl i : CreaServiceImpl.getRooms()) {
            if (i.getRoom().getId() == id) {
                users = i.getRoom().getUsers();
                sala = i.getRoom().getName();
                break;
            }
        }
        String salida = "";
        for (User i : users) {
            if (users.indexOf(i) == users.size() - 1) {

                salida += "{\n"
                        + "           \"id\": \"" + i.getId() + "\",\n"
                        + "           \"nikname\": \"" + i.getNickname() + "\",\n"
                        + "           \"points\": \"" + i.getPoints() + "\",\n"
                        + "           \"dibujante\": \"" + i.getIsDrawing() + "\",\n"
                        + "           \"skin\": \"" + i.getSkin() + "\"\n"
                        + "           }\n";
            } else {
                salida += "{\n"
                        + "           \"id\": \"" + i.getId() + "\",\n"
                        + "           \"nikname\": \"" + i.getNickname() + "\",\n"
                        + "           \"points\": \"" + i.getPoints() + "\",\n"
                        + "           \"dibujante\": \"" + i.getIsDrawing() + "\",\n"
                        + "           \"skin\": \"" + i.getSkin() + "\"\n"
                        + "           },\n";
            }
        }

        return "{\n"
                + "    \"name\": " + "\"" + sala +"\",\n"
                + "    \"user\": [\n"
                + salida
                + "   ]\n"
                + "}";

    }
    @CrossOrigin (origins = "*")
    @RequestMapping("/rooms")
    private String rooms() throws CreaServiceException {
        String salida = "";
        //
        //CreaServiceImpl.createRoom(new RoomServiceImpl("sala", "En", false, 10));
        //CreaServiceImpl.getRooms().get(0).addUser(new User("jugador1", "skin 1"));

        for (RoomServiceImpl i : CreaServiceImpl.getRooms()) {
            if (CreaServiceImpl.getRooms().indexOf(i) == CreaServiceImpl.getRooms().size() - 1) {
                salida += "{\n"
                        + "           \"id\": \"" + i.getRoom().getId() + "\",\n"
                        + "           \"name\": \"" + i.getRoom().getName() + "\",\n"
                        + "           \"users\": \"" + i.getRoom().getUsers().size() + "/" + i.getRoom().getLimit() + "\",\n"
                        + "           \"lenguaje\": \"" + i.getRoom().getLenguaje() + "\",\n"
                        + "           \"priv\": \"" + i.getRoom().getPriv() + "\"\n"
                        + "           }\n";
            } else {
                salida += "{\n"
                        + "           \"id\": \"" + i.getRoom().getId() + "\",\n"
                        + "           \"name\": \"" + i.getRoom().getName() + "\",\n"
                        + "           \"users\": \"" + i.getRoom().getUsers().size() + "/" + i.getRoom().getLimit() + "\",\n"
                        + "           \"lenguaje\": \"" + i.getRoom().getLenguaje() + "\",\n"
                        + "           \"priv\": \"" + i.getRoom().getPriv() + "\"\n"
                        + "           },\n";
            }
            //i.getRoom().getId() + " - " +  i.getRoom().getName() + " - " + i.getRoom().getLenguaje() + " - " + i.getRoom().getLimit() + " - " + i.getRoom().getUsers().size() +"   --------   "; 
        }

        //return salida;  
        return "{\n"
                + "    \"person\": [\n"
                + salida
                + "   ]\n"
                + "}";
    }

}
