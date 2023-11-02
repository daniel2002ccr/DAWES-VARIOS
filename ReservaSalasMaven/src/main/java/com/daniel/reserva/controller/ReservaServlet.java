package com.daniel.reserva.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ReservaServlet
 */
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaServlet() {
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
		String nombre = request.getParameter("Nombre");
        String fechaHora = request.getParameter("Fecha");
        String duracion = request.getParameter("duracion");
        String tipo = request.getParameter("tipo");

//        ReservaSalaService reservaSalaService = new ReservaSalaService();
//        String mensajeReserva = reservaSalaService.realizarReserva(nombre, fechaHora, duracion, tipo);

        
//        request.setAttribute("mensaje", mensajeReserva);
//        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
	}


