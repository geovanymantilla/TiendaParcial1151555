package co.edu.ufps.Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.Dao.ClienteDao;
import co.edu.ufps.Dao.ServicioDao;
import co.edu.ufps.Dao.TiendaDao;
import co.edu.ufps.Entities.Cliente;
import co.edu.ufps.Entities.Tienda;




/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/Cliente")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDao cliDao = new ClienteDao();
	ServicioDao serDao = new ServicioDao();
	TiendaDao tiDao = new TiendaDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pat = request.getServletPath();
		String action = request.getParameter("op");
		System.out.println(pat);
		System.out.println(action);

		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertarCliente(request, response);
				break;
			case "delete":
				eliminarCliente(request, response);
				break;
			case "listar":
				System.out.println("entro");
				listCliente(request, response);
				break;
			case "edit":
				showEditCliente(request, response);
				break;
			case "update":
				actualizarCliente(request, response);
				break;
//			case "/buscar":
//				buscarEmpleado(request,response);
//				break;
			case "Vistalogin":
				Vistalogin(request, response);
				break;
			case "login":
				login(request, response);
				break;

			default:
				index(request, response);

			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Tienda> listatienda = tiDao.list();
		request.getSession().setAttribute("listatienda", listatienda);	
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	private void Vistalogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("registroCliente.jsp").forward(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
        String contraseña = request.getParameter("contraseña");
        ClienteDao uDao = new ClienteDao();
        Cliente us = uDao.find(email);
        if(us!=null){
        	if(us.getClave().contentEquals(contraseña)){
        		
                request.getRequestDispatcher("/login.jsp").forward(request, response);
        	}else{
        		request.getRequestDispatcher("/login.jsp").forward(request, response);
        	}
        }else{
        	request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("registroCliente.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditCliente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		Heroe h = herDao.find(id);
//		List<Estado> estados = estDao.list();
//		List<Genero> generos = genDao.list();
//
//		request.setAttribute("heroe", h);
//		request.setAttribute("estados", estados);
//		request.setAttribute("generos", generos);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("heroeForm.jsp");
//		dispatcher.forward(request, response);

	}

	private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub

//		String nacimiento = request.getParameter("fechaNacimiento");
//		String aparicion = request.getParameter("fechaAparicion");
//		Date fechaNac = Date.valueOf(nacimiento);
//		Date fechaApa = Date.valueOf(aparicion);
//		Heroe heroe = new Heroe();
//		Genero genero = genDao.find(request.getParameter("generos"));
//		Estado estado = estDao.find(request.getParameter("estados"));
//		heroe.setNombre(request.getParameter("nombre"));
//		heroe.setHeroe(request.getParameter("alias"));
//		heroe.setArma(request.getParameter("arma"));
//		heroe.setDescripcion(request.getParameter("descripcion"));
//		heroe.setFechanacimiento(fechaNac);
//		heroe.setFechaaparicion(fechaApa);
//		heroe.setGeneroBean(genero);
//		heroe.setEstadoBean(estado);
//		herDao.insert(heroe);

//		request.getRequestDispatcher("heroeList.jsp").forward(request, response);

		response.sendRedirect("list");
	}

	private void listCliente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		List<Cliente> listCliente = cliDao.list();
		request.setAttribute("listCliente", listCliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("heroeList.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		
//		String nacimiento = request.getParameter("fechaNacimiento");
//		String aparicion = request.getParameter("fechaAparicion");
//		Date fechaNac = Date.valueOf(nacimiento);
//		Date fechaApa = Date.valueOf(aparicion);
//		Heroe heroe = new Heroe();
//		Genero genero = genDao.find(request.getParameter("generos"));
//		Estado estado = estDao.find(request.getParameter("estados"));
//		
//		heroe.setNombre(request.getParameter("nombre"));
//		heroe.setHeroe(request.getParameter("alias"));
//		heroe.setArma(request.getParameter("arma"));
//		heroe.setDescripcion(request.getParameter("descripcion"));
//		heroe.setFechanacimiento(fechaNac);
//		heroe.setFechaaparicion(fechaApa);
//		heroe.setGeneroBean(genero);
//		heroe.setEstadoBean(estado);
//		herDao.update(heroe);
//		List<Heroe> listHeroe = herDao.list();
//		request.setAttribute("listHeroe", listHeroe);
//		request.getRequestDispatcher("heroeList.jsp").forward(request, response);

	}

	private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

//		int codigo = Integer.parseInt(request.getParameter("id"));
//		Heroe h = herDao.find(codigo);
//		herDao.delete(h);
//		List<Heroe> listHeroe = herDao.list();
//		request.setAttribute("listHeroe", listHeroe);
		request.getRequestDispatcher("heroeList.jsp").forward(request, response);
	}

//	private void buscarEmpleado(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String codigo=request.getParameter("codigo");
//		EmpleadoDao eDao=new EmpleadoDao();
//		Empleado e =eDao.find(codigo);
//		
//		request.setAttribute("empleado", e);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("formEmpleado.jsp");
//		dispatcher.forward(request, response);
//	}
	
	

}
