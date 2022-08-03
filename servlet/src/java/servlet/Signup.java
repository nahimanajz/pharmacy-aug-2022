/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.google.gson.Gson;
import com.pharmacy.model.UserModel;
import pharmacy.controller.*;


import pharmacy.helpers.ValidatePassword;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.stream.Collectors;
import javax.servlet.annotation.MultipartConfig;
import org.json.JSONObject;

        

/**
 *
 * @author janvier
 */
@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
 public class Signup extends HttpServlet {
    PrintWriter out;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
                response.addHeader("Access-Control-Allow-Origin", "*");
                //response.setContentType("application/json");
                
                 out = response.getWriter();

             try {
      
                Admin admin = new Admin();
		Patient patient = new Patient();
                Pharmacist pharmacist = new Pharmacist();
                Physician physician = new Physician();
		LinkedHashMap<Integer, UserModel> lhmUsers = new LinkedHashMap<Integer, UserModel>();
                
                String jsonString = req.getReader().lines().collect(Collectors.joining());                         
            
                UserModel myObject = new Gson().fromJson(jsonString, UserModel.class);  
                System.out.println(myObject.getUserRole());   
                System.out.println(myObject.getAge());

                String successMessage = null;               
                if(myObject.getUserPassword()!= myObject.getRetype_password()){                    
                   successMessage= "Passwords do not match";                    
               }

                       if(myObject.getUserRole().equalsIgnoreCase("admin")){
                            if(ValidatePassword.getInstance().adminPassword(String.valueOf(myObject.getRetype_password())) == true){
                                lhmUsers = admin.signup(myObject);
                                successMessage = "Admin account is created successfully";
                            } else {
                                successMessage="Password should be 8 numbers";
                                                 
                            }
                     } else if(myObject.getUserRole().equalsIgnoreCase("Patient")){
                         System.out.println("Patient account..");
                         if(ValidatePassword.getInstance().patientPassword(String.valueOf(myObject.getRetype_password())) == true){
                          lhmUsers = patient.signup(myObject);  
                           successMessage = "Patient account is created successfully";
                         } else {                             
                              successMessage = "Password should be only 7 numbers";
                              
                         }
                     }else if(myObject.getUserRole().equalsIgnoreCase("Physician")){
                     
                         if(ValidatePassword.getInstance().physicianPassword(String.valueOf(myObject.getRetype_password())) == true){
                          lhmUsers = physician.signup(myObject);  
                            successMessage = "Physician account is created successfully";
                         }else {                             
                             successMessage =  "Password should be only 6 numbers";   
                         }
                     
                     }else if(myObject.getUserRole().equalsIgnoreCase("pharmacist")){
                         
                         if(ValidatePassword.getInstance().pharmacistPassword(String.valueOf(myObject.getRetype_password())) == true){
                          lhmUsers = pharmacist.signup(myObject);  
                           successMessage = "Pharmacist account is successfully";
                         }else {                           
                             successMessage = "Password should be only 5 numbers";
                         }
                     }
                           
                  out.print(successMessage);

               } catch (Exception e) {
		    e.printStackTrace();
                    out.print(e.getMessage());
	        }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
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
