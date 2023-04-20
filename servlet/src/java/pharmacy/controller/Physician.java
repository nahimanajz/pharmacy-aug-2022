/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy.controller;

import com.pharmacy.model.UserModel;
import pharmacy.db.CoreDB;
import pharmacy.helpers.Helper;
import pharmacy.interfaces.IUser;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author janvier
 */
public class Physician implements IUser {

    @Override
    public LinkedHashMap<Integer, UserModel> signup(UserModel physician) {
        LinkedHashMap<Integer, UserModel> newPhysician = CoreDB.getInstance().getData();
        newPhysician.put(new Random().nextInt(23), physician);
        return newPhysician;
    }

    @Override
    public String login(UserModel clientCredentials) {
        Helper helper = new Helper();
        helper.loggedInUser = "";

        LinkedHashMap<Integer, UserModel> users = CoreDB.getInstance().getData();
        for (Map.Entry<Integer, UserModel> entry : users.entrySet()) {
            UserModel currentUserData = entry.getValue();

            if (helper.isEqual(clientCredentials.getEmail(), currentUserData.getEmail())
                    && helper.isEqual(clientCredentials.getPassword(), currentUserData.getPassword())) {
                helper.loggedInUser = "Physician";
                break;
            } else {
                return "Invalid Physician credentials";
            }

        }
        return helper.loggedInUser;
    }

}
