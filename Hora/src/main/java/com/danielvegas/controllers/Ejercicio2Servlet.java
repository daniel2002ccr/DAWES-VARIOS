<<<<<<< HEAD
package com.danielvegas.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.danielvegas.negocio.FechaYHora;

@WebServlet("/Ejercicio2Servlet")
public class Ejercicio2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ejercicio2Servlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FechaYHora fh = new FechaYHora();
		String fecha = fh.obtenerFechaYHoraActual();
		response.getWriter().append("La hora es: " + fecha);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
=======
package com.danielvegas.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.danielvegas.negocio.FechaYHora;

@WebServlet("/Ejercicio2Servlet")
public class Ejercicio2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ejercicio2Servlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FechaYHora fh = new FechaYHora();
		String fecha = fh.obtenerFechaYHoraActual();
		response.getWriter().append("La hora es: " + fecha);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
>>>>>>> a42b7bd6688eda9c2398355f3724b4fc7b325f87
