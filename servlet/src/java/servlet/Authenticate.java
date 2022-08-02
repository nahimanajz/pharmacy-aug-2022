/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.google.gson.Gson;
import com.pharmacy.model.UserModel;
import pharmacy.db.CoreDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pharmacy.abstracte.User;
import pharmacy.controller.Admin;
import pharmacy.controller.Patient;
import pharmacy.controller.Pharmacist;
import pharmacy.controller.Physician;
import java.util.*;  

/**
 *
 * @author janvier
 */
@WebServlet(name = "Authenticate", urlPatterns = {"/Authenticate"})
public class Authenticate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(req, response);
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out;
        out = response.getWriter();
        
         UserModel um = new UserModel();
         LinkedHashMap<Integer, UserModel> lhmpUser = new LinkedHashMap<Integer, UserModel>();

          String jsonString = req.getReader().lines().collect(Collectors.joining());                            
          UserModel myObject = new Gson().fromJson(jsonString, UserModel.class);        
     
           lhmpUser = CoreDB.getInstance().getData(); 
     
           String error = null;
           User.setUserType(null); // reset data to be empty
           
           /** custom map */
            ArrayList<UserModel> arr = new ArrayList<>();           
           
           for (Map.Entry<Integer, UserModel> entry : lhmpUser.entrySet()) {   
               UserModel umData = entry.getValue();
               arr.add(umData);           
		}
           System.out.println(arr.size());
           boolean userFound = false;
           for(UserModel user: arr){               
               if(user.getUsername().equals(myObject.getUsername()) && user.getUserPassword() == myObject.getUserPassword()){
                   //out.print(user.getUserRole().toLowerCase()); //
                    //System.out.println("USER FOUND => Role:" + user.getUserRole() +"username:"+ user.getUsername()+ "password:" +user.getUserPassword());
                    userFound = true;
                    User.setUserType(user.getUserRole().toLowerCase());
               } 
           }
           if(userFound == false){
               out.print("Invalid credentials");
           } else {
               out.print(User.getUserType());
           }
             
	}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
