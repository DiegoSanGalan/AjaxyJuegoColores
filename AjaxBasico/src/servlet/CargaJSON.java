package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class CargaJSON
 */

public class CargaJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Persona persona = new Persona("Jose", 23); // Tiene que ser pojo
		Gson gson = new Gson(); // libreria de google que me permite serializar y deserializar json.
		String mensajeJson = gson.toJson(persona); // convertir el objeto persona a un String en formato Json.
		// el método .toJson es como el toString pero lo que hace es convertir en formato Json.
		
		response.setContentType("application/json"); // Elegir el tipo MIME para json
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(mensajeJson); // escribimos el contenido del String mensajeJson y lo transmite a traves del <body>
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String json = request.getReader().readLine();
		Gson gson = new Gson();
		Persona p = gson.fromJson(json, Persona.class); // lo deserializamos y lo carga en un objeto tipo Persona
		System.out.println("El usuario ha mandado a una persona! " + p.getNombre() + " " + p.getEdad());
	}

}
