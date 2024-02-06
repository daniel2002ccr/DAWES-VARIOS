package com.daniel.colegio.daoimpl.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.colegio.dao.AlumnosDAO;
import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.entities.AlumnoEntity;
import com.daniel.colegio.entities.MunicipioEntity;
import com.daniel.colegio.repositories.AlumnosRepository;
import com.daniel.colegio.repositories.MunicipioRepository;

@Component("AlumnosDAOImplSpringDataJPA")
public class AlumnosDAOImplSpringDataJPA implements AlumnosDAO{

	@Autowired
	private AlumnosRepository alumnosRepository;
	
	@Autowired
	private MunicipioRepository municipioRepository;
	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa)
			throws SQLException, ClassNotFoundException, NamingException {

		
		return alumnosRepository.buscaAlumnos(id, nombre, apellido, Integer.parseInt(activo), Integer.parseInt(famNumerosa));
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws SQLException, ClassNotFoundException, NamingException {

//		Si creas un constructor al combo con solo id te ahorras la siguiente linea
//		MunicipioEntity municipiosEntity = municipioRepository.findById(Integer.parseInt(municipios)).get();

		/*Se puede hacer de esta forma */
//		if ( municipioRepository.findById(Integer.parseInt(municipios)).isPresent()) {
//			 municipioRepository.findById(Integer.parseInt(municipios));
//		}else {
//			//lanzar una excepción.
//		}
		
		AlumnoEntity a = new AlumnoEntity(Integer.parseInt(id), nombre, apellido, new MunicipioEntity(Integer.parseInt(municipios)), Integer.parseInt(famNumerosa), Integer.parseInt(activo));
		
		alumnosRepository.save(a);
		return a.getId();
	}

	@Override
	public Integer actualizarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws SQLException, ClassNotFoundException, NamingException {
	
		
		return insertarAlumno(id, nombre, apellido, activo, famNumerosa, municipios);
	}

	@Override
	public Integer borrarAlumno(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
