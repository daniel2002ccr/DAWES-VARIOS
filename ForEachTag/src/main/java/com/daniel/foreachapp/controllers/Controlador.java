package com.daniel.foreachapp.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.foreachapp.bean.Persona;

@WebServlet("/obtenpersonas")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(new Persona("Pepe", 2000));
		listaPersonas.add(new Persona ("kike", 10000));
		listaPersonas.add(new Persona ("Luis", 5000));
		listaPersonas.add(new Persona ("Maria", 3000));
		
		request.setAttribute("personas", listaPersonas);
		
		RequestDispatcher despachador = getServletContext().getRequestDispatcher("/WEB-INF/vistas/vista.jsp");
		despachador.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
