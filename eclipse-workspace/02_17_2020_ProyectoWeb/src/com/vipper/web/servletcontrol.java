package com.vipper.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vipper.persistencia.AccesoBBDD;


/**
 * Servlet implementation class servletcontrol
 */
@WebServlet("/servletcontrol")
public class servletcontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletcontrol() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet ServletContol</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet ServletContol at " + request.getContextPath() + "</h1>");

			// Se instancia la clase de la capa de persistencia
			AccesoBBDD ab1 = new AccesoBBDD();

			// Recoger los valores del formulario
			String jusuario = request.getParameter("usuario");
			String jpassword = request.getParameter("password");
			System.out.println("Usuario " + jusuario);
			try {
			String passwordBBDD = ab1.verificarPassword(jusuario);
			System.out.println("Contraseña de Base de Datos: " + passwordBBDD);
			System.out.println("Contraseña Formulario "+ jpassword);
			if (jpassword.equals(passwordBBDD)) {
				System.out.println("Bienvenido a la Pagina web " + jusuario);
			} else 
			{
				System.out.println("Su contraseña es invalida " + jusuario);
			}
			
			out.println("</body>");
			out.println("</html>");
			
		    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}


