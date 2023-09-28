package com.exito.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Random;

import static com.exito.userInterfaces.ProductosUI.BTN_AGREGAR_MAS;
import static com.exito.utils.VariableGlobal.cantidadProducto;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CantidadProductosAleatorio implements Interaction {

    public int cantidadAleatoria;
    private int cantidadMin;
    private int cantidadMax;

    public CantidadProductosAleatorio(int cantidadMin, int cantidadMax) {
        this.cantidadMin = cantidadMin;
        this.cantidadMax = cantidadMax;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        cantidadProducto = numeroAleatorio(cantidadMin, cantidadMax);

        for (int i = 1; i < cantidadProducto; i++) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_AGREGAR_MAS, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_AGREGAR_MAS)
            );
        }

        System.out.println("Cantidad aleatoria generada: " + cantidadProducto);
    }

    private int numeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static Performable entre(int cantidadMinima, int cantidadMaxima) {
        return Tasks.instrumented(CantidadProductosAleatorio.class, cantidadMinima, cantidadMaxima);
    }
}
