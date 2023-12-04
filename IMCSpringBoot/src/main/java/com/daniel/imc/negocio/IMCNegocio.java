package com.daniel.imc.negocio;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.imc.modelo.IMCModeloInterface;


@Component
public class IMCNegocio implements IMCNegocioInterface{

	@Autowired
	IMCModeloInterface imc;
	public double obtenerIMC(String nombre) throws IOException, ParseException {
        List<String> lineas = imc.buscarNombre(nombre);


        
        for (String linea : lineas) {
            String[] partes = linea.split("-");
            double peso = Double.parseDouble(partes[1]);
            double altura = Double.parseDouble(partes[2]);

             return calcularIMC(peso, altura);


        }
        
		return 0;

      
    }

    private double calcularIMC(double peso, double altura) {

        double alturaEnMetros = altura / 100; 
        double imc = peso / (alturaEnMetros * alturaEnMetros);
        return imc;
    }
}
