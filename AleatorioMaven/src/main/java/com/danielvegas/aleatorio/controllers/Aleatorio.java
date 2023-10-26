package com.danielvegas.aleatorio.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.danielvegas.aleatorio.negocio.GenerarNumeroAleatorio;

@WebServlet("/numero")
public class Aleatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Aleatorio() {
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
	    int numeroAleatorio = GenerarNumeroAleatorio.numeroAleatorio(); 
	    
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    out.print("<html> <body> ");
	    out.print("<p> El número aleatorio es " + numeroAleatorio + "</p>");
	    out.print("</body> </html>");
	}

}
