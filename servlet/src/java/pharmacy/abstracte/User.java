/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy.abstracte;

import com.pharmacy.model.UserModel;
import java.util.LinkedHashMap;

/**
 *
 * @author janvier
 */
public abstract class User {
    private static String userType ;
   public  String login(String password , String username){return null;}
   
    public LinkedHashMap<Integer, UserModel> signup( UserModel user){ return null;}; 
    
    public static void setUserType(String userType){
        User.userType = userType;
     }
    public static String getUserType(){
        return User.userType;
    }


}
