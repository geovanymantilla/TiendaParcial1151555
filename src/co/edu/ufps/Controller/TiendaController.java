package co.edu.ufps.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.Dao.TiendaDao;
import co.edu.ufps.Entities.Tienda;

/**
 * Servlet implementation class TiendaController
 */
@WebServlet("/Tienda")
public class TiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TiendaDao tiDao = new TiendaDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiendaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		String action = request.getParameter("op");
		System.out.println(path);
		System.out.println(action);
		try {			
			switch (action) {
			case "registrar":
				registrarTienda(request, response);
				break;
			case "new":
				showNewForm(request, response);
				break;
			default:
				index(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	private void registrarTienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tienda tienda= new Tienda();
		tienda.setNombre(request.getParameter("nombre"));
		tienda.setClave(request.getParameter("password"));
		tienda.setLema(request.getParameter("lema"));
		tienda.setDescripcion(request.getParameter("descripcion"));
		tienda.setEmail(request.getParameter("email"));
		tienda.setFacebook(request.getParameter("facebook"));
		tienda.setImagen(request.getParameter("imagen"));		
		tienda.setPropietario(request.getParameter("propietario"));
		tienda.setWeb(request.getParameter("web"));
		Tienda ti = tiDao.findByField("email", tienda.getEmail());
		if (ti == null) {
			tiDao.insert(tienda);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
		dispatcher.forward(request, response);
	}

}
