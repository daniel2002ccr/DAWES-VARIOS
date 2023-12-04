package com.danielvegas.aleatorio.negocio;

import java.util.Random;

public class GenerarNumeroAleatorio {
    public static int numeroAleatorio() {
        Random r = new Random();

       return r.nextInt(10) + 1;

      
    }
}
