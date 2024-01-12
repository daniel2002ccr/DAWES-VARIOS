package com.daniel.tienda.controlador.actualizar;

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

import com.daniel.tienda.dao.ICombosDAO;
import com.daniel.tienda.dao.jdbc.CombosDAO;
import com.daniel.tienda.dtos.CombosDTO;
import com.daniel.tienda.negocio.impl.ClientesServicio;

@WebServlet("/cliente/actualizarcliente")
public class ActualizarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CombosDTO> listadoPoblacion = new ArrayList<>();
		ICombosDAO comboPoblacion = new CombosDAO();

		try {
			listadoPoblacion = comboPoblacion.recuperarComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("comboPoblacion", listadoPoblacion);

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarCliente.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String poblacion = request.getParameter("poblacion");
		String activo = request.getParameter("activo"); 
		
		Integer resultado = 0;
		
		activo = (activo != null) ? "1":"0";
		
		ClientesServicio cs = new ClientesServicio();
		
		try {
			resultado = cs.actualizarCliente(id, nombre, correo, poblacion, activo);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<CombosDTO> listadoPoblacion = new ArrayList<>();
		ICombosDAO comboPoblacion = new CombosDAO();

		try {
			listadoPoblacion = comboPoblacion.recuperarComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("comboPoblacion", listadoPoblacion);
		request.setAttribute("resultado", resultado);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarCliente.jsp");
		d.forward(request, response);
	}

}
