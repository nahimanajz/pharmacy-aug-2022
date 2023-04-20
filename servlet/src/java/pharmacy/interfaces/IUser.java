/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy.interfaces;

import com.pharmacy.model.UserModel;
import java.util.LinkedHashMap;

/**
 *
 * @author janvier
 */
public interface IUser {
    String login(UserModel userModel);
     LinkedHashMap<Integer, UserModel> signup( UserModel user);
    
}
