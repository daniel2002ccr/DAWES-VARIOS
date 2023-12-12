package com.daniel.controlador.borrar;

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


import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.negocio.impl.CategoriaServicio;

@WebServlet("/categoria/formularioborrarcategoria")
public class FormularioBorrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioBorrarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/borrarCategoria.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategoriaDTO> listaCategoria = new ArrayList<>();
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");

		String activo = request.getParameter("activo");
		
		activo = (activo != null) ? "1" : "0";
		
		CategoriaServicio cs = new CategoriaServicio();
		
		try {
			listaCategoria = cs.buscarCategoria(id, nombre, descripcion, activo);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listaCategoria);

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/borrarCategoria.jsp");
		d.forward(request, response);
	}

}
