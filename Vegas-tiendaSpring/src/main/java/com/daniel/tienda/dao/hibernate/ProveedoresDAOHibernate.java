package com.daniel.tienda.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IProveedoresDAO;
import com.daniel.tienda.dtos.ProveedoresDTO;
import com.daniel.tienda.entities.ProveedoresEntity;
import com.daniel.tienda.utils.DBUtils;

@Component("ProveedoresHibernateImpl")
public class ProveedoresDAOHibernate implements IProveedoresDAO {

	@Override
	public List<ProveedoresDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {

		String jpql = " SELECT new com.daniel.tienda.dtos.ProveedoresDTO (p.idProveedor, p.nombre, p.contacto, p.telefono, p.correoElectronico, p.direccion, p.activo) "
				+ " FROM ProveedoresEntity p WHERE CAST (p.idProveedor AS string) LIKE :idProveedor "
				+ " AND p.nombre LIKE :nombre " + " AND p.contacto LIKE :contacto " + " AND p.telefono LIKE  :telefono "
				+ " AND p.correoElectronico LIKE :correoElectronico " + " AND p.direccion LIKE :direccion "
				+ " AND p.activo = :activo ";

		SessionFactory sessionFactory = DBUtils.creadorSession();
		Session s = sessionFactory.getCurrentSession();

		s.beginTransaction();

		Query<ProveedoresDTO> query = s.createQuery(jpql, ProveedoresDTO.class)
				.setParameter("idProveedor", "%" + id + "%").setParameter("nombre", "%" + nombre + "%")
				.setParameter("contacto", "%" + contacto + "%").setParameter("telefono", "%" + telefono + "%")
				.setParameter("correoElectronico", "%" + correo + "%").setParameter("direccion", "%" + direccion + "%")
				.setParameter("activo", activo);

		List<ProveedoresDTO> listaProveedores = query.getResultList();
		s.close();

		return listaProveedores;
	}

	@Override
	public Integer insertarProveedor(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws SQLException, ClassNotFoundException, NamingException {

		SessionFactory sessionFactory = DBUtils.creadorSession();
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();

		ProveedoresEntity pe = new ProveedoresEntity(nombre, contacto, telefono, correo, direccion,
				Integer.parseInt(activo));

		s.persist(pe);
		s.getTransaction().commit();
		s.close();
		Integer pk = pe.getIdProveedor();
		return pk;
	}

	@Override
	public Integer actualizarProveedor(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws SQLException, ClassNotFoundException, NamingException {
		
		
		SessionFactory factory = DBUtils.creadorSession();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		
		ProveedoresEntity pe = new ProveedoresEntity(Integer.parseInt(id), nombre, contacto, telefono, correo, direccion, Integer.parseInt(activo));
		
		s.merge(pe);
		s.getTransaction().commit();
		s.close();
		Integer idPk = pe.getIdProveedor();
		return idPk;
	}

	@Override
	public Integer borrarProveedor(String id) throws SQLException, ClassNotFoundException, NamingException {

		SessionFactory factory = DBUtils.creadorSession();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		
		ProveedoresEntity pe = s.find(ProveedoresEntity.class, Integer.parseInt(id));
		
		pe.setActivo(0);
		
		s.merge(pe);
		s.getTransaction().commit();
		s.close();
		
		return null;
	}

}
