package com.exito.interactions;


import com.exito.utils.VariableGlobal;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.*;

import static com.exito.userInterfaces.ProductosUI.*;
import static com.exito.utils.VariableGlobal.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SeleccionarProductoAleatorio implements Interaction {

    int num;
    private static List<Integer> numeroAleatorio = new ArrayList<>();
    public static int numRandom;

    public SeleccionarProductoAleatorio(int num) {
        this.num = num;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Random random = new Random();

        List<WebElementFacade> nombreProducto = TXT_NOMBRE_PRODUCTO.resolveAllFor(actor);
        List<WebElementFacade> precioProducto = TXT_PRECIO_PRODUCTO.resolveAllFor(actor);
        List<WebElementFacade> btnCompraRapida = BTN_COMPRA_RAPIDA.resolveAllFor(actor);

        /*if (numeroAleatorio.isEmpty()) {
            // Llena la lista de índices no repetidos si está vacía
            for (int i = 1; i < btnCompraRapida.size(); i++) {
                numeroAleatorio.add(i);
            }
        }*/

        // Llena la lista de índices no repetidos si está vacía
        for (int i = 1; i < btnCompraRapida.size(); i++) {
            numeroAleatorio.add(i);
        }

        // Elige un índice aleatorio de la lista de índices no repetidos
        numRandom = numeroAleatorio.remove(random.nextInt(numeroAleatorio.size()));

        //numRandom = indiceElegido;
        productoAleatorio = nombreProducto.get(numRandom).getText();
        valorProducto = precioProducto.get(numRandom).getText();

        ExplicitWait.here(2);
        btnCompraRapida.get(numRandom).click();
        WaitUntil.the(BTN_AGREGAR, isVisible()).forNoMoreThan(10).seconds();


    }
    public static Performable on(int num){
        return Tasks.instrumented(SeleccionarProductoAleatorio.class, num);
    }
}
