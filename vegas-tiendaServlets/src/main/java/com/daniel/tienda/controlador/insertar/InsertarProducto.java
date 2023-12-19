package com.daniel.tienda.controlador.insertar;

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
import com.daniel.tienda.negocio.impl.ProductoServicio;

@WebServlet("/producto/insertarproducto")
public class InsertarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CombosDTO> listaCategorias = new ArrayList<>();	
		ICombosDAO combosCategoria = new CombosDAO();
		
		List<CombosDTO> listaProveedor = new ArrayList<>();
		ICombosDAO combosProveedor = new CombosDAO();
		
		
		try {
			listaCategorias = combosCategoria.recuperarComboCategoria();
			listaProveedor = combosProveedor.recuperarComboProovedor();
			
		
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("combosCategoria", listaCategorias);
		request.setAttribute("combosProveedor", listaProveedor);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/insertarProducto.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer resultado = 0;
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio"); 
		String cantidadStock = request.getParameter("cantidadStock");
		String id_categoria = request.getParameter("categorias");
		String id_proveedor = request.getParameter("proveedores");
		
		precio = (precio == "") ? "0":precio;
		cantidadStock = (cantidadStock == "") ? "0":cantidadStock;
		
		ProductoServicio ps = new ProductoServicio();
		
		try {
			resultado = ps.insertarProducto(nombre, descripcion, precio, cantidadStock, id_categoria, id_proveedor);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("resultado", resultado);
		doGet(request, response);
	}

}
