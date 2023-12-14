package com.daniel.tienda.controlador.listar;

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

import com.daniel.tienda.dao.ICategoriaDAO;
import com.daniel.tienda.dao.IProveedorDAO;
import com.daniel.tienda.dao.jdbc.CategoriaDAOJdbc;
import com.daniel.tienda.dao.jdbc.ProveedorDAO;
import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.dtos.ProveedorDTO;

@WebServlet("/producto/listadoproductos")
public class ListadoProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoProductosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<CategoriaDTO> listaCategorias = new ArrayList<>();	
		ICategoriaDAO combosCategoria = new CategoriaDAOJdbc();
		
		List<ProveedorDTO> listaProveedor = new ArrayList<>();
		IProveedorDAO combosProveedor = new ProveedorDAO();
		
		
		try {
			listaCategorias = combosCategoria.recuperarComboCategoria();
			listaProveedor = combosProveedor.recuperarComboProovedor();
			
		
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("combosCategoria", listaCategorias);
		request.setAttribute("combosProveedor", listaProveedor);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/listadoProductos.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		
		doGet(request, response);
	}

}
