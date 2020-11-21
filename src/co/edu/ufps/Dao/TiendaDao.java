package co.edu.ufps.Dao;

import co.edu.ufps.Entities.Tienda;
import co.edu.ufps.Util.Conexion;

public class TiendaDao extends Conexion<Tienda> implements GenericDao<Tienda> {
	public TiendaDao() {
		super(Tienda.class);
	}

}
