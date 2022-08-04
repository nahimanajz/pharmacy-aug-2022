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
        System.out.println("Physician Signed in");
         User.setUserType("physician");
         return null;
    }

    @Override
    public LinkedHashMap<Integer, UserModel> signup(UserModel physician){
        LinkedHashMap<Integer, UserModel> newPhysician  = CoreDB.getInstance().getData();
        newPhysician.put(new Random().nextInt(23), physician);
       return newPhysician;
    }
    
}
