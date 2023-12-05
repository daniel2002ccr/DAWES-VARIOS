<<<<<<< HEAD
package com.daniel.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.daniel.java.GeneradorNumeroAleatorio;

@WebServlet("/SegundoServicio")
public class SegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SegundoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numAleatorio = GeneradorNumeroAleatorio.numeroAleatorio();
		response.getWriter().append("Numero: " + numAleatorio);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
=======
package com.daniel.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.daniel.java.GeneradorNumeroAleatorio;

@WebServlet("/SegundoServicio")
public class SegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SegundoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numAleatorio = GeneradorNumeroAleatorio.numeroAleatorio();
		response.getWriter().append("Numero: " + numAleatorio);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
>>>>>>> a42b7bd6688eda9c2398355f3724b4fc7b325f87
