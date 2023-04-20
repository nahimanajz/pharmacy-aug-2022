/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy.controller;

import com.pharmacy.model.UserModel;
import pharmacy.db.CoreDB;
import pharmacy.interfaces.IUser;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author janvier
 */
public class Patient implements IUser {

    @Override
    public LinkedHashMap<Integer, UserModel> signup(UserModel patient) {
        LinkedHashMap<Integer, UserModel> newPatient = CoreDB.getInstance().getData();
        newPatient.put(new Random().nextInt(23), patient);
        return newPatient;
    }

    @Override
    public UserModel login(UserModel userModel){
        //return userModel;
         int sum = 0;
        UserModel loggedUser = new UserModel();
         System.out.println("username===>"+userModel.getUsername()+"==>password===>"+ userModel.getPassword());
        LinkedHashMap<Integer, UserModel> users = CoreDB.getInstance().getData();
        for (Map.Entry<Integer, UserModel> entry : users.entrySet()) {
            UserModel userData = entry.getValue();
            sum ++;
            System.out.println("From loop username ==>"+userModel.getUsername()+"password==>"+userData.getPassword());
            if(1==1){
                System.out.println("username is found");
                break;
            }
        }
        // System.out.println("total users"+ sum+"username"+userModel.getName());
        return userModel;
    
    }

}
