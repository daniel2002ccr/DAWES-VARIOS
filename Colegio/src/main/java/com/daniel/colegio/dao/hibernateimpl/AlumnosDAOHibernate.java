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
		
		AlumnoEntity alumnoEntity = new AlumnoEntity(Integer.parseInt(id), nombre, apellido, new MunicipioEntity(Integer.parseInt(municipios)), Integer.parseInt(famNumerosa), Integer.parseInt(activo));
	
		SessionFactory sessionFactory = DBUtils.creadorSession();
		Session s = sessionFactory.getCurrentSession();
		
		s.beginTransaction();
		Integer pk = (Integer) s.save(alumnoEntity);
		s.getTransaction().commit();
		
		
		
		
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
