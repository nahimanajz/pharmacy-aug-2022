/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy.controller;

import pharmacy.abstracte.User;
import com.pharmacy.model.UserModel;
import pharmacy.db.CoreDB;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
/**
 *
 * @author janvier
 */
public class Admin extends User{

    @Override
    public String login(String password, String username) {
        String userType = "Admin login";
        //Integer.parseInt(password);
        
        try {
            
            LinkedHashMap<Integer, UserModel> user = CoreDB.getInstance().getData();
            for (Map.Entry<Integer, UserModel> entry : user.entrySet()) {
                
                     
                    UserModel currentUser = entry.getValue();  
                   // return currentUser.getFname();
                    if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getUserPassword())) {
                        return currentUser.getUserRole();
//                        userType =  currentUser.getUserRole();  
//                        User.setUserType(userType);
//                        return "Admin";
//
                    } else {
                       return null;
                   }  
               
            }
           
            userType = User.getUserType();
            
        }catch(Exception e){
            userType = e.getMessage();           
        }
      return userType;

    }

    @Override
    public LinkedHashMap signup(UserModel user){
       LinkedHashMap<Integer, UserModel> newUser  = CoreDB.getInstance().getData();
       newUser.put(new Random().nextInt(23), user);
      
       return newUser;
    }
    
}
