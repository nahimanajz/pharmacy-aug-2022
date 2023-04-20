/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy.helpers;

/**
 *
 * @author janvier
 */
/**
 * TODO: throw exception if anything goes wrong instead returning boolean
 */
/**
 * Patient should use the username as a unique identifier and the password
 * (length 4-6)
 * Physician should use the email as the unique identifier and the password
 * (length 7-8)
 * The pharmacist should use the phone and the identifier and the password
 * (length 9-10)
 * 
 */
public class ValidatePassword {

    public static void validate(String role, String password) throws Exception {
        role.toLowerCase();
        switch (role) {
            case "Patient":
                if (password.length() < 4 || password.length() > 6) {
                    throw new Exception("Password length should be between 4-6 for Patient");
                }
                break;
            case "Physician":
                if (password.length() < 7 || password.length() > 8) {
                    throw new Exception("Password length should be between 7-8 for Physician");
                }
                break;
            case "Pharmacist":
                if (password.length() < 9 || password.length() > 10) {
                    throw new Exception("Password length should be between 9-10 for Pharmacist");
                }
                break;
            default:
                throw new Exception("Invalid role specified");
        }

    }
}
