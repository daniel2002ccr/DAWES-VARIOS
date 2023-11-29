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

import com.daniel.colegio.dao.ICombosDAO;
import com.daniel.colegio.dao.jdbc.impl.CombosDAOImpl;
import com.daniel.colegio.dtos.ComboDTO;
import com.daniel.colegio.negocio.impl.AlumnosServicio;

@WebServlet("/alumnos/insertaralumnos")
public class InsertarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAlumnosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	List<ComboDTO> listaMunicipios = new ArrayList<>();	
	ICombosDAO combosMunicipios = new CombosDAOImpl();
	
	try {
		listaMunicipios = combosMunicipios.recuperaCombosMunicipio();
	} catch (ClassNotFoundException | SQLException | NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	request.setAttribute("combosMunicipios", listaMunicipios);
	RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/insertarAlumnos.jsp");
	d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer resultado = 0;
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		String activo = request.getParameter("activo");
		String famNumerosa = request.getParameter("famNumerosa");
		String municipios = request.getParameter("municipios");
		
		famNumerosa = (famNumerosa != null) ? "1":"0";
		activo = (activo != null) ? "1":"0";
		
		 try {
			resultado = new AlumnosServicio().insertarAlumno(id, nombre, apellido, activo, famNumerosa, municipios);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 request.setAttribute("resultado", resultado);
		 doGet(request, response);
}
}
