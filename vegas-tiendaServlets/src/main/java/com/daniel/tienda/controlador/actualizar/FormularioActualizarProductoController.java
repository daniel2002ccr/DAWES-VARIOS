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

import com.daniel.tienda.dtos.ProductoDTO;
import com.daniel.tienda.negocio.impl.ProductoServicio;

@WebServlet("/producto/formularioactualizarproductos")
public class FormularioActualizarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioActualizarProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarProducto.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductoDTO> listaProductos = new ArrayList<>();
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio"); 
		String cantidadStock = request.getParameter("cantidadStock");
		String id_categoria = request.getParameter("categorias");
		String id_proveedor = request.getParameter("proveedores");
		
		ProductoServicio ps = new ProductoServicio();
		
		
		try {
			listaProductos = ps.buscarProducto(id, nombre, descripcion, precio, cantidadStock, id_categoria, id_proveedor);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("lista", listaProductos);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarProducto.jsp");
		d.forward(request, response);
	}

}
