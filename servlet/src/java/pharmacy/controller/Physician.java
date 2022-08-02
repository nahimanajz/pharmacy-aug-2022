/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy.controller;

import com.pharmacy.model.UserModel;
import pharmacy.db.CoreDB;
import pharmacy.abstracte.User;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author janvier
 */
public class Physician extends User {

    @Override
    public String login(String username, String password){
      String userType = "";
        try {
            
            LinkedHashMap<Integer, UserModel> user = CoreDB.getInstance().getData();
            for (Map.Entry<Integer, UserModel> entry : user.entrySet()) {
                     
                    UserModel currentUser = entry.getValue();                
                    if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getUserPassword())) {
                        userType =  currentUser.getUserRole();
                        User.setUserType(userType);
                        break;


                    } else {
                        return null;
                    }  
               
            }
           
            //userType = User.getUserType();
            
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
      return userType;
    }

    @Override
    public LinkedHashMap<Integer, UserModel> signup(UserModel user){
        LinkedHashMap<Integer, UserModel> newUser  = CoreDB.getInstance().getData();
       newUser.put(new Random().nextInt(23), user);
      
       return newUser;
    }
    
}
