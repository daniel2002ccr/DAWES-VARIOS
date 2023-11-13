package com.daniel.imc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

import com.daniel.imc.dtos.ImcDTO;
import com.daniel.imc.negocio.ImcNegocio;

@WebServlet("/imc")
public class ImcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImcServlet() {
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
		 
		 ImcNegocio i = new ImcNegocio();
		 
		 double imc = 0;
		 try {
			imc = i.obtenerIMC(nombre);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ImcDTO imcDto =new ImcDTO(nombre, imc);
		 
		 request.setAttribute("imc", imcDto);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/imcvista.jsp");
			
			rd.forward(request, response);
	}

}
