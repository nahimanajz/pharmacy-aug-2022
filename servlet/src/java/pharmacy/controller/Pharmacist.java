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
public class Pharmacist implements IUser {

    @Override
    public LinkedHashMap<Integer, UserModel> signup(UserModel pharmacist) {
        LinkedHashMap<Integer, UserModel> newPharmacist = CoreDB.getInstance().getData();
        newPharmacist.put(new Random().nextInt(23), pharmacist);

        return newPharmacist;
    }

    @Override
    public String login(UserModel userModel) {

        UserModel loggedUser = null;
        LinkedHashMap<Integer, UserModel> users = CoreDB.getInstance().getData();
        for (Map.Entry<Integer, UserModel> entry : users.entrySet()) {
            UserModel userData = entry.getValue();
            if (userData.getPhoneNumber() == userModel.getPhoneNumber()
                    && userData.getPassword() == userModel.getPassword()) {
                loggedUser = userData;
            }
        }
        return loggedUser;
    }

}
