/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.proyectos.entity.Proyecto;
import co.edu.unipiloto.arquitectura.proyectos.session.ProyectoFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author UUSARIO
 */
@WebServlet(name = "ProyectoServlet", urlPatterns = {"/ProyectoServlet"})
public class ProyectoServlet extends HttpServlet {

    @EJB
    private ProyectoFacadeLocal proyectoFacade;

    /**
     * *
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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        
        String idStr = request.getParameter("id");
        Integer id = new Integer(0);
        if (idStr != null && !idStr.equals("")) {
            id = Integer.parseInt(idStr);
        }
        String nombre = request.getParameter("nombre");
        String localidad = request.getParameter("localidad");
        
        String presupuestoStr = request.getParameter("prosupuesto");
        Double presupuesto = new Double(0);
        if (presupuestoStr != null && !presupuestoStr.equals("")) {
            presupuesto = Double.parseDouble(presupuestoStr);
        }
        
        String habitantesStr = request.getParameter("habitantes");
        Integer habitantes = new Integer(0);
        if (habitantesStr != null && !habitantesStr.equals("")) {
            habitantes = Integer.parseInt(habitantesStr);
        }
        
        Proyecto pro = new Proyecto (id, nombre, localidad, presupuesto, habitantes);
        if ("Add".equalsIgnoreCase(action)) {
            proyectoFacade.create(pro);
        } else if ("Edit".equalsIgnoreCase(action)) {
            proyectoFacade.edit(pro);
        } else if ("Delete".equalsIgnoreCase(action)) {
            proyectoFacade.remove(proyectoFacade.find(id));
        } else if ("Search".equalsIgnoreCase(action)) {
            pro = proyectoFacade.find(id);
        } 

        
        if ("Search".equalsIgnoreCase(action)) {
            List estudiantes = new ArrayList();
            estudiantes.add(pro);
            request.setAttribute("allProyectos", estudiantes);
        } else {
            request.setAttribute("allProyectos", proyectoFacade.findAll());
        }
        request.setAttribute("pr", pro);
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
