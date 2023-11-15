package com.daniel.foreach.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.daniel.foreach.bean.Persona;

@Component
public class Negocio implements INegocio{

	public List<Persona> buscarLista (){

		List<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(new Persona("Pepe", 2000));
		listaPersonas.add(new Persona ("kike", 10000));
		listaPersonas.add(new Persona ("Luis", 5000));
		listaPersonas.add(new Persona ("Maria", 3000));
		
		
		return listaPersonas;
	}
}
