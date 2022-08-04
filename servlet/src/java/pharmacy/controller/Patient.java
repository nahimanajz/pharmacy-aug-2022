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
public class Patient extends User{

    @Override
    public String login(String username, String password){
        System.out.println("Patient Signed in");
         User.setUserType("patient");
         return null;
    }

    @Override
    public LinkedHashMap<Integer, UserModel> signup(UserModel patient) {
        LinkedHashMap<Integer, UserModel> newPatient  = CoreDB.getInstance().getData();
        newPatient.put(new Random().nextInt(23), patient);
      
       return newPatient;
    }
    
}
