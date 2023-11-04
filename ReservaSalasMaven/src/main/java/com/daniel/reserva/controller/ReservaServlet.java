package com.daniel.reserva.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.daniel.reserva.negocio.ReservaSalas;

@WebServlet("/ReservaServlet")
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nombre = request.getParameter("Nombre");
        String fechaHora = request.getParameter("Fecha");
        String duracion = request.getParameter("duracion");
        String tipoSala = request.getParameter("tipo");


        ReservaSalas reservaSalas = new ReservaSalas();

        try {
            if (reservaSalas.esFechaValida(fechaHora) && reservaSalas.esHoraEnPunto(fechaHora) &&
                    reservaSalas.esSalaDisponible(tipoSala, fechaHora)) {
                int codigoConfirmacion = reservaSalas.generarCodigoConfirmacion();
                reservaSalas.guardarReservaEnArchivo(nombre + ";" + fechaHora + ";" + tipoSala);

                out.println("<h1>Reserva exitosa</h1>");
                out.println("<p>Código de confirmación: " + codigoConfirmacion + "</p>");
            } else {
                out.println("<h1>Error en la reserva</h1>");
                out.println("<p>Lo sentimos, la sala no está disponible en la fecha y hora seleccionadas.</p>");

                if (!reservaSalas.esSalaDisponible(tipoSala, fechaHora)) {
                    out.println("<p>Salas alternativas disponibles: </p>");
                    for (String alternativa : reservaSalas.buscarAlternativas(tipoSala, fechaHora)) {
                        out.println("<p>" + alternativa + "</p>");
                    }
                }
            }
        } catch (Exception e) {

            out.println("<h1>Error en la reserva</h1>");
            out.println("<p>Ha ocurrido un error en la reserva.</p>");
            out.println("<p>" + e.getMessage() + "</p>"); // Muestra el mensaje de la excepción
            e.printStackTrace(); // Muestra el rastreo de la pila en el servidor (útil para depurar)
        }
    }
	}


