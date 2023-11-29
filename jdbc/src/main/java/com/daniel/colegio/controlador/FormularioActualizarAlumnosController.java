package com.daniel.colegio.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.negocio.impl.AlumnosServicio;

@WebServlet("/alumnos/actualizaralumnos")
public class FormularioActualizarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormularioActualizarAlumnosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarAlumnos.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<AlumnoDTO> listaAlumnos = new ArrayList<>();
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");

		String activo = request.getParameter("activo");
		String famNumerosa = request.getParameter("famNumerosa");

		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";

		AlumnosServicio as = new AlumnosServicio();
		try {
			listaAlumnos = as.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}

		request.setAttribute("lista", listaAlumnos);

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarAlumnos.jsp");
		d.forward(request, response);
	}

}
