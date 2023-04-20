package pharmacy.helpers;

import com.pharmacy.model.UserModel;

public class Helper {
    public String loggedInUser = "";

    public String toLower(String text) {
        return text.toLowerCase();
    }

    /**
     * 
     * @param looped     current user from looped userlist
     * @param clientUser user, request data from client currently postman, reactjs
     *                   app
     * @param identifier username=>patient|email=>physician
     *                   |phonenumbe=>pharmacistr regarding to given username
     * @return { bool }
     */
    public boolean checkCredentials(UserModel loopedUser, UserModel clientUser) {
        String role = loopedUser.getUserRole();
        System.out.println("Checking credentials attent" + loopedUser.getEmail());
        return false;
        /*
         * switch (this.toLower(role)) {
         * case "patient":
         * return loopedUser.getUsername().equals(clientUser.getUsername())
         * && loopedUser.getPassword().equals(clientUser.getPassword());
         * case "physician":
         * return
         * this.toLower(loopedUser.getEmail()).equals(this.toLower(clientUser.getEmail()
         * ))
         * && loopedUser.getPassword().equals(clientUser.getPassword());
         * case "pharmacist":
         * return
         * this.toLower(loopedUser.getPhoneNumber()).equals(this.toLower(clientUser.
         * getPhoneNumber()))
         * && loopedUser.getPassword().equals(clientUser.getPassword());
         * default:
         * return false;
         * }
         */
    }

    public boolean isEqual(String text, String comparator)
   {  
    return this.toLower(text).equals(this.toLower(comparator));

  }
}
