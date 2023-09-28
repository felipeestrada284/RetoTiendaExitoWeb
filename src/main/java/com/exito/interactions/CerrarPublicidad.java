package com.exito.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.exito.userInterfaces.ProductosUI.BTN_CLOSE_ADVERTING;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarPublicidad implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_CLOSE_ADVERTING, isVisible()).forNoMoreThan(10).seconds()
        );

        if (BTN_CLOSE_ADVERTING.resolveFor(actor).isVisible()){
            actor.attemptsTo(
                    Click.on(BTN_CLOSE_ADVERTING)
            );
        }

    }

    public static CerrarPublicidad on(){
        return Tasks.instrumented(CerrarPublicidad.class);
    }
}
