
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
import pharmacy.controller.Patient;
import pharmacy.controller.Pharmacist;
import pharmacy.controller.Physician;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Field;

import pharmacy.controller.*;

/**
 *
 * @author janvier
 */
@WebServlet(name = "Signin", urlPatterns = { "/Signin" })
public class Signin extends HttpServlet {

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
        out = response.getWriter();

        response.addHeader("Access-Control-Allow-Origin", "*");
        String requestData = req.getReader().lines().collect(Collectors.joining());
        UserModel fromJson = new Gson().fromJson(requestData, UserModel.class);

        LinkedHashMap<Integer, UserModel> mappedUsers = new LinkedHashMap<Integer, UserModel>();
        mappedUsers = CoreDB.getInstance().getData();

        if (fromJson.getUsername() != null && (fromJson.getEmail() == null || fromJson.getPhoneNumber() == null)) {

            Patient patient = new Patient();
            out.print(patient.login(fromJson));

        } else if (fromJson.getEmail() != null
                && (fromJson.getUsername() == null || fromJson.getPhoneNumber() == null)) {

            Physician physician = new Physician();
            out.print(physician.login(fromJson));

        } else if (fromJson.getPhoneNumber() != null
                && (fromJson.getUsername() == null || fromJson.getEmail() == null)) {

            Pharmacist pharmacist = new Pharmacist();
            out.print(pharmacist.login(fromJson));

        } else {
            out.print("We don\'t have such user role");
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
