package co.edu.ufps.Dao;

import co.edu.ufps.Entities.Servicio;
import co.edu.ufps.Util.Conexion;

public class ServicioDao extends Conexion<Servicio> implements GenericDao<Servicio> {
	public ServicioDao() {
		super(Servicio.class);
	}

}
