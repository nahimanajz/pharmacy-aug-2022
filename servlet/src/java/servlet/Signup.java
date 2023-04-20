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
@WebServlet(name = "Signup", urlPatterns = { "/Signup" })
public class Signup extends HttpServlet {
    PrintWriter out;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        // response.setContentType("application/json");

        out = response.getWriter();

        try {

            LinkedHashMap<Integer, UserModel> lhmUsers = new LinkedHashMap<Integer, UserModel>();
            String jsonString = req.getReader().lines().collect(Collectors.joining());
            UserModel myObject = new Gson().fromJson(jsonString, UserModel.class);
            ValidatePassword.validate(myObject.getRole(), myObject.getPassword());
            out.print(createAccount(myObject));

        } catch (Exception e) {
            e.printStackTrace();
            out.print(e.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
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
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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

    private String createAccount(UserModel userModel) throws Exception {
        String role = userModel.getRole().toLowerCase();

        switch (role) {
            case "patient":
                Patient patient = new Patient();
                patient.signup(userModel);
                break;

            case "physician":
                Physician physician = new Physician();
                physician.signup(userModel);
                break;

            case "pharmacist":
                Pharmacist pharmacist = new Pharmacist();
                pharmacist.signup(userModel);
                break;
            default:
                throw new Exception(role + "is excluded from accepted roles");
        }
        return role.toUpperCase() + "Account is Created";
    }

}
