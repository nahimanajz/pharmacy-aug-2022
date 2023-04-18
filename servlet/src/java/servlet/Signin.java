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
import pharmacy.controller.*;

/**
 *
 * @author janvier
 */
@WebServlet(name = "Signin", urlPatterns = { "/Signin" })
public class Signin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(req, response);

        response.addHeader("Access-Control-Allow-Origin", "*");
        String requestData = req.getReader().lines().collect(Collectors.joining());
        UserModel fromJson = new Gson().fromJson(requestData, UserModel.class);

        LinkedHashMap<Integer, UserModel> mappedUsers = new LinkedHashMap<Integer, UserModel>();
        mappedUsers = CoreDB.getInstance().getData();
        User.setUserType(null);
        /** custom map */

        
        boolean userFound = false;
        for (UserModel user : usersList(mappedUsers)) {
            if (user.getUsername().equals(fromJson.getUsername())
                    && user.getUserPassword() == fromJson.getUserPassword()) {
                userFound = true;
                handleLogin(user.getUserRole().toLowerCase(), user.getUsername(),
                        String.valueOf(user.getUserPassword()));
            }
        }

        authResponse(response, userFound);
        
    }

    private ArrayList<UserModel> usersList(LinkedHashMap<Integer, UserModel> mappedUsers) {
        ArrayList<UserModel> usersList = new ArrayList<>();

        for (Map.Entry<Integer, UserModel> entry : mappedUsers.entrySet()) {
            UserModel umData = entry.getValue();
            usersList.add(umData);
        }
        return usersList;
    }

    private void authResponse(HttpServletResponse response, boolean userFound) {
        PrintWriter out;
        try {
            out = response.getWriter();
            if (userFound == false) {
                out.print("Invalid credentials");
            } else {
                out.print(User.getUserType());
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
            //out.print("something went wrong");

        }

    }

    private void handleLogin(String role, String username, String password) {
        if (role.equals("admin")) {
            Admin admin = new Admin();
            admin.login(username, password);
        } else if (role.equals("patient")) {
            Patient patient = new Patient();
            patient.login(username, password);

        } else if (role.equals("pharmacist")) {
            Pharmacist pharmacist = new Pharmacist();
            pharmacist.login(username, password);
        } else if (role.equals("physician")) {
            Physician physician = new Physician();
            physician.login(username, password);
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
