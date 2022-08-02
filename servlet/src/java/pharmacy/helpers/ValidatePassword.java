/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy.helpers;

/**
 *
 * @author janvier
 */
public class ValidatePassword {
 
    private static final ValidatePassword instance = new ValidatePassword();
    public static ValidatePassword getInstance() {
		return instance;
	}
    public Boolean adminPassword(String password){
        if(password.length() != 8){
            return false;
        }
        return true;
    }
    
    public Boolean patientPassword(String password){
        if(password.length() != 7){
            return false;
        }
        return true;
        
    }
    
    public Boolean physicianPassword(String password){
        if(password.length() != 6){
            return false;
        }
        return true;
        
    }
    
    public Boolean pharmacistPassword(String password){
        if(password.length() != 5){
            return false;
        }
        return true;
        
    }
    
    
    public boolean isNumber(int password){
        boolean answer = false;
        try 
		{ 
			
			answer= true;
		}  
		catch (NumberFormatException e)  
		{ 
			System.out.println(password + " is not a valid integer"); 
                        answer = false;
		} 
	return answer;
    }
    
}
