package com.daniel.descuento.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.daniel.descuento.dtos.DescuentosDTO;
import com.daniel.descuento.negocio.Descuentos;

@WebServlet("/calculadescuento")
public class DescuentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DescuentoServlet() {
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
		
		Descuentos d = new Descuentos();
		Integer descuento = d.calculaDescuento(nombre);
		
		DescuentosDTO descuentosDTO = new DescuentosDTO(nombre, descuento);
	
//		request.setAttribute("descuento", descuento);
//		request.setAttribute("nombre", nombre);
		
		request.setAttribute("descuento", descuentosDTO);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/descuentovista.jsp");
		
		rd.forward(request, response);
	}

}
