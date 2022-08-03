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
    public String login(String username, String password){
        
        return null;
    }

    @Override
    public LinkedHashMap signup(UserModel user){
       LinkedHashMap<Integer, UserModel> newUser  = CoreDB.getInstance().getData();
       newUser.put(new Random().nextInt(23), user);
      
       return newUser;
    }
    
}
