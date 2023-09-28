package com.exito.stepDefinitions;

import com.exito.tasks.CarritoTask;
import com.exito.tasks.ElegirProductoTask;
import com.exito.utils.WebDriverFactory;
import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ElegirProductosStepDef {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que me encuentro en la pagina principal del Exito$")
    public void queMeEncuentroEnLaPaginaPrincipalDelExito() {
        OnStage.theActorCalled("felipe").can(BrowseTheWeb.with(
                    WebDriverFactory.goToWeb("https://www.exito.com/SeleccionarProductosUI")
                )
        );
    }

    @Cuando("^selecciono cinco productos aleatorios de una categoria$")
    public void seleccionoCincoProductosAleatoriosDeUnaCategoria() {
        OnStage.theActor("felipe").attemptsTo(ElegirProductoTask.on());
    }

    @Entonces("^valido que los productos agregados sean iguales a los del carrito$")
    public void validoQueLosProductosAgregadosSeanIgualesALosDelCarrito() {
        OnStage.theActor("felipe").attemptsTo(CarritoTask.on());

    }

}
