package com.daniel.tienda.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.ICategoriaDAO;
import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.entities.CategoriaEntity;
import com.daniel.tienda.utils.DBUtils;

@Component("HibernateImpl")
public class CategoriasDAOHibernate implements ICategoriaDAO{

	@Override
	public List<CategoriaDTO> buscarCategoria(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		
		String jpql = " SELECT new com.daniel.tienda.dtos.CategoriaDTO (c.id, c.nombre, c.descripcion, c.activo) "
				+ " FROM CategoriaEntity c WHERE CAST (c.id AS string) LIKE :id "
				+ " AND c.nombre LIKE :nombre "
				+ " AND c.descripcion LIKE :descripcion "
				+ " AND c.activo = :activo ";
		
		SessionFactory sessionFactory = DBUtils.creadorSession();
		Session s = sessionFactory.getCurrentSession();
		
		s.beginTransaction();
		
		Query<CategoriaDTO> query = s.createQuery(jpql, CategoriaDTO.class)
				.setParameter("id", "%" + id + "%")
				.setParameter("nombre", "%" + nombre + "%")
				.setParameter("descripcion", "%" + descripcion + "%")
				.setParameter("activo", activo);
		
		List<CategoriaDTO> listaCategorias = query.getResultList();
		s.close();
		return listaCategorias;
	}

	@Override
	public Integer insertarCategoria(String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {

		SessionFactory sessionFactory = DBUtils.creadorSession();
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		
		CategoriaEntity ce = new CategoriaEntity(nombre, descripcion, Integer.parseInt(activo));
		
		s.persist(ce);
		s.getTransaction().commit();
		
		s.close();
		
		Integer pk = ce.getId();
		
		return pk;
	}

	@Override
	public Integer actualizarCategoria(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarCategoria(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
