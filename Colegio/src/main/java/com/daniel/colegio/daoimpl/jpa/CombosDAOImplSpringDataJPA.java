package com.daniel.colegio.daoimpl.jpa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.colegio.dao.ICombosDAO;
import com.daniel.colegio.dtos.ComboDTO;
import com.daniel.colegio.entities.MunicipioEntity;
import com.daniel.colegio.repositories.MunicipioRepository;

@Component("combospringdatajpa")
public class CombosDAOImplSpringDataJPA implements ICombosDAO{

	
	@Autowired
	private MunicipioRepository municipioRepository;
	@Override
	public List<ComboDTO> recuperaCombosMunicipio() throws ClassNotFoundException, SQLException, NamingException {

		Iterable <MunicipioEntity> listaEntidadesMunicipio = municipioRepository.findAll();
		return mapeoMunicipioEntityComboDTO(listaEntidadesMunicipio);
	}

	private List<ComboDTO> mapeoMunicipioEntityComboDTO (Iterable <MunicipioEntity> listaEntidadesMunicipio){
		
		List<ComboDTO> comboMunicipio = new ArrayList<>();
		
		
		for(MunicipioEntity m : listaEntidadesMunicipio) {
			comboMunicipio.add(new ComboDTO(m.getIdMunicipio(), m.getNombre()));
		}
		
		
		return comboMunicipio;
	}
}
