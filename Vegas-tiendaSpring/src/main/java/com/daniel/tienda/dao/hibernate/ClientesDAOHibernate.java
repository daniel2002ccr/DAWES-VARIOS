package com.daniel.tienda.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IClientesDAO;
import com.daniel.tienda.dtos.ClientesDTO;
import com.daniel.tienda.utils.DBUtils;

@Component("ClienteHibernateImpl")
public class ClientesDAOHibernate implements IClientesDAO {

	@Override
	public List<ClientesDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {

		String jpql = " SELECT new com.daniel.tienda.dtos.ClientesDTO (c.id, c.nombre, c.correo, p.id, p.nombre, c.activo)"
				+ " FROM ClienteEntity c,"
				+ " PoblacionEntity p "
				+ " WHERE c.ID_Poblacion = p.id "
				+ " AND CAST (c.id as string) LIKE :id "
				+ " AND c.nombre LIKE :nombre "
				+ " AND c.correo LIKE :correo "
				+ " AND c.activo = :activo ";
		
		SessionFactory sessionFactory = DBUtils.creadorSession();
		Session s = sessionFactory.getCurrentSession();
		
		s.beginTransaction();
		
		Query<ClientesDTO> query = s.createQuery(jpql, ClientesDTO.class).setParameter("id", "%" + id + "%")
				.setParameter("nombre", "%" + nombre + "%")
				.setParameter("correo", "%" + correo + "%")
				.setParameter("activo",  activo);
		
		List<ClientesDTO> listaClientes = query.getResultList();

		s.close();
		return listaClientes;
	}

	@Override
	public Integer insertarCliente(String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarCliente(String id, String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarCliente(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
