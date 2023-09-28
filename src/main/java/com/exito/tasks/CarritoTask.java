package com.exito.tasks;

import com.exito.interactions.ExplicitWait;
import com.exito.interactions.ValidarProductosCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.exito.userInterfaces.ProductosUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CarritoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_CARRITO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CARRITO),
                WaitUntil.the(INP_CORREO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("flip@gmail.com").into(INP_CORREO),
                Click.on(BTN_CONFIRMAR),
                WaitUntil.the(TXT_CARRITO_COMPRAS, isVisible()).forNoMoreThan(10).seconds(),
                ExplicitWait.here(5),
                ValidarProductosCarrito.on()

        );
    }

    public static CarritoTask on(){
        return Tasks.instrumented(CarritoTask.class);
    }
}
