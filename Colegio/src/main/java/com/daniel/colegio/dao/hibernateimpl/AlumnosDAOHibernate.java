package com.daniel.colegio.dao.hibernateimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.daniel.colegio.dao.AlumnosDAO;
import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.entities.AlumnoEntity;
import com.daniel.colegio.entities.MunicipioEntity;
import com.daniel.colegio.utils.DBUtils;

@Component("HibernateImpl")
public class AlumnosDAOHibernate implements AlumnosDAO {

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa)
			throws ClassNotFoundException, SQLException, NamingException {
		String jpql = " SELECT new com.daniel.colegio.dtos.AlumnoDTO (a.id, a.nombre, a.apellidos, m.nombre, m.idMunicipio, a.famNumerosa, a.activo)"
						+ " FROM AlumnoEntity a, "
						+ " MunicipioEntity m "
						+ " WHERE a.municipio.idMunicipio = m.idMunicipio "
						+ "	AND CAST (a.id AS string) LIKE :id "
						+ " AND a.nombre LIKE :nombre "
						+ " AND a.apellidos LIKE :apellido "
						+ " AND a.activo = :activo "
						+ " AND a.famNumerosa = :familiaNumerosa ";
		
		SessionFactory sessionFactory = DBUtils.creadorSession();
		Session s = sessionFactory.getCurrentSession();
		
		s.beginTransaction();
		
		Query<AlumnoDTO> query = s.createQuery(jpql, AlumnoDTO.class).setParameter("id", "%" + id + "%")
									.setParameter("nombre", "%" + nombre + "%")
									.setParameter("apellido", "%" + apellido + "%")
									.setParameter("activo", activo)
									.setParameter("familiaNumerosa", famNumerosa);
		
		List<AlumnoDTO> listaAlumnos= query.getResultList();
		
		s.close();
		return listaAlumnos;
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws ClassNotFoundException, SQLException, NamingException {

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
			String municipio) throws ClassNotFoundException, SQLException, NamingException {
		
		SessionFactory factory = DBUtils.creadorSession();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

		MunicipioEntity municipioEntity = s.find(MunicipioEntity.class, Integer.parseInt(municipio));
		
//		MunicipiosEntity municipioEntity = new MunicipiosEntity(Integer.parseInt(municipio), null, null, null, null, null);

		AlumnoEntity alumnoEntity = new AlumnoEntity(Integer.parseInt(id), 
													nombre, apellido, municipioEntity, 
													Integer.parseInt(activo), Integer.parseInt(famNumerosa));
		s.merge(alumnoEntity);

		s.getTransaction().commit();

		s.close();
		Integer idPk = alumnoEntity.getId();
		return idPk;
	}
	

	@Override
	public Integer borrarAlumno(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		SessionFactory factory = DBUtils.creadorSession();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		
		AlumnoEntity alumnoEntity = s.find(AlumnoEntity.class, Integer.parseInt(id));
		
		alumnoEntity.setActivo(0);
		
		s.merge(alumnoEntity);
		
		s.getTransaction().commit();

		s.close();
		return null;
	}

}
