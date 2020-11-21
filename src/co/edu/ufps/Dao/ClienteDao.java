package co.edu.ufps.Dao;

import co.edu.ufps.Entities.Cliente;
import co.edu.ufps.Util.Conexion;

public class ClienteDao extends Conexion<Cliente> implements GenericDao<Cliente> {
	public ClienteDao() {
		super(Cliente.class);
	}

}
