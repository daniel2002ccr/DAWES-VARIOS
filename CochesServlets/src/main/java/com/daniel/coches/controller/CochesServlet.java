package com.daniel.coches.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

import com.daniel.coches.dtos.CochesDTO;
import com.daniel.coches.negocio.CochesNegocio;

@WebServlet("/coches")
public class CochesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CochesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
        String nombre = request.getParameter("nombre");
        
        
        CochesNegocio c = new CochesNegocio();

        int cantidad = 0;
		try {
			cantidad = c.obtenerNumeroCoches(nombre);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        CochesDTO cochesDTO = new CochesDTO(nombre, cantidad);
        

        request.setAttribute("coches", cochesDTO);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/cochesvista.jsp");
		
		rd.forward(request, response);
    
		
	}

}
