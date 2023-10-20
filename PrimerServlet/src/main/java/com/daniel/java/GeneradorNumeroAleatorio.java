package com.daniel.java;

import java.util.Random;

public class GeneradorNumeroAleatorio {
    public static int numeroAleatorio() {
        Random r = new Random();

       return r.nextInt(10) + 1;

      
    }
}