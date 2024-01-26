package com.daniel.colegio.dao.hibernateimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.daniel.colegio.dao.AlumnosDAO;
import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.entities.AlumnoEntity;
import com.daniel.colegio.entities.MunicipioEntity;
import com.daniel.colegio.utils.DBUtils;

@Component("HibernateImpl")
public class AlumnosDAOHibernate implements AlumnosDAO{

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws SQLException, ClassNotFoundException, NamingException {
		
	
		SessionFactory sessionFactory = DBUtils.creadorSession();
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		
		MunicipioEntity me = s.find(MunicipioEntity.class, Integer.parseInt(municipios));
		
		AlumnoEntity ae = new AlumnoEntity(Integer.parseInt(id), nombre, apellido, me, Integer.parseInt(famNumerosa), Integer.parseInt(activo));
		s.persist(me);
		s.getTransaction().commit();
		s.close();
		Integer pk = ae.getId();
		
		
		
		return pk;
	}

	@Override
	public Integer actualizarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarAlumno(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
