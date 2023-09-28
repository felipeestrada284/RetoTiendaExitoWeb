package com.exito.utils;


import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CantidadProductos {
    List<WebElementFacade> element;

    public CantidadProductos(List<WebElementFacade> element) {
        this.element = element;
    }

    public static List<Integer> aleatoria(List<WebElementFacade> element) {

        Random random = new Random();

        //lista que almacenará los números aleatorios generados.
        List<Integer> numeroGenerado = new ArrayList<>();

        //cantidad de números aleatorios que se van a generar y agregar a la lista numeroGenerado.
        int cantidadNumerosAleatorios = 5;

        while (cantidadNumerosAleatorios > numeroGenerado.size()) {
            int numRandom = random.nextInt(element.size()-1);
            if(numRandom==0) {
                numRandom = 1;
            }
            if (!numeroGenerado.contains(numRandom)) {
                numeroGenerado.add(numRandom);
            }
        }

        return numeroGenerado;
    }
}
