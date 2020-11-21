package co.edu.ufps.Util;

import co.edu.ufps.Dao.ClienteDao;
import co.edu.ufps.Dao.ServicioDao;
import co.edu.ufps.Dao.TiendaDao;
import co.edu.ufps.Entities.Cliente;
import co.edu.ufps.Entities.Servicio;
import co.edu.ufps.Entities.Tienda;

public class Prueba {
	static ClienteDao cliDao = new ClienteDao();
	static TiendaDao tiDao = new TiendaDao();
	static ServicioDao serDao = new ServicioDao();

	public Prueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		cli.setNombre("Carlos Calderon");
		cli.setEmail("calderon@gmail.com");
		cli.setClave("1234");
		cliDao.insert(cli);
		
		Tienda ti = new Tienda();
		ti.setFacebook("www.facebook.com/papita");
		ti.setNombre("papita");
		ti.setLema("la papita es la mejor");
		ti.setDescripcion("hola como estas todo bn");
		ti.setEmail("papita@gmail.com");
		ti.setClave("1234");
		ti.setPropietario("juanperez");
		ti.setWeb("www.lapapita.com");
		ti.setImagen("lapapita");
		tiDao.insert(ti);
		
		Servicio ser = new Servicio();
		ser.setNombre("rapipapa");
		ser.setDescripcion("la papita ya lista");
		ser.setTiendaBean(ti);
		serDao.insert(ser);
		

	}

}
